public class Carta {
    private String valor;
    private String naipe;

    Carta (String valor, String naipe) {
        this.valor = valor;
        this.naipe = naipe;
    }

    public String getValor() {
        return valor;
    }
    
    public String getNaipe() {
        return naipe;
    }
}
