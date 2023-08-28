package play

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// 2 1 4 3
fun main() {
    print("main: ")
    println(Thread.currentThread())
    runBlocking {
        print("runBlocking1: ")
        println(Thread.currentThread())

        launch {
            delay(3000)
            println("Hello1")
        }
        runBlocking {
            print("runBlocking2: ")
            println(Thread.currentThread())
            delay(3000)
            println("Hello2")
        }
        launch {
            delay(2000)
            println("Hello3")
        }
        launch {
            delay(1000)
            println("Hello4")
        }
    }
    abc()
}

fun abc(){
    print(Thread.currentThread())
}