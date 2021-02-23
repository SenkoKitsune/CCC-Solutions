import java.util.Scanner;

public class S2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int screenX = in.nextInt();
        int screenY = in.nextInt();

        int mouseX = 0;
        int mouseY = 0;

        int moveX = in.nextInt();
        int moveY = in.nextInt();

        while(!(moveX == 0 && moveY == 0)){

                if (mouseX + moveX > screenX) {
                    mouseX = screenX;
                } else if (mouseX + moveX < 0) {
                    mouseX = 0;
                }
                else{
                    mouseX += moveX;
                }
                if (mouseY + moveY > screenY) {
                    mouseY = screenY;
                } else if (mouseY + moveY < 0) {
                    mouseY = 0;
                }else{
                    mouseY += moveY;
                }


            System.out.println(mouseX + " " + mouseY);
            moveX = in.nextInt();
            moveY = in.nextInt();

        }
    }
}
