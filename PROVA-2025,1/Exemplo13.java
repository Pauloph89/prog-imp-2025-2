import java.util.Scanner;

public class Exemplo13{

    public static final Scanner ENTRADA = new Scanner(System.in);
    public static final int TAMANHO_MAXIMO = 10;

    public static int buscarPessoaPorNome(Pessoa[] v, int qtd, String nome) {
        for (int i = 0; i < qtd; i++) {
            if (v[i].nome.equalsIgnoreCase(nome)) {
                return i;
            }
        }
        return -1;
    }

    public static int cadastrarPessoa(Pessoa[] v, int qtd) {
        if (qtd >= v.length) {
            System.out.println("ERRO: O vetor de pessoas está cheio. Cadastro impossível.");
            return qtd;
        }

        Pessoa novaPessoa = new Pessoa();
        String nomeDigitado;
        int indiceEncontrado;

        do {
            System.out.print("\nNome da pessoa: ");
            nomeDigitado = ENTRADA.nextLine();
            indiceEncontrado = buscarPessoaPorNome(v, qtd, nomeDigitado);

            if (indiceEncontrado != -1) {
                System.out.println("Nome já cadastrado! Por favor, digite outro nome.");
            }
        } while (indiceEncontrado != -1);

        novaPessoa.nome = nomeDigitado;

        System.out.print("Idade: ");
        novaPessoa.idade = ENTRADA.nextInt();
        System.out.print("Peso (ex: 75,5): ");
        novaPessoa.peso = ENTRADA.nextDouble();
        System.out.print("Altura (ex: 1,75): ");
        novaPessoa.altura = ENTRADA.nextDouble();
        ENTRADA.nextLine();

        v[qtd] = novaPessoa;
        System.out.println("\nPessoa '" + novaPessoa.nome + "' cadastrada com sucesso!");

        return qtd + 1;
    }

    public static void main(String[] args) {
        Pessoa[] vetorPessoas = new Pessoa[TAMANHO_MAXIMO];
        int quantidadeAtual = 0;

        System.out.println("--- Início do Programa Estruturado ---");

        // Primeiro cadastro
        quantidadeAtual = cadastrarPessoa(vetorPessoas, quantidadeAtual);
        System.out.println("Tamanho atual do vetor: " + quantidadeAtual);

        // Segundo cadastro
        quantidadeAtual = cadastrarPessoa(vetorPessoas, quantidadeAtual);
        System.out.println("Tamanho atual do vetor: " + quantidadeAtual);

        // Terceiro cadastro (Teste de nome duplicado)
        quantidadeAtual = cadastrarPessoa(vetorPessoas, quantidadeAtual);
        System.out.println("Tamanho atual do vetor: " + quantidadeAtual);

        System.out.println("\n--- Exibindo Pessoas Cadastradas ---");
        for (int i = 0; i < quantidadeAtual; i++) {
            System.out.println("Nome: " + vetorPessoas[i].nome + ", Idade: " + vetorPessoas[i].idade + ", Peso: " + vetorPessoas[i].peso + ", Altura: " + vetorPessoas[i].altura);
        }
    }
}