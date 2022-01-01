import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
//        takeOperator()
//        alternativeTerminalOperators()
        flowOnOperator()
    }
}

// Switch to other coroutine dispatcher
suspend fun flowOnOperator() {
    (1..10).asFlow()
        .flowOn(Dispatchers.IO)
        .collect {
            println(it)
        }
}

suspend fun alternativeTerminalOperators() {
    val size = 10
    val factorial = (1..size).asFlow()
        .reduce { accumulator, value ->
            accumulator * value
        }
//        .toList()
//        .toSet()
    println("Factorial of $size is $factorial")
}

suspend fun takeOperator() {
    (1..10).asFlow()
        .take(2)
        .collect {
            println(it)
        }
}