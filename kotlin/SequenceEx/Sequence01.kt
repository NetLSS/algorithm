fun main() {

    // 정상 적인 풀이
    val primes1: Sequence<Int> = sequence {
        var numbers = generateSequence(2) { it + 1 }

        while (true) {
            println("[while start]")
            val prime = numbers.first()
            println("numbers.first() : $prime")
            yield(prime)
            numbers = numbers.drop(1)
                .filter { println("filtered: $it"); it % prime != 0 }
        }
    }


    // 캡처링 된 문제
    val primes2: Sequence<Int> = sequence {
        var numbers = generateSequence(2) { it + 1 }

        var prime: Int
        while (true) {
            println("[while start]")
            prime = numbers.first()
            println("numbers.first() : $prime")
            yield(prime)
            numbers = numbers.drop(1)
                .filter { println("filtered: $it"); it % prime != 0 }

            println("numbers ${numbers.take(10).toList()}")
        }
    }

    println("===== primes1 ====")
    println(primes1.take(10).toList())
    println("===== primes2 ====")
    println(primes2.take(10).toList())
}

/*
/Users/LSS/Library/Java/JavaVirtualMachines/corretto-1.8.0_312/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA CE.app/Contents/lib/idea_rt.jar=53336:/Applications/IntelliJ IDEA CE.app/Contents/bin -Dfile.encoding=UTF-8 -classpath /Users/LSS/Library/Java/JavaVirtualMachines/corretto-1.8.0_312/Contents/Home/jre/lib/charsets.jar:/Users/LSS/Library/Java/JavaVirtualMachines/corretto-1.8.0_312/Contents/Home/jre/lib/ext/cldrdata.jar:/Users/LSS/Library/Java/JavaVirtualMachines/corretto-1.8.0_312/Contents/Home/jre/lib/ext/dnsns.jar:/Users/LSS/Library/Java/JavaVirtualMachines/corretto-1.8.0_312/Contents/Home/jre/lib/ext/jaccess.jar:/Users/LSS/Library/Java/JavaVirtualMachines/corretto-1.8.0_312/Contents/Home/jre/lib/ext/jfxrt.jar:/Users/LSS/Library/Java/JavaVirtualMachines/corretto-1.8.0_312/Contents/Home/jre/lib/ext/localedata.jar:/Users/LSS/Library/Java/JavaVirtualMachines/corretto-1.8.0_312/Contents/Home/jre/lib/ext/nashorn.jar:/Users/LSS/Library/Java/JavaVirtualMachines/corretto-1.8.0_312/Contents/Home/jre/lib/ext/sunec.jar:/Users/LSS/Library/Java/JavaVirtualMachines/corretto-1.8.0_312/Contents/Home/jre/lib/ext/sunjce_provider.jar:/Users/LSS/Library/Java/JavaVirtualMachines/corretto-1.8.0_312/Contents/Home/jre/lib/ext/sunpkcs11.jar:/Users/LSS/Library/Java/JavaVirtualMachines/corretto-1.8.0_312/Contents/Home/jre/lib/ext/zipfs.jar:/Users/LSS/Library/Java/JavaVirtualMachines/corretto-1.8.0_312/Contents/Home/jre/lib/jce.jar:/Users/LSS/Library/Java/JavaVirtualMachines/corretto-1.8.0_312/Contents/Home/jre/lib/jfr.jar:/Users/LSS/Library/Java/JavaVirtualMachines/corretto-1.8.0_312/Contents/Home/jre/lib/jfxswt.jar:/Users/LSS/Library/Java/JavaVirtualMachines/corretto-1.8.0_312/Contents/Home/jre/lib/jsse.jar:/Users/LSS/Library/Java/JavaVirtualMachines/corretto-1.8.0_312/Contents/Home/jre/lib/management-agent.jar:/Users/LSS/Library/Java/JavaVirtualMachines/corretto-1.8.0_312/Contents/Home/jre/lib/resources.jar:/Users/LSS/Library/Java/JavaVirtualMachines/corretto-1.8.0_312/Contents/Home/jre/lib/rt.jar:/Users/LSS/Library/Java/JavaVirtualMachines/corretto-1.8.0_312/Contents/Home/lib/ant-javafx.jar:/Users/LSS/Library/Java/JavaVirtualMachines/corretto-1.8.0_312/Contents/Home/lib/dt.jar:/Users/LSS/Library/Java/JavaVirtualMachines/corretto-1.8.0_312/Contents/Home/lib/javafx-mx.jar:/Users/LSS/Library/Java/JavaVirtualMachines/corretto-1.8.0_312/Contents/Home/lib/jconsole.jar:/Users/LSS/Library/Java/JavaVirtualMachines/corretto-1.8.0_312/Contents/Home/lib/packager.jar:/Users/LSS/Library/Java/JavaVirtualMachines/corretto-1.8.0_312/Contents/Home/lib/sa-jdi.jar:/Users/LSS/Library/Java/JavaVirtualMachines/corretto-1.8.0_312/Contents/Home/lib/tools.jar:/Users/LSS/Documents/00_Project/algorithm/out/production/algorithm:/Users/LSS/Library/Application Support/JetBrains/IdeaIC2021.1/plugins/Kotlin/kotlinc/lib/kotlin-stdlib.jar:/Users/LSS/Library/Application Support/JetBrains/IdeaIC2021.1/plugins/Kotlin/kotlinc/lib/kotlin-reflect.jar:/Users/LSS/Library/Application Support/JetBrains/IdeaIC2021.1/plugins/Kotlin/kotlinc/lib/kotlin-test.jar Sequence01Kt
===== primes1 ====
[while start]
numbers.first() : 2
[while start]
filtered: 3
numbers.first() : 3
[while start]
filtered: 3
filtered: 4
filtered: 5
filtered: 5
numbers.first() : 5
[while start]
filtered: 3
filtered: 4
filtered: 5
filtered: 5
filtered: 6
filtered: 7
filtered: 7
filtered: 7
numbers.first() : 7
[while start]
filtered: 3
filtered: 4
filtered: 5
filtered: 5
filtered: 6
filtered: 7
filtered: 7
filtered: 7
filtered: 8
filtered: 9
filtered: 9
filtered: 10
filtered: 11
filtered: 11
filtered: 11
filtered: 11
numbers.first() : 11
[while start]
filtered: 3
filtered: 4
filtered: 5
filtered: 5
filtered: 6
filtered: 7
filtered: 7
filtered: 7
filtered: 8
filtered: 9
filtered: 9
filtered: 10
filtered: 11
filtered: 11
filtered: 11
filtered: 11
filtered: 12
filtered: 13
filtered: 13
filtered: 13
filtered: 13
filtered: 13
numbers.first() : 13
[while start]
filtered: 3
filtered: 4
filtered: 5
filtered: 5
filtered: 6
filtered: 7
filtered: 7
filtered: 7
filtered: 8
filtered: 9
filtered: 9
filtered: 10
filtered: 11
filtered: 11
filtered: 11
filtered: 11
filtered: 12
filtered: 13
filtered: 13
filtered: 13
filtered: 13
filtered: 13
filtered: 14
filtered: 15
filtered: 15
filtered: 16
filtered: 17
filtered: 17
filtered: 17
filtered: 17
filtered: 17
filtered: 17
numbers.first() : 17
[while start]
filtered: 3
filtered: 4
filtered: 5
filtered: 5
filtered: 6
filtered: 7
filtered: 7
filtered: 7
filtered: 8
filtered: 9
filtered: 9
filtered: 10
filtered: 11
filtered: 11
filtered: 11
filtered: 11
filtered: 12
filtered: 13
filtered: 13
filtered: 13
filtered: 13
filtered: 13
filtered: 14
filtered: 15
filtered: 15
filtered: 16
filtered: 17
filtered: 17
filtered: 17
filtered: 17
filtered: 17
filtered: 17
filtered: 18
filtered: 19
filtered: 19
filtered: 19
filtered: 19
filtered: 19
filtered: 19
filtered: 19
numbers.first() : 19
[while start]
filtered: 3
filtered: 4
filtered: 5
filtered: 5
filtered: 6
filtered: 7
filtered: 7
filtered: 7
filtered: 8
filtered: 9
filtered: 9
filtered: 10
filtered: 11
filtered: 11
filtered: 11
filtered: 11
filtered: 12
filtered: 13
filtered: 13
filtered: 13
filtered: 13
filtered: 13
filtered: 14
filtered: 15
filtered: 15
filtered: 16
filtered: 17
filtered: 17
filtered: 17
filtered: 17
filtered: 17
filtered: 17
filtered: 18
filtered: 19
filtered: 19
filtered: 19
filtered: 19
filtered: 19
filtered: 19
filtered: 19
filtered: 20
filtered: 21
filtered: 21
filtered: 22
filtered: 23
filtered: 23
filtered: 23
filtered: 23
filtered: 23
filtered: 23
filtered: 23
filtered: 23
numbers.first() : 23
[while start]
filtered: 3
filtered: 4
filtered: 5
filtered: 5
filtered: 6
filtered: 7
filtered: 7
filtered: 7
filtered: 8
filtered: 9
filtered: 9
filtered: 10
filtered: 11
filtered: 11
filtered: 11
filtered: 11
filtered: 12
filtered: 13
filtered: 13
filtered: 13
filtered: 13
filtered: 13
filtered: 14
filtered: 15
filtered: 15
filtered: 16
filtered: 17
filtered: 17
filtered: 17
filtered: 17
filtered: 17
filtered: 17
filtered: 18
filtered: 19
filtered: 19
filtered: 19
filtered: 19
filtered: 19
filtered: 19
filtered: 19
filtered: 20
filtered: 21
filtered: 21
filtered: 22
filtered: 23
filtered: 23
filtered: 23
filtered: 23
filtered: 23
filtered: 23
filtered: 23
filtered: 23
filtered: 24
filtered: 25
filtered: 25
filtered: 25
filtered: 26
filtered: 27
filtered: 27
filtered: 28
filtered: 29
filtered: 29
filtered: 29
filtered: 29
filtered: 29
filtered: 29
filtered: 29
filtered: 29
filtered: 29
numbers.first() : 29
[2, 3, 5, 7, 11, 13, 17, 19, 23, 29]
===== primes2 =================================
[while start]
numbers.first() : 2
[while start]
filtered: 3
numbers.first() : 3
[while start]
filtered: 3
filtered: 4
filtered: 5
filtered: 5
numbers.first() : 5
[while start]
filtered: 3
filtered: 4
filtered: 4
filtered: 5
filtered: 6
filtered: 6
filtered: 6
numbers.first() : 6
[while start]
filtered: 3
filtered: 4
filtered: 4
filtered: 5
filtered: 5
filtered: 5
filtered: 6
filtered: 7
filtered: 7
filtered: 7
filtered: 7
numbers.first() : 7
[while start]
filtered: 3
filtered: 4
filtered: 4
filtered: 5
filtered: 5
filtered: 5
filtered: 6
filtered: 6
filtered: 6
filtered: 6
filtered: 7
filtered: 8
filtered: 8
filtered: 8
filtered: 8
filtered: 8
numbers.first() : 8
[while start]
filtered: 3
filtered: 4
filtered: 4
filtered: 5
filtered: 5
filtered: 5
filtered: 6
filtered: 6
filtered: 6
filtered: 6
filtered: 7
filtered: 7
filtered: 7
filtered: 7
filtered: 7
filtered: 8
filtered: 9
filtered: 9
filtered: 9
filtered: 9
filtered: 9
filtered: 9
numbers.first() : 9
[while start]
filtered: 3
filtered: 4
filtered: 4
filtered: 5
filtered: 5
filtered: 5
filtered: 6
filtered: 6
filtered: 6
filtered: 6
filtered: 7
filtered: 7
filtered: 7
filtered: 7
filtered: 7
filtered: 8
filtered: 8
filtered: 8
filtered: 8
filtered: 8
filtered: 8
filtered: 9
filtered: 10
filtered: 10
filtered: 10
filtered: 10
filtered: 10
filtered: 10
filtered: 10
numbers.first() : 10
[while start]
filtered: 3
filtered: 4
filtered: 4
filtered: 5
filtered: 5
filtered: 5
filtered: 6
filtered: 6
filtered: 6
filtered: 6
filtered: 7
filtered: 7
filtered: 7
filtered: 7
filtered: 7
filtered: 8
filtered: 8
filtered: 8
filtered: 8
filtered: 8
filtered: 8
filtered: 9
filtered: 9
filtered: 9
filtered: 9
filtered: 9
filtered: 9
filtered: 9
filtered: 10
filtered: 11
filtered: 11
filtered: 11
filtered: 11
filtered: 11
filtered: 11
filtered: 11
filtered: 11
numbers.first() : 11
[while start]
filtered: 3
filtered: 4
filtered: 4
filtered: 5
filtered: 5
filtered: 5
filtered: 6
filtered: 6
filtered: 6
filtered: 6
filtered: 7
filtered: 7
filtered: 7
filtered: 7
filtered: 7
filtered: 8
filtered: 8
filtered: 8
filtered: 8
filtered: 8
filtered: 8
filtered: 9
filtered: 9
filtered: 9
filtered: 9
filtered: 9
filtered: 9
filtered: 9
filtered: 10
filtered: 10
filtered: 10
filtered: 10
filtered: 10
filtered: 10
filtered: 10
filtered: 10
filtered: 11
filtered: 12
filtered: 12
filtered: 12
filtered: 12
filtered: 12
filtered: 12
filtered: 12
filtered: 12
filtered: 12
numbers.first() : 12
[2, 3, 5, 6, 7, 8, 9, 10, 11, 12]

Process finished with exit code 0

 */