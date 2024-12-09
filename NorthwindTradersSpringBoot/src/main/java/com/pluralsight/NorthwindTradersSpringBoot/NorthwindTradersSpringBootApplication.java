package com.pluralsight.NorthwindTradersSpringBoot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class NorthwindTradersSpringBootApplication {
	public static void main(String[] args) {
		SpringApplication.run(NorthwindTradersSpringBootApplication.class, args);
		Product p1 = new Product();
		p1.setProductId(1);
		p1.setName("Slinky");
		p1.setCategory("toys");
		p1.setPrice(10.99d);
		Product p2 = new Product(1, "Slinky", "toys", 10.99d);
	}
}