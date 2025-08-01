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
   
    //PUNTO 2 

    operator fun plus(otra: Fraccion): Fraccion {
        //fórmula: (a/b) + (c/d) = (a*d + b*c)/(b*d)
        val nnumerador= (this.numerador * otra.denominador) + (otra.numerador * this.denominador)
        val ddenominador = this.denominador *otra.denominador
        return Fraccion (nnumerador, ddenominador).simplificar()
    }
    operator fun minus(otra: Fraccion): Fraccion {
       //fórmula: (a/b) - (c/d) = (ad - bc)/(b*d)
       val nnumerador= (this.numerador * otra.denominador) - (otra.numerador * this.denominador)
       val ddenominador = this.denominador *otra.denominador
       return Fraccion (nnumerador, ddenominador).simplificar()
   }
    fun simplificar(): Fraccion {
        val mcd = mcd (this.numerador,this.denominador)
        return Fraccion (this.numerador/mcd, this.denominador/mcd)
    }
     private fun mcd(a: Int, b: Int): Int {
        return if (b == 0) a else mcd(b, a % b)
    }
    override fun toString(): String {
        return "$numerador/$denominador"
    }
    fun mostrar(): String = toString()

    //PUNTO TRES 
    
    operator fun times(otra: Fraccion): Fraccion { 
        //formula: (a/b) * (c/d) = (ac)/(bd)
        val multiNumerador = this.numerador * otra.numerador
        val multiDenominador = this.denominador * otra.denominador

        return Fraccion(multiNumerador, multiDenominador).simplificar()
    }

    operator fun div(otra: Fraccion): Fraccion{ 
        //formula: (a/b) / (c/d) = (ad)/(bc)
        if (otra.numerador == 0){
            throw IllegalArgumentException("El numerador de la segunda fracción no puede ser cero")
        }
        val diviNumerador = this.numerador * otra.denominador
        val diviDenominador = this.denominador * otra.numerador

        return Fraccion (diviNumerador, diviDenominador). simplificar()
    }
    //PUNTO 4
    operator fun compareTo(otra: Fraccion): Int {
       val comparaFraccion = ((this.numerador * otra.denominador). toDouble()).compareTo((otra.numerador * this.denominador).toDouble())
       return (comparaFraccion)
   }
    override fun equals(other: Any?): Boolean { 
        if (this === other){ // compara si los objetos son los mismos 
            return true
        }
        if (other !is Fraccion) { // si other no es un objeto de la clase, que devuelva falso
            return false
        }
        return this.numerador * other.denominador == other.numerador * this.denominador
    }
     fun esMayor(otra: Fraccion): Boolean { // Retorna true si es mayor
        if (this.numerador * otra.denominador > otra.numerador * this.denominador){
            return true
        }
        return false
    }
    fun esMenor(otra: Fraccion): Boolean { // Retorna true si es menor
        if (this.numerador * otra.denominador < otra.numerador * this.denominador){
            return true
        }
        return false
    }
    fun aDecimal(): Double{ // Retorna la fracción como decimal
        return ((numerador.toDouble() / denominador.toDouble())* 1000) / 1000
    }
    companion object{ // No se necesita crear un objeto para usarla
        //Esta función la hice por que no puedo llamar a la otra dentro de companion object
        fun simplificar(numerador: Int, denominador: Int): Fraccion{ 
            var numSim = numerador
            var denSim = denominador

            while (denSim != 0) {
                val temp = denSim
                denSim = numSim % denSim
                numSim = temp
            }
            val resultN: Int = (numerador / numSim)
            val resultD: Int = (denominador / numSim)

            return Fraccion(resultN,resultD )
        }


        fun desdeDecimal(decimal: Double): Fraccion{ 

            // Divide los decimales del entero
            val numStr: String = decimal.toString()
            val decimasStr: String = numStr.substring(numStr.indexOf('.') + 1 )
            var numDecimas: Int = 0
            for (i in decimasStr){
                numDecimas += 1
            }

            // Convierte el Double en Fracción
            var potencia = 1
        repeat(numDecimas) {
            potencia *= 10
        }
        val resulNumerador = (decimal * potencia).toInt()
        val resulDenominador = potencia
        return this.simplificar(resulNumerador, resulDenominador)
        }
    }

}

    