import java.io.File;
import java.util.Scanner;

public class Part1 {
    Scanner sc;
    private char[][] arr;
    private int rows;
    private int cols;
    private String xmas = "XMAS";
    
    public Part1(){
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
                if(arr[i][j] == 'X'){
                    count += checkXmas(i,j);
                }
            }
        }

        System.out.println(count);
    }

    private int checkXmas(int i, int j){
        int count = 0;

        count += checkHorizontal(i, j);
        count += checkVertical(i, j);
        count += checkMainDiagonal(i, j);
        count += checkSecondaryDiagonal(i, j);

        return count;
    }

    private int checkHorizontal(int i, int j){
        int count = 0;
        int currI = i;
        int currJ = j;
        boolean match = true;

        //check horizontal left
        if(j - 3 >= 0){
            int index = 0;
            while(index < 4){
                if(arr[currI][currJ] != xmas.charAt(index)){
                    match = false;
                    break;
                }
                index++;
                currJ--;
            }

            currJ = j;
        } else {
            match = false;
        }

        if(match){
            count++;
        } else {
            match = true;
        }

        //check horizontal right
        if(j + 3 <= cols - 1){
            int index = 0;
            while(index < 4){
                if(arr[currI][currJ] != xmas.charAt(index)){
                    match = false;
                    break;
                }
                index++;
                currJ++;
            }

            currJ = j;
        } else {
            match = false;
        }

        if(match){
            count++;
        }

        return count;
    }

    private int checkVertical(int i, int j){
        int count = 0;
        int currI = i;
        int currJ = j;
        boolean match = true;

        //check upward
        if(i - 3 >= 0){
            int index = 0;
            while(index < 4){
                if(arr[currI][currJ] != xmas.charAt(index)){
                    match = false;
                    break;
                }
                index++;
                currI--;
            }

            currI = i;
        } else {
            match = false;
        }

        if(match){
            count++;
        } else {
            match = true;
        }

        //check downward
        if(i + 3 <= rows - 1){
            int index = 0;
            while(index < 4){
                if(arr[currI][currJ] != xmas.charAt(index)){
                    match = false;
                    break;
                }
                index++;
                currI++;
            }

            currI = i;
        } else {
            match = false;
        }

        if(match){
            count++;
        }

        return count;
    }

    private int checkMainDiagonal(int i, int j){
        int count = 0;
        int currI = i;
        int currJ = j;
        boolean match = true;

        //check diagonal top left
        if(i - 3 >= 0 && j - 3 >= 0){
            int index = 0;
            while(index < 4){
                if(arr[currI][currJ] != xmas.charAt(index)){
                    match = false;
                    break;
                }
                index++;
                currI--;
                currJ--;
            }

            currI = i;
            currJ = j;
    
        } else {
            match = false;
        }

        if(match){
            count++;
        } else {
            match = true;
        }

        //check diagonal bottom right
        if(i + 3 <= rows - 1 && j + 3 <= cols - 1){
            int index = 0;
            while(index < 4){
                if(arr[currI][currJ] != xmas.charAt(index)){
                    match = false;
                    break;
                }
                index++;
                currI++;
                currJ++;
            }

            currI = i;
            currJ = j;
        } else {
            match = false;
        }

        if(match){
            count++;
        }

        return count;
    }

    private int checkSecondaryDiagonal(int i, int j){
        int count = 0;
        int currI = i;
        int currJ = j;
        boolean match = true;

        //check diagonal top right
        if(i - 3 >= 0 && j + 3 <= cols - 1){
            int index = 0;
            while(index < 4){
                if(arr[currI][currJ] != xmas.charAt(index)){
                    match = false;
                    break;
                }
                index++;
                currI--;
                currJ++;
            }

            currI = i;
            currJ = j;
        } else {
            match = false;
        }

        if(match){
            count++;
        } else {
            match = true;
        }

        //check diagonal bottom left
        if(i + 3 <= rows - 1 && j - 3 >= 0){
            int index = 0;
            while(index < 4){
                if(arr[currI][currJ] != xmas.charAt(index)){
                    match = false;
                    break;
                }
                index++;
                currI++;
                currJ--;
            }

            currI = i;
            currJ = j;
        } else {
            match = false;
        }

        if(match){
            count++;
        }

        return count;
    }

    

    public static void main(String[] args) {
        Part1 part1 = new Part1();
    }
}

