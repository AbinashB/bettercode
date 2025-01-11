package org.example.solid.interfacesegregation

// Class not forced to user inteerface if it doesn't impliment all the method defined by that interface
// Instead of creating large general purpose inteface, it is better to create small interface more sepcific as per our need
// Bad Practise we have provided input by calling fucntion but it doesn't do anything
fun main() {
    val eagle =Eagle()
    val penguin =Penguin()
    val duck =Duck()
    flyAble(eagle)
    flyAble(penguin) // Bad Practise program doesn't have output
    swimAble(penguin)
}

fun flyAble(birdAction: BirdAction){
    birdAction.fly()

}

fun swimAble(birdAction: BirdAction){
    birdAction.swim()

}

interface BirdAction{
    fun fly()
    fun swim()
}

open class Bird

class Eagle : Bird(), BirdAction{
    override fun fly() {
        println("eagle is flying")
    }

    override fun swim() {}
}

class Penguin : Bird(), BirdAction{
    override fun fly() {}

    override fun swim() {
        println("penguin is swim")
    }
}
class Duck : Bird(), BirdAction{
    override fun fly() {
        println("duck is flying slow")
    }

    override fun swim() {
        println("duck is swim slow")
    }
}