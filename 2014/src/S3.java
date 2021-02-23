import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class S3 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i = 0; i < T; i++){
            int N = in.nextInt();
            if(isSolvable(N, in)){
                System.out.println("Y");
            }
            else{
                System.out.println("N");
            }
        }
    }
    private static boolean isSolvable(int N, Scanner in){
        Stack<Integer> mountain = new Stack<>();
        for(int i = 0; i < N; i++){
            mountain.add(in.nextInt());
        }
        Stack<Integer> branch = new Stack<>();
        int index = 1;
        boolean inOrder = true;
        while(inOrder){
            if(mountain.size() == 0 && branch.size() == 0){
                break;
            }
            if(mountain.size() > 0 && mountain.peek() == index){
                mountain.pop();
                index++;
            }
            else if(branch.size() > 0 && branch.peek() == index){
                branch.pop();
                index++;
            }
            else if(mountain.size() > 0 && mountain.peek() != index){
                    branch.add(mountain.pop());
            }
            else if(mountain.size() == 0 && branch.size() > 0 && branch.peek() != index){
                inOrder = false;
                break;
            }
        }
        return inOrder;
    }
}


