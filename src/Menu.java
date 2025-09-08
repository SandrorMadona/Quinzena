import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public void inicializarMenu() {
        Quinzena quinzenaatual = new Quinzena();
        int sair = 0;
        Scanner scanner = new Scanner(System.in);

        while (sair == 0) {
            System.out.println("--------------------------------------------------------------\n" +
                    "O que deseja fazer:\n" +
                    "1 - Adicionar rota\n" +
                    "2 - Listar rotas\n" +
                    "3 - Valor total quinzena\n" +
                    "4 - Adicionar custo variável\n" +
                    "5 - Valor total custos variáveis\n" +
                    "6 - Adicionar custos fixos\n" +
                    "7 - Valor total custos fixos\n" +
                    "8 - Calcular lucro da quinzena\n" +
                    "9 - Sair");

            try {
                int escolha = scanner.nextInt();

                switch (escolha) {
                    case 1 -> quinzenaatual.addRota();
                    case 2 -> quinzenaatual.listarRotas();
                    case 3 -> {
                        BigDecimal total = quinzenaatual.calcularTotalQuinzena();
                        System.out.println("Total da Quinzena: R$ " + total);
                    }
                    case 4 -> quinzenaatual.addCustoVariavel();
                    case 5 -> {
                        BigDecimal totalVar = quinzenaatual.calcularTotalCustosVariaveis();
                        System.out.println("Total custos variáveis: R$ " + totalVar);
                    }
                    case 6 -> quinzenaatual.addCustosFixos();
                    case 7 -> {
                        BigDecimal totalFixos = quinzenaatual.calcularCustosFixos();
                        System.out.println("Total custos fixos: R$ " + totalFixos);
                    }
                    case 8 -> {
                        BigDecimal lucro = quinzenaatual.calcularLucro();
                        System.out.println("Lucro da quinzena: R$ " + lucro);
                    }
                    case 9 -> {
                        System.out.println("Programa Encerrado");
                        scanner.close();
                        sair = 1;
                    }
                    default -> System.out.println("Digite um número válido do Menu");
                }

            } catch (InputMismatchException e) {
                scanner.nextLine(); // limpa entrada inválida
                System.out.println("Digite apenas os números escolhidos");
            }
        }
    }
}
