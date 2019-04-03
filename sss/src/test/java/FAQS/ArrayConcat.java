package FAQS;

import java.util.Arrays;

public class ArrayConcat {

    public static void main(String[] args) {
        int[] array1 = {8, 2, 3};
        int[] array2 = {4, 10, 6};

        int length = array1.length + array2.length;

        int[] result = new int[length];
        int pos = 0;
        for (int element : array1) {
            result[pos] = element;
            pos++;
        }

        for (int element : array2) {
            result[pos] = element;
            pos++;
        }

        System.out.println(Arrays.toString(result));
      
        
        int temp;
        for (int i = 0; i < result.length; i++) 
        {
            for (int j = i + 1; j < result.length; j++) 
            {
                if (result[i] > result[j]) 
                {
                    temp = result[i];
                    result[i] = result[j];
                    result[j] = temp;
                }
            }
        }
        
        System.out.println(Arrays.toString(result));
        
    }
}