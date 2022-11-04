import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Pawn extends Figure {

    public Pawn(boolean colorWhite) {
        super(colorWhite);
    }

    public void stepFigure(Cell start, Cell end, Cell[][] field){
        List<Cell> list = stepPawn(start,field);
        GameLogic.printStep(list);
        for(Cell cell : list){
            if(cell.getX()==end.getX()&&cell.getY()==end.getY()) {
                field[end.getX()][end.getY()].setFigure(field[start.getX()][start.getY()].getFigure());
                field[start.getX()][start.getY()].setFigure(null);
            }
        }
    }

    public List<Cell> stepPawn(Cell start, Cell[][] field){
        int[][] stepDi = {{1,1},{-1,1},{-1,-1},{1,-1}};
        List<Cell> list = new ArrayList<>();
        if(field[start.getX()][start.getY()].getClass().equals(Square.class)){
            Square square = (Square) start;
            if(square.checkWhite()!=start.getFigure().checkWhite()) oneStep(start,field);
            else {
                Queue<Cell> queue = new LinkedList<>();
                queue.add(start);
                boolean[][] booleans = new boolean[10][10];
                for (int[] ints : stepDi) {
                    stepFromDi(field, queue, ints[0], ints[1], booleans, list);
                    queue.add(start);
                }
            }
        }else {
            oneStep(start,field);
        }
        return list;
    }

    private void stepFromDi(Cell[][] field, Queue<Cell> queue, int stepX, int stepY, boolean[][] booleans, List<Cell> list){
        Cell cell = queue.remove();
        queue.add(cell);
        while(!queue.isEmpty()){
            Cell cellNow = queue.remove();
            int x = cellNow.getX(), y = cellNow.getY();
            if(Edge(x+stepX,y+stepY)&&!booleans[x+stepX][y+stepY]&&field[x][y].getClass().equals(Square.class)){
                if(field[x+stepX][y+stepY].getFigure()!=null) {
                    if(cell.getFigure().checkWhite()!=field[x+stepX][y+stepY].getFigure().checkWhite()) {
                        list.add(field[x + stepX][y + stepY]);
                        queue.add(field[x + stepX][y + stepY]);
                        booleans[x + stepX][y + stepY] = true;
                    }
                    break;
                }else {
                    list.add(field[x + stepX][y + stepY]);
                    queue.add(field[x + stepX][y + stepY]);
                    booleans[x + stepX][y + stepY] = true;
                }
            }
        }
    }
}