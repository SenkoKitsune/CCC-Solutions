import java.util.Scanner;
import java.util.TreeSet;

public class S3 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int G = in.nextInt();
        int P = in.nextInt();
        int count = 0;
        TreeSet<Integer> gates = new TreeSet<>();
        for(int i = 0; i < G; i++){
            gates.add(i + 1);
        }
        for(int i = 0; i < P; i++){
            int g = in.nextInt();
            if(gates.floor(g) == null){
                break;
            }
            else{
                gates.remove(gates.floor(g));
                count++;
            }
        }
        System.out.println(count);
    }
}
