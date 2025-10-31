import java.util.Scanner;

public class Exemplo1 {
    
    public static Scanner input = new Scanner(System.in); 

    public static void main (String[] args){
        
        Aluno aluno = coletarDadosAluno();
        
        imprimir (aluno);
        
        double media = calcularMedia(aluno);
        
        System.out.println("\n A média ponderada do aluno é " + media);
        
        input.close();
    }
    
    public static Aluno coletarDadosAluno() {
        Aluno al = new Aluno();
        
        System.out.println("--- Coleta de Dados do Aluno ---");
        
        System.out.println("Digite seu nome: ");
        al.nome = input.nextLine();
        
        System.out.println("Digite sua idade: ");
        al.idade = input.nextInt();
        input.nextLine(); // Limpeza do buffer
        
        System.out.println("Digite a 1ª nota: ");
        al.nota1 = input.nextDouble();
        
        System.out.println("Digite a 2ª nota: ");
        al.nota2 = input.nextDouble();
        
        System.out.println("---------------------------------");
        
        return al; 
    }
    
    public static void imprimir (Aluno al){
        System.out.printf("Dados do Aluno: (%s, %d anos, Nota 1: %.2f, Nota 2: %.2f)\n", 
                          al.nome, al.idade, al.nota1, al.nota2);
    }
    
    public static double calcularMedia (Aluno al){
        return (al.nota1 * 2 + al.nota2 * 3) / 5;
    }
}