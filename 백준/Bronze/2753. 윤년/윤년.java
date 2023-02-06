import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int year = Integer.parseInt(input.readLine());

        if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }

    }
}