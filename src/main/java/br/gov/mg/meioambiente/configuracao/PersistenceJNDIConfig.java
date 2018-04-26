package br.gov.mg.meioambiente.configuracao;

import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties.LocaleResolver;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.jndi.JndiTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:persistence-jndi.properties" })
@ComponentScan({ "br.gov.mg.meioambiente.persistence" })
@EnableJpaRepositories(basePackages = "br.gov.mg.meioambiente.persistence.repository.dao")
public class PersistenceJNDIConfig {

	@Autowired
	private Environment env;

	public PersistenceJNDIConfig() {
		super();
	}

	@Bean
	@ConfigurationProperties("spring.jpa")
	public JpaProperties jpaProperties() {
		return new JpaProperties();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(JpaProperties jpaProperties) throws NamingException {
		final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] { "br.gov.mg.meioambiente.persistence.entity" });
		em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		em.setJpaProperties(additionalProperties(jpaProperties));
		// em.setJpaVendorAdapter(createJpaVendorAdapter(jpaProperties));
		return em;
	}

	@Bean
	public DataSource dataSource() throws NamingException {
		JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
		DataSource dataSource = dataSourceLookup.getDataSource(env.getProperty("jdbc.url"));
		return dataSource;
	}

	@Bean
	public PlatformTransactionManager transactionManager(final EntityManagerFactory emf) {
		final JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	final Properties additionalProperties(JpaProperties jpaProperties) {
		final Properties hibernateProperties = new Properties();
		for (Map.Entry<String, String> pair : jpaProperties.getProperties().entrySet()) {
			hibernateProperties.setProperty(pair.getKey(), pair.getValue());
		}
		return hibernateProperties;
	}

	/*
	 * private JpaVendorAdapter createJpaVendorAdapter(JpaProperties jpaProperties)
	 * { AbstractJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
	 * adapter.setShowSql(jpaProperties.isShowSql());
	 * adapter.setDatabase(jpaProperties.getDatabase());
	 * adapter.setDatabasePlatform(jpaProperties.getDatabasePlatform());
	 * adapter.setGenerateDdl(jpaProperties.isGenerateDdl()); return adapter; }
	 */

}