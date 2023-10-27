package kr.co.eoding.kotlingrammar.chapter2

import org.junit.jupiter.api.Test

class ObjectTest {

    private val arr1 = listOf(1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3)

    @Test
    fun tuplePairTest() {
        val pair = Pair("a", 1)
        println("pair.first - ${pair.first}")
        println("pair.second - ${pair.second}")
        println("pair.toList().map { it } - ${pair.toList().map { it }}")
    }

    @Test
    fun tupleTripleTest() {
        val triple = Triple("a", '.', 3)
        println("triple.first - ${triple.first}")
        println("triple.second - ${triple.second}")
        println("triple.third - ${triple.third}")
        println("triple.component1() - ${triple.component1()}")
        println("triple.component2() - ${triple.component2()}")
        println("triple.component3() - ${triple.component3()}")
        println("triple.toList().map { it } - ${triple.toList().map { it }}")
    }

    @Test
    fun arrTest() {
        println("arr1.distinct() - ${arr1.distinct()}")
        println("arr1.distinctBy { it % 2 == 0 } - ${arr1.distinctBy { it / 2 }}") // 중괄호 안에 계산된 값으로 중복 제거
    }

}