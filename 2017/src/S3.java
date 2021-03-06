import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] PV = new int[2001];
        StringTokenizer line = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++)
        {
            PV[Integer.parseInt(line.nextToken())]++;
        }
        int[] PS = new int[4002];
        int L = -1;
        for (int i = 1; i < 2001; i++)
        {
            if (PV[i] == 0) {continue;}
            for (int j = i; j < 2001; j++)
            {
                if (PV[j] == 0){continue;}
                if (i == j)
                {
                    PS[i + j] += (PV[i]/2);
                } else {
                    PS[i + j] += Integer.min(PV[i], PV[j]);
                }
                if (PS[i + j] > L)
                {
                    L = PS[i + j];
                }
            }
        }
        int count = 0;
        for (int i = 0; i < 4002; i++)
        {
            if (PS[i] == L)
            {
                count++;
            }
        }
        System.out.println(L + " " + count);
    }
}
