package baekjoon.bronze

import java.util.*
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

class Boj1085 {

    // (6,2) (10,3)
    fun run() = with(Scanner(System.`in`)) {
        val x = nextInt()
        val y = nextInt()
        val w = nextInt()
        val z = nextInt()

        val xDistance = if (abs(x.minus(w)) > x.minus(0)) x.minus(0) else abs(x.minus(w))
        val yDistance = if (abs(y.minus(z)) > y.minus(0)) y.minus(0) else abs(y.minus(z))
        println(if(xDistance > yDistance) yDistance else xDistance)
    }
}

fun main() = Boj1085().run()