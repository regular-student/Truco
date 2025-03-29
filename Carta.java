public class Carta {
    private String valor;
    private String naipe;
    private int forca;

    Carta (String valor, String naipe, int forca) {
        this.valor = valor;
        this.naipe = naipe;
        this.forca = forca;
    }

    public String getValor() {
        return valor;
    }
    
    public String getNaipe() {
        return naipe;
    }

    public int getForca() {
        return forca;
    }


    public void setForca() {
        switch (naipe) {
            case "Ouros":
                this.forca = 11;
                break;
            case "Espadas":
                this.forca = 12;
                break;
            case "Copas":
                this.forca = 13;
                break;
            case "paus":
                this.forca = 14;
                break;
            default:
                break;
        }
    }
}
