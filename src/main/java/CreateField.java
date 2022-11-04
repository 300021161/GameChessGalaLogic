public class CreateField {

    private final static Cell[][] field = new Cell[10][10];

    public Cell[][] create() {
        for (int i = 0; i < field.length; i++) {
            for (int e = 0; e < field[0].length; e++) {
                if ((i > 3 && i < 6) || (e > 3 && e < 6)) {
                    if((i > 3 && i < 6) && (e > 3 && e < 6)) field[i][e] = new Cell(i,e,true);
                    else field[i][e] = new Cell(i,e);
                } else {
                    if(i > 5) field[i][e] = new Square(i,e,true);
                    else field[i][e] = new Square(i,e);
                }
            }
        }

        Arrange();

        return field;
    }

    private static void Arrange() {
        addKing(0, 0);
        addRook(0, 1);
        addElephant(0, 2);
        addPawn(0, 3);
        addPawn(0, 6);
        addRook(0, 7);
        addElephant(0, 8);
        addKing(0,9);
        addRook(1, 0);
        addElephant(1, 1);
        addPawn(1, 2);
        addPawn(1, 7);
        addRook(1, 8);
        addElephant(1, 9);
        addElephant(2, 0);
        addPawn(2, 1);
        addPawn(2, 8);
        addRook(2, 9);
        addPawn(3, 0);
        addPawn(3, 9);

    }

    private static void addKing(int x, int y) {
        field[x][y].chessKing(false);
        Square square = (Square) field[x][y];
        square.HaveChess();
        field[field.length - 1 - x][field.length - 1 - y].chessKing(true);
        square = (Square) field[field.length - 1 - x][field.length - 1 - y];
        square.HaveChess();
    }

    private static void addPawn(int x, int y) {
        field[x][y].chessPawn(false);
        Square square = (Square) field[x][y];
        square.HaveChess();
        field[field.length - 1 - x][field.length - 1 - y].chessPawn(true);
        square = (Square) field[field.length - 1 - x][field.length - 1 - y];
        square.HaveChess();
    }

    private static void addRook(int x, int y) {
        field[x][y].chessRook(false);
        Square square = (Square) field[x][y];
        square.HaveChess();
        field[field.length - 1 - x][field.length - 1 - y].chessRook(true);
        square = (Square) field[field.length - 1 - x][field.length - 1 - y];
        square.HaveChess();
    }

    private static void addElephant(int x, int y) {
        field[x][y].chessElephant(false);
        Square square = (Square) field[x][y];
        square.HaveChess();
        field[field.length - 1 - x][field.length - 1 - y].chessElephant(true);
        square = (Square) field[field.length - 1 - x][field.length - 1 - y];
        square.HaveChess();
    }
}