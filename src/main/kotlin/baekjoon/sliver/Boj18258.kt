package baekjoon.sliver

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

//push X: 정수 X를 큐에 넣는 연산이다.
//pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//size: 큐에 들어있는 정수의 개수를 출력한다.
//empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
//front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.

class Boj18258 {

    private val MAX = 2000000
    private val queue = IntArray(MAX)
    private var front = 0 // 머리 쪽에 위치할 index 값, pop할 때 참조하는 index
    private var rear = 0 // 꼬리 쪽에 위치할 index 값, push할 때 참조하는 index

    private fun isEmpty() = front == rear

    private fun isFull() = rear == MAX.minus(1)

    private fun size() = rear - front

    fun solve() {

        val sb = StringBuilder()
        val bw = BufferedWriter(OutputStreamWriter(System.out))

        repeat(readln().toInt()) {
            val tokenizer = StringTokenizer(readln())
            when (tokenizer.nextToken()) {

                "push" -> {
                    val value = tokenizer.nextToken().toInt()
                    if (isFull().not()) {
                        queue[rear++] = value
                    }
                }
                "pop" -> {
                    if (isEmpty()) {
                        sb.append(-1).append("\n")
                    } else {
                        val popValue = queue[front++]
                        sb.append(popValue).append("\n")
                    }
                }
                "size" -> {
                    sb.append(size()).append("\n")
                }
                "empty" -> {
                    if (isEmpty()) {
                        sb.append(1).append("\n")
                    } else {
                        sb.append(0).append("\n")
                    }
                }
                "front" -> {
                    if (isEmpty().not()) {
                        sb.append(queue[front]).append("\n")
                    } else {
                        sb.append(-1).append("\n")
                    }
                }
                "back" -> {
                    if (isEmpty().not()) {
                        sb.append(queue[rear - 1]).append("\n")
                    } else {
                        sb.append(-1).append("\n")
                    }
                }

            }
        }
        bw.write(sb.toString())
        bw.flush()
        bw.close()

    }
}

fun main() = Boj18258().solve()