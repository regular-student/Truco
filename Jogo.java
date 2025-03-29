import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jogo{
    private float rodada;
    private final List<Jogador> jogadores;


 Jogo (float rodada) {
    this.rodada = rodada;
    this.jogadores = new ArrayList<>();
 }
    

    public void cadJogadores() {
        Scanner leitor = new Scanner(System.in);
        System.out.print("Digite o número de jogadores: ");
        int numeroDeJogadores = leitor.nextInt();

        Baralho baralho = new Baralho();
        baralho.embaralhar();

        for(int i = 0; i < numeroDeJogadores; i++) {
            System.out.print("Digite o nome do Jogador " + (i + 1) + ": ");
            String nome = leitor.next();
            Jogador jogador = new Jogador(nome);
            jogadores.add(jogador);
            for (int j = 0; j < 3; j++) {
                Carta carta = baralho.darCarta();
                if (carta != null) {
                    jogador.receberCarta(carta);
                }
            }
        }
        leitor.close();
        

    }
    

    public void rodada(Carta carta1, Carta carta2) {
        if(carta1.getForca() > carta2.getForca()) {
            System.out.println("Jogador 1 ganhou a rodada");
            
        } else if(carta1.getForca() < carta2.getForca()) {
            System.out.println("Jogador 2 ganhou a rodada");
        } else{
            System.out.print("Empate");
        }
    }
}

