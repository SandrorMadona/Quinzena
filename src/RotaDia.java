import java.time.LocalDate;

public class RotaDia {

    private LocalDate data;  // guarda a data do trabalho
    private Rota rota;       // guarda a rota feita no dia (AM, AM2 ou SD)

    // Construtor: obriga a informar data e rota ao criar um RotaDia
    public RotaDia(LocalDate data, Rota rota) {
        this.data = data;
        this.rota = rota;
    }

    // Getters para acessar os atributos
    public LocalDate getData() {
        return data;
    }

    public Rota getRota() {
        return rota;
    }
}
