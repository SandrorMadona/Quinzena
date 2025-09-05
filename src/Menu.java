import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    // Cria um RotaDia dizendo que no dia 3 de setembro de 2025 você fez a rota AM
    public void inicializarMenu(){
    Quinzena quinzenaatual = new Quinzena();
    int sair = 0;
    Scanner scanner = new Scanner(System.in);

        while (sair == 0) {
            System.out.println("--------------------------------------------------------------\n" +
                    "O que deseja fazer:\n" +
                    "Adicionar rota: 1\n" +
                    "Listar rotas: 2\n" +
                    "Valor total quinzena: 3\n" +
                    "sair = 4");
            try {
                int escolha = scanner.nextInt();
                if (escolha == 1) {
                    quinzenaatual.addRota();
                } else if (escolha == 2) {
                    quinzenaatual.listarRotas();
                } else if (escolha == 3) {
                    int total = quinzenaatual.calcularTotalQuinzena();
                    System.out.println("total da Quinzena: " + total);
                } else if (escolha == 4) {
                    System.out.println("Programa Encerrado");
                    scanner.close();
                    sair = 1;
                }else{
                    System.out.println("Digite um numero do Menu"); //aqui nao preciso colocar o scanner.nextLine(); porque nao vai gerar erro vai apenas continuar no loop entao posso apenas informar ao usuario o erro dele
                }
            }catch(InputMismatchException e){
                scanner.nextLine(); // para limpar o scanner e nao gerar recursao, pois chamar o Menu(); toda vez que errar pode gerar stackOverFlow0
                System.out.println("Digite apenas os numeros escolhidos");
            }
        }
    }
}
