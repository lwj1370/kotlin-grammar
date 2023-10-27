package kr.co.eoding.kotlingrammar.chapter1

import org.junit.jupiter.api.Test

class StringTest {

    private val str1 = "abcdefghijk"
    private val strNumber1 = "1234"

    private val arr1 = arrayOf("1", "2", "3", "4", "5")
    private val arr2 = arrayOf("a", "b", "c", "d", "e")

    @Test
    fun stringTest1() {
        println("str1.let { it.length } - ${str1.let { it.length }}")
        println("str1.run { this.length } - ${str1.run { this.length }}")
        println("str1.also { it.length } - ${str1.also { it.length }}")
        println("str1.apply { this.length } - ${str1.apply { this.length }}")
    }

    @Test
    fun stringTest2() {
        println("str1.reversed() - ${str1.reversed()}")
        println("str1.take(1) - ${str1.take(1)}")
        println("str1.takeLast(3) - ${str1.takeLast(3)}")
        println("str1.hashCode() - ${str1.hashCode()}")
        println("str1.drop(3) - ${str1.drop(3)}")
        println("str1.dropLast(3) - ${str1.dropLast(3)}")
        println("str1.codePointAt(4) - ${str1.codePointAt(4)}")
        println("str1.replaceIndent(\"1\") - ${str1.replaceIndent("1")}")
        println("str1.firstOrNull() - ${str1.firstOrNull()}")
    }

    @Test
    fun stringTest3() {
        println("strNumber1.toIntOrNull(radix = 5) - ${strNumber1.toIntOrNull(radix = 5)}")
        println("strNumber1.toLongOrNull() - ${strNumber1.toLongOrNull()}")
    }

    @Test
    fun stringTest4() {
        println("str1.takeIf { it.length > 0 } ?: \"짧음\" - ${str1.takeIf { it.length > 0 } ?: "짧음"}")
        println("str1.takeLastWhile { it.isDigit() }.toLongOrNull() ?: 0 - ${
            str1.takeLastWhile { it.isDigit() }.toLongOrNull() ?: 0}")
        println("strNumber1.takeLastWhile { it.isDigit() }.toLongOrNull() ?: 0 - ${
            strNumber1.takeLastWhile { it.isDigit() }.toLongOrNull() ?: 0}")
        println("str1.takeWhile { it.isDigit() } - ${str1.takeWhile { it.isDigit() }.toLongOrNull() ?: 0}")
        println("strNumber1.takeWhile { it.isDigit() } - ${strNumber1.takeWhile { it.isDigit() }.toLongOrNull() ?: 0}")
        println("str1.takeUnless { it.isEmpty() } - ${str1.takeUnless { it.isEmpty() }}")
    }

    @Test
    fun stringTest5() {
        println("strNumber1.zipWithNext { a, b -> a + b.digitToInt() } - ${
            strNumber1.zipWithNext { a, b -> a + b.digitToInt() }}")
        // String을 튜플(Pair)형태로 만드는 로직
        println("strNumber1.zip(\"0000\") { a, b -> a + b.toString() } - ${
            strNumber1.zip("0000") { a, b -> a + b.toString() }}")
        // 배열을 튜플(Pair)형태로 만드는 로직
        println("arr1.zip(arr2).map {\n" +
                "            println(\"\${it.first}, \${it.second}\")\n" +
                "        }")
        arr1.zip(arr2).map {
            println("${it.first}, ${it.second}")
        }
    }

}