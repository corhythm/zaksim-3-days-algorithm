import java.util.*

fun main(args: Array<String>)  = with(Scanner(System.`in`)) {

    val inputNums = arrayListOf<Int>()
    while (true) {
        val value = nextInt()

        if (value == 0) {
            break
        }
        if (value < 123456) {
            inputNums.add(value)
        }
    }

    inputNums.forEach {
        val numberOfPrime = findNumberOfPrime(it)
        println(numberOfPrime)
    }


}

// n보다 크고 2n보다 작은 소수 (n <= ? < 2n)
fun findNumberOfPrime(number: Int): Int {
    if (number == 1) {
        return 1;
    }

    for (i in number..(number * 2)) {

    }
    return 1;
}