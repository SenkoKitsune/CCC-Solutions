import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class S3 {
    private static String[] matches = {"WLT", "WLT", "WLT", "WLT", "WLT", "WLT"};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int G = in.nextInt();
        /*
        0 = AB
        1 = AC
        2 = AD
        3 = BC
        4 = BD
        5 = CD
         */
        int[][] scores = new int[6][4];
        for (int i = 0; i < G; i++) {
            int A = in.nextInt();
            int B = in.nextInt();
            int Sa = in.nextInt();
            int Sb = in.nextInt();
            setMatches(A, B, Sa, Sb);
        }
        //Gets all possible combinations
        HashSet<String> games = new HashSet<>();
        for (int i = 0; i < matches[0].length(); i++) {
            for (int j = 0; j < matches[1].length(); j++) {
                for (int k = 0; k < matches[2].length(); k++) {
                    for (int l = 0; l < matches[3].length(); l++) {
                        for (int m = 0; m < matches[4].length(); m++) {
                            for (int n = 0; n < matches[5].length(); n++) {
                                String result = "" + matches[0].charAt(i) + matches[1].charAt(j) + matches[2].charAt(k) + matches[3].charAt(l) + matches[4].charAt(m) + matches[5].charAt(n);
                                games.add(result);
                            }
                        }
                    }
                }
            }
        }
        int counter = 0;
        for(String x : games){
            if(getWin(x, t)){
                counter ++;
            }
        }
        System.out.println(counter);
    }

    private static void setMatches(int A, int B, int Sa, int Sb) {
        switch (A) {
            case 1:
                switch (B) {
                    case 2:
                        matches[0] = getStatus(Sa, Sb);
                        break;
                    case 3:
                        matches[1] = getStatus(Sa, Sb);
                        break;
                    case 4:
                        matches[2] = getStatus(Sa, Sb);
                        break;
                }
                break;
            case 2:
                switch (B) {
                    case 3:
                        matches[3] = getStatus(Sa, Sb);
                        break;
                    case 4:
                        matches[4] = getStatus(Sa, Sb);
                        break;
                }
                break;
            case 3:
                matches[5] = getStatus(Sa, Sb);
                break;
        }
    }

    private static String getStatus(int Sa, int Sb) {
        if (Sa > Sb) {
            return "W";
        } else if (Sa == Sb) {
            return "T";
        } else {
            return "L";
        }
    }

    private static boolean getWin(String game, int favourite) {
        int[] scores = new int[4];
        for (int i = 0; i < 6; i++) {
            char index = game.charAt(i);
            switch (i) {
                case 0:
                   setScores(scores, 0, 1, index);
                    break;
                case 1:
                    setScores(scores, 0, 2, index);
                    break;
                case 2:
                    setScores(scores, 0, 3, index);
                    break;
                case 3:
                    setScores(scores, 1, 2, index);
                    break;
                case 4:
                    setScores(scores, 1, 3, index);
                    break;
                case 5:
                    setScores(scores, 2, 3, index);
                    break;
            }
        }
        int score = scores[favourite - 1];
        Arrays.sort(scores);
        if(score == scores[3] && score != scores[2]){
            return true;
        }
        else{
            return false;
        }
    }

    private static void setScores(int[] scores, int A, int B, char index) {
        if (index == 'W') {
            scores[A] += 3;
        } else if (index == 'T') {
            scores[A] += 1;
            scores[B] += 1;
        } else {
            scores[B] += 3;
        }
    }

}
