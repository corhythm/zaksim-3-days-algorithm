import java.util.Scanner

class Boj3036 {

    fun run() = with(Scanner(System.`in`)) {
        val ringNum = nextInt()
        val firstRing = nextInt()
        val otherRings = arrayListOf<Int>()
        for (i in 0 until ringNum.minus(1)) {
            otherRings.add(nextInt())
        }

        otherRings.forEach { otherRing ->
            val gcd = gcd(firstRing, otherRing)
            println("${firstRing/gcd}/${otherRing/gcd}") // 기약분수를 나타내고 싶다면, 분모와 분자의 최대공약수로 나눠주면 된다.
        }

    }

    private fun gcd(a: Int, b: Int): Int { // great common divisor
        var r: Int
        var numA = a
        var numB = b

        while (numB != 0) {
            r = numA % numB
            numA = numB
            numB = r
        }
        return numA
    }

}

fun main() = Boj3036().run()