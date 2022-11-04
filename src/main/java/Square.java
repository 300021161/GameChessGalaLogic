public class Square extends Cell {
    private boolean CellColor = false;
    private boolean InBeginHaveCell = false;

    public Square(int x, int y) {
        super(x, y);
    }

    public Square(int x, int y,boolean white) {
        super(x, y);
        this.CellColor = white;
    }

    public boolean checkWhite() {return CellColor;}
    public void HaveChess(){
        InBeginHaveCell = true;
    }

    public boolean checkChess(){
        return InBeginHaveCell;
    }
}