/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.df.jogovelha;

/**
 *
 * @author francisco62977666
 */
public class Tabuleiro {
     private int notaJ1;
     private int notaJ2;  
     private String regras;
     private boolean houveGanhadorUltimarodada;
     private int jogadordaVez;
     private char a1 = ' ', a2 = ' ', a3 = ' ', b1 = ' ' , b2 = ' ' , b3 = ' ', c1 = ' ', c2 = ' ', c3 = ' ';
     
    public int getNotaJ1() {
        return notaJ1;
    }

    public void setNotaJ1(int notaJ1) {
        this.notaJ1 = notaJ1;
    }

    public int getNotaJ2() {
        return notaJ2;
    }

    public void setNotaJ2(int notaJ2) {
        this.notaJ2 = notaJ2;
    }

    public String getRegras() {
        return regras;
    }

    public void setRegras(String regras) {
        this.regras = regras;
    }

    public Tabuleiro(String regras) {
        this.regras = regras;
        this.notaJ1 = 0;
        this.notaJ2 = 0;
        this.houveGanhadorUltimarodada = false;
        this.jogadordaVez = 1;
    }

    public boolean isHouveGanhadorUltimarodada() {
        return houveGanhadorUltimarodada;
    }

    public void setHouveGanhadorUltimarodada(boolean houveGanhadorUltimarodada) {
        this.houveGanhadorUltimarodada = houveGanhadorUltimarodada;
    }

    public int getJogadordaVez() {
        return jogadordaVez;
    }

    public void setJogadordaVez(int jogadordaVez) {
        this.jogadordaVez = jogadordaVez;
    }
    
    
    
    
    
   public void verificarGanhador(char simbolo, int numeroJogador){
    if(a3 == simbolo && b2 == simbolo &&  c1 == simbolo){
      this.houveGanhadorUltimarodada = true;
    }else if(a1 == simbolo && b2 == simbolo && c3 == simbolo){
      this.houveGanhadorUltimarodada = true;
    }else if(a2 == simbolo && b2 == simbolo && c2 == simbolo){
      this.houveGanhadorUltimarodada = true;
    }else if(a3 == simbolo && b3 == simbolo && c3 == simbolo){
      this.houveGanhadorUltimarodada = true;
    }else if(a1 == simbolo && b1 == simbolo && c1 == simbolo){
      this.houveGanhadorUltimarodada = true;
    }else if(b1 == simbolo && b2 == simbolo && b3 == simbolo){
      this.houveGanhadorUltimarodada = true;
    }else if(a1 == simbolo && a2 == simbolo && a3 == simbolo){
      this.houveGanhadorUltimarodada = true;
    }else if(c1 == simbolo && c2 == simbolo && c3 == simbolo){
      this.houveGanhadorUltimarodada = true;
    }
     {
        
    }
    
    if(this.houveGanhadorUltimarodada == true){
      System.out.println("Jogador que venceu: " + numeroJogador);
    }
   } 
    
   public void organizar(){
   
   } 
   
   public void mostrarTabuleiro(){
    System.out.printf("""
                       
                             A            B             C
                                    |             |             
                                    |             |             
                     1      %c       |     %c       |     %c       
                                    |             |             
                       -------------+-------------+-------------
                                    |             |             
                     2      %c       |     %c       |     %c        
                                    |             |             
                                    |             |             
                       -------------+-------------+-------------
                                    |             |             
                     3      %c       |     %c       |     %c       
                                    |             |             
                                    |             |          
                       """, a1, b1, c1,a2,b2,c2,a3,b3,c3);
   }
   
   public boolean marcarJogada(char simbolo, String coordenada){
     switch(coordenada.toUpperCase()){
         case "A1":
           if(a1 != ' ')return false;
           a1 = simbolo;
           break;
         case "A2":           
           if(a2 != ' ')return false;
           a2 = simbolo;
           break;  
         case "A3":  
           if(a3 != ' ')return false;
           a3 = simbolo;
           break;
         case "B1":
            if(b1 != ' ')return false;
           b1 = simbolo;
           break;
         case "B2":
             if(b2 != ' ')return false;
           b2 = simbolo;
           break;
         case "B3":
             if(b3 != ' ')return false;
           b3 = simbolo;
           break;
         case "C1":
             if(c1 != ' ')return false;
           c1 = simbolo;
           break;
         case "C2":
             if(c2 != ' ')return false;
           c2 = simbolo;
           break;
         case "C3":
             if(c3 != ' ')return false;
           c3 = simbolo;
           break;
           
         default:
             return false;
     } 
         return true;
         
         
   }

    public void atualizarPlacar(int numeroJogador) {
        int notaJ1 = 0;
        int notaJ2 = 0;
    if (numeroJogador == 1) {
        notaJ1++;
    } else if (numeroJogador == 2) {
        notaJ2++;
    }

    System.out.println("\n===== PLACAR =====");
    System.out.println("Jogador 1: " + notaJ1 + " ponto(s)");
    System.out.println("Jogador 2: " + notaJ2 + " ponto(s)");
    System.out.println("==================");
    }
    
    public void reiniciarTabuleiro() {
    a1 = ' ';
    a2 = ' ';
    a3 = ' ';
    b1 = ' ';
    b2 = ' ';
    b3 = ' ';
    c1 = ' ';
    c2 = ' ';
    c3 = ' ';

    houveGanhadorUltimarodada = false;
    jogadordaVez = 1;

    System.out.println("Tabuleiro reiniciado!");
   }
    
    public boolean isTabuleiroCheio() {
    return a1 != ' ' && a2 != ' ' && a3 != ' '
        && b1 != ' ' && b2 != ' ' && b3 != ' '
        && c1 != ' ' && c2 != ' ' && c3 != ' ';
  }
}
   
   
   
   

