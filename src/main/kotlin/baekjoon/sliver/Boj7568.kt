import java.util.Scanner

// https://www.acmicpc.net/problem/7568
// 덩치 (Silver 5)

data class Build(val weight: Int, val height: Int, var ranking: Int = -1)


class Boj7568 {

    fun run() = with(Scanner(System.`in`)) {
        val num = nextInt()
        val builds = arrayListOf<Build>()
        for (i in 0 until num) {
            builds.add(Build(nextInt(), nextInt()))
        }

        for (i in builds.indices) {
            var count = 0
            for (j in builds.indices) {
                if (i == j) continue
                if (builds[i].weight < builds[j].weight && builds[i].height < builds[j].height) count++
            }
            builds[i].ranking = count
        }

        builds.forEach {
            it.ranking = it.ranking.plus(1)
            print("${it.ranking} ")
        }


    }
}

fun main() = Boj7568().run()