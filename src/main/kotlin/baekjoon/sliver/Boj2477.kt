import java.util.Scanner

data class Side(val point: Int, val length: Int)

class Boj2477 {

    private val EAST = 1
    private val WEST = 2
    private val SOUTH = 3
    private val NORTH = 4

    // 두 번째 잘리지 않는 변을 찾으면, 잘리는 변은 [i + 2], [i + 3]. 단 잘리는 것도 생각해야 함
    fun run() = with(Scanner(System.`in`)) {
        val numPerSquare = nextInt()
        val sides = mutableListOf<Side>()
        var maxWidth = 0
        var maxHeight = 0
        var maxWidthIndex = 0
        var maxHeightIndex = 0

        for (i in 0 until 6) {
            val point = nextInt()
            val length = nextInt()
            if ((point == EAST || point == WEST) && length > maxWidth) { // 가장 큰 가로
                maxWidth = length
                maxWidthIndex = i
            } else if ((point == SOUTH || point == NORTH) && length > maxHeight) { // 가장 큰 세로
                maxHeight = length
                maxHeightIndex = i
            }

            sides.add(Side(point, length))
        }

        // 가장 긴 변이 두 번째 등장한 인덱스 찾기
        val (maxFirstIndex, maxLastIndex) = if (maxWidthIndex > maxHeightIndex)
            Pair(maxHeightIndex, maxWidthIndex)
        else
            Pair(maxWidthIndex, maxHeightIndex)

        /**
         * 경우의 수
         * 1. 가장 큰 변을 가진 두 번째 인덱스에 +2 +3을 해도 array index를 out of bound하지 않을 때 -> +2, +3 계산
         * 2. 가장 큰 두 번째 변이 마지막 인덱스에 위치할 때 -> 첫 번째 가장 큰 변 +2, +3을 하면 됨
         * 3. 가장 큰 변을 가진 두 번째 인덱스에 +2를 하면 인덱스 초과가 안 뜨는데, +3을 하면 인덱스 초과가 나는 경우 -> +3은 0번 인덱스로 가면 됨
         */
        val totalArea = maxWidth * maxHeight
        val emptyArea = if (maxLastIndex < 3) { // 0, 1, 2
            sides[maxLastIndex + 2].length * sides[maxLastIndex + 3].length
        } else if (maxFirstIndex == 0 && maxLastIndex == 5) {
            sides[2].length * sides[3].length
        } else {
            when (maxLastIndex) {
                3 -> sides[maxLastIndex + 2].length * (sides[0].length)
                4 -> sides[0].length * sides[1].length
                else -> sides[1].length * sides[2].length // 5
            }
        }

        println(totalArea.minus(emptyArea).times(numPerSquare))
    }

}

fun main() = Boj2477().run()