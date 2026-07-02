# Projeto: Longest Increasing Subsequence (LIS)

## Descrição

Este projeto implementa um experimento para calcular a Longest Increasing Subsequence (LIS) em sequências geradas automaticamente. O programa gera sequências de diferentes tamanhos, executa o algoritmo de LIS e grava métricas (comparações, atualizações, tempo de execução e tamanho da LIS) em um arquivo `results.csv`.

## Estrutura do projeto

- `ExecutionResult.java` - Classe para armazenar métricas/resultados da execução.
- `GenerateSequence.java` - Gera as sequências de teste usadas pelo experimento.
- `LongestIncreasingSubsequence.java` - Implementação(s) do(s) algoritmo(s) para calcular LIS.
- `Main.java` - Ponto de entrada que orquestra a geração, execução e gravação dos resultados.

## Requisitos

- Java JDK (versão 8 ou superior)

## Compilar e executar

1. Abra um terminal na pasta do projeto.
2. Compile todos os arquivos Java:

```bash
javac *.java
```

3. Execute o programa principal:

```bash
java Main
```

Ao finalizar, o programa deverá gerar o arquivo `results.csv` na mesma pasta e imprimir uma mensagem de sucesso no console.

## Exemplo de saída

O arquivo `results.csv` conterá linhas no formato:

```
n,comparisons,updates,executionTime,lisLength
```

E uma linha por tamanho testado (por exemplo `100, ...`). O `Main` costuma imprimir "results.csv generated successfully." ao final.

## Observações

- Se o `Main.java` estiver organizado em um pacote, ajuste os comandos de compilação/execução para refletir o pacote.
- Para testar variações, edite os tamanhos ou a forma de geração em `Main.java` ou em `GenerateSequence.java`.

## Autor

Projeto gerado a partir do repositório local. Para ajustar o README, edite este arquivo conforme necessário.
