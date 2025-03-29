import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class Baralho {
    private final List<Carta> cartas;

    public Baralho() {
        cartas = new ArrayList<>();
        int f = 1;
        int aux = 0;
        String[] naipes = {"Ouros", "Copas", "Espadas", "Paus"};
        String[] valores = {"4", "5", "6", "7", "Q", "J", "K", "A", "2", "3"};
        for (String valor : valores) {    
            for (String naipe : naipes)  {
                if(aux > 3) {
                    f++;
                    aux = 0;
                }
    

                cartas.add(new Carta(valor, naipe, f));
                aux++;
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