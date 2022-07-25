package baekjoon.sliver

class Boj2164 {

    fun solve() {
        val num = readln().toInt()
        val queue = (1..num.times(2)).toList().toIntArray()
        var front = 0
        var rear = num.minus(1)

        while (front != rear) {
            queue[front++] = -1
            queue[++rear] = queue[front]
            queue[front++] = -1
        }
        println(queue[front])
    }
}

fun main() = Boj2164().solve()