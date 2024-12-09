package com.pluralsight.NorthwindTradersSpringBoot;

import dao.interfaces.ProductDao;
import models.Product;
import com.abdurraheem.utils.Console;
import com.pluralsight.NorthwindTradersSpringBoot.dao.interfaces.ProductDao;
import com.pluralsight.NorthwindTradersSpringBoot.models.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class NorthwindTradersSpringBootApplication {

	//private static ProductDao productDao;
	private static ApplicationContext context;

	public static void main(String[] args) {

		context = SpringApplication.run(NorthwindTradersSpringBootApplication.class, args);

		for(String bean : context.getBeanDefinitionNames()){
			System.out.println(bean);
		}

		String options = """
                Please select from the following choices:
                1 - Add Product
                2 - List All Products
                99 - Quit
                >>>\s""";

		int selection;

		// User Interface Loop
		do {
			selection = Console.PromptForInt(options);
			switch (selection) {
				case 1 -> processAddProduct();
				case 2 -> processGetAllProducts();
				case 99 -> System.exit(0);
				default -> System.out.println("Invalid selection. Please try again.");
			}
		} while (true);

	}

	private static void processGetAllProducts() {
		ProductDao productDao = context.getBean(ProductDao.class);
		List<Product> products = productDao.getAll();
		for(Product p : products){
			System.out.println(p);
		}
	}

	private static void processAddProduct() {
		ProductDao productDao = context.getBean(ProductDao.class);

		int productId = Console.PromptForInt("Please enter the Product ID: ");
		String name = Console.PromptForString("Please enter the Product Name: ");
		String category = Console.PromptForString("Please enter the Category:" );
		double price = Console.PromptForDouble("Please enter the price: ");
		Product p1 = new Product(productId, name, category, price);

		productDao.add(p1);

	}


}