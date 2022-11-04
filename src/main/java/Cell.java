public class Cell{
    private Figure figure = null;

    private final int x;

    private final int y;

    private boolean center = false;

    public boolean isCenter() {
        return center;
    }

    public void setFigure(Figure figure){
        this.figure = figure;
    }

    public Cell(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Cell(int x, int y, boolean center){
        this.x = x;
        this.y = y;
        this.center = center;
    }

    public Figure getFigure() {
        return figure;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void chessKing(boolean whiteColor){figure = new King(whiteColor);}

    public void chessPawn(boolean whiteColor){figure = new Pawn(whiteColor);}

    public void chessRook(boolean whiteColor){figure = new Rook(whiteColor);}

    public void chessElephant(boolean whiteColor){figure = new Elephant(whiteColor);}
}