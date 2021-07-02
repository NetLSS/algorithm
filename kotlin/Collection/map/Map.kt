package ggkrgok3t3g4gf

fun main() {
    val langMap: Map<Int, String> = mapOf(11 to "Java", 22 to "Kotlin", 33 to "C++")
    for ((key, value) in langMap){
        println("key=$key, value=$value")
    }

    println("langMap[22] = ${langMap[22]}")
    println("langMap.get(22) = ${langMap.get(22)}") // 위와 동일

    println("langMap.keys = ${langMap.keys}")

    println("${langMap.containsKey(22)}, ${langMap.containsValue("Kotlin")}")
}

/*
/Users/LSS/Library/Java/JavaVirtualMachines/corretto-1.8.0_292/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA CE.app/Contents/lib/idea_rt.jar=64813:/Applications/IntelliJ IDEA CE.app/Contents/bin -Dfile.encoding=UTF-8 -classpath /Users/LSS/Library/Java/JavaVirtualMachines/corretto-1.8.0_292/Contents/Home/jre/lib/charsets.jar:/Users/LSS/Library/Java/JavaVirtualMachines/corretto-1.8.0_292/Contents/Home/jre/lib/ext/cldrdata.jar:/Users/LSS/Library/Java/JavaVirtualMachines/corretto-1.8.0_292/Contents/Home/jre/lib/ext/dnsns.jar:/Users/LSS/Library/Java/JavaVirtualMachines/corretto-1.8.0_292/Contents/Home/jre/lib/ext/jaccess.jar:/Users/LSS/Library/Java/JavaVirtualMachines/corretto-1.8.0_292/Contents/Home/jre/lib/ext/jfxrt.jar:/Users/LSS/Library/Java/JavaVirtualMachines/corretto-1.8.0_292/Contents/Home/jre/lib/ext/localedata.jar:/Users/LSS/Library/Java/JavaVirtualMachines/corretto-1.8.0_292/Contents/Home/jre/lib/ext/nashorn.jar:/Users/LSS/Library/Java/JavaVirtualMachines/corretto-1.8.0_292/Contents/Home/jre/lib/ext/sunec.jar:/Users/LSS/Library/Java/JavaVirtualMachines/corretto-1.8.0_292/Contents/Home/jre/lib/ext/sunjce_provider.jar:/Users/LSS/Library/Java/JavaVirtualMachines/corretto-1.8.0_292/Contents/Home/jre/lib/ext/sunpkcs11.jar:/Users/LSS/Library/Java/JavaVirtualMachines/corretto-1.8.0_292/Contents/Home/jre/lib/ext/zipfs.jar:/Users/LSS/Library/Java/JavaVirtualMachines/corretto-1.8.0_292/Contents/Home/jre/lib/jce.jar:/Users/LSS/Library/Java/JavaVirtualMachines/corretto-1.8.0_292/Contents/Home/jre/lib/jfr.jar:/Users/LSS/Library/Java/JavaVirtualMachines/corretto-1.8.0_292/Contents/Home/jre/lib/jfxswt.jar:/Users/LSS/Library/Java/JavaVirtualMachines/corretto-1.8.0_292/Contents/Home/jre/lib/jsse.jar:/Users/LSS/Library/Java/JavaVirtualMachines/corretto-1.8.0_292/Contents/Home/jre/lib/management-agent.jar:/Users/LSS/Library/Java/JavaVirtualMachines/corretto-1.8.0_292/Contents/Home/jre/lib/resources.jar:/Users/LSS/Library/Java/JavaVirtualMachines/corretto-1.8.0_292/Contents/Home/jre/lib/rt.jar:/Users/LSS/Library/Java/JavaVirtualMachines/corretto-1.8.0_292/Contents/Home/lib/ant-javafx.jar:/Users/LSS/Library/Java/JavaVirtualMachines/corretto-1.8.0_292/Contents/Home/lib/dt.jar:/Users/LSS/Library/Java/JavaVirtualMachines/corretto-1.8.0_292/Contents/Home/lib/javafx-mx.jar:/Users/LSS/Library/Java/JavaVirtualMachines/corretto-1.8.0_292/Contents/Home/lib/jconsole.jar:/Users/LSS/Library/Java/JavaVirtualMachines/corretto-1.8.0_292/Contents/Home/lib/packager.jar:/Users/LSS/Library/Java/JavaVirtualMachines/corretto-1.8.0_292/Contents/Home/lib/sa-jdi.jar:/Users/LSS/Library/Java/JavaVirtualMachines/corretto-1.8.0_292/Contents/Home/lib/tools.jar:/Users/LSS/Documents/00_Project/algorithm/out/production/algorithm:/Users/LSS/Library/Application Support/JetBrains/IdeaIC2021.1/plugins/Kotlin/kotlinc/lib/kotlin-stdlib.jar:/Users/LSS/Library/Application Support/JetBrains/IdeaIC2021.1/plugins/Kotlin/kotlinc/lib/kotlin-reflect.jar:/Users/LSS/Library/Application Support/JetBrains/IdeaIC2021.1/plugins/Kotlin/kotlinc/lib/kotlin-test.jar ggkrgok3t3g4gf.MapKt
key=11, value=Java
key=22, value=Kotlin
key=33, value=C++
langMap[22] = Kotlin
langMap.get(22) = Kotlin
langMap.keys = [11, 22, 33]
true, true

Process finished with exit code 0

*/