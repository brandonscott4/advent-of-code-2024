import java.io.File;
import java.util.Scanner;

public class Part2 {
    Scanner sc;
    private char[][] arr;
    private int rows;
    private int cols;
    
    public Part2(){
        readFile("input.txt");
        solve();
    }

    private void readFile(String filePath){
        try {
            File file = new File(filePath);
            sc = new Scanner(file);

            cols = sc.nextLine().length();
            rows = 1;
            while(sc.hasNextLine()){
                rows += 1;
                sc.nextLine();
            }

            arr = new char[rows][cols];
            sc.close();

            int index = 0;
            sc = new Scanner(file);
            while(sc.hasNextLine()){
                arr[index] = sc.nextLine().toCharArray();
                index++;
            }
        } catch (Exception e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }

    private void solve(){
        int count = 0;

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(arr[i][j] == 'A'){
                    count += checkMas(i,j);
                }
            }
        }

        System.out.println(count);
    }

    private int checkMas(int i, int j){
        //top left and bottom right check
        if((i - 1 >= 0 && j - 1 >= 0) && (i + 1 <= rows - 1 && j + 1 <= cols - 1)){
            if(arr[i - 1][j - 1] == 'M' && arr[i + 1][j + 1] == 'S' || arr[i - 1][j - 1] == 'S' && arr[i + 1][j + 1] == 'M'){
                //top right and bottom left check
                if((i - 1 >= 0 && j + 1 <= cols - 1) && (i + 1 <= rows - 1 && j - 1 >= 0)){
                    if(arr[i - 1][j + 1] == 'M' && arr[i + 1][j - 1] == 'S' || arr[i - 1][j + 1] == 'S' && arr[i + 1][j - 1] == 'M'){
                        return 1;       
                    }
                }    
            }
        }

        return 0;
    }
    

    public static void main(String[] args) {
        Part2 part2 = new Part2();
    }
}

