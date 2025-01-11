package org.example.solid.liskovsubstitution

//Liskovsubstitution principle say that child class substitide replace of base class without affecting correctness/results of base class
// Here Penguine class affect the base class bird.
// this will not build. we forbid from program to crash

fun main() {
    val eagle = EagleFixed ()
    val duck = DuckFixed()
    val penguin = PenguinFixed ()
    makeFlyFixed(eagle)
    makeFlyFixed(duck)
    //makeFlyFixed(penguin)

}
interface  flayAble{
     fun fly(){
         println("Bird fly")
     }
}
fun makeFlyFixed (flayAble: flayAble){
    flayAble.fly()
}


open class BirdFixed{
    open fun walk(){
        println("Bird walk")
    }
}


open class EagleFixed: BirdFixed(), flayAble {
    override fun fly(){
        println("Bird fly High")
    }

}

open class DuckFixed: BirdFixed(), flayAble {
    override fun fly(){
        println("Bird fly Slow")
    }
    override fun walk(){
        println("Bird walk Slow")
    }
}
open class PenguinFixed: BirdFixed(){
    override fun walk(){
        println("Bird walk funny")
    }

}


