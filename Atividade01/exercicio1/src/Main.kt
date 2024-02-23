package fundamentos

fun main(args: Array<String>) {

    val  num1: Byte = 127
    val num2: Short = 32767
    val num3: Int = 2_147_483_647
    val num4: Long = 9_223_372_036_854_775_807
    val num5: Float = 3.14F
    val num6: Double = 3.14

    val char: Char = '?'

    val boolean: Boolean = true // ou false
    println(listOf(num1, num2, num3, num4, num5, num6, char, boolean))
    println(2 is Int)
    println(2147483648 is Long)
    println (1.0 is Double)
    println(10.dec())
}