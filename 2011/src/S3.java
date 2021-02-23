import java.util.Scanner;

public class S3 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            int m = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            if(y < getHeight(m,x)){
                System.out.println("crystal");
            }
            else{
                System.out.println("empty");
            }
        }
    }

    private static int getHeight(int m, int x) {
        if (m == 0) {
            return 0;
        } else {
            int power = (int) Math.pow(5,m-1);
            int location = x/power;
            if (location == 0 || location == 4) {
                return 0;
            }
            else if(location == 1 || location == 3){
                int height = power + getHeight(m - 1,x % power);
                return height;
            }
            else{
                int height = 2 * power + getHeight(m-1, x % power);
                return height;
            }
        }
    }
}
