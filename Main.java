import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Baralho baralho = new Baralho();

        baralho.embaralhar();
        Scanner leitor = new Scanner(System.in);
        String nome = leitor.nextLine();

        Jogador jogador = new Jogador(nome);

        for (int i = 0; i < 3; i++) {
            Carta carta = baralho.darCarta();
            if (carta != null) {
                jogador.receberCarta(carta);
            }
        }

        for (Carta c : jogador.getMao()) {
            System.out.println(c.getValor() + " de " + c.getNaipe());
        }

        System.out.println("Essas são suas cartas " + jogador.getNome());

        leitor.close();
    }
}