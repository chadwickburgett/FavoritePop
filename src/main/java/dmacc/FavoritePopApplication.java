package dmacc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import dmacc.beans.Pop;
import dmacc.beans.User;
import dmacc.controller.BeanConfiguration;
import dmacc.repository.PopRepository;

@SpringBootApplication
public class FavoritePopApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(FavoritePopApplication.class, args);
	}
	
	@Autowired
	PopRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		
		//Using an existing bean
		Pop p = appContext.getBean("pop", Pop.class);
		p.setFlavor("Coke");
		repo.save(p);
		
		//Create a bean to use - not managed by Spring
		Pop po = new Pop("Mountain Dew", 4);
		User u = new User("Tom", "Bombadil", 28);
		po.setUser(u);
		repo.save(po);
		
		List<Pop> allMyFavoritePop = repo.findAll();
		for(Pop pop: allMyFavoritePop) {
			System.out.println(pop.toString());
		}
		
		((AbstractApplicationContext) appContext).close();
	
	}

}