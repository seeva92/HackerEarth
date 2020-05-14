package com.athiradikupanjamillai.codearena;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KArrays {

    private static long pow(long base, long exponent, long mod) {
        long result = 1;
        while (exponent > 0) {
            if ((exponent & 1) != 0) {
                result = (result * base) % mod;
            }

            base = (base * base) % mod;

            exponent >>= 1;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] nk = br.readLine().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);
            int[][] arr = new int[k][n];
            for (int i = 0; i < k; i++) {
                String[] nValues = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(nValues[j]);
                }
            }

            long mod = (long) 1e9 + 7;

            int mask = (1 << n) - 1;

            long maxP = Long.MIN_VALUE, minP = Long.MAX_VALUE;
            long maxSize = 0, minSize = 0;
            for (int i = 1; i <= mask; i++) {
                long Q = 1;
                long P;
                long subsetSize = 0;

                for (int j = 0; j < n; j++) {
                    int bit = 1 << j;
                    long subSetSum = 0;
                    if ((i & (bit)) != 0) {
                        subsetSize++;
                        for (int x = 0; x < k; x++) {
                            subSetSum = (subSetSum + arr[x][j]);
                        }
                        Q = (Q * subSetSum) % mod;

                    }
                }

                //Fermat's little theorem
                //https://comeoncodeon.wordpress.com/tag/fermat/
                Q = (Q * pow(subsetSize, mod - 2, mod)) % mod;
                P = Q % mod;
                if (maxP < P) {
                    maxP = P;
                    maxSize = subsetSize;
                } else if (maxP == P) {
                    if (maxSize > subsetSize) {
                        maxSize = subsetSize;
                    }
                }

                if (minP > P) {
                    minP = P;
                    minSize = subsetSize;
                } else if (minP == P) {
                    if (minSize < subsetSize) {
                        minSize = subsetSize;
                    }
                }

            }

            System.out.println((maxP ^ minP) + " " + (maxSize ^ minSize));
        }


    }
}
