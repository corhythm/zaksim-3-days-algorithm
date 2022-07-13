package baekjoon.bronze

class Boj14416 {

//    private var recursiveCount = 1
    private val fb = IntArray(40)

    fun solve() {
        fb[0] = 1
        fb[1] = 1

        println("recursive=${countFibonacciByRecursive(5)}")
        println("repeat=${countFibonacciByRepeat(5)}")
    }

//    fib(n) {
//        if (n = 1 or n = 2)
//            then return 1;  # 코드1
//        else return (fib(n - 1) + fib(n - 2));
//    }

//    fibonacci(n) {
//        f[1] <- f[2] <- 1;
//        for i <- 3 to n
//        f[i] <- f[i - 1] + f[i - 2];  # 코드2
//        return f[n];
//    }

    private fun countFibonacciByRepeat(n: Int): Int {
        var repeatCount = 1
        if (n == 1 || n == 2) return repeatCount

        for (i in 3..n) {
            fb[i] = fb[i - 1] + fb[i - 2]
            repeatCount++
        }

        return repeatCount
    }

    private fun countFibonacciByRecursive(n: Int, recursiveCount: Int = 1): Int {
        println("call")
        return if (n == 1 || n == 2)
            recursiveCount
        else
            countFibonacciByRecursive(n - 1, recursiveCount.plus(1)) + countFibonacciByRecursive(
                n - 2, recursiveCount.plus(1)
            )
    }


}

fun main() = Boj14416().solve()