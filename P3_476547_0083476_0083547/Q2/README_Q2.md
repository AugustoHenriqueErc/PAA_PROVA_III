# Longest Increasing Subsequence Analysis

## Descrição

Este projeto implementa uma solução para o problema da **Maior Subsequência Crescente** (*Longest Increasing Subsequence - LIS*) utilizando **Programação Dinâmica** em Java.

Além de encontrar o tamanho da maior subsequência crescente, o programa realiza uma análise experimental do algoritmo, medindo:

* Número de comparações realizadas;
* Número de atualizações efetuadas;
* Tempo de execução;
* Tamanho da maior subsequência crescente encontrada.

Os resultados são exportados para um arquivo `results.csv`, permitindo a construção de gráficos e a análise empírica da complexidade do algoritmo.

---

## Problema

Dada uma sequência de inteiros:

```text
v = [v0, v1, ..., vn-1]
```

o objetivo é determinar o comprimento da maior subsequência estritamente crescente presente no vetor.

Exemplo:

```text
Entrada:
[32, 19, 32, 17, 31, 43, 30, 29, 54, 16, 28, 66, 15, 41, 65, 14, 50]

Saída:
Comprimento da LIS = 5
Uma subsequência possível = [19, 31, 43, 54, 66]
```

---

## Abordagem Utilizada

A solução foi implementada utilizando **Programação Dinâmica**.

Define-se:

```text
best[i]
```

como o tamanho da maior subsequência crescente que se inicia na posição `i`.

A recorrência utilizada é:

```text
best[i] = 1 + max(best[j]),
para todo j > i tal que sequence[j] > sequence[i]
```

Caso não exista um índice `j` que satisfaça a condição:

```text
best[i] = 1
```

A implementação também utiliza um vetor `next` para reconstruir uma subsequência máxima encontrada.

---

## Geração das Sequências

As sequências de teste são geradas por meio da classe `Random` do Java utilizando a semente fixa:

```java
private static final long SEED = 476547;
```

Cada elemento da sequência é gerado por:

```java
random.nextInt(10000);
```

produzindo valores inteiros no intervalo:

```text
0 ≤ x < 10000
```

A utilização de uma semente fixa garante que os experimentos sejam reproduzíveis.

---

## Tamanhos de Entrada

Os experimentos são executados para os seguintes tamanhos de entrada:

```text
100
250
500
1000
2000
4000
```

---

## Saída

Ao executar o programa, é gerado o arquivo:

```text
results.csv
```

com o seguinte formato:

```csv
n,comparisons,updates,time,lisLength
100,...
250,...
500,...
1000,...
2000,...
4000,...
```

Cada linha contém:

| Campo       | Descrição                               |
| ----------- | --------------------------------------- |
| n           | Tamanho da sequência                    |
| comparisons | Número de comparações realizadas        |
| updates     | Número de atualizações do vetor `best`  |
| time        | Tempo de execução em nanossegundos      |
| lisLength   | Tamanho da maior subsequência crescente |

---

## Complexidade

O algoritmo utiliza dois laços aninhados:

```java
for (int i = size - 2; i >= 0; i--) {
    for (int j = i + 1; j < size; j++) {
        ...
    }
}
```

Portanto, o número de operações é aproximadamente:

```text
n(n - 1) / 2
```

resultando em:

```text
Complexidade Temporal: O(n²)
Complexidade Espacial: O(n)
```

---

## Compilação

Compilar:

```bash
javac LongestIncreasingSubsequenceAnalysis.java
```

Executar:

```bash
java LongestIncreasingSubsequenceAnalysis
```

---

## Exemplo de Saída

```text
n = 100 | comparisons = 4950 | updates = 164 | time = 155462 ns | LIS = 18
n = 250 | comparisons = 31125 | updates = 508 | time = 856246 ns | LIS = 27
n = 500 | comparisons = 124750 | updates = 1152 | time = 1921632 ns | LIS = 39
n = 1000 | comparisons = 499500 | updates = 2637 | time = 4378756 ns | LIS = 60
n = 2000 | comparisons = 1999000 | updates = 5961 | time = 11945015 ns | LIS = 80
n = 4000 | comparisons = 7998000 | updates = 12986 | time = 49584909 ns | LIS = 116
```

---

## Autor

Projeto desenvolvido para a disciplina de **Projeto e Análise de Algoritmos (PAA)**, com o objetivo de estudar a aplicação de Programação Dinâmica ao problema da Maior Subsequência Crescente e analisar experimentalmente seu comportamento assintótico.
