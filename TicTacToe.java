import java.util.Scanner;

 public class TicTacToe { 
   int cols = 3;
   int rows = 3;
   int totalTurns = 0;
   int winner = -1;

   enum GameState {
     OVER, RUNNING
    }
   static GameState currentState = GameState.OVER;
   
   GridSquare[][] board; 
   
   public void setup() { 
     board = new GridSquare[rows][cols];
     int position = 1; 
     for (int r = 0; r < rows; r++) { 
       for (int c = 0; c < cols; c++) { 
         board[r][c] = new GridSquare(position); 
         position++; 
       } 
     }
     currentState = GameState.RUNNING;
     playGame();
   } 

   public void playGame() {
    while (currentState == GameState.RUNNING) {
      displayBoard();
      makeMove();
    }
    if (currentState == GameState.OVER) {
      displayGameOver();
    }
   }

   public void displayBoard() {
    System.out.println("\n  " + board[0][0].drawSpace() + " | " + board[0][1].drawSpace() + "  | " + board[0][2].drawSpace());
    System.out.println(" ___|____|___ ");

    System.out.println("  " + board[1][0].drawSpace() + " | " + board[1][1].drawSpace() + "  | " + board[1][2].drawSpace());
    System.out.println(" ___|____|___ ");

    System.out.println("  " + board[2][0].drawSpace() + " | " + board[2][1].drawSpace() + "  | " + board[2][2].drawSpace());
    System.out.println("    |    |   ");

    System.out.println("\n");    
   }

   public void makeMove() {
     System.out.println("Player " + getPlayer() + " choose a pos: ");
     Scanner in = new Scanner(System.in);
     int spot = in.nextInt();
     
     for (int i = 0; i < cols; i++) {
      for (int j = 0; j < rows; j++) {
        if (board[i][j].state == -1 && board[i][j].pos == spot) {
          board[i][j].state = totalTurns % 2;
          totalTurns++;
          checkWin(i, j, board[i][j].state);
        }
      }
    }
   }

   public void displayGameOver() {
     displayBoard();
     System.out.println("Game Over!");
     
     if (winner == 0) {
      System.out.println("O Wins!");
     }
     if (winner == 1) {
        System.out.println("X Wins!");
     }
     if (totalTurns == 9) {
       if (winner != 0) {
         if (winner != 1) {
           System.out.println("Tie!");
         }
       }
     }
   }
   
  public char getPlayer() {
    if (totalTurns % 2 == 0) {
      return 'O';
    }
    return 'X';
  }

  public void checkWin(int x, int y, int turn) {
      int colWin = 0;
      int rowWin = 0;
      int diag1Win = 0;
      int diag2Win = 0;

     for (int next = 0; next < 3; next++) {
        if (board[x][next].state == turn) {
          colWin++;
        }
        if (board[next][y].state == turn) {
          rowWin++;
        }
        if (board[next][next].state == turn) {
          diag1Win++;
        }
        if (board[next][2 - next].state == turn) {
          diag2Win++;
        }
     }
     
    if (colWin == 3 || rowWin == 3 || diag1Win == 3 || diag2Win == 3) {
      winner = turn;
      if (winner != -1) {
        currentState = GameState.OVER;
      }
    }
    if (totalTurns == 9) {
      currentState = GameState.OVER;
    }
  }
 }
