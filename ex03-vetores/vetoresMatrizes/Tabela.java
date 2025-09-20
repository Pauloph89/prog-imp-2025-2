public class Tabela {
    public static void imprimirTabelaFrequencia(int [] v, int tam){
        int qtd = 1
        for(int i = 1; i < tam; i+=1) {
            if (v[i]! = v [i-1]) {
                System.out.println(v[i-1] + "|" + qtd);
                qtd = 1;

            }else {
                qtd +=1;
            }
        }
        System.out.println(v[tam -1] + "|" + qtd);
    }

}