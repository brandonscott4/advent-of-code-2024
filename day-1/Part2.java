import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Part2 {
    private ArrayList<Integer> list1 = new ArrayList<>();
    private ArrayList<Integer> list2 = new ArrayList<>();
    
    public Part2(){
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
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<list2.size(); i++){
            int num = list2.get(i);

            map.put(num, map.getOrDefault(num, 0) + 1);
        }
    
        int similarityScore = 0;
        for(int i=0; i<list1.size(); i++){
            int num = list1.get(i);
            
            if(map.containsKey(num)){
                similarityScore += num * map.get(num);
            }
        }

        System.out.println(similarityScore);
    }  

    public static void main(String[] args) {
        Part2 part2 = new Part2();
    }
}
