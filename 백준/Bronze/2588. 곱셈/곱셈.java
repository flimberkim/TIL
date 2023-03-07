import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(input.readLine());
        int b = Integer.parseInt(input.readLine());

        int x = b%10;
        int y = ((b - x) % 100)/10;
        int z = (b - (y*10) - x)/100;

        System.out.println(a*x);
        System.out.println(a*y);
        System.out.println(a*z);
        System.out.println(a*z*100 + a*y*10 + a*x);

    }
}
