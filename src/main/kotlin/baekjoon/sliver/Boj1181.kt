package baekjoon.sliver

import java.util.*

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

        /**
         * 스트링을 비교할 때는 기본적으로 ascii 코드 값으로 비교한다.
         * 만약 길이가 같다면(e.g. "a" > "b") 해당 문자의 ascii 코드 값을 비교하고
         * 길이가 다르다면 맨 처음 문자의 ascii 코드 값으로 비교하되, 맨 처음 문자가 같은 문자이면
         * 다음 문자로 비교해서 비교 우위를 가린다. 즉, 길이가 1이든, 그보다 크든, 가장 앞에 있는 문자만 비교해서
         * 우선 순위를 가린다. (compareTo도 내부적으로 그렇게 동작하고 단순히 "a" > "bcd" 도 마찬가지이다.
         */
        val words = rawWords.toTypedArray()
        words.sortWith { s1, s2 ->
            if (s1.length == s2.length) {
                s1.compareTo(s2) // s1의 ascii 코드 값이 더 크면 (+), s2의 ascii 코드 값이 더 크면 (-)
            } else {
                s1.length - s2.length
            }
        }

        words.forEach { println(it) }
    }


}


fun main() = BOJ1181().run()


