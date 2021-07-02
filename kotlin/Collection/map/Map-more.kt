package f2f32fqqq

import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.LinkedHashMap

fun main() {
    val hashMap: HashMap<Int, String> = hashMapOf(1 to "Hello", 2 to "World")
    println("hashMap = $hashMap")

    // sortedMap = 기본적으로 키에 대해 오름차순
    val sortedMap: SortedMap<Int, String> = sortedMapOf(1 to "Apple", 2 to "Samsung")
    println("sortedMap = $sortedMap")

    val linkedHashMap: LinkedHashMap<Int, String> = linkedMapOf(1 to "Computer", 2 to "Mouse")
    println("linkedHashMap = $linkedHashMap")
}