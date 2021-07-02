package wefwevf2323

import kotlin.math.sqrt

fun isPrime(num:Int):Boolean{
    for(i in 2..sqrt(num.toFloat()).toInt()){
        if(num%i ==0) return false
    }
    return true
}

fun main() {
    println(isPrime(1))
    println(isPrime(2))
    println(isPrime(3))
    println(isPrime(4))
    println(isPrime(5))
    println(isPrime(6))
    println(isPrime(7))

}

/*
    public static boolean isPrime(int num){
        for(int i=2; i*i<=num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
 */