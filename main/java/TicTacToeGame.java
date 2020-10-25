
import java.util.*;
public class TicTacToeGame {
    static Scanner in = new Scanner(System.in);
    static char playerLetter;
    static char compLetter;
    public static void main(String args[]) {
        System.out.println("Welcome to Tic Tac Toe Game");
        char board[] = createBoard();
        playerLetter = chooseLetter();
        if(playerLetter=='X')
            compLetter = 'O';
        else
            compLetter = 'X';
        System.out.println("Player: "+playerLetter+" Computer: "+compLetter);
        System.out.println("Current Board: ");
        showBoard(board);
        int tossWinner = toss();
    }

    public static char[] createBoard()
    {
        char board[] = new char[10];
        for(char charValue : board)
            charValue = ' ';
        return board;
    }

    public static char chooseLetter()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Choose X or O: ");
        char letterChoice = in.next().charAt(0);
        return letterChoice;
    }

    private static void showBoard(char board[])
    {
        for(int index=1; index<board.length; index++)
        {
            if(index%3==0)
                System.out.println(board[index]);
            else
                System.out.print(board[index] + ",");
        }
    }

    private static void makePlayerMove(char board[], char playerLetter)
    {
        Scanner in = new Scanner(System.in);
        int indexChoice;
        do
        {
            System.out.print("Select index between 1 and 9: ");
            indexChoice = in.nextInt();
            in.nextLine();
            if(isFreeIndex(indexChoice, board) == false)
                System.out.println("Index already filled");
            else
            {
                board[indexChoice] = playerLetter;
                return;
            }
        }while(board[indexChoice]!=' ');
    }

    private static boolean isFreeIndex(int index, char board[])
    {
        if(board[index]=='X' || board[index]=='O')
            return false;
        else
            return true;
    }
    
    private static int toss()
    {
        int randomNo = (int) (Math.random()*10)%2;
        if(randomNo==0)
            System.out.println("User won the toss.");
        else
            System.out.println("Computer won the toss.");
        return randomNo;
    }
}
