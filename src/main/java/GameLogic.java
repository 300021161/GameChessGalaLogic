import java.util.List;

public class GameLogic {

    public static void main(String[] args) {
        CreateField createField = new CreateField();
        Cell[][] field = createField.create();
        field[3][3].setFigure(new King(true));
        sort(3,3,4,4,field);
        sort(4,4,9,4,field);
        sort(9,4,0,9,field);
        printField(field);
    }

    public static void sort(int x,int y,int xE, int yE, Cell[][] field){
        if(field[x][y].getFigure()!=null) {
            if (field[x][y].getFigure().getClass().equals(King.class)) {
                King king = (King) field[x][y].getFigure();
                king.stepFigure(field[x][y],field[xE][yE],field);
            }else if(field[x][y].getFigure().getClass().equals(Pawn.class)){
                Pawn pawn = (Pawn) field[x][y].getFigure();
                pawn.stepFigure(field[x][y],field[xE][yE],field);
            }else if(field[x][y].getFigure().getClass().equals(Elephant.class)) {
                Elephant elephant = (Elephant) field[x][y].getFigure();
                elephant.stepFigure(field[x][y],field[xE][yE],field);
            }else if(field[x][y].getFigure().getClass().equals(Rook.class)){
                Rook rook = (Rook) field[x][y].getFigure();
                rook.stepFigure(field[x][y],field[xE][yE],field);
            }
        }
    }

    public static void printField(Cell[][] field){
        for(int i = 0; i < 10;i++){
            for(int e = 0;e < 10; e ++){
                if(field[i][e].getFigure()!=null) {
                    if (field[i][e].getFigure().getClass().equals(King.class)) System.out.print("k ");
                    else if (field[i][e].getFigure().getClass().equals(Pawn.class)) System.out.print("p ");
                    else if (field[i][e].getFigure().getClass().equals(Rook.class)) System.out.print("r ");
                    else if (field[i][e].getFigure().getClass().equals(Elephant.class)) System.out.print("e ");
                }
                else System.out.print("- ");
            }
            System.out.println();
        }
    }

    public static void printStep(List<Cell> list){
        System.out.println(list.size());
        boolean[][] b = new boolean[10][10];
        for(Cell cell : list) b[cell.getX()][cell.getY()] = true;
        for(int i = 0; i < 10; i ++){
            for (int e = 0; e < 10; e++){
                if(b[i][e]) System.out.print("* ");
                else System.out.print("- ");
            }
            System.out.println();
        }
    }
}