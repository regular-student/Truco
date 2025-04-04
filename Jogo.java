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
            for (int j = 0; j < 3; j++) {
                Carta carta = baralho.darCarta();
                if (carta != null) {
                    jogador.receberCarta(carta);
                    System.out.println("cARTAS RECEBIDAS");
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
        System.out.println("RODADA INICIADA");
        Scanner scanner = new Scanner(System.in);

        for(int i = 0; i < 3; i++) { 
            for (Carta carta1 : jogador1.getMao()) {
                System.out.println(carta1.getValor() + " de " + carta1.getNaipe() + " forca" + carta1.getForca());
            }

        System.out.println(jogador1.getNome() + ", escolha sua carta (1, 2 ou 3): ");
        int escolha1 = scanner.nextInt();

        Carta carta1 = jogador1.jogarCarta(escolha1 - 1);

        for (Carta carta2 : jogador2.getMao()) {
            System.out.println(carta2.getValor() + " de " + carta2.getNaipe() + "forca" + carta2.getForca());
        }
        System.out.println(jogador2.getNome() + ", escolha sua carta (1, 2 ou 3): ");
        int escolha2 = scanner.nextInt();
        Carta carta2 = jogador2.jogarCarta(escolha2 - 1);
            
         
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
        } else{
            if(i == 1) {
                System.out.println("Empate");
                
            } else {
                pontosJogador1 ++;
                pontosJogador2 ++;
                System.out.println("Empate");

            }
            
        }
        if (pontosJogador1 == 2 || pontosJogador2 == 2) {
            break;
        }

        baralho.gerarManilha();
        jogador1.receberCarta(baralho.darCarta());
        jogador2.receberCarta(baralho.darCarta());
    }  
    
        if (pontosJogador1 == pontosJogador2) {
          if (vencedorPrimeiraRodada == 1) {
              System.out.println("Empate na última rodada! Vitória para " + jogador1.getNome());
              jogador1.aumentarPontuacao(pontosJogador1);
          } else if (vencedorPrimeiraRodada == 2) {
             System.out.println("Empate na última rodada! Vitória para " + jogador2.getNome());
             jogador2.aumentarPontuacao(pontosJogador2);
         } 
      } else if (pontosJogador1 > pontosJogador2) {
         System.out.println(jogador1.getNome() + " venceu a mão!");
     } else {
         System.out.println(jogador2.getNome() + " venceu a mão!");
      }
}
    
    }
