
public class Main {

    static int N = 8; // variable to store the size chess board 
    static int[][] moves = {{1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}}; //2D array to store all possible moves for the knight

    public static void main(String[] args) {
        int[][] board = new int[N][N]; // 2D array to store the chess board

        //Start off in top left corner
        board[0][0] = 1;

        if (solveKnightTour(board, 0, 0, 1)) {
            printBoard(board);
        } else {
            System.out.println("Solution does not exist");
        }
    }

    // Function to check if the move is valid
    static boolean isValidMove(int x, int y, int[][] board) {
        // Check if the move is within the board
        boolean withinBounds = (x>=0 && x<N && y>=0 && y<N); 
        
        boolean notVisited = (board[x][y] == 0); //Check if the cell is not visited
    }

    // Function to solve the knight tour problem
    static boolean solveKnightTour(int[][] board, int x, int y, int moveCount) {
        // Check if all potential moves are made
        if (moveCount == N * N) { //base case: if all moves are made already.
            return true;
        }
        // Attempt each move
        for (int i = 0; i < 8; i++) {
            int nextX = x + moves[i][0];
            int nextY = y + moves[i][1];

            if (isValidMove(nextX, nextY, board)) {

                board[nextX][nextY] = moveCount + 1;

                boolean isSolved = solveKnightTour(board, nextX, nextY, moveCount + 1);

                if (isSolved) {
                    return true; //Checks if tour is complete, return true
                }
                //backtrack: if the move is not valid, undo the move
                board[nextX][nextY] = 0;

            }
        }
        return false; //return false if no solution is found
    }

    // Function to print the chess board
    static void printBoard(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf("%2d",board[i][j]);
            }
            System.out.println();
        }
    }
}
