package org.example

//PUNTO 1 
class Fraccion(
    numerador: Int,
    denominador: Int
) {
    var numerador: Int = numerador
        set(value) { field = value }
    
    var denominador: Int = denominador
        set(value) {
            if (value == 0) throw IllegalArgumentException("El denominador no puede ser cero")
            field = value
        }

    init {
        require(denominador != 0) { "El denominador no puede ser cero." }
    }

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
    //PUNTO 2 

    operator fun plus(otra: Fraccion): Fraccion {
        //fórmula: (a/b) + (c/d) = (a*d + b*c)/(b*d)
        val nnumerador= (this.numerador * otra.denominador) + (otra.numerador * this.denominador)
        val ddenominador = this.denominador *otra.denominador
        return Fraccion (nnumerador, ddenominador)
    }
}

    