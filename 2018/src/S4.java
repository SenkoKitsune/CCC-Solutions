import java.util.HashMap;
import java.util.Scanner;

public class S4 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        long N = in.nextLong();

        System.out.println(solve(N));
    }

    private static long getSubtrees(long N, HashMap<Integer, Long> subtrees, long count){
        long hold = count;
        for (int i = (int) N; i >= 2; i--){
            if (subtrees.containsKey((int) N/i)){
                count += subtrees.get((int) N / i);
            } else {
                count = getSubtrees(N / i, subtrees, count);
            }
        }
        subtrees.put((int) N, count - hold);
        return count;
    }
    private static long solve(long N) {
        HashMap<Integer, Long> subtrees = new HashMap<>();
        if (N == 1)
        {
            return 1;
        }
        subtrees.put(1, 1L);
        subtrees.put(2, 1L);
        subtrees.put(3, 2L);
        subtrees.put(4, 3L);
        subtrees.put(5, 4L);
        subtrees.put(6, 6L);

        return getSubtrees(N, subtrees, 0);
    }

}
