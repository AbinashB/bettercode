package org.example.solid.interfacesegregation
// Class not forced to user interface if it doesn't impliment all the method defined by that interface
// Instead of creating large general purpose inteface, it is better to create small interface more sepcific as per our need
// we fixed bad practise by compilation error
fun main() {
    val eagle =EagleFixed()
    val penguin =PenguinFixed()
    val duck =DuckFixed()
    flyAble(eagle)
    //flyAble(penguin) // Fixed it will give compilation error
    swimAble(penguin)
    flyAble(duck)
}

fun flyAble(flyInterface: FlyInterface){
    flyInterface.fly()

}

fun swimAble(swimInterface: SwimInterface){
    swimInterface.swim()

}

interface FlyInterface {
    fun fly()
}
interface SwimInterface {
    fun swim()
}

open class BirdFixed

class EagleFixed : BirdFixed(), FlyInterface{
    override fun fly() {
        println("eagle is flying")
    }
}

class PenguinFixed : BirdFixed(), SwimInterface{

    override fun swim() {
        println("penguin is swim")
    }
}
class DuckFixed : BirdFixed(), FlyInterface,SwimInterface{
    override fun fly() {
        println("duck is flying slow")
    }

    override fun swim() {
        println("duck is swim slow")
    }
}