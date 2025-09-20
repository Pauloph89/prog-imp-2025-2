import java.util.Scanner;

public class GerenciadorDeConjuntos {

    public static void main(String[] args) {
        int[] conjuntoA = new int[30];
        int[] conjuntoB = new int[30];
        
        int tamanhoA = 0;
        int tamanhoB = 0;
        
        int opcao;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\n--- Gerenciador de Conjuntos ---");
            System.out.println("1) Inserir 1 elemento no Conjunto A");
            System.out.println("2) Inserir 1 elemento no Conjunto B");
            System.out.println("3) Imprimir os Conjuntos A e B");
            System.out.println("0) Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    tamanhoA = inserirElemento(conjuntoA, tamanhoA, scanner);
                    break;
                case 2:
                    tamanhoB = inserirElemento(conjuntoB, tamanhoB, scanner);
                    break;
                case 3:
                    imprimirConjuntos(conjuntoA, tamanhoA, conjuntoB, tamanhoB);
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }


    public static int buscaSequencial(int[] vetor, int tamanho, int valor) {
        for (int i = 0; i < tamanho; i++) {
            if (vetor[i] == valor) {
                return i; 
            }
        }
        return -1; 
    }

    public static int inserirElemento(int[] vetor, int tamanho, Scanner scanner) {
        if (tamanho >= vetor.length) {
            System.out.println("O vetor está cheio. Não é possível adicionar mais elementos.");
            return tamanho;
        }

        System.out.print("Digite o elemento a ser inserido: ");
        int elemento = scanner.nextInt();

        if (buscaSequencial(vetor, tamanho, elemento) != -1) {
            System.out.println("O elemento " + elemento + " já existe no conjunto. Não é possível adicionar duplicatas.");
            return tamanho;
        }

        vetor[tamanho] = elemento;
        System.out.println("Elemento " + elemento + " inserido com sucesso.");
        return tamanho + 1;
    }

    public static void imprimirConjuntos(int[] a, int tamA, int[] b, int tamB) {
        System.out.print("Conjunto A: { ");
        for (int i = 0; i < tamA; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("}");

        System.out.print("Conjunto B: { ");
        for (int i = 0; i < tamB; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println("}");
    }
}