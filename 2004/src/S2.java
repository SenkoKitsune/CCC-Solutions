import java.util.Arrays;
import java.util.Scanner;

public class S2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        //n = yodellers, k = rounds
        int n = in.nextInt();
        int k = in.nextInt();
       int[] yodellers = new int[n];
       int[] ranks = new int[n];
       int[] worstRanks = new int[n];

        for (int i = 0 ; i < k ; i++) {
            for (int j = 0 ; j < n ; j++) {
                yodellers[j] += in.nextInt();
            }
            for (int j = 0 ; j < n ; j++) {
                int rank = 1;
                for (int l = 0 ; l < n ; l++) {
                    if (l != j && yodellers[l] > yodellers[j]) {
                        rank++;
                    }
                }
                if (rank > worstRanks [j]) {
                    worstRanks[j] = rank;
                }

                ranks[j] = rank;
            }
        }
        for (int i = 0 ; i < n ; i++) {
            if (ranks[i] == 1) {
                System.out.println("Yodeller " + (i + 1) + " is the TopYodeller: score " + yodellers[i] + ", worst rank " + worstRanks[i]);
            }
        }
    }

}
