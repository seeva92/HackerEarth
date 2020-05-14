package com.athiradikupanjamillai.codearena;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SymmetricLogos {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = parseInt(br.readLine());
        while (t-- > 0) {
            int N = parseInt(br.readLine());
            char[][] image = new char[N][N];
            for (int i = 0; i < N; i++) {
                image[i] = br.readLine().toCharArray();
            }

            if (checkXAxis(image) && checkYAxis(image)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean checkYAxis(char[][] image) {
        int N = image.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0, k = N - 1; j < N && k >= 0 && j <= k; j++, k--) {
                if (image[j][i] != image[k][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkXAxis(char[][] image) {
        int N = image.length;
        for (char[] chars : image) {
            for (int j = 0, k = N - 1; j < N && k >= 0 && j <= k; j++, k--) {
                if (chars[j] != chars[k]) {
                    return false;
                }
            }
        }

        return true;
    }
}
