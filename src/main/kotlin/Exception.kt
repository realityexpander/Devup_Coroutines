import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

fun main() {

    runBlocking {

        /////////////// launch with ExceptionHandler /////////////////

        val myHandler = CoroutineExceptionHandler { context: CoroutineContext, throwable ->
            println("Exception handled by MyHandler: ${throwable.localizedMessage}")
        }

        val job = GlobalScope.launch(myHandler) {
            println("Throwing an exception from job...")
            throw IndexOutOfBoundsException("Index out of bounds from launch")
        }
        job.join()


        /////////////// async /////////////////

        val deferred = GlobalScope.async {
            println("Throwing exception from async")
            throw ArithmeticException("Arithmetic exception from async")
        }

        try {
            deferred.await()
        } catch (e: ArithmeticException) {
            println("caught Arithmetic exception :$e")
        } catch (e: IndexOutOfBoundsException) {
            println("caught Index Out Of Bounds exception :$e")
        }
    }

}