package GameDaVeia;

import java.util.Scanner;

public class Jogo {
    private Tabuleiro tabuleiro;
    private int rodada=1, vez=1;
    private Jogador jogador1;
    private Jogador jogador2;
    public Scanner entrada = new Scanner(System.in);

    
    public Jogo(){
        this.tabuleiro = new Tabuleiro();
    }
    
    public void iniciaJogo() {
    	iniciarJogadores();
        regras();
        
        while( Jogar() );
    }
    
    private void iniciarJogadores(){
        System.out.println("Quem vai ser o Jogador 1 (X) ?");
        if(escolherJogador() == 1)
            this.jogador1 = new Player1(1);
        else
            this.jogador1 = new Player2(1);
        
        System.out.println("----------------------");
        System.out.println("Quem vai ser o Jogador 2 (O) ?");
        
        if(escolherJogador() == 1)
            this.jogador2 = new Player1(2);
        else
            this.jogador2 = new Player2(2);
        
    }
    
    private int escolherJogador(){
        int opcao=0;
        
        do{
            System.out.println("1. Player 1");
            System.out.println("2. Player 2\n");
            System.out.print("Opção: ");
            opcao = entrada.nextInt();
            
            if(opcao != 1 && opcao != 2)
                System.out.println("Opção inválida! Tente novamente");
        }while(opcao != 1 && opcao != 2);
        
        return opcao;
    }
    
    private void regras() {
    	
    	System.out.println("Regas do Jogo:");
    	System.out.println("No modo básico do jogo, participam duas pessoas, que jogam alternadamente, preenchendo cada um dos\r\n"
    			+ "espaços vazios.\n");
    	System.out.println("Vence o jogador que conseguir formar primeiro uma linha com três símbolos iguais,\r\n" 
    			+ "seja ela na horizontal, vertical ou diagonal.");
    	System.out.println("Informe Primeiramente a Linha 'Horizontal', Apos isso a Coluna 'Vertical'");
    	System.out.println("----------------------");
    	System.out.println("Tenha um bom Jogo <3");
    	
    	
    }
    
    private boolean Jogar(){
        if(ganhou() == 0 ){
            System.out.println("----------------------");
            System.out.println("\nRodada "+rodada);
            System.out.println("É a vez do jogador " + vez() );
            
            if(vez()==1)
                jogador1.jogar(tabuleiro);
            else
                jogador2.jogar(tabuleiro);
            
            
            if(tabuleiro.tabuleiroCompleto()){
                System.out.println("Tabuleiro Completo. Jogo empatado");
                return false;
            }
            vez++;
            rodada++;

            return true;
        } else{
            if(ganhou() == -1 )
                System.out.println("Jogador 1 ganhou!");
            else
                System.out.println("Jogador 2 ganhou!");
            
            return false;
        }
            
    }
    
    private int vez(){
        if(vez%2 == 1)
            return 1;
        else
            return 2;
    }
    
    private int ganhou(){
        if(tabuleiro.checaLinhas() == 1)
            return 1;
        if(tabuleiro.checaColunas() == 1)
            return 1;
        if(tabuleiro.checaDiagonais() == 1)
            return 1;
        
        if(tabuleiro.checaLinhas() == -1)
            return -1;
        if(tabuleiro.checaColunas() == -1)
            return -1;
        if(tabuleiro.checaDiagonais() == -1)
            return -1;
        
        return 0;
    }
    
    
}
