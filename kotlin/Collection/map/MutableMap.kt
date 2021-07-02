package wgr3v34

fun main() {
    val capitalCityMap: MutableMap<String, String> =
        mutableMapOf("Korea" to "Seoul", "China" to "Beijing", "Japan" to "Tokyo")
    println(capitalCityMap.values)
    println(capitalCityMap.keys)

    capitalCityMap["UK"] = "London"
    //capitalCityMap.put("UK", "London")

    capitalCityMap["Japan"] = ""

    capitalCityMap.putAll(mapOf("Egypt" to "Cairo", "Gambia" to "Banjul"))

    capitalCityMap.remove("China")
    println(capitalCityMap)
}

/*
[Seoul, Beijing, Tokyo]
[Korea, China, Japan]
{Korea=Seoul, Japan=, UK=London, Egypt=Cairo, Gambia=Banjul}

Process finished with exit code 0

 */