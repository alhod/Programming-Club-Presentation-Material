import java.util.*;

public class Trianglelane {
    
    public static void main(String[] args){

        // Create scanner
        Scanner input = new Scanner(System.in);

        // Get number of columns
        int C = input.nextInt();

        // Store input
        int[][] arr = new int[2][C];

        // Getting input
        // Iterates over rows
        for(int r=0; r<2; r++){

            // Iterates over columns
            for(int c=0; c<C; c++){
                arr[r][c] = input.nextInt();
            }
        }

        // Stores answer
        int ans = 0;

        // Iterate over rows
        for(int r=0; r<2; r++){

            // Iterate over columns
            for(int c=0; c<C; c++){

                // Check if spill on this triangle
                if(arr[r][c]==0){

                    // Skip to next iteration
                    continue;
                }

                // Check left side of triangle
                if(c==0||arr[r][c-1]==0){
                    
                    // Left side needs tape
                    ans++;
                }

                // Check right side triangle
                if(c==C-1||arr[r][c+1]==0){

                    // Right side needs tape
                    ans++;
                }

                // Check if it is a 
                //      /\
                //      \/
                // triangle
                if(c%2==0){

                    // Check if other triangle in this column is not spilled on
                    if(arr[(r+1)%2][c]==0){
                        ans++;
                    }
                    
                } 
                
                // It is a 
                //      \/
                //      /\
                // triangle
                else {
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}
