package br.com.anagram;


import br.com.anagram.service.AnagramService;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AnagramServiceTest {

    @Test
    void testThreeLetters() {
        List<String> result = AnagramService.generate("abc");
        assertEquals(6, result.size());
        assertEquals(Set.of("abc", "acb", "bac", "bca", "cab", "cba"), Set.copyOf(result));
    }

    @Test
    void testSingleLetter() {
        List<String> result = AnagramService.generate("x");
        assertEquals(List.of("x"), result);
    }

    @Test
    void testEmptyInputThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> AnagramService.generate(""));
    }

    @Test
    void testInvalidCharacterThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> AnagramService.generate("a1"));
    }

    @Test
    void testDuplicateLetterThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> AnagramService.generate("aab"));
    }

    @Test
    void testFourLetters() {
        List<String> result = AnagramService.generate("abcd");
        assertEquals(24, result.size());
        assertTrue(result.contains("abcd"));
        assertTrue(result.contains("dcba"));
    }

    @Test
    void testCaseSensitivity() {
        List<String> result = AnagramService.generate("aA");
        assertEquals(2, result.size());
        assertEquals(Set.of("aA", "Aa"), Set.copyOf(result));
    }

    @Test
    void testLargeInputPerformance() {
        List<String> result = AnagramService.generate("abcde");
        assertFalse(result.isEmpty());
        assertEquals(120, result.size());
    }

    @Test
    void testInputWithSpacesThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> AnagramService.generate("a b"));
    }

    @Test
    void testNullInputThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> AnagramService.generate(null));
    }
}