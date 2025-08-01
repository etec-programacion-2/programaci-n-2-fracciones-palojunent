package org.example
import java.util.Scanner
import java.util.InputMismatchException

fun main() {

    val scanner = Scanner(System.`in`)
    var opcion: Int

    do {
        try {
            mostrarMenu()
            opcion = scanner.nextInt()

            when (opcion) {
                1 -> realizarSuma(scanner)
                2 -> realizarResta(scanner)
                3 -> realizarMultiplicacion(scanner)
                4 -> realizarDivision(scanner)
                5 -> realizarComparacion(scanner)
                6 -> convertirADecimal(scanner)
                7 -> crearDesdeDecimal(scanner)
                8 -> mostrarEjemplos()
                0 -> println("¡Hasta luego!")
                else -> println("Opción inválida. Intente de nuevo.")
            }
        }
        catch (e: InputMismatchException) {
            println("Error: Ingrese solo números enteros.")
            opcion = -1
        }
        catch (e: Exception) {
            println("Error: ${e.message}")
            opcion = -1
        }


        if (opcion != 0) {
            println("\nPresione Enter para continuar...")
            scanner.nextLine() // Limpiar buffer
            scanner.nextLine() // Esperar Enter
        }
    } while (opcion != 0)

}


fun mostrarMenu() {
    println("=== CALCULADORA DE FRACCIONES ===")
    println("1. Sumar fracciones")
    println("2. Restar fracciones")
    println("3. Multiplicar fracciones")
    println("4. Dividir fracciones")
    println("5. Comparar fracciones")
    println("6. Convertir fracción a decimal")
    println("7. Crear fracción desde decimal")
    println("8. Ejemplos predefinidos")
    println("0. Salir")
    println("Ingrese su opción: ")
}

fun leerFraccion(scanner: Scanner, mensaje: String): Fraccion {
    println(mensaje)
    print("Numerador: ")
    val numerador = scanner.nextInt()
    print("Denominador: ")
    val denominador = scanner.nextInt()
    return Fraccion(numerador, denominador)
}

fun mostrarEjemplos() {
    println("\n=== EJEMPLOS PREDEFINIDOS ===")

    val f1 = Fraccion(1, 2)  // 1/2
    val f2 = Fraccion(1, 3)  // 1/3

    println("Fracción 1: $f1")
    println("Fracción 2: $f2")
    println("Suma: $f1 + $f2 = ${f1 + f2}")
    println("Resta: $f1 - $f2 = ${f1 - f2}")
    println("Multiplicación: $f1 * $f2 = ${f1 * f2}")
    println("División: $f1 / $f2 = ${f1 / f2}")
    println("¿$f1 > $f2? ${f1 > f2}")
    println("$f1 en decimal: ${f1.aDecimal()}")
}


//CÁCLULOS

fun realizarSuma(scanner: Scanner) {
    val f1 = leerFraccion(scanner, "Ingrese la fracción N°1")
    val f2 = leerFraccion(scanner, "Ingrese la fracción N°2")
    println("$f1 + $f2 es igual: ${f1 + f2}")
}

fun realizarResta(scanner: Scanner) {
    val f1 = leerFraccion(scanner, "Ingrese la fracción N°1")
    val f2 = leerFraccion(scanner, "Ingrese la fracción N°2")
    println("$f1 + $f2 es igual: ${f1 - f2}")
}

fun realizarMultiplicacion(scanner: Scanner) {
    val f1 = leerFraccion(scanner, "Ingrese la fracción N°1")
    val f2 = leerFraccion(scanner, "Ingrese la fracción N°2")
    println("$f1 + $f2 es igual: ${f1 * f2}")
}

fun realizarDivision(scanner: Scanner) {
    val f1 = leerFraccion(scanner, "Ingrese la fracción N°1")
    val f2 = leerFraccion(scanner, "Ingrese la fracción N°2")
    println("$f1 + $f2 es igual: ${f1 / f2}")
}

fun realizarComparacion(scanner: Scanner) {
    val f1 = leerFraccion(scanner, "Ingrese la fracción N°1")
    val f2 = leerFraccion(scanner, "Ingrese la fracción N°2")
    val resul = f1.compareTo(f2)
    if (resul == -1) println("$f1 es menor que $f2")
    if (resul == 0) println("$f1 es igual que $f2")
    if (resul == 1) println("$f1 es mayor que $f2")
}

fun convertirADecimal(scanner: Scanner) {
    val frac = leerFraccion(scanner, "Ingrese la fracción")
    println("$frac en decimal es: ${frac.aDecimal()}")
}

fun crearDesdeDecimal (scanner: Scanner){
    println("Ingrese el número decimal: ")
    val deci = scanner.nextDouble()
    println("$deci en fracción es: ${Fraccion.desdeDecimal(deci)}")
}