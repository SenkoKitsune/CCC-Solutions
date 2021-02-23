import java.util.Scanner;

public class S2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int radius = in.nextInt();
        while(radius != 0){
            int counter = 0;
            int maxHeight = radius;
            for(int x = 0; x <= radius; x++){
                for(int y = maxHeight; y >= 0; y--){
                    if(Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) <= radius){
                        counter += y + 1;
                        break;
                    }
                    else{
                        maxHeight--;
                    }
                }
            }
            System.out.println(counter * 4 - 3 - radius * 4);
            radius = in.nextInt();
        }
    }
}
