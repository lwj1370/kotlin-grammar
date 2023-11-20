package kr.co.eoding.kotlingrammar.chapter4

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import java.lang.Exception

class Coroutine {

    private val privateCoroutineScope = CoroutineScope(Dispatchers.Default)

    @Test
    fun coroutineTest() {
        // GlobalScope.launch는 앱 전체에서 사용되는 전역 스코프 코루틴을 시작합니다.
        // 주의: GlobalScope를 사용할 때는 앱 전체에서 관리되기 때문에 메모리 누수에 주의해야 합니다.
        GlobalScope.launch {
            println("코루틴 시작")

            // delay 함수는 비동기로 지정된 시간만큼 일시 중지시킵니다.
            delay(1000)

            println("1초 후에 출력")

            // 다른 비동기 작업을 시작할 수 있습니다.
            val result = withContext(Dispatchers.Default) {
                // withContext 함수를 사용하여 다른 스레드에서 동작하도록 지정할 수 있습니다.
                "다른 스레드에서 실행된 결과"
            }

            println(result)

            // 코루틴이 끝났음을 알립니다.
            println("코루틴 종료")
        }

        // 메인 스레드는 계속해서 실행됩니다.
        println("메인 스레드 계속 실행 중")

        // 메인 스레드가 종료되면서 앱이 종료되기 전에 충분한 시간을 주기 위해
        // delay 함수를 사용합니다.
        runBlocking {
            delay(2000)
        }
    }

    @Test
    fun coroutineLaunchTest() {
        // Exception 이후 스코프가 실행 되지 않음
        CoroutineScope(Dispatchers.Unconfined).launch {
            val scope = coroutineScope {
                launch { println("Test Start") }
                launch { throw Exception("Test Start") }
                launch { println("Test End") }
            }

            scope.children.forEach {
                it.join()
            }
        }
    }

    @Test
    fun supervisorLaunchTest() {
        val superJob = SupervisorJob()

        // Exception 이후 스코프가 실행 됨
        CoroutineScope(Dispatchers.Default).launch {
            val scope = supervisorScope {
                launch { println("Test Start") }
                launch { throw Exception("Test Start") }
                launch { println("Test End") }
            }

            scope.children.forEach {
                it.join()
            }
        }
    }

    private suspend fun coroutineScopeTest() {
        coroutineScope {
            launch {
                println("Coroutine Scope Test")
            }

        }
    }

    private suspend fun supervisorScopeTest() {
        supervisorScope {
            launch {
                println("SupervisorScope Scope Test Start")
            }.join()
            launch {
                println("SupervisorScope Scope Test End")
            }.join()
        }
    }

}