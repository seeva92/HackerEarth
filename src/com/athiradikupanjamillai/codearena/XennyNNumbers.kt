package com.athiradikupanjamillai.codearena

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.*

private object XennyNNumbers {
    private fun gcd(a: Long, b: Long): Long {
        return if (b == 0L) {
            a
        } else {
            gcd(b, a % b)
        }
    }

    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val br = BufferedReader(InputStreamReader(System.`in`))
        var t = br.readLine().toInt()
        while (t-- > 0) {
            val nk = br.readLine().split(" ".toRegex()).toTypedArray();
            val n = nk[0].toInt()
            val k = nk[1].toInt()
            val count = Arrays.stream(br.readLine().split(" ".toRegex()).toTypedArray()).map { s: String -> s.toInt() }
                    .filter { value: Int -> value == k }.count().toInt()
            if (count < 3) {
                println("0/1")
            } else {
                val numerator = calculateNC3(count.toLong())
                val denominator = calculateNC3(n.toLong())
                val divisor = gcd(numerator, denominator)
                println((numerator / divisor).toString() + "/" + denominator / divisor)
            }
        }
    }

    private fun calculateNC3(count: Long): Long {
        return count * (count - 1) * (count - 2) / 6
    }
}