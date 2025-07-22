(prompts de IA) 

(punto 1)

le pasamos el codigo:

Implementar el constructor principal que reciba numerador y denominador como parámetros.

Implementar las propiedades con getters y setters automáticos de Kotlin. 

Qué erroes hay en el codigo que no estén siguiendo esta consigna? 

Creame un ejemplo para que pueda implementar la funcion fraccion en el app.kt y que valide si el denominador es cero en el constructor, sin que de error en el codigo. 

(punto 2)

dame ejemplos de prueba para implementar el siguiente operador: 

    operator fun plus(otra: Fraccion): Fraccion {
    //fórmula: (a/b) + (c/d) = (ad + bc)/(b*d)
    val nnumerador= (this.numerador * otra.denominador) + (otra.numerador * this.denominador)
    val ddenominador = this.denominador *otra.denominador
    return Fraccion (nnumerador, ddenominador)
    }

no aparecen las fracciones simplificadas, este es el codigo que hice para poder simplificarlas 

    fun simplificar(): Fraccion {
        val mcd = mcd(numerador, denominador)
        return Fraccion(numerador / mcd, denominador / mcd)
    }

    fun mostrar(): String = toString()

    private fun mcd(a: Int, b: Int): Int {
        return if (b == 0) a else mcd(b, a % b)
    }

    override fun toString(): String {
        return "$numerador/$denominador"
    }