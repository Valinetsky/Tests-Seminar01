package com.example.task03;

public class task03Test {
	public static void main(String[] args) {
		int x = -1;
		// Проверяем, что x неотрицательно с использованием оператора assert
		assert x >= 0 : "x должно быть неотрицательным";
		System.err.println("программа продолжает выполнение");
	}
}
