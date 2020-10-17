package dmacc.beans;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Pop {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String flavor;
	@Autowired
	private User user;
	private int stars;
	
	public Pop() {
		super();
		this.flavor = "Coke";
	}
	
	public Pop(String flavor) {
		super();
		this.flavor = flavor;
	}
	public Pop(String flavor, int stars) {
		super();
		this.flavor = flavor;
		this.stars = stars;
	}
	public Pop(long id, String flavor, int stars) {
		super();
		this.id = id;
		this.flavor = flavor;
		this.stars = stars;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "Favorite Pop [User=" + user + ", flavor=" + flavor + 
				", stars=" + stars + "]";
	}
}
