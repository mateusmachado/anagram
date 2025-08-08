package br.com.anagram.controler;


import br.com.anagram.service.AnagramService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnagramController {

    @GetMapping("/anagrams")
    public List<String> getAnagrams(@RequestParam String letters) {
        return AnagramService.generate(letters);
    }
}