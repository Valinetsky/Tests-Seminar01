package com.example.task01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class task01Test {
	@Test
	public void testMethod() {
		assertEquals(5, 2 + 3);
	}

	@BeforeEach
	public void setup() {
		// Инициализация ресурсов
	}

	@AfterEach
	public void teardown() {
		// Очистка ресурсов
	}

	@BeforeAll
	public static void globalSetup() {
		// Инициализация
	}

	@AfterAll
	public static void globalTeardown() {
		// Очистка
	}

	@Test
	@DisplayName("Тест суммирования")
	public void testSum() {
		assertEquals(5, 2 + 3);
	}

	@Test
	@Disabled
	public void testMethodDisabled() {
		// Этот тест не будет запущен
	}

	@ParameterizedTest
	@ValueSource(ints = { 1, 2, 3 })
	public void testMethod(int argument) {
		assertTrue(argument > 0);
	}
}