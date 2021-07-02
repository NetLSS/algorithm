package ggkrgok3t3g4g.set

fun main() {
    val animals = mutableSetOf("Lion", "Dog", "Cat", "Python", "Hippo")
    println(animals)

    animals.add("Dog")
    println(animals)

    animals.remove("Dog")
    println(animals)
}