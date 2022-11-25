public class Figure {

    private final boolean whiteColor;

    private final int[][] stepD = {{1,1},{1,-1},{-1,1},{-1,-1}};

    private final int[][] stepC = {{1,0},{0,1},{-1,0},{0,-1}};

    private final int[][] stepO = {{1,1},{1,-1},{-1,1},{-1,-1},{1,0},{0,1},{-1,0},{0,-1}};

    public boolean checkWhite () {return whiteColor;}

    public Figure(boolean colorWhite){
        this.whiteColor = colorWhite;
    }

    public boolean yourAlien(Cell start, Cell end){
        return end.getFigure() == null || (start.getFigure().checkWhite()!=end.getFigure().checkWhite());
    }

    public boolean yourAlien(boolean white, Cell end){
        return end.getFigure() == null || (end.getFigure().checkWhite()!=white);
    }

    public boolean Edge(int i,int e){return i >= 0 && i < 10 && e >= 0 && e < 10;}

    public int[][] getStepD() {return stepD;}

    public int[][] getStepC() {return stepC;}

    public int[][] getStepO() {return stepO;}
}//интерфейс