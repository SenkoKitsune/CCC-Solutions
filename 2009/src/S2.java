import java.util.HashSet;
import java.util.Scanner;

public class S2 {
    private static HashSet<String> above= new HashSet<>();
    private static HashSet<String> below = new HashSet<>();

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int r = in.nextInt();
        int l = in.nextInt();
        in.nextLine();
        String[] lights = new String[r];
        for(int i = 0; i < r; i++){
            lights[i] = in.nextLine().replaceAll("\\s+", "");
        }
        above.add(lights[0]);
        for(int i = 1; i < lights.length; i++){
            getBottomLine(lights[i]);
        }
        System.out.println(above.size());
    }

    private static String buttonPress(String top, String bottom){
        String result = "";
        for(int i = 0; i < top.length(); i++){
            if(bottom.charAt(i) == top.charAt(i)){
                result += 0;
            }
            else{
                result += 1;
            }
        }
        return result;
    }

    private static void getBottomLine(String lights){
        below.add(lights);
        for(String x: above){
            below.add(buttonPress(x,lights));
        }
        above = (HashSet) below.clone();
        below.clear();
    }
}
