import java.math.BigDecimal;
import java.util.Scanner;

public class CustosFixos {
    private BigDecimal financiamento;
    private BigDecimal trocaDeOleo;

    public void adicionarValor(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("digite o valor do financiamento: ");
        this.financiamento = scanner.nextBigDecimal();
        System.out.println("digite o valor da Troca de Oleo: ");
        this.trocaDeOleo = scanner.nextBigDecimal();
    }

    public BigDecimal calcularCustoFixo(){
        return financiamento.add(trocaDeOleo);
    }

    public BigDecimal getFinanciamento(){
        return financiamento;
    }

    public BigDecimal getTrocaDeOleo() {
        return trocaDeOleo;
    }
}
