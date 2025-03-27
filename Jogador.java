import java.util.List;
import java.util.ArrayList;

public class Jogador {
    private final String nome;
    private final List<Carta> mao;
    private int pontuacao;

    public Jogador(String nome) {
        this.nome = nome;
        this.mao = new ArrayList<>();
        pontuacao = 0;
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

    public void aumentarPontuação(int pontos) { this.pontuacao += pontos; }



}