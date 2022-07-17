package baekjoon.sliver

class Boj1541 {

    fun solve() {
        val raw = readln()
        val split = if (raw.contains("-")) {
            raw.split("-")
        } else {
            arrayListOf(raw)
        }

        var res = 0

        for (i in split.indices) {
            if (i == 0) {
                if (split[i].contains("+")) {
                    split[i].split("+").forEach { res += it.toInt() }
                } else {
                    res += split[i].toInt()
                }
                continue
            }

            if (split[i].contains("+")) {
                split[i].split("+").forEach { res -= it.toInt() }
            } else {
                res -= split[i].toInt()
            }
        }

        println(res)
    }
}

fun main() = Boj1541().solve()