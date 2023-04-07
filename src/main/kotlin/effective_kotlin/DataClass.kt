package effective_kotlin

data class DataClass(
    var id: Long
)


fun main(){
    noneDataClassTest()
    dataClassTest()
}

fun noneDataClassTest() {
    val nd1 = NoneDataClass(1)
    val nd2 = NoneDataClass(1)

    println("noneDataClassTest")
    println("nd1 HashCode: ${nd1.hashCode()}, nd2 HashCode: ${nd2.hashCode()}")
    if (nd1 == nd2) {
        println("nd1 == nd2")
    }
    else {
        println("n d1 != nd2")
    }
}

fun dataClassTest(){
    val d1 = DataClass(1)
    val d2 = DataClass(1)

    println("dataClassTest")
    println("nd1 HashCode: ${d1.hashCode()}, nd2 HashCode: ${d2.hashCode()}")
    if (d1 == d2) {
        println("d1 == d2")
    }
    else {
        println("d1 != d2")
    }
}