import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class Baralho {
    private final List<Carta> cartas;

    private String[] naipes = {"Ouros", "Copas", "Espadas", "Paus"};
    private String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

    public Baralho() {
        cartas = new ArrayList<>();
        for (String naipe : naipes) {
            for (String valor : valores) {
                cartas.add(new Carta(valor, naipe));
            }
        }
    }

    public void embaralhar() {
        Collections.shuffle(cartas);
    }
    
    public Carta darCarta() {
        if (cartas.isEmpty()) {
            return null;
        }
        return cartas.remove(0);
    }
}