import java.util.*
import kotlin.math.min

// Boj1676 참조
class Boj2004 {

    // C(n, m) => n! / m! * (n-m)!
    fun solve() {
        val st = StringTokenizer(readln())
        val (n, m) = Pair(st.nextToken().toInt(), st.nextToken().toInt())

        val nCount2 = calculateTimes(n, 2)
        val nCount5 = calculateTimes(n, 5)

        val mCount2 = calculateTimes(m, 2)
        val mCount5 = calculateTimes(m, 5)

        val nMinusMCount2 = calculateTimes(n.minus(m), 2)
        val nMinusMCount5 = calculateTimes(n.minus(m), 5)

        val count2 = nCount2.minus(mCount2).minus(nMinusMCount2)
        val count5 = nCount5.minus(mCount5).minus(nMinusMCount5)

        // 팩토리얼이 아니고 조합이다보니, 나누면, 2의 개수가 더 작을 수도 있어서 최소값으로
        println(min(count2, count5))
    }

    private fun calculateTimes(num: Int, n: Int): Int { // num에 n이 몇 번 곱해져 있는지 계산
        var numPrime = num
        var count = 0

        while (numPrime >= n) {
            count += numPrime.div(n)
            numPrime /= n
        }
        return count
    }
}

fun main() = Boj2004().solve()