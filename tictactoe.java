import java.util.Scanner;

class Tictactoe{
    public static void main(String []args){

        char[][] board=new char[3][3];
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[i].length;j++)
                board[i][j]=' ';

        char player='X';
        boolean game=false;
        int count=0;
        Scanner sc=new Scanner(System.in);
        while(!game){
            printboard(board);
            System.out.println("Player "+player+" enter: ");
            int r=sc.nextInt();
            int c=sc.nextInt();
            if(r>2 || c>2){
                System.out.println("Invalid Input as row or col is out of bonds");
                continue;
            }
            if(board[r][c]==' '){
                count++;
                board[r][c]=player;
                game=haveWon(board, player);
                if(game)
                    System.out.println("Player "+player +" has Won!!!!!!");
                else
                    player=((player=='X'?'O':'X'));
            }
            else
                System.out.println("INVALID move, Try Again!");
            if(count==9){
                System.out.println("Game TIED._.");
                break;
            }
            // printboard(board);
        }
        printboard(board);
    }

        public static boolean haveWon(char [][]b, char p){
            
            //rows
            for(int i=0;i<b.length;i++)
                if(b[i][0]==p && b[i][1]==p && b[i][2]==p)
                    return true;

            //columns
            for(int i=0;i<b[0].length;i++)
                if(b[0][i]==p && b[1][i]==p && b[2][i]==p)
                    return true;

            //diagonal
            if((b[0][0]==p && b[1][1]==p && b[2][2]==p) || (b[0][2]==p && b[1][1]==p && b[2][0]==p))
                return true;
                
            return false;
        }

        public static void printboard(char [][]b){
            for(int i=0;i<b.length;i++){
                for(int j=0;j<b[i].length;j++){
                    System.out.print(b[i][j]+" | ");
                }
                System.out.println();
                System.out.println("--+---+---+");
            }
        }

}