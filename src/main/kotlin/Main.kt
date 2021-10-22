fun tablaMultiplicar(n: Int){ //Muestra la tabla de un número dado.
    var producto: Int
    println("\nTABLA DEL $n \n" + "*".repeat(11))

    for (operando in 1.rangeTo(10))
            println("$n x $operando = " + (operando *n))
}

fun pedir_datos():Pair<Int, Int> {
    print("Introduzca la edad y el mes actual, separados por comas: ")
    val datos = readLine() ?: ""
    val lista = datos.split(",")

    val edad:Int = try{lista[0].trim().toInt()}
        catch(e: Exception){0}
    val mes:Int = try{lista[1].trim().toInt()}
        catch(e: Exception){0}

    return Pair(edad, mes)
}

fun edadValida(n:Int):Boolean{return n in 6..12}

fun mesValido(n:Int):Boolean{return n in 1..12}

fun esPar(mes:Int):Boolean{return mes%2 == 0}

fun muestraTablasCorrectas(edad:Int, par:Boolean){
    print("Edad: $edad. ")
    when(edad) {
        in 6..8 -> {
            println("El alumno está dentro del rango [6-8]")
            if (par) {
                println("El mes es par, corresponden las tablas siguientes: {1, 3, 5}.")
                for (operando in 1..5 step 2)
                    tablaMultiplicar(operando)
            } else {
                println("El mes es impar, corresponden las tablas siguientes: {2, 4}.")
                for (operando in 2..4 step 2)
                    tablaMultiplicar(operando)
            }
        }

        in 9..10 -> {
            println("El alumno está dentro del rango [9-10]")
            if (par) {
                println("El mes es par, corresponden las tablas siguientes: {7, 9}.")
                for (operando in 7..9 step 2)
                    tablaMultiplicar(operando)
            } else {
                println("El mes es impar, corresponden las tablas siguientes: {6, 8, 10}.")
                for (operando in 6..10 step 2)
                    tablaMultiplicar(operando)
            }
        }

        in 11..12 -> {
            println("El alumno está dentro del rango [11-12]")
            if (par) {
                print("El mes es par, corresponden las tablas siguientes:{11, 12, 13}")
                for (operando in 11..13)
                    tablaMultiplicar(operando)
            }
            else {
                println("El mes es impar, corresponden las tablas siguientes: {14, 15, 16}.")
                for (operando in 14..16)
                    tablaMultiplicar(operando)
            }
        }
    }
}

fun mensajeInicial() = println("\n" +"*".repeat(70) + "\n"
                        + "PROGRAMA DE GENERACIÓN DE TABLAS: ALEJANDRO M. OGALLA LÓPEZ \n"
                        +  "-".repeat(70))

fun mensajeFinal() = println("*".repeat(70))

fun main(args: Array<String>) {
    val datos = pedir_datos()
    val edad = datos.first
    val mes = datos.second

    mensajeInicial()

    if(edadValida(edad) && mesValido(mes))
        muestraTablasCorrectas(edad, esPar(mes))
    else{
        if(!edadValida(edad))
            println("Edad: $edad. Tiene que estar en los rangos permitidos.")
        if(!mesValido(mes))
            println("Mes: $mes. Tiene que ser un número válido: 1-12.")
    }

    mensajeFinal()
}