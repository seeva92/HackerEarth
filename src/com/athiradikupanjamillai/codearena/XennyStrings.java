package com.athiradikupanjamillai.codearena;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class XennyStrings {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t, n, k, m;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] nkm = br.readLine().split(" ");
            n = Integer.parseInt(nkm[0]);
            k = Integer.parseInt(nkm[1]);
            m = Integer.parseInt(nkm[2]);

            List<Pair> pairs = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                String curr = br.readLine();
                String sub = curr.substring(0, m - 1);
                pairs.add(new Pair(curr, sub));
            }

            pairs.sort(Comparator.comparing(o -> o.sub));
            System.out.println(pairs.get(k - 1).curr);
        }
    }

    static class Pair {
        String curr;
        String sub;

        public Pair(String curr, String sub) {
            this.curr = curr;
            this.sub = sub;
        }
    }
}
