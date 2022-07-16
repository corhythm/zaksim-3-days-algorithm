package baekjoon.sliver

import java.util.StringTokenizer

data class Meeting(val start: Int, val end: Int): Comparable<Meeting> {

    override fun compareTo(other: Meeting): Int {
//        return if (this.start == other.start)
//            this.end.minus(this.start) - other.end.minus(other.start)
//        else
//            this.start - other.start

//        return this.end.minus(this.start) - other.end.minus(other.start)

        return if (this.end == other.end) {
            this.start - other.start
        } else {
            this.end - other.end
        }
    }
}

class Boj1931 {

    fun solve() {
        val meetingNum = readln().toInt()
        val meetingList = arrayListOf<Meeting>()
        var availableMeetingNum = 0

        repeat(meetingNum) {
            val tokenizer = StringTokenizer(readln())
            val meeting = Meeting(tokenizer.nextToken().toInt(), tokenizer.nextToken().toInt())
            meetingList.add(meeting)
        }

        meetingList.sort()

        availableMeetingNum = 1
        var nowMeeting = meetingList[0]
        for (i in 1 until meetingList.size) {
            if (nowMeeting.end <= meetingList[i].start) {
                nowMeeting = meetingList[i]
                availableMeetingNum++
            }
        }
        println(availableMeetingNum)
    }
}

fun main() = Boj1931().solve()