import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Part1{
    private ArrayList<Integer> list1 = new ArrayList<>();
    private ArrayList<Integer> list2 = new ArrayList<>();
    
    public Part1(){
        readFile("input.txt");
        solve();
    }

    private void readFile(String filePath){
        try {
            File file = new File(filePath);
            Scanner sc = new Scanner(file);
            
            int i = 0;
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] numbers = line.split("\\s+");

                list1.add(Integer.parseInt(numbers[0]));
                list2.add(Integer.parseInt(numbers[1]));

                i++;
            }
        } catch (Exception e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }

    private void solve(){
        Collections.sort(list1);
        Collections.sort(list2);

        int totalDistance = 0;
        for(int i=0; i<list1.size(); i++){
            totalDistance += Math.abs(list1.get(i) - list2.get(i));
        }

        System.out.println(totalDistance);
    }

    public static void main(String[] args) {
        Part1 part1 = new Part1();
    }
}