import kotlinx.coroutines.*

fun main() {
    runBlocking {
//        // Must have android context
//        launch(Dispatchers.Main) {
//            println("Main Dispatcher, ${Thread.currentThread().name}")
//        }

        launch(Dispatchers.Unconfined) {
            println("1.Unconfined Dispatcher, ${Thread.currentThread().name}")
            delay(100)
            println("2.Unconfined Dispatcher, ${Thread.currentThread().name}")
        }

        launch(Dispatchers.Default) {
            println("Default Dispatcher, ${Thread.currentThread().name}")
        }

        launch(Dispatchers.IO) {
            println("IO Dispatcher, ${Thread.currentThread().name}")
        }

        launch(newSingleThreadContext("MyThread")) {
            println("MyThread Dispatcher, ${Thread.currentThread().name}")
        }
    }


}