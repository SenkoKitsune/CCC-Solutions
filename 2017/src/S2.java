import java.util.Arrays;
import java.util.Scanner;

public class S2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] measurements = new int[n];
        int[] finalOrder = new int[n];
        for(int i = 0; i < n; i++){
            measurements[i] = in.nextInt();
        }
        Arrays.sort(measurements);
        int indexH = n/2 + n%2;
        int indexL = indexH - 1;
        for(int i = 0; i < n + 2; i+= 2){
            try {
                finalOrder[i] = measurements[indexL];
                finalOrder[i + 1] = measurements[indexH];
                indexH++;
                indexL--;
            }
            catch (IndexOutOfBoundsException exception){
                break;
            }
        }
        for(int i = 0; i < finalOrder.length; i++){
            System.out.print(finalOrder[i] + " ");
        }
    }
}
