public class Exemplo02 {

    public static void main(String[] args) {
        System.out.println("Imprima  1 - 100!");
        for(int i=1; i<=100 ;i++){
            System.out.print(i + ", ");
        }
        System.out.println("\n Agora ímpares");
        for(int i=1; i<=100; i+=2){
            System.out.print(i + ", ");
        }
            System.out.println("\n Agora pares");

        for(int i=2; i<=100; i+=2){
            System.out.print(i + ", ");
        }
            System.out.println("\n Agora múltiplos de 3");

        for(int i=3; i<=100; i+=3){
            System.out.print(i + ", ");
        }
            System.out.println("\n Agora múltiplos de 3 ou terminados em 3");

        for(int i=1; i<100; i++){
            if (i%3==0 || i%10==0)  {
                System.out.print(i + ", ");
            }
        }
    }
}