# Sudoku Console Game

![Build Status](https://img.shields.io/badge/build-passing-brightgreen)

Um motor de Sudoku funcional em Java, jogável via console.  
O projeto segue princípios de **Clean Architecture**, com separação clara entre:

- **Domain**: `Board`, `Cell`, `Position` e regras de validação
- **Application**: `SudokuGame` que coordena jogadas e validações
- **Infrastructure**: Console printer para exibição do tabuleiro

---

## Status atual

✅ Motor de Sudoku completo  
✅ Regras validadas:
- Sem duplicidade em linhas
- Sem duplicidade em colunas
- Sem duplicidade em blocos 3x3  
✅ Células fixas protegidas (não podem ser alteradas)  
✅ Console jogável com loop de entrada do usuário  
✅ Tabuleiro atualizado após cada jogada  

---

## Como jogar

1. Clone o projeto:

```bash
git clone https://github.com/seu-usuario/sudoku-console.git
cd sudoku-console
```

2. Compile o projeto:

```bash
javac -d bin $(find src -name "*.java")
```

3. Rode o jogo:

```bash
java -cp bin Main
```

4. O tabuleiro será exibido no console. Insira:
   - Linha (0-8)
   - Coluna (0-8)
   - Número (1-9)

Exemplo de input:
```
Linha (0-8): 0
Coluna (0-8): 2
Número (1-9): 4
```


## Estrutura do projeto

```
src/
 ├─ application/
 │   └─ SudokuGame.java
 ├─ domain/
 │   ├─ entity/
 │   │   ├─ Board.java
 │   │   ├─ Cell.java
 │   │   └─ Position.java
 │   ├─ rule/
 │   │   ├─ NoDuplicateInRowRule.java
 │   │   ├─ NoDuplicateInColumnRule.java
 │   │   └─ NoDuplicateInBlockRule.java
 │   └─ service/
 │       └─ SudokuRuleValidator.java
 ├─ infrastructure/
 │   └─ console/
 │       └─ BoardPrinter.java
 └─ Main.java
```

## Tecnologias
 - Java 17+
 - Console como interface inicial
 - Design baseado em Clean Architecture
