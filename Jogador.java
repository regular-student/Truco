import java.util.List;
import java.util.ArrayList;

public class Jogador {
    private final String nome;
    private final List<Carta> mao;
    private int pontuacao;

    public Jogador(String nome) {
        this.nome = nome;
        this.mao = new ArrayList<>();
        this.pontuacao = 0;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void receberCarta(Carta carta) {
        mao.add(carta);
    }

    public List<Carta> getMao() {
        return mao;
    }

    public String getNome() {
        return nome;
    }

    public void aumentarPontuacao(int pontos) { this.pontuacao += pontos; }

    public Carta jogarCarta(int indice) {
        if (indice < 0 || indice >= mao.size()) {
            System.out.println("Índice inválido! Escolha uma carta válida.");
            return null; 
        }
        Carta cartaEscolhida = mao.get(indice);
        mao.remove(indice);
        return cartaEscolhida;
    }



    
}