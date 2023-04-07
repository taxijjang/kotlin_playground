import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

suspend fun main() {
//    val account = BankAccount()
//    println(account.balance)
//    account.deposit(100.0)
//    println(account.balance)
//    account.withdraw(50.0)
//    println(account.balance)
//
//    threadTest()
//    coroutineTest()
//    lockTest()

//    val list1: MutableList<Int> = mutableListOf()
//    var list2: List<Int> = listOf()
//
//    list1 += 1
//    list2 = list2 + 1
//
//    println(list1)
//    println(list2)
//    listTest()
//    eratotenes()
//    factorial(-1)
}

class BankAccount {
    var balance = 0.0
        private set

    fun deposit(depositAmount: Double) {
        balance += depositAmount
    }

    @Throws(InsufficientFunds::class)
    fun withdraw(withdrawAmount: Double) {
        if (balance < withdrawAmount) {
            throw InsufficientFunds()
        }
        balance -= withdrawAmount
    }
}

class InsufficientFunds : Exception()


fun threadTest() {
    var num = 0
    for (i in 1..1000) {
        thread {
            Thread.sleep(10)
            num += 1
        }
    }
    Thread.sleep(5000)
    println("threadTest: $num")
}

suspend fun coroutineTest() {
    var num = 0
    coroutineScope {
        for (i in 1..1000) {
            launch {
                delay(10)
                num += 1
            }
        }
    }
    println("coroutinTest: $num")
}

fun lockTest() {
    val lock = Any()
    var num = 0
    for (i in 1..1000) {
        thread {
            Thread.sleep(10)
            synchronized(lock) {
                num += 1
            }
        }
    }
    Thread.sleep(1000)
    println("lockTest: $num")
}

fun listTest() {
    val list1: MutableList<Int> = mutableListOf()
    var list2: List<Int> = listOf()

    for (i in 1..1000) {
        thread {
            list1.add(i)
        }
    }
    Thread.sleep(1000)
    println(list1.size)
}

fun eratotenes() {
    val primes: Sequence<Int> = sequence {
        var numbers = generateSequence(2) { it + 1 }

        while (true) {
            val prime = numbers.first()
            yield(prime)
            numbers = numbers.filter { it % prime != 0 }
        }
    }
    print(primes.take(10).toList())
}

open class Animal
class Zebra : Animal()


fun inferredTypeTest() {
    var animal = Zebra()
//    animal = Animal() // error

    var animal2: Animal = Zebra()
    animal2 = Animal()
}

fun factorial(n: Int): Long {
    require(n >= 0)
    return if (n < 1) 1 else factorial(n - 1) * n
}