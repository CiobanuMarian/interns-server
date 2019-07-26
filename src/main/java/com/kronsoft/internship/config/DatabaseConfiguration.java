package com.kronsoft.internship.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableJpaRepositories("com.kronsoft.internship.persistence.repositories")

public class DatabaseConfiguration {

	private static final String ENTITY_PACKAGE = "com.kronsoft.internship.persistence.entity";

	@Autowired
	private Environment env;

	@Bean
	public DataSource dataSource() {
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setDriverClassName(env.getRequiredProperty("database.driver"));
		dataSource.setJdbcUrl(env.getRequiredProperty("database.url"));
		dataSource.setUsername(env.getRequiredProperty("database.username"));
		dataSource.setPassword(env.getRequiredProperty("database.password"));

		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		HibernateJpaVendorAdapter jpaVendor = new HibernateJpaVendorAdapter();
		entityManagerFactory.setDataSource(dataSource());
		entityManagerFactory.setPackagesToScan(ENTITY_PACKAGE);

		entityManagerFactory.setJpaVendorAdapter(jpaVendor);
		entityManagerFactory.setJpaProperties(jpaProperties());

		return entityManagerFactory;

	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}

	private Properties jpaProperties() {
		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
		jpaProperties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
		jpaProperties.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
		jpaProperties.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
		jpaProperties.put("hibernate.jdbc.lob.non_contextual_creation",
				env.getRequiredProperty("hibernate.jdbc.lob.non_contextual_creation"));

		return jpaProperties;
	}

}
