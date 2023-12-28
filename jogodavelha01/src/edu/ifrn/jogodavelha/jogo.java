/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ifrn.jogodavelha;

/**
 *
 * @author geron
 */


public class jogo {
    private int[][] tabuleiro;
    private char jogadorAtual;

    public jogo() {
        tabuleiro = new int[3][3];
        jogadorAtual = 1; // Começa com o jogador X
        inicializarTabuleiro();
    }

    private void inicializarTabuleiro() {
        // Inicializa o tabuleiro vazio
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = -1;
            }
        }
    }

    public boolean fazerJogada(int linha, int coluna) {
        // Verifica se a jogada é válida
        if (linha < 0 || linha >= 3 || coluna < 0 || coluna >= 3 || tabuleiro[linha][coluna] != '-') {
            return false; // Jogada inválida
        }

        tabuleiro[linha][coluna] = jogadorAtual;
        trocarJogador(); // Troca para o próximo jogador
        return true;
    }

    private void trocarJogador() {
        jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
    }

    public char verificarVencedor() {
     // Verificar linhas, colunas e diagonais para jogador O (0) e jogador X (1)
    for (int jogador = 0; jogador <= 1; jogador++) {
        // Verificar linhas
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == jogador && tabuleiro[i][1] == jogador && tabuleiro[i][2] == jogador) {
                return jogadorAtual; // Vitória na linha
            }
        }

        // Verificar colunas
        for (int j = 0; j < 3; j++) {
            if (tabuleiro[0][j] == jogador && tabuleiro[1][j] == jogador && tabuleiro[2][j] == jogador) {
                return jogadorAtual; // Vitória na coluna
            }
        }

        // Verificar diagonais
        if (tabuleiro[0][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador) {
            return jogadorAtual; // Vitória na diagonal principal
        }
        if (tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][0] == jogador) {
            return jogadorAtual; // Vitória na diagonal secundária
        }
    }

    // Verificar empate
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (tabuleiro[i][j] == -1) {
                return (char) -1; // Jogo em andamento
            }
        }
    }

    return 2; // Empate
}

    public int[][] getTabuleiro() {
        return tabuleiro;
    }

    public char getJogadorAtual() {
        return jogadorAtual;
    }
}
