import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class S2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String plainText = in.nextLine();
        String cipherText = in.nextLine();
        String message = in.nextLine();
        TreeSet<String> pairs = new TreeSet<>();
        for(int i = 0; i < plainText.length(); i++){
            pairs.add("" + plainText.charAt(i) + cipherText.charAt(i));
        }
        String decryptMessage = "";
        char[][] table = new char[pairs.size()][2];
        int count = 0;
        while(pairs.size() > 0){
            String pair = pairs.pollFirst();
            table[count][0] = pair.charAt(0);
            table[count][1] = pair.charAt(1);
            count++;
        }
        for(int i = 0; i < message.length(); i++){
            char current = message.charAt(i);
            boolean found = false;
            for(int k = 0; k < table.length; k++){
                if(table[k][1] == current){
                    decryptMessage += "" + table[k][0];
                    found = true;
                    break;
                }
                else if(k == table.length - 1 && !found){
                    decryptMessage += ".";
                }
            }
        }
        System.out.println(decryptMessage);
    }
}
