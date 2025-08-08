package br.com.anagram.service;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
public final class AnagramService {

    private AnagramService() {
    }

    public static List<String> generate(String letters) {
        validateInput(letters);
        List<String> results = new ArrayList<>();
        char[] chars = letters.toCharArray();
        backtrack(chars, 0, results);
        return results;
    }

    private static void backtrack(char[] chars, int index, List<String> results) {
        if (index == chars.length - 1) {
            results.add(new String(chars));
            return;
        }
        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            backtrack(chars, index + 1, results);
            swap(chars, index, i);
        }
    }

    private static void swap(char[] arr, int i, int j) {
        if (i != j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    private static void validateInput(String letters) {
        if (letters == null || letters.isBlank()) {
            throw new IllegalArgumentException("Entrada não pode ser nula ou vazia.");
        }
        Set<Character> seen = new HashSet<>();
        for (char c : letters.toCharArray()) {
            if (!Character.isLetter(c)) {
                throw new IllegalArgumentException("Entrada deve conter apenas letras.");
            }
            if (!seen.add(c)) {
                throw new IllegalArgumentException("As letras devem ser distintas.");
            }
        }
    }
}