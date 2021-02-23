import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class S2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        HashMap<String, String> map = new HashMap<>();
        for(int i = 0; i < k; i++){
            String character = in.next();
            String code = in.next();
            map.put(code, character);
        }
        String input = in.next();
        String currentCode = "";
        String result = "";
        for(int i = 0; i < input.length();){
            if(map.containsKey(currentCode)){
                result += map.get(currentCode);
                currentCode = "";
            }
            else{
                currentCode += "" + input.charAt(i);
                i++;
            }
        }
        if(map.containsKey(currentCode)){
            result += map.get(currentCode);
        }
        System.out.println(result);
    }
}
