package com.athiradikupanjamillai.codearena;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UniqueMaximumNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(input[i]);
            int count = map.getOrDefault(x, 0);
            map.put(x, count + 1);
        }

        Optional<Integer> integer = map.entrySet().stream().filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey).max(Integer::compareTo);
        System.out.println(integer.orElse(-1));

    }
}
