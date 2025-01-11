package org.example

fun main() {
//    println("What's your name?")
//    val name = readln()
//    println("Hello, $name!")
    val baseClass = BaseClass()
    val childClass = ChildClass()
    funcationAble(baseClass)
    funcationAble(childClass)
}

 fun funcationAble(baseClass: BaseClass){
    baseClass.baseFunction()
}

open class BaseClass{
    open fun baseFunction(){
        println("I am base function")
    }

}

open class ChildClass : BaseClass(){
    override fun baseFunction(){
        println("I am child function")
    }

}