import java.util.Scanner;

public class VetorSemRepeticao {

    public static void preencherVetorDigitacaoSemRepeticao(int[] v) {
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < v.length; i++) {
            int numero;
            boolean repetido;

            do {
                System.out.print("Digite o " + (i + 1) + "º número: ");
                numero = input.nextInt();

                int posicao = buscaSequencial(v, i, numero);
                repetido = (posicao != -1);

                if (repetido) {
                    System.out.println("Valor já existe no vetor! Digite outro número.");
                }
            } while (repetido);

            v[i] = numero;
        }
    }

    public static int buscaSequencial(int[] v, int tam, int x) {
        for (int i = 0; i < tam; i++) {
            if (v[i] == x) {
                return i; 
            }
        }
        return -1; 
    }

    public static void main(String[] args) {
        int[] vetor = new int[10];

        preencherVetorDigitacaoSemRepeticao(vetor);

        System.out.println("\nVetor preenchido sem repetição:");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
    }
}