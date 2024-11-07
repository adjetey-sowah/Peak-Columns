public class App {
    public static void main(String[] args) throws Exception {
        
        int[][] matrixA = {
            {3,5,6,7,7},
            {4,2,2,8,9},
            {6,3,2,9,7}
        };


        int index = 0;
        int rows = matrixA.length;
        int max = 0;
        int columsPosition = -1;
        int row = -1;
        boolean flag = false;

        while (index < rows){
            for (int i = 1; i < matrixA[0].length; i++){
                if (matrixA[index][i] > matrixA[index][i-1]){
                    max = matrixA[index][i];
                    columsPosition = i;
                    row = index;
                }
                else{
                    max = matrixA[index][i-1];
                    columsPosition = i-1;
                    row = index;
                }
            }
            
            index++;
        }

        System.out.println("Max number = "+max);
        System.out.printf("\nOn row %d and column %d ", row, columsPosition);
        
    }

    public static int getMaxIndex(){
        return 0;
    };
}
