public class mainclass {

	public static void main(String[] args) {
		// the strategy is to have an int array with 8 numbers in it,
		// representing the row number of that specific pawn
		int[] pawns = new int[8];
		for (int i = 0; i < pawns.length; i++) {
			pawns[i] = -1;
		}
		pawns[0]=0;
		outputBoard(pawns);
		checkIfValid(pawns, 0);

	}

	public static void checkIfValid(int[] pawns, int curPawn) {
		// this method will check if the current arrangement is valid, by making
		// sure current pawn is not
		// at fault. if it is, it will increase it's row by 1, and move to next
		// column. If it's not, it will increase
		// it's row by 1 and move to next column. If the row number reaches 8,
		// it will delete, previous pawn will increment by 1.
		// if column reaches 8 will output
		// boolean isValid = false;
		System.out.println("starting");

		if (horizontalValid(pawns, curPawn) && diagonalValid(pawns, curPawn)) {
			System.out.println("all valid");
			// valid board and filled
			if (curPawn == 7) {
				outputBoard(pawns);
			} else {
				// valid and unfilled
				curPawn++;
				pawns[curPawn]++;
				checkIfValid(pawns, curPawn);
			}

		} else {
			// invalid placed rightmost pawn, edit position
			System.out.println("invalid");
			outputBoard(pawns);
			int checkme = ++pawns[curPawn];
			outputBoard(pawns);
			System.out.println(checkme +" is checkme");
			// see if you went off the board
			if (checkme == 8) {
				pawns[curPawn] = -1;
				curPawn--;
				pawns[curPawn]++;
				
			}
			checkIfValid(pawns, curPawn);

		}

	}

	private static void outputBoard(int[] pawns) {
		// TODO Auto-generated method stub
		for (int i = 0; i < pawns.length; i++) {
			// iterate through columns
			int pawnRow = pawns[i];
			if(pawnRow!=-1){
			for (int j = 0; j < pawnRow; j++) {
				System.out.print("_ ");
			}
			System.out.print("Q ");
			for (int j = pawnRow + 1; j < 8; j++) {
				System.out.print("_ ");
			}
			}else{
				System.out.print("_ _ _ _ _ _ _ _ ");
			}
			System.out.print("\n");

		}
	}

	static boolean horizontalValid(int[] pawns, int curPawn) {
		// row that rightmost pawn is held
		int curRow = pawns[curPawn];

		for (int i = 0; i < curPawn; i++) {
			if (pawns[i] == curRow)
				return false;
		}
		System.out.println("horiz valid");
		return true;
		
	}

	static boolean diagonalValid(int[] pawns, int curPawn) {
		// each pawn can intersect with curPawn in 2 ways, going up and right,
		// or down and right

		// up and right intersection
		for (int i = 0; i < curPawn; i++) {
			// the position curPawn needs to be in for it to be invalid is
			// pawns[i] + curPawn - i.
			if (pawns[curPawn] == pawns[i] + curPawn - i) {
				return false;
			} else if (pawns[curPawn] == pawns[i] - curPawn + i) {
				return false;
			}

		}
		return true;

	}
}
