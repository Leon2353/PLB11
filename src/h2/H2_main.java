package h2;

public class H2_main {

	public static long[] globalArray = new long[1000];

	public static void main(String[] args) {

		

	}

	public static long fibonacci(int n) {

		if (n == 0) {

			return 0;

		}
		if (n <= 2) {

			return 1;

		}

		return fibonacci(n - 1) + fibonacci(n - 2);

	}

	public static long fibonacciCached(int n) {

		if (n == 0) {

			return 0;

		}
		if (n <= 2) {

			return 1;

		}
		if (globalArray[n] != 0) {

			return globalArray[n];

		}

		globalArray[n] = fibonacciCached(n - 1) + fibonacciCached(n - 2);
		return globalArray[n];

	}

	public static long fibonacciFor(int n) {

		if (n == 0) {

			return 0;

		}
		if (n <= 2) {

			return 1;

		}

		long a = 1;
		long b = 1;

		long result = 0;

		for (int i = 2; i < n; i++) {

			result = a + b;
			a = b;
			b = result;

		}

		return result;

	}

	public static void benchmark(int n) {

		long startTime, endTime, currentResult;

		startTime = System.nanoTime();
		currentResult = fibonacci(n);
		endTime = System.nanoTime();

		System.out.println(n + "te Stelle der Fibonacci-Folge, laut 'fibonacci': " + currentResult);
		System.out.println("Laufzeit von 'fibonacci': " + (endTime - startTime) + " Nanosekunden");
		

		startTime = System.nanoTime();
		currentResult = fibonacciCached(n);
		endTime = System.nanoTime();

		System.out.println(n + "te Stelle der Fibonacci-Folge, laut 'fibonacciCached': " + currentResult);
		System.out.println("Laufzeit von 'fibonacciCached': " + (endTime - startTime) + " Nanosekunden");
		

		startTime = System.nanoTime();
		currentResult = fibonacciFor(n);
		endTime = System.nanoTime();

		System.out.println(n + "te Stelle der Fibonacci-Folge, laut 'fibonacciFor': " + currentResult);
		System.out.println("Laufzeit von 'fibonacciFor': " + (endTime - startTime) + " Nanosekunden");

	}

}
