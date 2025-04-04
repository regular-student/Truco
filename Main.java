import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Jogo j1 = new Jogo(1);
        j1.cadJogadores();
        j1.rodada();


//        Scanner leitor = new Scanner(System.in);
//        leitor.close();
//        Scanner scanner = new Scanner(System.in);
//        scanner.close();


     /*   Baralho baralho = new Baralho();

        baralho.embaralhar();
        Scanner leitor = new Scanner(System.in);
        String nome = leitor.nextLine();
        String nome1 = leitor.nextLine();

        Jogador jogador = new Jogador(nome);
        Jogador jogador1 = new Jogador(nome1);

        for (int i = 0; i < 3; i++) {
            Carta carta = baralho.darCarta();
            if (carta != null) {
                jogador.receberCarta(carta);
            }
        }
        for (int i = 0; i < 3; i++) {
            Carta carta = baralho.darCarta();
            if (carta != null) {
                jogador1.receberCarta(carta);
            }
        }
        System.out.println("Essas são suas cartas " + jogador.getNome());
        for (Carta c : jogador.getMao()) {
            System.out.println(c.getValor() + " de " + c.getNaipe() + "forca" + c.getForca());
        }
        System.out.println("Essas são suas cartas " + jogador1.getNome());
        for (Carta c :  jogador1.getMao()) { 
        System.out.println(c.getValor() + " de " + c.getNaipe() + "forca" + c.getForca());
        }

        
        
        leitor.close();*/
    }
}
