import java.util.Scanner;

public class S2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        String[] rhyme = new String[N * 4];
        for(int i = 0; i < (4 * N); i++){
            String input = in.nextLine().toLowerCase();
            int startIndex = 0;
            loop:
            for(int j = input.length() - 1; j > 0; j--){
                switch (input.charAt(j)){
                    case 'a','e','i','o','u', ' ':
                        startIndex = j;
                        break loop;
                }
            }
            rhyme[i] = input.substring(startIndex);
        }

        for(int i = 0; i < N; i++){
            int x = (4 * i);

            if(rhyme[x].equals(rhyme[x + 1]) && rhyme[x + 1].equals(rhyme[x + 2]) && rhyme[x + 2].equals(rhyme[x + 3])){
                System.out.println("perfect");
            }
            else if(rhyme[x].equals(rhyme[x + 1]) && !rhyme[x + 1].equals(rhyme[x + 2]) && rhyme[x + 2].equals(rhyme[x + 3])){
                System.out.println("even");
            }
            else if(rhyme[x].equals(rhyme[x + 2]) && rhyme[x + 1].equals(rhyme[x + 3]) && !rhyme[x + 1].equals(rhyme[x + 2])){
                System.out.println("cross");
            }
            else if(rhyme[x].equals(rhyme[x + 3]) && rhyme[x + 1].equals(rhyme[x + 2]) && !rhyme[x].equals(rhyme[x + 1])){
                System.out.println("shell");
            }
            else{
                System.out.println("free");
            }
        }
    }
}
