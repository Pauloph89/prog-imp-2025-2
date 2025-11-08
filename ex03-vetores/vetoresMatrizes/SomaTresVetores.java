
import java.util.Scanner;

public class SomaTresVetores {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int tamanho = 5;
        int[] vetor1 = new int[tamanho];
        int[] vetor2 = new int[tamanho];
        int[] vetor3 = new int[tamanho];
        int[] soma = new int[tamanho];

        // Preencher vetor 1
        System.out.println("Digite os valores do primeiro vetor:");
        for (int i = 0; i < tamanho; i++) {
            System.out.print("Posição [" + i + "]: ");
            vetor1[i] = input.nextInt();
        }

        // Preencher vetor 2
        System.out.println("\nDigite os valores do segundo vetor:");
        for (int i = 0; i < tamanho; i++) {
            System.out.print("Posição [" + i + "]: ");
            vetor2[i] = input.nextInt();
        }

        // Preencher vetor 3
        System.out.println("\nDigite os valores do terceiro vetor:");
        for (int i = 0; i < tamanho; i++) {
            System.out.print("Posição [" + i + "]: ");
            vetor3[i] = input.nextInt();
        }

        // Somar os 3 vetores
        for (int i = 0; i < tamanho; i++) {
            soma[i] = vetor1[i] + vetor2[i] + vetor3[i];
        }

        // Mostrar resultado
        System.out.println("\nResultado da soma dos 3 vetores:");
        for (int i = 0; i < tamanho; i++) {
            System.out.println("Posição [" + i + "] = " + soma[i]);
        }

        input.close();
    }
}
