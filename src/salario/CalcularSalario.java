package salario;

import java.util.Scanner;

public class CalcularSalario {

    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        //----------------- Entrada de Dados -----------------
        System.out.print("Salário bruto: ");
        float salarioBruto = leitura.nextFloat();
        
        System.out.print("Valor do adiantamento: ");
        float adiantamento = leitura.nextFloat();
        
        System.out.print("Carga horária diária: ");
        int horasDiarias = leitura.nextInt();
        
        System.out.print("Quantidade de dias úteis: ");
        int diasUteis = leitura.nextInt();

        System.out.print("Quantidade de dias trabalhados: ");
        int diasTrabalhados = leitura.nextInt();
        
        float valorHora = salarioBruto / diasUteis / horasDiarias;

        float salarioLiquido = valorHora * horasDiarias * diasTrabalhados;

        float inss = salarioBruto * 0.11f;
        float salarioDesc = salarioBruto - inss;
        
        float fgts = .08f;
        float calcfgts = salarioBruto * fgts;
        
        System.out.println("\n----------------------------------------");
        System.out.printf("\nAdiantamento: R$ %.2f \n", adiantamento);
        System.out.printf("FGTS: R$ %.2f \n\n", calcfgts);
        System.out.println("----------------------------------------");
        
        leitura.nextLine();
        
        //----------------- Cálculos -----------------
        System.out.print("\nSerá descontado INSS? (S / N): ");
        String resposta = leitura.nextLine().toLowerCase();
        
        if (resposta.equals("s")) {
            System.out.print("\nFoi realizado adiantamento? (S / N): ");
            String resposta1 = leitura.nextLine().toLowerCase();
            if (resposta1.equals("s")) {
                System.out.println("\n----------------------------------------");
                System.out.printf("\nSalário com desconto de INSS e adiantamento: R$ %.2f \n\n", (salarioDesc - adiantamento));
                System.out.println("----------------------------------------");
            } else {
                System.out.println("\n----------------------------------------");
                System.out.printf("\nSalário com desconto de INSS sem adiantamento: R$ %.2f \n\n", salarioDesc);
                System.out.println("----------------------------------------");
            }

        } else if (resposta.equals("n")) {
            System.out.print("\nFoi realizado adiantamento? (S / N): ");
            String resposta1 = leitura.nextLine().toLowerCase();
            if (resposta1.equals("s")) {
                System.out.println("\n----------------------------------------");
                System.out.printf("\nSalário com desconto de adiantamento: R$ %.2f \n\n", (salarioLiquido - adiantamento));
                System.out.println("----------------------------------------");
            } else {
                System.out.println("\n----------------------------------------");
                System.out.printf("\nSalário sem desconto de adiantamento e INSS: R$ %.2f \n\n", salarioLiquido);
                System.out.println("----------------------------------------");
            }
            
        } else {
            System.out.println("\nOpção inválida.");
        }
    }
}