import java.util.Scanner;

public class S2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String input = in.next();
        char[][] arr = new char[input.length()/2][2];
        boolean isRoman = false;
        int index = 0;
        for(int i = 0; i < input.length() - 1; i+=2){
            arr[index][0] = input.charAt(i);
            arr[index][1] = input.charAt(i + 1);
            index++;
        }
        int result = 0;
        for(int i = 1; i < arr.length; i++){
            if(getArabicNumbers(arr[i][1]) > getArabicNumbers(arr[i - 1][1])){
                result -= Integer.parseInt("" + arr[i - 1][0]) * getArabicNumbers(arr[i - 1][1]);
            }
            else{
                result += Integer.parseInt("" + arr[i - 1][0]) * getArabicNumbers(arr[i - 1][1]);
            }
        }
        result += Integer.parseInt("" + arr[arr.length - 1][0]) * getArabicNumbers(arr[arr.length - 1][1]);
        System.out.println(result);
    }

    private static int getArabicNumbers(char roman){
        switch(roman){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }
}
