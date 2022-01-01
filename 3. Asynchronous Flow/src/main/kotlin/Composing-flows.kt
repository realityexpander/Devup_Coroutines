import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
//        zip()
        combine()
    }
}

// Triggers on latest, and uses the other most recent value
suspend fun combine() {
    val numbers1 = (1..5).asFlow()
        .onEach { delay(300L) }
    val numbers2 = flowOf("One", "Two", "Three", "Four", "Five")
        .onEach { delay(400L) }
    numbers1.combine(numbers2) { a, b ->
        "$a -> $b"
    }
        .collect { println(it) }
}

// Waits for both emitters to be ready
suspend fun zip() {
    val english = flowOf("One", "Two", "Three")
    val french = flowOf("Un", "Deux", "Troix")
    english.zip(french) { a, b -> "'$a' in French is '$b'" }
        .collect {
            println(it)
        }
}