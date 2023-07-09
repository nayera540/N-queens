import java.util.*;
 /*Brute Force Solution*/
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of board tiles: ");
        int N = in.nextInt();
        int [][] chessBoard = new int[N][N];
        initBoard(chessBoard, N);
        solve(chessBoard,N);

    }
    public static void initBoard(int [][] chessBoard, int n){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                chessBoard[i][j] = 0;
            }
        }
    }
    public static void printBoard(int [][] chessBoard, int n){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(chessBoard[i][j] + "\t");
            }
            System.out.println();

        }
        System.out.println();
    }
    public static void boardFill(int [][] chessBoard, int n, int row, int column){
        //Fill the rows with -1
        for(int i = 0; i < n; i++){
            if(chessBoard[row][i] == 1)
                continue;
            else
                chessBoard[row][i] = -1;

        }

        //Fill columns with -1
        for(int i = 0; i < n; i++){
            if(chessBoard[i][column] == 1)
                continue;
            else
                chessBoard[i][column] = -1;
        }
        //Fill the upper left diagonal with -1
        for(int i = row, j = column;  j >= 0 || i >= 0; i--, j--){
            if(i < 0 || j < 0){
                break;
            }
            if(chessBoard[i][j] == 1)
                continue;
            else
                chessBoard[i][j] = -1;
        }
        //Fill the upper right diagonal with -1
        for(int i = row, j = column;  j < n || i >= 0; i--, j++){
            if(i < 0 || j == n){
                break;
            }
            if(chessBoard[i][j] == 1)
                continue;
            else
                chessBoard[i][j] = -1;
        }
        //Fill the lower right diagonal with -1
        for(int i = row, j = column;  j < n || i < n; i++, j++){
            if(i == n || j == n){
                break;
            }
            if(chessBoard[i][j] == 1)
                continue;
            else
                chessBoard[i][j] = -1;
        }
        //Fill the lower left diagonal with -1
        for(int i = row, j = column;  j <= 0 || i < n; i++, j--){
            if(j < 0 || i == n){
                break;
            }
            if(chessBoard[i][j] == 1)
                continue;
            else
                chessBoard[i][j] = -1;

        }
    }
    //To remove -1 from the board
     public static void remove(int [][] chessBoard, int n){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(chessBoard[i][j] == -1){
                    chessBoard[i][j] = 0;
                }
            }
        }
     }

    public static void solve(int [][] chessBoard, int n){
        int nqueens = n;
        boolean flag = false;
        for(int i = 0; i < n; i++){
            chessBoard[i][0] = 1;
            boardFill(chessBoard, n, i, 0);
            nqueens--;
            for(int j = 1; j < n; j++){
                for(int k =0; k < n; k++){
                    if(chessBoard[k][j] == 0){
                        chessBoard[k][j] = 1;
                        boardFill(chessBoard,n,k,j);
                        nqueens--;
                    }
                }
            }
            if(nqueens == 0){
                remove(chessBoard,n);
                printBoard(chessBoard,n);
                initBoard(chessBoard, n);
                nqueens = n;
                flag = true;
            }
            else{
                nqueens = n;
                initBoard(chessBoard,n);
            }

        }

            if(!flag){
                System.out.println("There is no valid solution");
            }


    }
}
