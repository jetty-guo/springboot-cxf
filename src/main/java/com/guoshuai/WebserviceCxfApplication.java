package com.guoshuai;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.WriteAbortedException;
import java.io.Writer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.guoshuai.domain.Customer;
import com.guoshuai.service.UserService;
import com.guoshuai.service.impl.UserServiceImpl;

@SpringBootApplication
@Configuration
public class WebserviceCxfApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(WebserviceCxfApplication.class, args);

		Customer customer = new Customer();
		customer.setId(100);
		customer.setName("mkyong");
		customer.setAge(29);
		
		
		Writer outputWriter = new StringWriter();
		
		JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
		//JAVA OBJECT------>XML
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		 jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); 
		 
		
		 jaxbMarshaller.marshal(customer, System.out);
		 jaxbMarshaller.marshal(customer, outputWriter);
		 
		 String resultXml = outputWriter.toString();
		 
		 /**
	       <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
				<customer>
				    <age>29</age>
				    <id>100</id>
				    <name>mkyong</name>
				</customer>
	        */
		 
		  Unmarshaller um = jaxbContext.createUnmarshaller();
		  Customer unmarshal = (Customer) um.unmarshal(new StringReader(resultXml));
		 System.out.println(unmarshal);
		 
	}

	@Bean
	public ServletRegistrationBean dispatcherServlet() {
		return new ServletRegistrationBean(new CXFServlet(), "/service/*");
	}

	@Bean(name = Bus.DEFAULT_BUS_ID)
	public SpringBus springBus() {
		return new SpringBus();
	}

	@Bean
	public UserService userService() {
		return new UserServiceImpl();
	}

	@Bean
	public Endpoint endpoint() {
		EndpointImpl endpoint = new EndpointImpl(springBus(), userService());
		endpoint.publish("/user");
		return endpoint;
	}
}
