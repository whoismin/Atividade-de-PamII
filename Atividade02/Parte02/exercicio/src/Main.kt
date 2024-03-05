package funções.areas
import kotlin.math.PI
import kotlin.math.sqrt

fun calcAreaR(base: Double, alt: Double): Double {
    return base * alt
}
fun calcAreaTriEquilatero(lado: Double): Double {
    return (sqrt(3.0) / 4) * lado * lado
}
fun calcAreaTriIsosceles(base: Double, alt: Double): Double {
    return (base * alt) / 2
}
fun calcAreaTriEscaleno(ladoA: Double, ladoB: Double, ladoC: Double): Double {
    val perimetro = (ladoA + ladoB + ladoC) / 2
    return sqrt(perimetro * (perimetro - ladoA) * (perimetro - ladoB) * (perimetro - ladoC))
}
fun calcAreaCirc(raio: Double): Double {
    return PI * raio * raio
}
fun calcAreaLos(diagonalMaior: Double, diagonalMenor: Double): Double {
    return (diagonalMaior * diagonalMenor) / 2
}
fun calcAreaTrap(baseMaior: Double, baseMenor: Double, altura: Double): Double {
    return ((baseMaior + baseMenor) * altura) / 2
}
fun main() {
    println("Calculando Áreas")
    val areaR = calcAreaR(5.0, 10.0)
    println("A área do retângulo é: $areaR")
    val areaTriEquilatero = calcAreaTriEquilatero(5.0)
    println("A área do triângulo equilátero é: $areaTriEquilatero")
    val areaTriIsosceles = calcAreaTriIsosceles(4.0, 6.0)
    println("A área do triângulo isósceles é: $areaTriIsosceles")
    val areaTriEscaleno = calcAreaTriEscaleno(3.0, 4.0, 5.0)
    println("A área do triângulo escaleno é: $areaTriEscaleno")
    val areaCirc= calcAreaCirc(3.0)
    println("A área da circunferência é: $areaCirc")
    val areaLos= calcAreaLos(6.0, 8.0)
    println("A área do losango é: $areaLos")
    val areaTrap = calcAreaTrap(6.0, 4.0, 5.0)
    println("A área do trapézio é: $areaTrap")
}