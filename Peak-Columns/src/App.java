public class App {
    public static void main(String[] args) throws Exception {
        
        int[][] matrixA = {
            {12,2,4},
            {17,10,1},
            {92,80,79}
        };

        findPeakColumn(matrixA);





        // int currentRow = 0;
        // int rowsOfMatrix = matrixA.length;
        // boolean isPeak = false;

        // while (currentRow < rowsOfMatrix && !isPeak) {
            
        //     System.out.println("this is row "+currentRow);
            
        //     // Get the maximum number in the row.
        //     int maximumIndex = getMaxPosition(matrixA[currentRow]);
        //     int maximumNumber =  matrixA[currentRow][maximumIndex];


        //     System.out.println("Maximum number ="+ maximumNumber);

        //     // Check the columns to verify that's the smallest.
            
        //     for (int i = 0; i < rowsOfMatrix; i++){
        //         int[] currentArray = matrixA[i];
        //             if (maximumNumber < currentArray[maximumIndex ]){
        //                 isPeak = true;
        //             }
        //             else{
        //                 isPeak = false;
        //             }
        //     }

            

        //     System.out.println("This is the peak row and column: "+(currentRow+1)+ " "+ (getMaxPosition(matrixA[currentRow])+1));
        //     // Return the row and the column;



        //     currentRow++;
        // }

    }

    public static void findPeakColumn(int[][] matrix){

        int currentRow = 0;
        int rowsInMatrix = matrix.length;
        boolean isPeak = false;
        int peakRow = -1;
        int peakColumn = -1;

        while (currentRow < rowsInMatrix && !isPeak){

            int maxIndex = getMaxPosition(matrix[currentRow]);
            int maxValue = matrix[currentRow][maxIndex];

            for (int i = 0; i < rowsInMatrix; i++){
                int[] currentArray = matrix[i];

                if (maxValue < currentArray[maxIndex]){
                    isPeak = true;
                }
                else isPeak = false;
            }

            peakRow = currentRow+1;
            peakColumn = maxIndex+1;

            currentRow++;

        }

            System.out.println("The peak column is :"+peakRow + " "+peakColumn);
    }

    


    private static int getMaxPosition(int[] arr){
        int maxIndex  = -1;
        int max = 0;

        for (int i = 0; i < arr.length; i++ ){
            if (arr[i] > max){
                max = arr[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }


}
