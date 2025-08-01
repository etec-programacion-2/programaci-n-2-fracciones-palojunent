(prompts de IA)

HERRAMIENTA USADA PARA TODOS LOS PROMPS: CLAUDE 

(punto 1)
Fecha de los promps: 22/07/25
le pasamos el codigo:

Implementar el constructor principal que reciba numerador y denominador como parámetros.

Implementar las propiedades con getters y setters automáticos de Kotlin. 

Qué erroes hay en el codigo que no estén siguiendo esta consigna? 

Creame un ejemplo para que pueda implementar la funcion fraccion en el app.kt y que valide si el denominador es cero en el constructor, sin que de error en el codigo. 

(punto 2)
Fecha de los promps: 22/07/25 y 26/07/25
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

(punto 3)
Fecha de los promps: 26/07/25
Revisa la parte de simplificacion del siguiente codigo, que no simplifica las fracciones: 
    
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

(punto 4)
Fecha del promp: 01/08/25
// Convierte el Double en Fracción
 val resulNumerador = (decimal * 10.0.pow(numDecimas)).toInt()
val resulDenominador = (10.0.pow(numDecimas)).toInt()
return this.simplificar(resulNumerador, resulDenominador) 

me da error en el pow, dame distintas soluciones