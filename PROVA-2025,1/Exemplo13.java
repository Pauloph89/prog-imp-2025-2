import java.util.Scanner;
import java.util.Locale;

public class Exemplo13 {

    public static final Scanner ENTRADA = new Scanner(System.in).useLocale(Locale.US);
    public static final int TAMANHO_MAXIMO = 10;

    public static int buscarPessoaPorNome(Pessoa[] v, int qtd, String nome) {
        for (int i = 0; i < qtd; i++) {
            if (v[i].nome.equalsIgnoreCase(nome)) {
                return i;
            }
        }
        return -1;
    }

    public static double calcularIMC(double peso, double altura) {
        if (altura > 0) {
            return peso / (altura * altura);
        }
        return 0.0;
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
        System.out.print("Peso (ex: 75.5): ");
        novaPessoa.peso = ENTRADA.nextDouble();
        System.out.print("Altura (ex: 1.75): ");
        novaPessoa.altura = ENTRADA.nextDouble();
        ENTRADA.nextLine();

        v[qtd] = novaPessoa;
        System.out.println("\nPessoa '" + novaPessoa.nome + "' cadastrada com sucesso!");

        return qtd + 1;
    }
    
    public static void imprimirPessoas(Pessoa[] v, int qtd) {
        if (qtd == 0) {
            System.out.println("\nNão há pessoas cadastradas para imprimir.");
            return;
        }
        
        System.out.println("\n--- LISTA DE PESSOAS CADASTRADAS ---");
        for (int i = 0; i < qtd; i++) {
            double imc = calcularIMC(v[i].peso, v[i].altura);
            
            System.out.printf("Pessoa %d: Nome: %s, Idade: %d, Peso: %.2f kg, Altura: %.2f m, IMC: %.2f\n", 
                (i + 1), v[i].nome, v[i].idade, v[i].peso, v[i].altura, imc);
        }
        System.out.println("------------------------------------");
    }

    public static int maisVelhaIMCMagreza(Pessoa[] v, int qtd) {
        int indiceMaisVelha = -1;
        int maiorIdade = -1;

        for (int i = 0; i < qtd; i++) {
            double imc = calcularIMC(v[i].peso, v[i].altura);
            
            if (imc < 18.5) {
                if (v[i].idade > maiorIdade) {
                    maiorIdade = v[i].idade;
                    indiceMaisVelha = i;
                }
            }
        }
        
        return indiceMaisVelha;
    }

    public static void insertionSortPorNome(Pessoa[] v, int qtd) {
        for (int i = 1; i < qtd; i++) {
            Pessoa chave = v[i];
            int j = i - 1;
            
            while (j >= 0 && v[j].nome.compareTo(chave.nome) > 0) {
                v[j + 1] = v[j];
                j = j - 1;
            }
            v[j + 1] = chave;
        }
        System.out.println("\n--- Ordenação Insertion Sort por Nome Concluída ---");
    }

    public static void verificarIdososAcimaDoPeso(Pessoa[] v, int qtd, double limiteIMC) {
        System.out.printf("\n--- Idosos (>= 60) com IMC acima de %.2f ---\n", limiteIMC);
        int contador = 0;
        
        for (int i = 0; i < qtd; i++) {
            double imc = calcularIMC(v[i].peso, v[i].altura);
            
            if (v[i].idade >= 60 && imc > limiteIMC) {
                System.out.printf("Nome: %s, Idade: %d, IMC: %.2f\n", v[i].nome, v[i].idade, imc);
                contador++;
            }
        }
        
        if (contador == 0) {
            System.out.println("Nenhuma pessoa idosa acima do limite de IMC encontrado.");
        }
        System.out.println("-------------------------------------------------");
    }
    
    public static void main(String[] args) {
        Pessoa[] vetorPessoas = new Pessoa[TAMANHO_MAXIMO];
        int quantidadeAtual = 0;

        System.out.println("--- Teste de Execução das 5 Questões ---");

        quantidadeAtual = cadastrarPessoa(vetorPessoas, quantidadeAtual);
        quantidadeAtual = cadastrarPessoa(vetorPessoas, quantidadeAtual);
        quantidadeAtual = cadastrarPessoa(vetorPessoas, quantidadeAtual);

        imprimirPessoas(vetorPessoas, quantidadeAtual);
        
        int indiceMagreza = maisVelhaIMCMagreza(vetorPessoas, quantidadeAtual);
        if (indiceMagreza != -1) {
            System.out.println("\nMais velha com Magreza: " + vetorPessoas[indiceMagreza].nome);
        } else {
            System.out.println("\nNenhuma pessoa com IMC Magreza encontrada.");
        }

        insertionSortPorNome(vetorPessoas, quantidadeAtual);
        imprimirPessoas(vetorPessoas, quantidadeAtual); 

        verificarIdososAcimaDoPeso(vetorPessoas, quantidadeAtual, 25.0);

        System.out.println("\nFim do Programa.");
    }
}