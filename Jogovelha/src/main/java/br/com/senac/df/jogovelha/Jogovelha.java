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
        
        Tabuleiro tabuleiro = new Tabuleiro("1 - Cada jogador deve escolher um simbolo;" + "2 - O jogador 1 inicia a partida; 3 - ");
        Jogador jogador1 = new Jogador(1,"Francisco",'X');        
        Jogador jogador2 = new Jogador(2, "Maria", 'O');


          
          
          
          do{
              tabuleiro.mostrarTabuleiro();
              
              if(tabuleiro.getJogadordaVez() == 1){
                System.out.println("Jogador 1, escolha onde jogar: ");
                String local = entrada.nextLine();
                  tabuleiro.marcarJogada(jogador1.getSimbolo(), local);
                  tabuleiro.setJogadordaVez(2);
                  tabuleiro.mostrarTabuleiro();
                  tabuleiro.verificarGanhador(jogador1.getSimbolo(),1);
                  
                  
              }else{
                System.out.println("Jogador 2, escolha onde jogar: "); 
                String local = entrada.nextLine();
                
                tabuleiro.marcarJogada(jogador2.getSimbolo(), local);
                  tabuleiro.setJogadordaVez(1);
                  tabuleiro.mostrarTabuleiro();
                  tabuleiro.verificarGanhador(jogador2.getSimbolo(), 2);
              }
              
         //  tabuleiro.setHouveGanhadorUltimarodada(true);
          }while(tabuleiro.isHouveGanhadorUltimarodada()== false);
          
    }
}
