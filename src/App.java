import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int QtddePrestações = 0;
        double ValorTotalDia = 0;
        Scanner entrada = new Scanner(System.in);
        while (true) {
            System.out.print("Digite o valor da prestação:");
            double ValorDaPrestacao = entrada.nextDouble();
            if (ValorDaPrestacao == 0) {
                break;
            }
            System.out.print("Quantos dias está atrasada a sua orestação ?: ");
            int diasAtrasados = entrada.nextInt();

            double valorTotal = ValorApagar(ValorDaPrestacao, diasAtrasados);

            System.out.println("O valor a ser pago será de R$ " + String.format("%.2f", valorTotal));
            System.out.println("");

            QtddePrestações++;
            ValorTotalDia += valorTotal;
        }

        System.out.println("Relatorio Diário");
        System.out.println("Quantidade de prestações: " + QtddePrestações);
        System.out.println("Valor total de prestações: R$ " + String.format("%.2f", ValorTotalDia));
        System.out.println("");

    }

    public static double ValorApagar(double valorPrestacao, double diasAtrasados) {
        double valorAPagar = 0;
        if (diasAtrasados > 0) {
            double percentual = 0.03;
            double juros = 0.001;
            double valorMulta = valorPrestacao + (valorPrestacao * percentual);
            valorAPagar = valorMulta + (valorMulta * juros * diasAtrasados);
        } else {
            return valorPrestacao;
        }
        return valorAPagar;

    }

}
