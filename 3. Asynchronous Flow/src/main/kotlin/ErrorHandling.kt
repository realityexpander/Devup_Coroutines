import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking

fun main() {

    runBlocking {
//        trycatch()  // regular way to catch exceptions

//        collectTryCatch()

        onCompletion()

    }
    
}

suspend fun onCompletion() {
    (1..5).asFlow()
        .onEach {
            check(it != 2)
        }
        .onCompletion { e->  // Like a finally block
            if(e!=null)
                println("Flow completed with exception $e")
            else
                println("Flow completed successfully")
        }
        .catch { e ->  // flow way to catch exceptions
            println("Caught exception $e")
        }
        .collect {
            println(it)
        }
}

private suspend fun collectTryCatch() {
    (1..5).asFlow()
        .onEach {
            check(it != 2)
        }
        .catch { e ->  // flow way to catch exceptions
            println("Caught exception $e")
        }
        .collect {
            println(it)
        }
}

suspend fun trycatch() {
    try {
        (1..5).asFlow()
            .onEach {
                check(it != 2)
            }
            .collect {
                println(it)
            }

    } catch (e: Exception) {
        println("Caught exception $e")
    }
}