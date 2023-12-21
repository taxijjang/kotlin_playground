package advancekotlin.generic

fun main(){
//    val cage = Cage()
//    cage.put(Carp("잉어"))

    // return 형태가 Animal이기 때문에 error 발생
//    val carp: Carp = cage.getFirst()
//    val carp: Carp = cage.getFirst() as Carp


    val goldFishCage = Cage2<GoldFish>()
    goldFishCage.put(GoldFish("금붕어"))

    val fishCage = Cage2<Fish>()

    // GoldFish 는 Fish 의 자식인데 왜 error가 발생할까?
    fishCage.moveFrom(goldFishCage)

    // 오우씨 이건 되는데?
    fishCage.put(GoldFish("금붕어"))


}

class Cage {
    private val animals: MutableList<Animal> = mutableListOf()

    fun getFirst(): Animal {
        return animals.first()
    }

    fun put(animal: Animal) {
        this.animals.add(animal)
    }

    fun moveFrom(cage: Cage) {
        this.animals.addAll(cage.animals)
    }
}

class Cage2<T>{
    private val animals = mutableListOf<T>()

    fun getFirst(): T {
        return animals.first()
    }

    fun put(animal: T) {
        this.animals.add(animal)
    }

    fun moveFrom(otherCage: Cage2<out T>) {
        this.animals.addAll(otherCage.animals)
    }

    fun moveTo(otherCage: Cage2<in T>){
        otherCage.animals.addAll(this.animals)
    }
}