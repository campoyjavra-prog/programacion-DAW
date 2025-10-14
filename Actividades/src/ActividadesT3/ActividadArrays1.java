package ActividadesT3;

public class ActividadArrays1 {
    public static void main(String[] args) {

    //Practica recorrer matrices
    int[][] matriz={1,2,3,4,5},{1,2,3,4},{1,2,3},{1,2},{1};
    for (int i = 0; i < matriz.length; i++) {
        for (int j = 0; j < matriz[0].length; j++){
            System.out.print(matriz[i][j] + " ");
        }
    }

 }

}