import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */


     /*
1 1 1 0 0 0 
5 10 8 12 17 20
1 1 1 0 0 0
0 0 2 4 4 0
0 0 0 2 0 0
0 0 1 2 4 0
     */



    public static int getSumHourGlass(final List<List<Integer>> p_arr,int p_i,int p_j) {
        int in_i=p_i-1;
        int in_j=p_j-1;
        int len_j = p_j+1;
        int len_i = p_i+1;
        int l_sum = 0;
        for(int i = in_i; i<=len_i;i++){
            for(int j =in_j; j<=len_j;j++){  
                if(!(i == p_i  && j == p_j-1 ||  i == p_i  && j == p_j+1)){
                   l_sum = l_sum + p_arr.get(i).get(j);
                }
            }
        }
        
        return l_sum;
    }

    public static int hourglassSum(List<List<Integer>> arr) {
        int l_max = Integer.MIN_VALUE;
        int l_lenght = arr.get(0).size();
        for(int i = 1 ; i< l_lenght-1;i++){
            for(int j = 1 ; j < l_lenght-1;j++){
                int aux = getSumHourGlass(arr,i,j);
                if(aux>l_max) l_max = aux;
            }
        }
        return l_max;


}

public class HackerRank {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            String[] arrRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arrRowItems = new ArrayList<>();

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowTempItems[j]);
                arrRowItems.add(arrItem);
            }

            arr.add(arrRowItems);
        }

        int result = Result.hourglassSum(arr);
        System.out.println(result);
    }
}

