import java.util.Scanner;

public class S2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int J = in.nextInt();
        int A = in.nextInt();
        int[] jerseys = new int[J];
        boolean[] isTaken = new boolean[J];
        for(int i = 0; i < J; i++){
            char size = in.next().charAt(0);
            switch (size){
                case 'S':
                    jerseys[i] = 0;
                    break;
                case 'M':
                    jerseys[i] = 1;
                    break;
                case 'L':
                    jerseys[i] = 2;
                    break;
            }
        }
        int counter = 0;
        for(int i = 0; i < A; i++){
            char size = in.next().charAt(0);
            int jerseySize = 0;
            switch (size){
                case 'S':
                    jerseySize = 0;
                    break;
                case 'M':
                    jerseySize = 1;
                    break;
                case 'L':
                    jerseySize = 2;
                    break;
            }
            int number = in.nextInt() - 1;

            if(jerseys[number] >= jerseySize && !isTaken[number]){
                counter++;
                isTaken[number] = true;
            }
        }
        System.out.println(counter);

    }
}
