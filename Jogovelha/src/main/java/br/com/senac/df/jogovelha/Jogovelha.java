/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.com.senac.df.jogovelha;

import java.util.Scanner;

/**
 *
 * @author francisco62977666
 */
public class Jogovelha {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        Tabuleiro tabuleiro = new Tabuleiro(
            "1 - Cada jogador deve escolher um simbolo; "
            + "2 - O jogador 1 inicia a partida;"
        );

        Jogador jogador1 = new Jogador(1, "Francisco", 'X');
        Jogador jogador2 = new Jogador(2, "Maria", 'O');

        String resposta;

        do {
            // Inicia uma nova partida
            boolean partidaTerminou = false;

            while (!partidaTerminou) {

                tabuleiro.mostrarTabuleiro();

                if (tabuleiro.getJogadordaVez() == 1) {

                    System.out.println("Jogador 1, escolha onde jogar:");
                    String local = entrada.nextLine().trim();

                    boolean jogadaValida =
                        tabuleiro.marcarJogada(
                            jogador1.getSimbolo(), local
                        );

                    if (jogadaValida) {

                        tabuleiro.verificarGanhador(
                            jogador1.getSimbolo(), 1
                        );

                        if (tabuleiro.isHouveGanhadorUltimarodada()) {
                            tabuleiro.mostrarTabuleiro();
                            tabuleiro.atualizarPlacar(1);
                            partidaTerminou = true;
                        } else if (tabuleiro.isTabuleiroCheio()) {
                            tabuleiro.mostrarTabuleiro();
                            System.out.println("Empate!");
                            partidaTerminou = true;
                        } else {
                            tabuleiro.setJogadordaVez(2);
                        }

                    } else {
                        System.out.println(
                            "Posição inválida ou já ocupada! Tente novamente."
                        );
                    }

                } else {

                    System.out.println("Jogador 2, escolha onde jogar:");
                    String local = entrada.nextLine().trim();

                    boolean jogadaValida =
                        tabuleiro.marcarJogada(
                            jogador2.getSimbolo(), local
                        );

                    if (jogadaValida) {

                        tabuleiro.verificarGanhador(
                            jogador2.getSimbolo(), 2
                        );

                        if (tabuleiro.isHouveGanhadorUltimarodada()) {
                            tabuleiro.mostrarTabuleiro();
                            tabuleiro.atualizarPlacar(2);
                            partidaTerminou = true;
                        } else if (tabuleiro.isTabuleiroCheio()) {
                            tabuleiro.mostrarTabuleiro();
                            System.out.println("Empate!");
                            partidaTerminou = true;
                        } else {
                            tabuleiro.setJogadordaVez(1);
                        }

                    } else {
                        System.out.println(
                            "Posição inválida ou já ocupada! Tente novamente."
                        );
                    }
                }
            }

            // Pergunta se os jogadores querem jogar novamente
            System.out.println("Desejam jogar novamente? (S/N)");
            resposta = entrada.nextLine().trim();

            if (resposta.equalsIgnoreCase("S")) {
                tabuleiro.reiniciarTabuleiro();
            }

        } while (resposta.equalsIgnoreCase("S"));

        System.out.println("\n===== PLACAR FINAL =====");
        System.out.println("Francisco: " + tabuleiro.getNotaJ1());
        System.out.println("Maria: " + tabuleiro.getNotaJ2());
        System.out.println("Obrigado por jogar!");

        entrada.close();
    }
}