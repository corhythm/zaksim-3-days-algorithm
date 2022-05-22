import java.util.Scanner

// https://www.acmicpc.net/problem/10814
// 나이순 정렬, 실버5

class Member(private val id: Int, private val age: Int, private val name: String) : Comparable<Member> {
    override fun compareTo(other: Member): Int { // 원래는 this가 크면 return 1, 같으면 0, other가 더 크면 return -1 <== 이거 헷갈린다...
        if (this.age == other.age) {
            return this.id.minus(other.id)
        }
        return this.age.minus(other.age)
    }

    override fun toString() = "$age $name"
}

class Boj10814 {
    fun run() = with(Scanner(System.`in`)) {
        val memberNum = nextInt()
        val members = arrayListOf<Member>()

        for (i in 1..memberNum) {
            members.add(Member(id = i, age = nextInt(), name = next()))
        }
        members.sort()
        members.forEach { println(it) }
    }
}

fun main() = Boj10814().run()