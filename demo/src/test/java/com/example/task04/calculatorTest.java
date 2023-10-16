package com.example.task04;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class calculatorTest {
	static Calculator calculator;

	@BeforeAll
	public static void initAll() {
		// здесь можно, например подключистся к базе данных

		calculator = new Calculator();
	}

	@AfterAll
	public static void tearDownAll() {
		System.out.println("Тесты завершены");
		// Закрытие всего любого. Если было подключение к БД — закрытие соединения с БД
	}

	@BeforeEach
	void setUp() {
		calculator = new Calculator();
	}

	@AfterEach
	public void teardown() {
		calculator = null; // Очистка после каждого теста
	}

	@Test
	@DisplayName("Проверка равенства значений")
	void testAssertEquals() {
		assertEquals(4, Calculator.calculation(2, 2, '+'));
	}

	@Test
	@DisplayName("Проверка неравенства значений")
	void testAssertNotEquals() {
		assertNotEquals(5, Calculator.calculation(2, 2, '+'));
	}

	@Test
	@DisplayName("Проверка истинности условия")
	void testAssertTrue() {
		assertTrue(Calculator.calculation(2, 2, '+') == 4);
	}

	@Test
	@DisplayName("Проверка ложности условия")
	void testAssertFalse() {
		assertFalse(Calculator.calculation(2, 2, '+') == 5);
	}

	@Test
	@DisplayName("Проверка наличия объекта")
	void testAssertNotNull() {
		assertNotNull(calculator);
	}

	@Test
	@DisplayName("Проверка отсутствия объекта")
	void testAssertNull() {
		calculator = null;
		assertNull(calculator);
	}

	@Test
	@DisplayName("Проверка равенства массивов")
	void testAssertArrayEquals() {
		int[] expected = { 1, 2, 3 };
		int[] actual = { 1, 2, 3 };
		assertArrayEquals(expected, actual);
	}

	@Test
	@DisplayName("Проверка на генерацию исключений")
	void testAssertThrows() {
		assertThrows(ArithmeticException.class, () -> Calculator.calculation(1, 0, '/'));
	}

	// Дополнительные ассерты
	@Test
	@DisplayName("Проверка с сообщением")
	void testAssertWithMessage() {
		assertEquals(4, Calculator.calculation(2, 2, '+'), "2 + 2 должно быть равно 4");
	}

	@Test
	@DisplayName("Проверка с использованием лямбда-выражения для сообщения")
	void testAssertWithLambdaMessage() {
		assertEquals(4, Calculator.calculation(2, 2, '+'), () -> "2 + 2 должно быть равно 4");
	}

	@ParameterizedTest
	@ValueSource(ints = { 0, 1, 5, 100 })
	@DisplayName("Параметризированный тест для суммирования")
	public void parameterizedTest(int arg) {
		assertEquals(arg + 2, Calculator.calculation(arg, 2, '+'));
	}

	// Домашнее задание
	// Квадратные корни
	@Test
	@DisplayName("Проверка функции извлечения корня")
	void testAssertSqrtZero() {
		assertEquals(3, Calculator.squareRootExtraction(10));
	}

	// Скидки
	@Test
	@DisplayName("Проверка функции скидки")
	void testAssertDiscount() {
		assertEquals(4100, Calculator.calculatingDiscount(5000, 18));
	}

	@Test
	@DisplayName("Проверка функции скидки")
	void testAssertNegativePurchase() {
		String messageException = "Сумма покупки менее 1 — не имеет смысла";
		Exception exception = assertThrows(IllegalArgumentException.class,
				() -> Calculator.calculatingDiscount(-1, 10));
		assertEquals(messageException, exception.getMessage());
	}

	@Test
	@DisplayName("Проверка функции скидки")
	void testAssertNegativeDiscount() {
		String messageException = "Скидка равна или меньше 0 — не имеет смысла";
		Exception exception = assertThrows(IllegalArgumentException.class,
				() -> Calculator.calculatingDiscount(10, -5));
		assertEquals(messageException, exception.getMessage());
	}

}
