import java.util.*;

public class SymmetricMountains {
    
    public static void main(String[] args){

        // Create scanner
        Scanner input = new Scanner(System.in);

        // Number of mountains
        int N = input.nextInt();

        // Array of mountains
        int[] h = new int[N];

        // Get mountain heights
        for(int i=0; i<N; i++){
            h[i]=input.nextInt();
        }

        // Create array to store minimum asymmetric value for each crop
        int[] ans = new int[N];

        // Fill array with maximum integer values
        for(int i=0; i<N; i++){
            ans[i]=Integer.MAX_VALUE;
        }

        // Iterate over all mountains (to handle even crops)
        for(int i=0; i<N; i++){
            
            // Store cumulative asymmetric value at this index
            int crop_val = 0;

            // Iterate through even crop values
            for(int crop=0; i-crop/2>=0&&i+crop/2<N; crop+=2){

                // Calculate absolute difference, add to cumulative asymmetric value 
                crop_val+=Math.abs(h[i-crop/2]-h[i+crop/2]);

                // Compare minimum asymmetric value for this crop (thus far) to current 
                // cumulative asymmetric value
                ans[crop]=Math.min(ans[crop], crop_val);
            }
        }

        // Iterate over all mountains (to handle odd crops)
        for(int i=0; i<N; i++){

            // Store cumulative asymmetric value at this index
            int crop_val = 0;

            // Iterate through odd crop values
            for(int crop=1; i-crop/2>=0&&i+crop/2+1<N; crop+=2){

                // Calculate absolute difference, add to cumulative asymmetric value
                crop_val+=Math.abs(h[i-crop/2]-h[i+crop/2+1]);

                // Compare minimum asymmetric value for this crop (thus far) to current
                // Cumulative asymmetric value
                ans[crop]=Math.min(ans[crop], crop_val);
            }
        }

        // Output
        for(int i=0; i<N; i++){
            System.out.printf("%d ", ans[i]);
        }

    }
}
