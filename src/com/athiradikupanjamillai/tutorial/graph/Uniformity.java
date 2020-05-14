package com.athiradikupanjamillai.tutorial.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Uniformity {


    /// abababababccbbbaaaa

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        char[] str = br.readLine().toCharArray();

        if (k > 0) {
            int a = compute(str, 'a', k);
            int b = compute(str, 'b', k);
            int c = compute(str, 'c', k);
            System.out.println(Math.max(Math.max(a, b), c));
        } else {
            int count = 1;
            int maxSub = 1;
            for (int i = 1; i < n; i++) {
                if (str[i] == str[i - 1]) {
                    count++;
                } else {
                    count = 1;
                }
                maxSub = Math.max(maxSub, count);
            }
            System.out.println(maxSub);
        }
    }

    private static int compute(char[] str, char c, int k) {
        int length = str.length;
        boolean[] toggled = new boolean[length];
        Arrays.fill(toggled, false);

        int maxSub = 0;

        int front = 0, rear = 0, tog = 0, index = 0;
        while (index < length) {
            if (str[index] == c) {
                rear++;
            } else {
                while (tog == k && front < rear) {
                    if (toggled[front]) {
                        toggled[front] = false;
                        tog--;
                    }
                    front++;
                }
                toggled[rear] = true;
                tog++;
                rear++;
            }

            maxSub = Math.max(maxSub, rear - front);

            index++;
        }

        return maxSub;
    }
}
