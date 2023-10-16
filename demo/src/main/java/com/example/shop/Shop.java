package com.example.shop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shop {
	private List<Product> products;

	public Shop() {
		this.products = new ArrayList<>();
	}

	public void addProduct(Product product) {
		products.add(product);
	}

	// Геттеры, сеттеры:
	public List<Product> getProducts() {
		return products;
	}

	// Метод должен вернуть отсортированный по возрастанию по цене список продуктов
	public void sortProductsByPrice() {
		// Допишите реализацию метода самостоятельно
		Collections.sort(products, (p1, p2) -> p1.getCost() - p2.getCost());
	}

	// Метод должен вернуть самый дорогой продукт
	public Product getMostExpensiveProduct() {
		// Допишите реализацию метода самостоятельно
		Product mostExpensiveProduct = null;
		for (Product product : products) {
			if (mostExpensiveProduct == null || product.getCost() > mostExpensiveProduct.getCost()) {
				mostExpensiveProduct = product;
			}
		}

		return mostExpensiveProduct;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}