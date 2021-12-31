import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.random.Random
import kotlin.random.Random.Default.nextInt

fun main() {

    runBlocking {

        val firstDeferred = async { getFirstVal() }
        val secondDeferred = async { getSecondVal() }

        println("Doing some processings...")
        delay(500)
        println("Waiting for values...")

        val firstValue = firstDeferred.await()
        val secondValue = secondDeferred.await()

        println("Total = ${firstValue + secondValue}")
    }

}

suspend fun getFirstVal(): Int {
    delay(500)
    val value= Random.nextInt(100)
    println("Returning first value $value")
    return value
}

suspend fun getSecondVal(): Int {
    delay(1000)
    val value= Random.nextInt(100)
    println("Returning second value $value")
    return value
}