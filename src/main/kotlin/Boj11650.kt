import java.util.Scanner

// https://www.acmicpc.net/problem/11650
// 좌표 정렬하기 (silver 5)

class Point(private val x: Int, private val y: Int) : Comparable<Point> {

    override fun compareTo(other: Point): Int {
        return if (this.x == other.x)
            this.y - other.y
        else
            this.x - other.x
    }

    override fun toString() = "$x $y"

}


class Boj11650 {

    fun run() = with(Scanner(System.`in`)) {
        val num = nextInt()
        val pointList = arrayListOf<Point>()
        for (i in 0 until num) {
            pointList.add(Point(nextInt(), nextInt()))
        }
        pointList.sort()
        pointList.forEach { println(it) }
    }
}

fun main() = Boj11650().run()