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

    /*
     * Greatest Common Divisor
     * <Euclidean algorithm>
     * 임의로 나눈 두 자연수 a, b가 주어졌을 때, 둘 중 큰 값이 a라고 가정
     * a를 b로 나눈 나머지를 n (a % b == n)
     * n == 0이면 b가 최대 공약수(GCD)
     * n != 0이면 a에 b를 다시 넣고, n를 b에 대입한 후 다시 step2부터 반복
     */
    private fun gcd(a: Int, b: Int): Int {
        var n: Int
        var numA = a
        var numB = b

        while (numB != 0) {
            n = numA % numB
            numA = numB
            numB = n
        }
        return numA
    }

}

fun main() = Boj3036().run()