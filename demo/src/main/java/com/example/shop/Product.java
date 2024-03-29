package com.example.shop;

public class Product implements Comparable<Product> {
	private Integer cost; // Стоимость продукта
	private String title; // Название

	public Product(Integer cost, String title) {
		this.cost = cost;
		this.title = title;
	}

	// Геттеры, сеттеры:
	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public int compareTo(Product arg0) {
		return cost.compareTo(arg0.cost);
	}
}