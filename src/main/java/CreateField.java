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
        addKing(0, 0,false);
        addKing(9, 0, true);
        addRook(0, 1,false);
        addRook(0, 7,false);
        addRook(1, 8,false);
        addRook(2, 9,false);
        addElephant(0, 2,false);
        addElephant(8,0,true);
        addElephant(9,1,true);
        addPawn(0, 3, false);
        addPawn(6,0,true);
        addPawn(7,1,true);
        addPawn(8,2,true);
        addPawn(9,3,true);
        addPawn(0, 6,false);
        addPawn(6,9,true);
        addPawn(7,8,true);
        addPawn(8,7,true);
        addPawn(9,6,true);
        addRook(8,9,true);
        addRook(9, 8,true);
        addElephant(0, 8,false);
        addElephant(7,9,true);
        addElephant(8,8,true);
        addElephant(9,7,true);
        addKing(0,9,false);
        addKing(9,9,true);
        addRook(7,0,true);
        addRook(8,1,true);
        addRook(9,2,true);
        addRook(1, 0,false);
        addRook(1, 9,true);
        addElephant(1, 1,false);
        addPawn(1, 2,false);
        addPawn(1, 7,false);
        addElephant(1, 9,false);
        addElephant(2, 0,false);
        addPawn(2, 1,false);
        addPawn(2, 8,false);
        addPawn(3, 0,false);
        addPawn(3,9,false);
    }

    private static void addKing(int x, int y, boolean color) {
        field[x][y].setFigure(new King(color));
        Square square = (Square) field[x][y];
        square.HaveChess();
    }

    private static void addPawn(int x, int y, boolean color) {
        field[x][y].setFigure(new Pawn(color));
        Square square = (Square) field[x][y];
        square.HaveChess();
    }

    private static void addRook(int x, int y,boolean color) {
        field[x][y].setFigure(new Rook(color));
        Square square = (Square) field[x][y];
        square.HaveChess();
    }

    private static void addElephant(int x, int y,boolean color) {
        field[x][y].setFigure(new Elephant(color));
        Square square = (Square) field[x][y];
        square.HaveChess();
    }
}