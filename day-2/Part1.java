import java.io.File;
import java.util.Scanner;

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
        int safeReports = 0;
    
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            String[] strLevels = line.split("\\s+");

            int[] levels = new int[strLevels.length];
            for(int i=0; i<levels.length; i++){
                levels[i] = Integer.parseInt(strLevels[i]);
            }

            if(levels[1] == levels[0]){
                continue;
            }
            boolean increasing = levels[1] > levels[0] ? true : false;


            if(isSafe(levels, increasing)){
                safeReports++;
            }
        }

        System.out.println(safeReports);
    }

    private boolean isSafe(int[] levels, boolean increasing){
        for(int i=0; i<levels.length - 1; i++){

            int difference = Math.abs(levels[i] - levels[i+1]);
            if(difference < 1 || difference > 3 ){
                return false;
            }

            if(increasing){
                if(levels[i] >= levels[i + 1]){
                    return false;
                }
            } else {
                if(levels[i] <= levels[i + 1]){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Part1 part1 = new Part1();
    }
}

