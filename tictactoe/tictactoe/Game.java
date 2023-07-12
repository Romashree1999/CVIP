import java.util.Random;
import java.util.Scanner;

class tictactoe {

   static char[][] board;

    public tictactoe(){
        board = new char[3][3];
        startBord();
    }

    void startBord(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j]=' ';
            }
        }
    }

    public static void displayaBord(){
    
        System.out.println("-------------");
        for (int i = 0; i < board.length; i++) {

            System.out.print("| ");

            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]+ " | ");
                // System.out.println();
            }
             System.out.println();
             System.out.println("-------------");
        }
    }

    static void placeMark(int row, int col, char mark){
        if (row>=0 && row<=2 && col>=0 && col<=2) {
            board[row][col] =mark;
        }
        else{
            System.out.println("Invalid Position");
        }
    }

    static boolean checkColWin(){
        for (int j = 0; j <= 2; j++) {
            if (board[0][j] !=' ' &&   board[0][j] == board[1][j] && board[1][j] == board[2][j]   ) {
                return true;
            }
        }
        return false;
    }

    static boolean checkRowWin(){
        for (int i = 0; i <= 2; i++) {
            
            if (board[i][0] !=' ' &&  board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
        }
        return false;
    }
    
    static boolean checkDiagonallWin(){

        if (board[0][0] !=' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2] || board[0][2] !=' ' &&  board[0][2] == board[1][1] && board[1][1] == board[2][0] ){
            return true;
        }
        else{
            return false;
        }
       
    }

    static boolean checkDraw(){
        for (int i = 0; i <=2; i++) {
            for (int j = 0; j <=2; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    
}

abstract class Player{
    String name;
    char mark;
    abstract void makeMove();
    boolean isvalidMove(int row, int col){
        if (row >= 0 && row <=2 & col >=0 && col <=2) {
            if (tictactoe.board[row][col] == ' ') {
                return true;
            }
        }
        return false;
    }
}

class HumanPlayer extends Player{
    

    HumanPlayer(String name, char mark){
        this.name = name;
        this.mark  = mark;
    }

    void makeMove(){
        Scanner input = new Scanner(System.in);
        int row;
        int col;
        do {
            System.out.println("Enter the row and collumn");
            row = input.nextInt();
            col = input.nextInt();
        } while (!isvalidMove(row, col));

        tictactoe.placeMark(row, col, mark);
    }

}

class AIPlayer extends Player{

    AIPlayer(String name, char mark){
        this.name = name;
        this.mark  = mark;
    }

    void makeMove(){
        Scanner input = new Scanner(System.in);
        int row;
        int col;
        do {
          Random r = new Random();
          row = r.nextInt(3);
          col = r.nextInt(3);
        } while (!isvalidMove(row, col));

        tictactoe.placeMark(row, col, mark);
    }
}




public class Game {

    public static void main(String[] args) {
        tictactoe t = new tictactoe();
        HumanPlayer p1 = new HumanPlayer("Roma" ,'X');
        AIPlayer p2 = new AIPlayer("AI", 'O');
        Player cp;
        cp=p1;
        while (true) {
            System.out.println(cp.name + " Turn");
        cp.makeMove();
        tictactoe.displayaBord();
        if (tictactoe.checkColWin() || tictactoe.checkRowWin() || tictactoe.checkDiagonallWin()) {
            System.out.println(cp.name + " is Winner");
            break;
        }
        else if (tictactoe.checkDraw()) {
            System.out.println("Game is Draw");
            break;
        }
        else{
            if (cp == p1) {
                cp = p2;
            }
            else{
                cp = p1;
            }
        }
        
        }
        

    }
}