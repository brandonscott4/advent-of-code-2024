import java.io.File;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Part1 {
    Scanner sc;
    public Part1(){
        readFile("input.txt");
        solve();
    }

    private void readFile(String filePath){
        try {
            File file = new File(filePath);
            sc = new Scanner(file);
        } catch (Exception e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }

    private void solve(){
        int sum = 0;
        String pattern = "mul\\((\\d+),(\\d+)\\)";
        Pattern regex = Pattern.compile(pattern);

        while(sc.hasNextLine()){
            String line = sc.nextLine();
            Matcher matcher = regex.matcher(line);
            
            while(matcher.find()){
                int x = Integer.parseInt(matcher.group(1));
                int y = Integer.parseInt(matcher.group(2));

                sum += x * y;
            }
        }

        System.out.println(sum);
    }

    public static void main(String[] args) {
        Part1 part1 = new Part1();
    }
}

