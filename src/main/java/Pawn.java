import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Pawn extends Figure {

    public Pawn(boolean colorWhite) {
        super(colorWhite);
    }

    private boolean[][] booleans;

    public List<Cell> stepPawn(Cell start, Cell[][] field){
        List<Cell> list = new ArrayList<>();
        booleans  = new boolean[10][10];
        if(field[start.getX()][start.getY()].getClass().equals(Square.class)){
            Square square = (Square) start;
            if(square.checkWhite() != start.getFigure().checkWhite()) oneStep(start,field,list);
            else {
                Queue<Cell> queue = new LinkedList<>();
                queue.add(start);
                for (int[] ints : getStepD()) {
                    stepFromDi(field, queue, ints[0], ints[1], list);
                    queue.add(start);
                }
            }
        }else {
            oneStep(start,field,list);
        }
        return list;
    }

    private void stepFromDi(Cell[][] field, Queue<Cell> queue, int stepX, int stepY, List<Cell> list){
        Cell cell = queue.remove();
        queue.add(cell);
        while(!queue.isEmpty()){
            Cell cellNow = queue.remove();
            int x = cellNow.getX(), y = cellNow.getY();
            if(Edge(x+stepX,y+stepY)&&!booleans[x+stepX][y+stepY]&&field[x][y].getClass().equals(Square.class)){
                if(field[x+stepX][y+stepY].getFigure()!=null) {
                    if(cell.getFigure().checkWhite()!=field[x+stepX][y+stepY].getFigure().checkWhite()) {
                        list.add(field[x + stepX][y + stepY]);
                        queue.add(cell);
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

    private void oneStep(Cell start, Cell[][] field,List<Cell> list){
        for(int[] ints : getStepO()){
            if(Edge(start.getX()+ints[0],start.getY()+ints[1]) && yourAlien(start,field[start.getX()+ints[0]][start.getY()+ints[1]])){
                list.add(field[start.getX()+ints[0]][start.getY()+ints[1]]);
            }
        }
    }
}