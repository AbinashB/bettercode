package org.example.solid.liskovsubstitution

//Liskovsubstitution principle say that child class substitide replace of base class without affecting correctness/results of base class
// Here Penguine class affect the base class bird. Program crash

fun main() {
    val eagle = Eagle ()
    val duck = Duck()
    val penguin = Penguin ()
    makeFly(eagle)
    makeFly(duck)
    makeFly(penguin)

}
fun makeFly (bird: Bird){
    bird.fly()
}

open class Bird{ //base class Bird which has atribute to fly and walk
    open fun fly(){
        println("Bird fly")
    }
    open fun walk(){
        println("Bird walk")
    }
}


open class Eagle: Bird(){
    override fun fly(){
        println("Bird fly High")
    }

}

open class Duck: Bird(){
    override fun fly(){
        println("Bird fly Slow")
    }
    override fun walk(){
        println("Bird walk Slow")
    }
}
open class Penguin: Bird(){
    override fun fly(){
      throw Exception("Can not fly")
    }
    override fun walk(){
        println("Bird walk funny")
    }

}


