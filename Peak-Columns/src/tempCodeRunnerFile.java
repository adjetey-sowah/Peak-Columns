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