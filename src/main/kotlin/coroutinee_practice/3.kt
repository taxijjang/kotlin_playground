package coroutinee_practice

import kotlinx.coroutines.*


fun main(): Unit = runBlocking {
    val job = async {
        1 + 3
    }
    val result = job.await()
    println(result)
}

fun example4(): Unit = runBlocking {
    val job1 = launch{
        delay(1_000L)
        printWithThread("Job 1")
    }
    job1.join()

    val job2 = launch {
        delay(2_000L)
        printWithThread("Job 2")
    }
    job2.join()
}

fun example3_3(): Unit = runBlocking {
    val job = launch {
        (1..5).forEach{
            printWithThread("Hello launch $it")
            delay(1_000L)
        }
    }

    delay(1_000L)
    job.cancel()
 }

fun exmaple3_2() = runBlocking {
    val job = launch(start = CoroutineStart.LAZY) {
        printWithThread("Hello launch")
    }

    delay(1_000L)
    job.start()
}

fun example3_1(){
    runBlocking {
        printWithThread("START")
        launch{
            delay(2)
            printWithThread("END")
        }
    }
}