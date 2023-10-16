package com.example.task04;

public class Calculator {
	public static int calculation(int firstOperand, int secondOperand, char operator) {
		int result;

		switch (operator) {
			case '+':
				result = firstOperand + secondOperand;
				break;
			case '-':
				result = firstOperand - secondOperand;
				break;
			case '*':
				result = firstOperand * secondOperand;
				break;
			case '/':
				if (secondOperand != 0) {
					result = firstOperand / secondOperand;
					break;
				} else {
					throw new ArithmeticException("Division by zero is not possible");
				}
			case 'v':
				return squareRootExtraction(firstOperand);

			case '%':
				return calculatingDiscount(firstOperand, secondOperand);

			default:
				throw new IllegalStateException("Unexpected value operator: " + operator);
		}
		return result;
	}

	// HW1.1: Придумайте и опишите (можно в псевдокоде) функцию извлечения корня и
	// необходимые проверки для него используя граничные случаи
	public static int squareRootExtraction(int num) {
		// 0
		// Отрицательные числа
		// Дробные значения корней
		// Целые
		if (num < 0) {
			throw new IllegalArgumentException("Cannot calculate square root of a negative number");
		}

		// ---------------------------------------------------
		if (num == 0) {
			return 0;
		}

		if (num == 1) {
			return 1;
		}

		// ---------------------------------------------------

		// Можно объединить
		// if (num == 0 || num == 1) {
		// return num;
		// }

		// ---------------------------------------------------

		double square = Math.sqrt(num);
		if ((int) square != square) {
			System.out.println(
					"Корень выражен дробью. Результат, в терминах ограничения метода (возврат целых чисел) точен только для целых корней целых же чисел (25 --> 5, а 26 --> не очень 5)");
		}
		return (int) square;
	}

	// Нужно написать в калькуляторе метод вычисления суммы покупки со скидкой и
	// проверить его, используя AssertJ
	// Примерная сигнатура и тело метода:
	public static int calculatingDiscount(int purchaseAmount, int discountAmount) {
		// purchaseAmount - сумма покупки
		// discountAmount - размер скидки (по условию — не очень понятно, но по коду —
		// скидка — целое число процентов)
		if (purchaseAmount < 1) {
			throw new IllegalArgumentException("Сумма покупки менее 1 — не имеет смысла");
		}
		if (discountAmount < 1) {
			throw new IllegalArgumentException("Скидка равна или меньше 0 — не имеет смысла");
		}

		// Тут была одна из лютых засад: без каста в double,
		// (100 - discountAmount) / 100 — не работает.
		// Считаю необходимым вынести промежуточный результат в переменную.
		// Встречаем discount!!!
		double discount = (double) (100 - discountAmount) / 100;
		double result = purchaseAmount * discount;
		return (int) result; // Метод должен возвращать сумму покупки со скидкой
		// Тут опять непонятно, насколько нас плющит с возврата int'ов.
		// Но, перекастуем и вернем их.
	}
}