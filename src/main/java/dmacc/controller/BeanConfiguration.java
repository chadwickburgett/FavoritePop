package dmacc.controller;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dmacc.beans.Pop;
import dmacc.beans.User;

@Configuration
public class BeanConfiguration {
	
	@Bean
	public Pop pop() {
		Pop bean = new Pop();
		bean.setFlavor("Cherry Coke");
		bean.setStars(5);
		return bean;
	}

	@Bean
	public User user() {
		User bean = new User("Will", "Williams", 28);
		return bean;
	}
}
