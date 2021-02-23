import java.util.Scanner;

public class S2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();
        for(int i = 0; i < T; i++){
            int N = in.nextInt();
            findPrimes(N);
        }
    }
    private static boolean isPrime(int N){
        int max = (int) Math.sqrt(N) + 1;
        for (int i = 2; i < max; i++){
            if (N % i == 0){
                return true;
            }
        }
        return false;
    }
    private static int[] findPrimes(int N){
        int[] output = new int[2];
        if (N % 2 == 0){
            N--;
            output[0] = N;
            output[1] = N + 2;
        } else {
            output[0] = N;
            output[1] = N;
        }
        while (isPrime(output[0]) || isPrime(output[1])){
            output[0] -= 2;
            output[1] += 2;
        }
        return output;
    }
}
