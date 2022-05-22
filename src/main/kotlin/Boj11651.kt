import java.util.Scanner

// https://www.acmicpc.net/problem/11651
// 좌표 정렬하기 2, 실버 5

class Coornidate(private val x: Int, private val y: Int) : Comparable<Coornidate> {

    override fun compareTo(other: Coornidate): Int {
        return if (this.y == other.y)
            return this.x - other.x
        else
            this.y - other.y
    }

    override fun toString() = "$x $y"

}


class Boj11651 {
    fun run() = with(Scanner(System.`in`)) {
        val coordinateNum = nextInt()
        val coornidates = arrayListOf<Coornidate>()

        for (i in 0 until coordinateNum) {
            coornidates.add(Coornidate(nextInt(), nextInt()))
        }
        coornidates.sort()
        coornidates.forEach { println(it) }
    }
}

fun main() = Boj11651().run()