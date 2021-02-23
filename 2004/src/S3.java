import java.util.Scanner;
import java.util.StringTokenizer;

public class S3 {
    static int[][] values = new int[10][9];
    static String[][] formulas = new String[10][9];
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);


        for(int i = 0; i < 10; i++){
            for (int j = 0; j < 9; j++){
                formulas[i][j] = in.next();
                values[i][j] = -1;
            }
        }

        boolean change = true;
        while (change)
        {
            change = false;
            for (int i = 0 ; i < 10 ; i++) {
                for (int j = 0; j < 9; j++) {
                    StringTokenizer tokenizer = new StringTokenizer(formulas[i][j], "+");
                    int value = 0;
                    int addedValue = 0;
                    while (tokenizer.hasMoreTokens() && addedValue != -1) {
                        addedValue = getValue(tokenizer.nextToken());
                        if (addedValue == -1) {
                            value = -1;
                        }
                        else {
                            value += addedValue;
                        }
                    }
                    if (values[i][j] != value) {
                        change = true;
                        values[i][j] = value;
                    }
                }
            }
        }
    }
    public static int getValue (String line)
    {
        int value = -1;

        if (line.charAt (0) >= 'A' && line.charAt (0) <= 'J') {
            value = values[line.charAt(0) - 'A'][line.charAt(1) - '1'];
        }

        else {
            value = Integer.parseInt(line);
        }

        return value;
    }
}
