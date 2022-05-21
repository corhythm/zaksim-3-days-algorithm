import java.util.*
import kotlin.collections.ArrayList

// https://www.acmicpc.net/problem/1181
// 단어 정렬(Silver 5, Success)
/**
 * O(N^2)짜리 정렬 알고리즘을 사용하면 당연히 시간 초과입니다.
 * 이에 해당하는 것으로는 버블 정렬, 선택 정렬, 삽입 정렬 등이 있습니다.
 * 이 문제는 O(NlogN) 이하의 복잡도를 갖는 정렬을 사용해야 하고, 이에 해당하는 것으로는 병합 정렬, 힙 정렬 등이 있습니다.
 * 또는 기수 정렬이나 카운팅 정렬을 사용해도 됩니다.
 */
class BOJ1181 {

    fun run() = with(Scanner(System.`in`)) {

        val wordNum = nextInt()
        val rawWords = hashSetOf<String>()
        for (i in 0 until wordNum) {
            rawWords.add(next())
        }

        val words = rawWords.toTypedArray()
        words.sortWith { s1, s2 ->
            if (s1.length == s2.length) {
                s1.compareTo(s2)
            } else {
                s1.length - s2.length
            }
        }

        words.forEach { println(it) }
    }


}


fun main() {
    BOJ1181().run()
}

