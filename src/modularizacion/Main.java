package modularizacion;

import java.util.Random;
import java.util.Scanner;

public class Main {

	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int opcion;
		
		do {
			mostrarMenu();
			opcion = leerEntero("\nSelecciones una opción: ");
			
			switch (opcion) {
			case 1:
				calculadoraBasica();
				break;
			case 2:
				validarContrasenia();
				break;	
			case 3:
				numerosPrimos();
				break;
			case 4:
				sumaPares();
				break;
			case 5:
				conversionTemperatura();
				break;
			case 6:
				contadorVocales();
				break;
			case 7:
				calcularFactorial();
				break;
			case 8:
				juegoAdivinanza();
				break;
			case 9:
				intercambiarValores();
				break;
			case 10:
				tablaMultiplicar();
				break;
			case 0:
				System.out.println("Saliendo del programa...");
				break;
			default:
				System.out.println("Opción inválida.");
			}
		} while (opcion != 0);
		
		scanner.close();;
	}

	private static void mostrarMenu() {
		System.out.println("\nMENÚ PRINCIPAL");
		System.out.println("1. Calculadora básica");
		System.out.println("2. Validación de contraseña");
		System.out.println("3. Números primos");
		System.out.println("4. Suma de números pares");
		System.out.println("5. Conversión de temperatura");
		System.out.println("6. Contador de vocales");
		System.out.println("7. Cálculo de factorial");
		System.out.println("8. Juego de adivinanza");
		System.out.println("9. Paso por referencia");
		System.out.println("10. Tabla de multiplicar");
		System.out.println("0. Salir");
	}
	
	//Validaciones

	private static int leerEntero(String mensaje) {
		while (true) {
			try {
				System.out.print(mensaje);
				return Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Error. Debe ingresar un número entero válido.");
			}
		}
	}
	
	public static double leerDouble(String mensaje) {
		while (true) {
			try {
				System.out.print(mensaje);
				return Double.parseDouble(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Error. Debe ingresar un número válido.");
			}
		}
	}
	
	//1) CALCULADORA

	private static void calculadoraBasica() {
		double num1 = leerDouble("\nIngrese el primer número: ");
		double num2 = leerDouble("Ingrese el segundo número: ");
		
		System.out.println("\n1. Suma");
		System.out.println("2. Resta");
		System.out.println("3. Multiplicación");
		System.out.println("4. División");
		
		int opcion = leerEntero("\nElija una operación: ");
		System.out.println();
		
		switch (opcion) {
		case 1:
			System.out.println("Resultado: " + sumar(num1, num2));
			break;
		case 2:
			System.out.println("Resultado: " + restar(num1, num2));
			break;
		case 3:
			System.out.println("Resultado: " + multiplicar(num1, num2));
			break;
		case 4:
			System.out.println("Resultado: " + dividir(num1, num2));
			break;
			
		}
		
	}
	
	private static double sumar(double a, double b) {return a+b; }
	private static double restar(double a, double b) {return a-b; }
	private static double multiplicar(double a, double b) {return a*b; }
	private static double dividir(double a, double b) {
		if (b == 0) {
			System.out.println("Error. No se puede dividir entre cero.");
			return 0;
		}
		return a / b;
	}
	
	//2. VALIDAR CONTRASEÑA
	
	private static void validarContrasenia() {
		String password;
		do {
			System.out.print("Ingrese la contraseña: ");
			password = scanner.nextLine();
			if (!password.equals("1234")) {
				System.out.println("Contraseña incorrecta.");
			}
		} while (!password.equals("1234"));
		System.out.println("Acceso concedido.");
	}

	//3. NÚMEROS PRIMOS
	
	private static void numerosPrimos() {
		int numero = leerEntero("Ingrese un número: ");
		if (esPrimo(numero))
			System.out.println("Es número primo.");
		else
			System.out.println("No es número primo.");
	}
	public static boolean esPrimo(int num) {
		if (num <= 1) return false;
		for (int i = 2; i < num; i++) {
			if (num % i == 0) return false;
		}
		return true;
	}


	//4. SUMA DE NÚMEROS PARES
	
	private static void sumaPares() {
		int suma = 0;
		int numero = 1;
		
		while (numero != 0) {
			numero = leerEntero("Ingrese números enteros (0 para terminar)");
			if (numero % 2 == 0)
				suma += numero;
		}
		System.out.println("Suma de números pares: " + suma);
	}

	//5. CONVERSIÓN DE TEMPERATURA
	
	private static void conversionTemperatura() {
		System.out.println("\n1. Celsius a Fahrenheit");
		System.out.println("2. Fahrenheit a Celsius");
		
		int opcion = leerEntero("Selecciona una opción: ");
		
		if (opcion == 1) {
			double c = leerDouble("\nIngrese Celsius: ");
			System.out.println("Resultado: " + celsiusAFahrenheit(c));
		} else if (opcion == 2) {
			double f = leerDouble("\nIngrese Fahrenheit: ");
			System.out.println("Resultado: " + fahrenheitACelsius(f));
		} else {
			System.out.println("Opción inválida.");
		}
		
	}

	private static double celsiusAFahrenheit(double c) {
		return (c * 9 / 5) + 32;
	}

	private static double fahrenheitACelsius(double f) {
		return (f - 32) * 5 / 9;
	}

	//6. CONTADOR DE VOCALES
	
	private static void contadorVocales() {
		System.out.print("Escriba una frase: ");
		String texto = scanner.nextLine();
		System.out.println("Cantidad de vocales ingresadas: " + contarVocales(texto));
	}

	private static int contarVocales(String texto) {
		int contador = 0;
		texto = texto.toLowerCase();
		
		for (int i = 0; i < texto.length(); i++) {
			char c = texto.charAt(i);
			if ("aeiou".indexOf(c) != -1)
				contador++;
		}
		return contador;
	}

	//7. CÁLCULO DE FACTORIAL
	
	private static void calcularFactorial() {
		int numero = leerEntero("Ingrese un número: ");
		
		if (numero < 0) {
			System.out.println("No se puede calcular factorial de un número negativo.");
			return;
			}
		System.out.println("Factorial: " + factorial(numero));
	}

	private static long factorial(int n) {
		long resultado = 1;
		for (int i = 1; i <= n; i++) {
			resultado *= i;
		}
		return resultado;
	}

	//8. JUEGO DE ADIVINANZA
	
	private static void juegoAdivinanza() {
		Random random = new Random();
		int numeroSecreto = random.nextInt(100) + 1;
		int intento;
		
		do {
			intento = leerEntero("Adivine el número (1-100): ");
			
			if (intento < numeroSecreto)
				System.out.println("El número es mayor.");
			else if (intento > numeroSecreto)
				System.out.println("El número es menor.");
		} while (intento != numeroSecreto);
		System.out.println("¡¡¡Correcto!!!");
	}

	//9. PASO POR REFERENCIA
	
	static class Contenedor {
		int valor;
		Contenedor(int valor) {
			this.valor = valor;
		}
	}
	
	private static void intercambiarValores() {
		Contenedor a = new Contenedor(leerEntero("Ingrese primer número: "));
		Contenedor b = new Contenedor(leerEntero("Ingrese segundo número: "));
		
		System.out.println("Antes del intercambio: a=" + a.valor + ", b=" + b.valor);
		intercambiar(a, b);
		System.out.println("Después del intercambio: a=" + a.valor + ", b=" + b.valor);
	}

	private static void intercambiar(Contenedor x, Contenedor y) {
		int temp = x.valor;
		x.valor = y.valor;
		y.valor = temp;
		
	}

	//10. TABLA DE MULTIPLICAR
	
	private static void tablaMultiplicar() {
		int numero = leerEntero("Ingrese un número: ");
		generarTabla(numero);
		
	}

	private static void generarTabla(int numero) {
		for (int i = 1; i <= 10; i++) {
		System.out.println(numero + " x " + i + " = " + (numero * i));
		}
	}
}
