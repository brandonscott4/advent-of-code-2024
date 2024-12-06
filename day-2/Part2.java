import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Part2 {
    Scanner sc;
    public Part2(){
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

            ArrayList<Integer> levels = new ArrayList<>();
            for(int i=0; i<strLevels.length; i++){
                levels.add(Integer.parseInt(strLevels[i]));
            }

            if(isSafeWithDampener(levels)){
                safeReports++;
            }
        }

        System.out.println(safeReports);
    }



    private boolean isSafe(ArrayList<Integer> levels){
        if(levels.get(0) == levels.get(1)){
            return false;
        }
        
        boolean isIncreasing = levels.get(1) > levels.get(0);

        for(int i=0; i<levels.size()-1; i++){

            int currLevel = levels.get(i);
            int nextLevel = levels.get(i+1);

            int difference = Math.abs(currLevel - nextLevel);
            if(difference < 1 || difference > 3 ){
                return false;
            }

            if(isIncreasing){
                if(nextLevel < currLevel){
                    return false;
                }
            } else {
                if(nextLevel > currLevel){
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isSafeWithDampener(ArrayList<Integer> levels){
        if(isSafe(levels)){
            return true;
        }

        for(int i=0; i<levels.size(); i++){
            ArrayList<Integer> copyLevels = new ArrayList<>(levels);

            copyLevels.remove(i);

            if(isSafe(copyLevels)){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Part2 part2 = new Part2();
    }
}

