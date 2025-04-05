import java.net.CacheRequest;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class Baralho {
    private final List<Carta> cartas;

    public Baralho() {
        cartas = new ArrayList<>();
        iniciarBaralho();
        
        
    }

    public void iniciarBaralho() {
        this.cartas.clear();
        int f = 1;
        int aux = 0;
        String[] naipes = {"Ouros", "Copas", "Espadas", "Paus"};
        String[] valores = {"4", "5", "6", "7", "Q", "J", "K", "A", "2", "3"};
        for (String valor : valores) {    
            for (String naipe : naipes)  {
                cartas.add(new Carta(valor, naipe, f));

                aux++;
                if(aux == 4) {
                    f++;
                    aux = 0;
                }
            }
        }
        Collections.shuffle(this.cartas);

    }

    public void mostrarBaralho() {
        for (Carta c : cartas) {
            System.out.println(c);
        }
    }

    public void gerarManilha() {
        Carta c = this.cartas.get(0);

        for (Carta carta : this.cartas) {
            if (carta.getForca() != 10) {
                if (carta.getForca() + 1 == carta.getForca()) {
                    carta.setForca();
                }
            } else {
                if (1 == carta.getForca()) {
                    carta.setForca();
                }
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