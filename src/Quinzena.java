import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quinzena {

    // Lista que guarda todas as rotas da quinzena
    private List<RotaDia> rotasQuinzena = new ArrayList<>();

    // Metodo para adicionar uma rota com interação via console
    public void addRota() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o dia da rota: ");
        int dia = scanner.nextInt();
        System.out.println("Digite o mes da rota: ");
        int mes = scanner.nextInt();
        System.out.println("Digite o ano da rota: ");
        int ano = scanner.nextInt();

        System.out.println("Digite o numero conforme a rota: AM = 1 \n AM2 = 2 \n SD = 3");
        int rotaHorario = scanner.nextInt();

        // Cria a data apenas uma vez
        LocalDate data = LocalDate.of(ano, mes, dia);

        // Escolhe a rota de acordo com o número
        Rota rotaEscolhida = null;
        if (rotaHorario == 1) {
            rotaEscolhida = Rota.AM;
        } else if (rotaHorario == 2) {
            rotaEscolhida = Rota.AM2;
        } else if (rotaHorario == 3) {
            rotaEscolhida = Rota.SD;
        } else {
            System.out.println("Numero de rota invalido!");
            return; // sai do metodo se for inválido
        }

        // Cria o RotaDia e adiciona na lista
        RotaDia novaRota = new RotaDia(data, rotaEscolhida);
        rotasQuinzena.add(novaRota);

        System.out.println("Rota adicionada com sucesso!");
    }

    // Metodo para listar todas as rotas registradas na quinzena
    public void listarRotas() {
        System.out.println("Rotas registradas na quinzena:");
        for (RotaDia rd : rotasQuinzena) {
            System.out.println("Data: " + rd.getData() + " - Rota: " + rd.getRota() + " - Valor: R$" + rd.getRota().getValor());
        }
    }

    public int calcularTotalQuinzena() {
        int total = 0; // inicializa a soma

        // percorre cada RotaDia na lista
        for (RotaDia rotaPercorrida : rotasQuinzena) {
            total += rotaPercorrida.getRota().getValor(); // pega o valor da rota e soma
        }

        return total; // retorna o total acumulado
    }

    // Getter para acessar a lista de rotas (caso precise fora da classe)
    public List<RotaDia> getRotasQuinzena() {
        return rotasQuinzena;
    }

}
