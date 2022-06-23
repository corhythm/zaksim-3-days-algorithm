package baekjoon.sliver

import java.util.Scanner

class Boj1620 {

    fun run() = with(Scanner(System.`in`)) {
        val pokemonNum = nextInt()
        val questionNum = nextInt()
        val pokemons = linkedMapOf<String, Int>()

        for (i in 1 .. pokemonNum) {
            pokemons[next()] = i
        }
        // key -> value, value -> key
        val pokemonsReverse = pokemons.entries.associate { (k, v) -> v to k }
        println(pokemonsReverse)

        for (i in 0 until questionNum) {
            val value = next()
            try {
                println(pokemonsReverse[value.toInt()])
            } catch (ex: java.lang.NumberFormatException) { // string일 때
                println(pokemons[value])
            }
        }
    }
}

fun main() = Boj1620().run()