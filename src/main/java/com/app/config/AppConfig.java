package com.app.config;

import java.util.Properties;


import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.format.FormatterRegistry;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.app.converter.UserIdToObjectConverter;
import com.app.model.Customer;
import com.app.model.Item;
import com.app.model.OrderMethod;
import com.app.model.PurchaseOrder;
import com.app.model.ShipmentType;
import com.app.model.Uom;
import com.app.model.User;
import com.app.model.Vendor;
import com.app.model.WhUserType;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages="com.app")
@PropertySource("classpath:db.properties")
@Import(SecurityConfig.class)
public class AppConfig implements WebMvcConfigurer{
	
	@Autowired
	private Environment env;
	
	@Autowired
	private UserIdToObjectConverter userConverter;
	@Bean
	public BasicDataSource dsobj()
	{
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName(env.getProperty("dc"));
		ds.setUrl(env.getProperty("url"));
		ds.setUsername(env.getProperty("un"));
		ds.setPassword(env.getProperty("pwd"));
		
		ds.setInitialSize(5);
		ds.setMaxIdle(5);
		ds.setMinIdle(3);
		ds.setMaxTotal(5);
		return ds;	
	}
	@Bean
	public LocalSessionFactoryBean sfobj() {
		LocalSessionFactoryBean sf=new LocalSessionFactoryBean();
		sf.setDataSource(dsobj());
		sf.setAnnotatedClasses(Uom.class,OrderMethod.class,ShipmentType.class,WhUserType.class,Item.class,Customer.class,Vendor.class,PurchaseOrder.class,User.class);
		sf.setHibernateProperties(props());
		return sf;
	}
	private Properties props() {
		Properties p=new Properties();
		p.put("hibernate.dialect", env.getProperty("dialect"));
		p.put("hibernate.show_sql", env.getProperty("showsql"));
		p.put("hibernate.format_sql", env.getProperty("fmtsql"));
		p.put("hibernate.hbm2ddl.auto", env.getProperty("ddlauto"));
		return p;
	}
	@Bean
	public HibernateTemplate htobj() {
		HibernateTemplate ht=new HibernateTemplate();
		ht.setSessionFactory(sfobj().getObject());
		return ht;
	}
	@Bean
	public HibernateTransactionManager htmobj() {
		HibernateTransactionManager htm=new HibernateTransactionManager();
		htm.setSessionFactory(sfobj().getObject());
		return htm;
	}
	@Bean
	public InternalResourceViewResolver ivr() {
		InternalResourceViewResolver iv=new InternalResourceViewResolver();
		iv.setPrefix(env.getProperty("mvc.prefix"));
		iv.setSuffix(env.getProperty("mvc.suffix"));
		return iv;
	}
	//webconfigurere adapterer
	@Override
	public void addFormatters(FormatterRegistry registery)
	{
		registery.addConverter(userConverter);
	}
	@Bean
	public BCryptPasswordEncoder encoder()
	{
		return new BCryptPasswordEncoder();
	}
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**")
		.addResourceLocations("/resources/");
	}
}
