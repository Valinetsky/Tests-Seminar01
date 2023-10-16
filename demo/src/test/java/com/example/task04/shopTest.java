package com.example.task04;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.shop.Product;
import com.example.shop.Shop;

public class shopTest {
	@Test
	@DisplayName("Тест заполнения магазина")
	public void testAddProduct() {
		Shop shop = new Shop();
		assertEquals(0, shop.getProducts().size());

		Product product01 = new Product(13, "Fallout");
		shop.addProduct(product01);
		assertEquals(1, shop.getProducts().size());
		assertEquals(product01, shop.getProducts().get(0));

		Product product02 = new Product(37, "Deus Ex");
		shop.addProduct(product02);
		assertEquals(2, shop.getProducts().size());
		assertEquals(product02, shop.getProducts().get(1));
	}

	@Test
	@DisplayName("Тест сортировки товаров по цене")
	public void testSortProductsByPrice() {
		Shop shop = new Shop();

		Product product01 = new Product(13, "Fallout");
		shop.addProduct(product01);

		Product product02 = new Product(37, "Deus Ex");
		shop.addProduct(product02);

		Product product03 = new Product(1, "Pong");
		shop.addProduct(product03);

		shop.sortProductsByPrice();

		assertEquals(product03, shop.getProducts().get(0));
		assertEquals(product01, shop.getProducts().get(1));
		assertEquals(product02, shop.getProducts().get(2));
	}

	@Test
	@DisplayName("Тест поиска самого дорогого товара")
	public void testGetMostExpensiveProduct() {
		Shop shop = new Shop();

		Product product01 = new Product(13, "Fallout");
		shop.addProduct(product01);

		Product product02 = new Product(37, "Deus Ex");
		shop.addProduct(product02);

		Product product03 = new Product(1, "Pong");
		shop.addProduct(product03);

		Product mostExpensiveProduct = shop.getMostExpensiveProduct();

		assertEquals(product02, mostExpensiveProduct);
	}
}
