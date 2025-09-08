import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Quinzena {

    private List<RotaDia> rotasQuinzena = new ArrayList<>();
    private List<CustosVariaveis> custosVariaveis = new ArrayList<>();
    private CustosFixos custosFixos; // apenas um conjunto de custos fixos

    // --- Rotas ---
    public void addRota() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.println("Digite o dia da rota: ");
        int dia = scanner.nextInt();
        System.out.println("Digite o mes da rota: ");
        int mes = scanner.nextInt();
        System.out.println("Digite o ano da rota: ");
        int ano = scanner.nextInt();

        System.out.println("Digite o numero conforme a rota: AM = 1 \n AM2 = 2 \n SD = 3");
        int rotaHorario = scanner.nextInt();

        LocalDate data = LocalDate.of(ano, mes, dia);

        Rota rotaEscolhida = null;
        if (rotaHorario == 1) {
            rotaEscolhida = Rota.AM;
        } else if (rotaHorario == 2) {
            rotaEscolhida = Rota.AM2;
        } else if (rotaHorario == 3) {
            rotaEscolhida = Rota.SD;
        } else {
            System.out.println("Numero de rota invalido!");
            return;
        }

        RotaDia novaRota = new RotaDia(data, rotaEscolhida);
        rotasQuinzena.add(novaRota);

        System.out.println("Rota adicionada com sucesso!");
    }

    public void listarRotas() {
        System.out.println("Rotas registradas:");
        for (RotaDia rd : rotasQuinzena) {
            System.out.println("Data: " + rd.getData() + " - Rota: " + rd.getRota() + " - Valor: R$" + rd.getRota().getValor());
        }
    }

    public BigDecimal calcularTotalQuinzena() {
        BigDecimal total = BigDecimal.ZERO;
        for (RotaDia rotaPercorrida : rotasQuinzena) {
            total = total.add(BigDecimal.valueOf(rotaPercorrida.getRota().getValor()));
        }
        return total;
    }

    // --- Custos variáveis ---
    public void addCustoVariavel() {
        CustosVariaveis cv = CustosVariaveis.criarViaScanner();
        custosVariaveis.add(cv);
        System.out.println("Gasto adicionado: " + cv);
    }

    public BigDecimal calcularTotalCustosVariaveis() {
        BigDecimal total = BigDecimal.ZERO;
        for (CustosVariaveis cv : custosVariaveis) {
            total = total.add(cv.getValor());
        }
        return total;
    }

    // --- Custos fixos ---
    public void addCustosFixos() {
        custosFixos = new CustosFixos();
        custosFixos.adicionarValor();
    }

    public BigDecimal calcularCustosFixos() {
        if (custosFixos == null) {
            return BigDecimal.ZERO;
        }
        return custosFixos.calcularCustoFixo();
    }

    // --- Lucro final ---
    public BigDecimal calcularLucro() {
        return calcularTotalQuinzena()
                .subtract(calcularTotalCustosVariaveis())
                .subtract(calcularCustosFixos());
    }
}
