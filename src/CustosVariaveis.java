import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustosVariaveis {
    private LocalDate data;
    private String descricao;
    private BigDecimal valor;

    private List<CustosVariaveis> custosVariaveisList = new ArrayList<>();

    public CustosVariaveis(LocalDate data, String descricao, BigDecimal valor){
        this.data = data;
        this.descricao = descricao;
        this.valor = valor;
    }

    public void addCustoVariavel(List<CustosVariaveis> listaCustos) {
        Scanner scanner = new Scanner(System.in);

        // Captura da data
        System.out.println("Digite o dia do gasto: ");
        int dia = scanner.nextInt();
        System.out.println("Digite o mês do gasto: ");
        int mes = scanner.nextInt();
        System.out.println("Digite o ano do gasto: ");
        int ano = scanner.nextInt();
        scanner.nextLine(); // limpa o buffer do scanner

        LocalDate data = LocalDate.of(ano, mes, dia);

        // Captura da descrição
        System.out.println("Nomeie o gasto: ");
        String descricao = scanner.nextLine();

        // Captura do valor
        System.out.println("Digite o valor do gasto: ");
        BigDecimal valor = scanner.nextBigDecimal();

        // Cria o objeto CustosVariaveis
        CustosVariaveis cv = new CustosVariaveis(data, descricao, valor);

        // Adiciona na lista passada como parâmetro
        listaCustos.add(cv);

        System.out.println("Gasto adicionado: " + descricao + " | Valor: " + valor + " | Data: " + data);
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
}
