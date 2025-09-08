import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class CustosVariaveis {
    private LocalDate data;
    private String descricao;
    private BigDecimal valor;

    public CustosVariaveis(LocalDate data, String descricao, BigDecimal valor){
        this.data = data;
        this.descricao = descricao;
        this.valor = valor;
    }

    // Método utilitário para criar um CustosVariaveis via console
    public static CustosVariaveis criarViaScanner() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o dia do gasto: ");
        int dia = scanner.nextInt();
        System.out.println("Digite o mês do gasto: ");
        int mes = scanner.nextInt();
        System.out.println("Digite o ano do gasto: ");
        int ano = scanner.nextInt();
        scanner.nextLine(); // limpa o newline pendente

        LocalDate data = LocalDate.of(ano, mes, dia);

        System.out.println("Digite a descrição do gasto: ");
        String descricao = scanner.nextLine();

        System.out.println("Digite o valor do gasto (ex: 150.50): ");
        BigDecimal valor = scanner.nextBigDecimal();

        return new CustosVariaveis(data, descricao, valor);
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getData(){
        return data;
    }

    @Override
    public String toString() {
        return "[" + data + "] " + descricao + " - R$ " + valor;
    }
}
