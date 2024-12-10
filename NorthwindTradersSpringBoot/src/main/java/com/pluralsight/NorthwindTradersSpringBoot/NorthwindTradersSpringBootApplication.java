package com.pluralsight.NorthwindTradersSpringBoot;

import com.abdurraheem.utils.Console;
import dao.impl.SimpleProductDao;
import dao.interfaces.ProductDao;
import models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NorthwindApplication implements CommandLineRunner {

	@Autowired
	private ProductDao productDao;

	@Override
	public void run(String... args) throws Exception {



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




	private void processGetAllProducts() {

		List<Product> products = productDao.getAll();
		for(Product p : products){
			System.out.println(p);
		}
	}

	private void processAddProduct() {

		int productId = Console.PromptForInt("Please enter the Product ID: ");
		String name = Console.PromptForString("Please enter the Product Name: ");
		String category = Console.PromptForString("Please enter the Category:" );
		double price = Console.PromptForDouble("Please enter the price: ");
		Product p1 = new Product(productId, name, category, price);

		productDao.add(p1);

		System.out.println("Added product: \n" + p1);
	}

