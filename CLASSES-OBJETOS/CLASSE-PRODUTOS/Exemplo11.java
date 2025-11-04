import java.util.Scanner;

public class Exemplo11 {
    
    public static Scanner input = new Scanner(System.in); 

    public static void main (String[] args){

        System.out.println("--- INÍCIO DA COLETA ---");
        
        Produto produto1 = lerProduto("1");
        Produto produto2 = lerProduto("2");

        System.out.println("\n--- DADOS COLETADOS ---");

        imprimir (produto1);
        imprimir (produto2);

        input.close();
    }
    
    public static Produto lerProduto(String numeroProduto) {
        Produto p = new Produto();
        
        System.out.println("\n--- Produto " + numeroProduto + " ---");
        
        System.out.print("Digite o nome do produto " + numeroProduto + ": ");
        p.titulo = input.nextLine();
        
        System.out.print("Digite a descrição do produto " + numeroProduto + ": ");
        p.descricao = input.nextLine();
        
        System.out.print("Digite o preço unitário do produto " + numeroProduto + ": ");
        p.precoUnitario = input.nextDouble();
        
        System.out.print("Digite a qtd de estoque do produto " + numeroProduto + ": ");
        p.qtdEstoque = input.nextInt();
        
        input.nextLine(); 
        
        return p; 
    }
    
    public static void imprimir(Produto p) {
        System.out.printf("Dados: {Produto: %s, Descrição: %s, Preço: R$%.2f, Estoque: %d}%n",
        p.titulo, p.descricao, p.precoUnitario, p.qtdEstoque);
    }
}