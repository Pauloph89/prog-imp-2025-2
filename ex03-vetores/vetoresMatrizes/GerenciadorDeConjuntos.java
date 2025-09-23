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
            System.out.println("4) Gerar e Imprimir a união de A e B");
            System.out.println("5) Gerar e Imprimir a interseção entre A e B");
            System.out.println("6) Gerar e Imprimir a diferença entre A e B");
            System.out.println("7) Gerar e Imprimir a diferença entre B e A");
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
                    imprimir(conjuntoA, tamanhoA, "Conjunto A");
                    imprimir(conjuntoB, tamanhoB, "Conjunto B");
                    break;
                case 4:
                    int[] uniao = new int[conjuntoA.length + conjuntoB.length];
                    int tamanhoUniao = uniao(conjuntoA, tamanhoA, conjuntoB, tamanhoB, uniao);
                    imprimir(uniao, tamanhoUniao, "União de A e B");
                    break;
                case 5:
                    int[] intersecao = new int[conjuntoA.length];
                    int tamanhoIntersecao = intersecao(conjuntoA, tamanhoA, conjuntoB, tamanhoB, intersecao);
                    imprimir(intersecao, tamanhoIntersecao, "Interseção de A e B");
                    break;
                case 6:
                    int[] diferencaAB = new int[conjuntoA.length];
                    int tamanhoDiferencaAB = diferenca(conjuntoA, tamanhoA, conjuntoB, tamanhoB, diferencaAB);
                    imprimir(diferencaAB, tamanhoDiferencaAB, "Diferença de A e B");
                    break;
                case 7:
                    int[] diferencaBA = new int[conjuntoB.length];
                    int tamanhoDiferencaBA = diferenca(conjuntoB, tamanhoB, conjuntoA, tamanhoA, diferencaBA);
                    imprimir(diferencaBA, tamanhoDiferencaBA, "Diferença de B e A");
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

    public static void imprimir(int[] v, int tam, String nome) {
        System.out.print(nome + ": { ");
        for (int i = 0; i < tam; i++) {
            System.out.print(v[i] + " ");
        }
        System.out.println("}");
    }

    public static int uniao(int[] a, int tamA, int[] b, int tamB, int[] uniao) {
        int tamUniao = 0;

        for (int i = 0; i < tamA; i++) {
            uniao[tamUniao++] = a[i];
        }

        for (int i = 0; i < tamB; i++) {
            if (buscaSequencial(uniao, tamUniao, b[i]) == -1) {
                uniao[tamUniao++] = b[i];
            }
        }
        return tamUniao;
    }

    public static int intersecao(int[] a, int tamA, int[] b, int tamB, int[] intersecao) {
        int tamIntersecao = 0;
        for (int i = 0; i < tamA; i++) {
            if (buscaSequencial(b, tamB, a[i]) != -1) {
                intersecao[tamIntersecao++] = a[i];
            }
        }
        return tamIntersecao;
    }

    public static int diferenca(int[] a, int tamA, int[] b, int tamB, int[] diferenca) {
        int tamDiferenca = 0;
        for (int i = 0; i < tamA; i++) {
            if (buscaSequencial(b, tamB, a[i]) == -1) {
                diferenca[tamDiferenca++] = a[i];
            }
        }
        return tamDiferenca;
    }
}