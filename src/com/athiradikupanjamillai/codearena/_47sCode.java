package com.athiradikupanjamillai.codearena;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _47sCode {

    static int[] arr;
    static int[] seg;

    static void build(int start, int end, int index) {
        if (start == end) {
            seg[index] = arr[start];
            return;
        }
        int mid = start + (end - start) / 2;
        build(start, mid, (index << 1) + 1);
        build(mid + 1, end, (index << 1) + 2);
        seg[index] = seg[(index << 1) + 1] + seg[(index << 1) + 2];
    }

    static long query(int start, int end, int index, int i, int j) {
        if (i <= start && end <= j) {
            return seg[index];
        }

        if (j < start || i > end) {
            return 0;
        }

        int mid = start + (end - start) / 2;
        return query(start, mid, (index << 1) + 1, i, j) +
                query(mid + 1, end, (index << 1) + 2, i, j);
    }

    static void pointUpdate(int start, int end, int index, int i, int diff) {
        if (start == end) {
            arr[start] += diff;
            seg[index] += diff;
            return;
        }

        int mid = start + (end - start) / 2;
        if (i <= mid) {
            pointUpdate(start, mid, (index << 1) + 1, i, diff);
        } else {
            pointUpdate(mid + 1, end, (index << 1) + 2, i, diff);
        }
        seg[index] = seg[(index << 1) + 1] + seg[(index << 1) + 2];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String[] nk = br.readLine().split(" ");
            int N = Integer.parseInt(nk[0]);
            int K = Integer.parseInt(nk[1]);
            String[] nArrString = br.readLine().split(" ");
            arr = new int[N];
            seg = new int[4 * N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(nArrString[i]);
            }

            build(0, N - 1, 0);
            int Q = Integer.parseInt(br.readLine());
            while (Q-- > 0) {
                String[] queries = br.readLine().split(" ");
                if (queries[0].charAt(0) == 'Q') {
                    int x = Integer.parseInt(queries[1]);
                    int y = Integer.parseInt(queries[2]);
                    System.out.println(query(0, N - 1, 0, x, y));
                } else {
                    int x = Integer.parseInt(queries[1]);
                    int val = Integer.parseInt(queries[2]);
                    pointUpdate(0, N - 1, 0, x, val - arr[x]);
                }
            }

            ///2 1 1 1 4 3 5 7 9 1 1 1 1
            ///9 2 1 1 1 4 3 5 7 1 1 1 1
            //
            //            for (int i = 1; i < N && K > 0; i++) {
            //                int j = i;
            //                while (j > 0 && K > 0 && arr[j] > arr[j - 1]) {
            //                    swap(j, j - 1, arr);
            //                    j--;
            //                    K--;
            //                }
            //            }
            //
            //            StringBuilder sb = new StringBuilder(N);
            //            for (int i = 0; i < N; i++) {
            //                sb.append(arr[i]);
            //            }

            //            System.out.println(sb.toString());
        }
    }

    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void buildSeg(int start, int end, int index) {

    }

}
