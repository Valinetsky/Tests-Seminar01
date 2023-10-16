package com.example.task02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class task02Test {

	// Статический блок кода, который будет выполнен перед всеми тестами
	@BeforeAll
	public static void BeforeAll() {
		System.out.println("Выполнение кода перед всеми тестами");
		// Инициализация глобальных ресурсов
	}

	// Блок кода, который будет выполнен после всех тестов
	@AfterAll
	public static void AfterAll() {
		System.out.println("Выполнение кода после всех тестов");
		// Освобождение глобальных ресурсов
	}

	// Статический блок кода, который будет выполнен перед каждым тестом
	@BeforeEach
	public void BeforeEach() {
		System.out.println("Выполнение кода перед каждым тестом");
		// Инициализация ресурсов для каждого теста
	}

	// Блок кода, который будет выполнен после каждого теста
	@AfterEach
	public void AfterEach() {
		System.out.println("Выполнение кода после каждого теста");
		// Освобождение ресурсов после каждого теста
	}

	// Основные тестовые метки
	@Test
	@DisplayName("Тест суммирования")
	public void testSum() {
		System.out.println("Выполнение теста суммирования");
		int a = 2;
		int b = 3;
		int sum = a + b;
		assertEquals(5, sum);
	}

	// Отключенный тест
	@Test
	@Disabled
	@DisplayName("Отключенный тест")
	public void disabledTest() {
		System.out.println("Этот тест отключен и не будет выполнен");
	}

	// Параметризированный тест
	@ParameterizedTest
	@ValueSource(ints = { 1, 2, 3 })
	@DisplayName("Параметризированный тест")
	public void parameterizedTest(int arg) {
		System.out.println("выполнение параметризированного теста с аргументом: " + arg);
		assertTrue(arg > 0);
	}

}
