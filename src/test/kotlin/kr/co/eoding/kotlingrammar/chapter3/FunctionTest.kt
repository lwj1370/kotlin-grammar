package kr.co.eoding.kotlingrammar.chapter3

import org.junit.jupiter.api.Test

typealias TypeAliasTest = (Int, Int) -> String

class FunctionTest {

    @Test
    fun functionTest() {
        // 1차
        testFunction1(
            "1", 2, ::test1,
            5, 3, ::test2
        )
        // 2차
        testFunction2(::test3, ::test4)
        // 3차
        test5(2, 3, ::test6)
        // 4차
        val testFunction3: (Int, Int) -> String = ::test6
        println(testFunction3(1, 2))
    }

    // 1차 매개변수가 있는 함수
    private fun test1(a: String, b: Int): Boolean {
        return a.length > b
    }

    private fun test2(a: Int, b: Int): Boolean {
        return a > b
    }

    private fun testFunction1(
        function1Str1: String,
        function1Int2: Int,
        function1: (a: String, b: Int) -> Boolean,
        function2Int1: Int,
        function2Int2: Int,
        function2: (a: Int, b: Int) -> Boolean,) {

        println("function1 : ${function1(function1Str1, function1Int2)}")
        println("function2 : ${function2(function2Int1, function2Int2)}")
    }

    // 2차 매개변수가 없는 함수
    private fun test3(): String {
        return "테스트"
    }

    private fun test4(defaultParam: String = "test"): String {
        return defaultParam
    }

    private fun testFunction2(
        function1: () -> String,
        function2: () -> String,
    ) {
        println(function1())
        println(function2())
    }

    // 3차 typeAlias를 사용하는 경우
    private fun test5(a: Int, b: Int, type: TypeAliasTest): String {
        return type(a, b)
    }

    // 4차 함수를 변수 형태로 저장하는 경우
    private fun test6(a: Int, b: Int): String {
        return (a + b).toString()
    }

}