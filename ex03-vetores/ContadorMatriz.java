import java.util.Scanner;

public class ContadorMatriz {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        int[][] matriz = new int[4][4];
        
        int contadorMaiores10 = 0;
        
        System.out.println("--- Preenchendo a Matriz 4x4 ---");

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                
                System.out.printf("Digite o valor para a posição [%d][%d]: ", i, j);
                
                matriz[i][j] = input.nextInt();
                
                ,
                if (matriz[i][j] > 10) {
                    contadorMaiores10++; 
                }
            }
        }
        
        
        System.out.println("\n--- Matriz Digitada ---");
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matriz[i][j] + "\t"); 
            }
            System.out.println();
        }
        
        System.out.println("\n-------------------------------------");
        System.out.println("A matriz possui " + contadorMaiores10 + " valores maiores que 10.");
        System.out.println("-------------------------------------");

        input.close();
    }
}