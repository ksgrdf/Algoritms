import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Brackets {

    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number:");
        int N = Integer.parseInt(reader.readLine()); // Number of brackets
        while(N < 0) //Validation of number
        {
            System.out.println("Number must be positive");
            System.out.println("Enter number:");
            N = Integer.parseInt(reader.readLine());
        }

        int[] num = new int[N+1]; //array of number of Catalan
        num[0] =1;

        for(int i = 0; i < N; i++)
        {
            num[i+1] = num[i] *2 *(2*i + 1) / (i +2);  // Find number of Catalan

        }

        System.out.println(num[N]);

    }
}

