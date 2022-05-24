// ref: https://hyo-ue4study.tistory.com/68
class Sort {

    /**
     * 선택 정렬 (Selection Sort)
     * - 선택된 값과 나머지 데이터 중에 비교하여 알맞은 자리를 찾는 정렬 방법
     * - worst, average, best: O(n²)
     */
    fun selectionSort(array: IntArray) {
        var min: Int

        for (i in 0 until array.size - 1) {
            min = i
            for (j in i + 1 until array.size) {
                if (array[j] < array[min]) {
                    min = j
                }
            }
            val temp = array[min]
            array[min] = array[i]
            array[i] = temp
        }
    }

    /**
     * 삽입 정렬 (Insertion Sort)
     * - 데이터 집합을 순회하면서 정렬이 필요한 요소를 뽑아내어 이를 다시 적당한 곳으로 삽입하는 정렬 방법
     * - 성능은 버블 정렬보다 좋다
     * - worst, average: O(n²)
     * - best: 이미 정렬되어 있다면 O(n)
     */
    fun insertionSort(array: IntArray) {
        var min: Int
        var key: Int
        var i = 0
        var j = 0

        for (i in 1 until array.size) {
            key = array[i]
            for (j in i - 1 downTo 0) {
                if (array[j] > key) array[j + 1] = array[j]
                else break
            }
            array[j + 1] = key
        }

    }
}

fun main() {

    val sort = Sort()
    val array = (1..20).toList().shuffled().toIntArray()
    println(array.toList())
    sort.insertionSort(array)
    println(array.toList())


}