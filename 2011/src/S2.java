import java.util.Scanner;

public class S2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        String[] ans = new String[N*2];
        for(int i = 0; i < N * 2; i++){
            ans[i] = in.next();
        }
        int result = 0;
        for(int i = 0; i < N; i++){
            if(ans[i].equals(ans[N + i])){
                result++;
            }
        }

        System.out.println(result);

    }
}
