package org.example.solid.liskovsubstitution
import java.util.LinkedList

// here List don't have function for .add as it keep minimum implimentation but childclass have it's own

fun main() {
    val mylist1 :MutableList<String> = ArrayList<String>()
    mylist1.add("John")
    mylist1.add("Mary")
    printListItem(mylist1)

    val mylist2 :MutableList<String> = LinkedList<String>()
    mylist2.add("Peter")
    mylist2.add("Ganesh")
    printListItem(mylist2)

}

fun printListItem(list :List<String>) {
    for (item in list) {
        println(item)
    }
}

