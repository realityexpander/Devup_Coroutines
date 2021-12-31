import kotlinx.coroutines.*

fun main() {
    runBlocking {
        launch {
            delay(1000)
            println("Task from runBlocking ")
        }

        GlobalScope.launch {
            delay(500)
            println("Task from globalScope")
        }

        coroutineScope {
            launch {
                delay(1500L)
                println("Task from coroutineScope")
            }
        }
    }

    println("Program will now continue")
}