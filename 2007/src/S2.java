import java.util.Arrays;
import java.util.Scanner;

public class S2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] sizes = new int[n][3];
        for (int i = 0; i < n; i++) {
            sizes[i][0] = in.nextInt();
            sizes[i][1] = in.nextInt();
            sizes[i][2] = in.nextInt();
            Arrays.sort(sizes[i]);
        }

        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            boolean fit = false;
            int[] packages = new int[3];
            packages[0] = in.nextInt();
            packages[1] = in.nextInt();
            packages[2] = in.nextInt();
            int minVolume = Integer.MAX_VALUE;
            Arrays.sort(packages);
            for (int boxSize = 0; boxSize < n; boxSize++)
                if (packages[0] <= sizes[boxSize][0] && packages[1] <= sizes[boxSize][1] && packages[2] <= sizes[boxSize][2]) {
                    if(sizes[boxSize][0] * sizes[boxSize][1] * sizes[boxSize][2] < minVolume){
                        minVolume = sizes[boxSize][0] * sizes[boxSize][1] * sizes[boxSize][2];
                    }
                    fit = true;
                }
            if (!fit) {
                System.out.println("Item does not fit.");
            }
            else{
                System.out.println(minVolume);
            }
        }
    }
}
