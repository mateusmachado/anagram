# Anagram Generator - Spring Boot

Aplicação Spring Boot que gera todos os anagramas possíveis a partir de um conjunto de letras distintas.

---

## Como rodar

### Pré-requisitos

- Java 17+ instalado
- Gradle instalado ou usar o wrapper (`./gradlew`)

### Rodando a aplicação

No terminal, dentro do diretório do projeto:

```bash
./gradlew bootRun
```

### Endpoint para gerar anagramas
```bash
curl --location 'http://localhost:8080/anagrams?letters=abc'

 Exemplo de resposta

json
[
  "abc",
  "acb",
  "bac",
  "bca",
  "cab",
  "cba"
]

```
