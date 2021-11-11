import java.util.Scanner;

public class MineSweeper {

	int rowNumber;
	int columnNumber;
	String[][] board;
	String[][] answerBoard;
	int mineNumber;
	int correctAnswer = 0;
	int selectedRow;
	int selectedColumn;
	int rowMaxLimit;
	int rowMinLimit;
	int columnMaxLimit;
	int columnMinLimit;
	int mineCount;
	
	MineSweeper(int rowNumber, int columnNumber){
		this.rowNumber = rowNumber;
		this.columnNumber = columnNumber;
		this.board = new String[this.rowNumber][this.columnNumber];
		this.answerBoard = new String[this.rowNumber][this.columnNumber];
		this.mineNumber = (this.rowNumber * this.columnNumber) / 4;
	}
	
	void fillBoard() {
		for(int i = 0; i < this.rowNumber; i++) {
			for(int j = 0; j < columnNumber; j++) {
				this.board[i][j] = "-";
				this.answerBoard[i][j] = "-";
			}
		}
	}
	
	
	void placeMines() {
		for(int i = 0; i < this.mineNumber; i++) {
			double row = Math.random() * this.rowNumber;
			double column = Math.random() * this.columnNumber;
			/*if (this.answerBoard[(int) row][(int) column].equals("*")) {
                //i--;
            }*/
            this.answerBoard[(int) row][(int) column] = "*";
		}
	}
	
	void findMines() {
        this.rowMaxLimit = this.selectedRow + 1;
        this.rowMinLimit = this.selectedRow - 1;
        this.columnMaxLimit = this.selectedColumn + 1;
        this.columnMinLimit = this.selectedColumn - 1;

       if (this.rowMinLimit < 0) {
            this.rowMinLimit++;
        }
        if (this.rowMaxLimit > this.answerBoard[0].length - 1) {
            this.rowMaxLimit--;
        }
        if (this.columnMinLimit < 0) {
            this.columnMinLimit++;
        }
        if (this.columnMaxLimit > this.answerBoard.length - 1) {
            this.columnMaxLimit--;
        }

       for (int i = this.rowMinLimit; i <= this.rowMaxLimit; i++) {
            for (int j = this.columnMinLimit; j <= this.columnMaxLimit; j++) {
                if (this.answerBoard[i][j].equals("*")) {
                    this.mineCount++;
                }
            }
        }
        this.board[this.selectedRow][this.selectedColumn] = Integer.toString(this.mineCount);
        this.mineCount = 0;

    }
	void showBoard() {
		for(int i = 0; i < this.rowNumber; i++) {
			for(int j = 0; j < this.columnNumber; j++) {
				System.out.print(this.board[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	void showAnswerBoard() {
		System.out.println("Location of Mines");
		for(int i = 0; i < this.rowNumber; i++) {
			for(int j = 0; j < this.columnNumber; j++) {
				System.out.print(this.answerBoard[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	void run() {
		Scanner scan = new Scanner(System.in);
		
		fillBoard();
		placeMines();
		//showAnswerBoard();
		
		System.out.println("Welcome to Minefield Game");

		while(this.correctAnswer < (this.rowNumber * this.columnNumber) - this.mineNumber) {
			System.out.println("--------------------------");
			showBoard();
			
			System.out.print("Enter your selected row : ");
			this.selectedRow = scan.nextInt();
			System.out.print("Enter your selected column : ");
			this.selectedColumn = scan.nextInt();
			
			if(this.selectedRow >= 0 && this.selectedRow < this.board[0].length) {
				if(this.selectedColumn >= 0 && this.selectedColumn < this.board.length) {
					findMines();
					this.correctAnswer++;
					
					if(this.correctAnswer == (this.rowNumber * this.columnNumber) - this.mineNumber) {
						System.out.println("Congrats! You win! :)");
					}else if(this.answerBoard[this.selectedRow][this.selectedColumn].equals("*")) {
						showAnswerBoard();
						System.out.println("Gameover :( You lose!");
						break;
					}
				}else {
					System.out.println("Enter an available number!");
				}
			}else {
				System.out.println("Enter an available number!");
			}
		}
		
		
	}
}
