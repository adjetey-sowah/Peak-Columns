import java.util.ArrayList;
import java.util.Arrays;

public class Trial {
    
    public static void main(String[] args) {
        int[] arr = {2,5,1,3,4,7};
        System.out.println(Arrays.toString(shuffle(arr,3)));
    }


    public static int[] shuffle(int[] nums, int n) {
        
        int[] arr = new int[nums.length];
        int i = 0;
        int increment = 0;

        

        while (i < arr.length){
            arr[i] = nums[increment++];
            arr[i+1] = nums[n];
            i+=2;
            n++;
        }

        return arr;
    }

}
