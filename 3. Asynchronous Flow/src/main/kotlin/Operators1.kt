import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        mapOperator()
//        filterOperator()
//        transformOperator()
    }
}

// 1 in and many out
suspend fun transformOperator() {
    (1..10).asFlow()
        .transform {
            emit("Emitting string value $it")
            emit(it)
        }
        .collect {
            println(it)
        }
}

// All in and some out
suspend fun filterOperator() {
    (1..10).asFlow()
        .filter {
            it % 2 == 0
        }
        .collect {
            println(it)
        }
}

// 1 in and 1 out
suspend fun mapOperator() {
    (1..10).asFlow()
        .map {
            delay(500L)
            "mapping $it"
        }
        .collect {
            println(it)
        }
}