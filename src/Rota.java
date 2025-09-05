public enum Rota {

    // Constantes do enum, cada uma já recebe o valor correspondente.
    AM(310),   // Rota da manhã, valor fixo 310
    AM2(220),  // Rota do meio-dia, valor fixo 220
    SD(220);   // Rota da tarde/noite, valor fixo 220

    // Atributo interno que vai guardar o valor da rota
    private final int valor;

    // Construtor do enum (é sempre privado, mesmo sem escrever "private")
    Rota(int valor) {
        this.valor = valor; // O valor passado (310, 220...) é guardado aqui
    }

    // Getter para acessar o valor de cada rota
    public int getValor() {
        return valor;
    }

}