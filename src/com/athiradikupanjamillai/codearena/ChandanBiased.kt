package com.athiradikupanjamillai.codearena

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.*

object ChandanBiased {
    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val br = BufferedReader(InputStreamReader(System.`in`))
        val n = br.readLine().toInt()
        val stack = Stack<Int>()
        for (i in 0 until n) {
            val curr = br.readLine().toInt()
            if (curr == 0) {
                if (!stack.empty()) {
                    stack.pop()
                }
            } else {
                stack.push(curr)
            }
        }
        var sum: Long = 0
        while (!stack.isEmpty()) {
            sum += stack.peek()
            stack.pop()
        }
        println(sum)
    }
}