package com.athiradikupanjamillai.codearena;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;


////Not completed
public class DigitalNumbers {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int[] tubes = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
        System.out.println((1<<10) -1);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] lm = br.readLine().split(" ");
            int l = Integer.parseInt(lm[0]);
            int m = Integer.parseInt(lm[1]);

            int count = m/7;
            if(l == 0) {
                System.out.println(0);
            } else {
                System.out.println(compute(l, count, new HashSet<>(), tubes, ""));
            }

        }
    }

    private static long compute(int l, int count, Set<Integer> used, int[] tubes, String num)
            throws IOException {
        if(l == 0) {
            return 0L;
        }

        long result = 0L;
        for (int digit = 0; digit < 10; digit++) {
            if(!used.contains(digit) && (count - tubes[digit] >=0)) {
                used.add(digit);
                result += 1 + compute(l-1, count - tubes[digit], used, tubes, num + digit);
                used.remove(digit);
            }
        }
        return result;
    }
}
