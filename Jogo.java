import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jogo{
    private float rodada;
    private final List<Jogador> jogadores;
    private Baralho baralho;


 Jogo (float rodada) {
    this.rodada = rodada;
    this.jogadores = new ArrayList<>();
 }
    

    public void cadJogadores() {
        Scanner leitor = new Scanner(System.in);
        System.out.print("Digite o número de jogadores 2 ou 4");
        int numeroDeJogadores = leitor.nextInt();
        
        while (numeroDeJogadores != 2 && numeroDeJogadores != 4) {
            System.out.println("O jogo deve ter 2 2ou 4 jogadores.");
            numeroDeJogadores = leitor.nextInt();
        }
        this.baralho = new Baralho();
        baralho.embaralhar();
        baralho.gerarManilha();
        baralho.mostrarBaralho();
        System.out.println("Baralho embaralhado.");

        for(int i = 0; i < numeroDeJogadores; i++) {
            System.out.print("Digite o nome do Jogador " + (i + 1) + ": ");
            String nome = leitor.next();
            Jogador jogador = new Jogador(nome);
            jogadores.add(jogador);
            System.out.println("ADD JOGADOR");
            
        }
        
        
    }

    public void darCarta() {
        
        for (Jogador jogador:this.jogadores){
            jogador.getMao().clear();
            for (int j = 0; j < 3; j++) {
                Carta carta = baralho.darCarta();
                if (carta != null) {
                    jogador.receberCarta(carta);
                }
            }
        }
    }
    

    public void rodada() {
        Jogador jogador1 = jogadores.get(0);
        Jogador jogador2 = jogadores.get(1);
        int pontosJogador1 = 0;
        int pontosJogador2 = 0;
        int vencedorPrimeiraRodada = 0;
        System.out.println("#####RODADA INICIADA#####");
        Scanner scanner = new Scanner(System.in);

        while (jogador1.getPontuacao() < 12 && jogador2.getPontuacao() < 12) {
            System.out.println("Pontos jogador 1 :" + jogador1.getPontuacao());
            System.out.println("Pontos jogador 2 :" + jogador2.getPontuacao());
            baralho.gerarManilha();
      
        pontosJogador1 = 0;
        pontosJogador2 = 0;
        System.out.println("#####NOVA RODADA INICIADA#####");

        darCarta();
        for(int i = 0; i < 3; i++) { 
            for (Carta carta1 : jogador1.getMao()) {
                System.out.println(carta1.getValor() + " de " + carta1.getNaipe() + " forca :" + carta1.getForca());
            }

        System.out.println(jogador1.getNome() + ", escolha sua carta (1, 2 ou 3): ");
        int escolha1 = scanner.nextInt();
        Carta carta1 = jogador1.jogarCarta(escolha1 - 1);
        System.out.println("Jogou um " + carta1.getValor() +  " de " + carta1.getNaipe());

        for (Carta carta2 : jogador2.getMao()) {
            System.out.println(carta2.getValor() + " de " + carta2.getNaipe() + " forca: " + carta2.getForca());
        }
        System.out.println(jogador2.getNome() + ", escolha sua carta (1, 2 ou 3): ");
        int escolha2 = scanner.nextInt();
        Carta carta2 = jogador2.jogarCarta(escolha2 - 1);
        System.out.println("Jogou um " + carta2.getValor() +  " de " + carta2.getNaipe());
        
            
         
        if(carta1.getForca() > carta2.getForca()) {
            System.out.println("Jogador 1 ganhou a rodada");
            pontosJogador1++;
            if(i == 0) {
                vencedorPrimeiraRodada = 1;
            }
        } else if(carta1.getForca() < carta2.getForca()) {
            System.out.println("Jogador 2 ganhou a rodada");
            pontosJogador2++;
            if(i == 0) {
                vencedorPrimeiraRodada = 2;
            }
        } else if (i == 1){
            if(pontosJogador1 == pontosJogador2) {
                if (vencedorPrimeiraRodada == 1) {
                    System.out.println("Empate na segunda rodada! Vitória para " + jogador1.getNome());
              jogador1.aumentarPontuacao(1); }
              else if(vencedorPrimeiraRodada == 2) {
                System.out.println("Empate na segunda rodada! Vitória para " + jogador2.getNome());
              jogador2.aumentarPontuacao(1);
              }
               else {  System.out.println("Empate");
                    }
                } 
            }
        if (pontosJogador1 == 2) {
            System.out.println("Vitoria para o jogador 1");
            break;
        } else if(pontosJogador2 == 2) {
            System.out.println("Vitoria para o jogador 2");
            break;
        }

        
    }  

    this.baralho.iniciarBaralho();

        if (pontosJogador1 == pontosJogador2) {
          if (vencedorPrimeiraRodada == 1) {
              System.out.println("Empate na última rodada! Vitória para " + jogador1.getNome());
              jogador1.aumentarPontuacao(1);
          } else if (vencedorPrimeiraRodada == 2) {
             System.out.println("Empate na última rodada! Vitória para " + jogador2.getNome());
             jogador2.aumentarPontuacao(1);
         } 
      } else if (pontosJogador1 > pontosJogador2) {
         System.out.println(jogador1.getNome() + " venceu a mão!");
         jogador1.aumentarPontuacao(1);
     } else {
         System.out.println(jogador2.getNome() + " venceu a mão!");
         jogador2.aumentarPontuacao(1);
      }
    }
   }
}
//PEDIR TRUCO - IF(TRUCO = TRUE AUMENTAR PONTUAÇÃO PARA 3 -)  
    
