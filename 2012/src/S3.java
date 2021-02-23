import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class S3 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] readings = new int[1000];
        for(int i = 0; i < N; i++){
            int reading = in.nextInt();
            readings[reading - 1] += 1;
        }
        int[] sorted = Arrays.copyOf(readings, readings.length);
        Arrays.sort(sorted);
        ArrayList<Integer> highestFrequency = new ArrayList<>();
        ArrayList<Integer> secondFrequency = new ArrayList<>();
        int highest = sorted[sorted.length - 1];
        int second = highest;
        int count = sorted.length - 2;
        while(second == highest && count >= 0){
            if(sorted[count] == 0){
                break;
            }
            second = sorted[count];
            count--;
        }
        for(int i = 0; i < readings.length; i++){
            if(readings[i] == highest){
                highestFrequency.add(i + 1);
            }
            else if(readings[i] == second){
                secondFrequency.add(i + 1);
            }
        }
        if(highestFrequency.size() > 1){
            Collections.sort(highestFrequency);
            System.out.println(highestFrequency.get(highestFrequency.size() - 1) - highestFrequency.get(0));
        }
        else{
            int largest = 0;
            int high = highestFrequency.get(0);
            Collections.sort(secondFrequency);
            System.out.println(Math.max(Math.abs(high - secondFrequency.get(0)), Math.abs(high- secondFrequency.get(secondFrequency.size() - 1))));
        }
    }
}
