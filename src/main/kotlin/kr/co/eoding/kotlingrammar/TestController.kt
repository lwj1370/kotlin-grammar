package kr.co.eoding.kotlingrammar

import kotlinx.coroutines.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/test")
class TestController {

    @GetMapping("/co-scope/dispatchers")
    suspend fun getCoScopeTestResult(): String {
        val result =
        coroutineScope {
            async {
                "test"
            }
        }

        return result.await()
    }
}