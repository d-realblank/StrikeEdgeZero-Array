import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Part2_A {
    /**
     * Moves left or right in the array depending on the value of the current index.
     * Stops when it reaches the egde of the array. Or the value of the current index is 0.
     * @param arr - the array to move in.
     * @param n - size of the array.
     * @param currP - the current index.
     * @return
     */
    public static boolean strikeEdge(int arr[], int n, int currP, boolean[] visited) {
        visited[currP] = true;
        //if currP is end of arr then return true
        if(currP == n - 1){
            return true;
        }
        //check right side
        if(currP + arr[currP] < n && !visited[currP + arr[currP]]){
            if(strikeEdge(arr, n, currP + arr[currP], visited)){
                return true;
            }
        }
        //check left side
        if(currP - arr[currP] >= 0 && !visited[currP - arr[currP]]){
            if(strikeEdge(arr, n, currP - arr[currP], visited)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("in.txt"));
            FileWriter fw = new FileWriter("out.txt");
            //reads m
            int m = sc.nextInt();
            //reads n and start position and arr values
            for(int tests = 0; tests < m; tests++){
                int n = sc.nextInt();
                int initP = sc.nextInt();
                int[] arr = new int[n];
                boolean[] visited = new boolean[n];
                for(int i = 0; i < n - 1; i++){
                    arr[i] = sc.nextInt();
                }
                arr[n - 1] = 0;
                for(int i = 0; i < n; i++){
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
                //checks if there is a solution
                if(strikeEdge(arr, n, initP, visited))
                    fw.write("1\n");
                else
                    fw.write("0\n");
            }
            fw.close();
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}


 
 
 