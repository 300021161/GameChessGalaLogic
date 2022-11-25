import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Rook extends Figure {

    private boolean[][] booleans;

    private Cell[][] field;

    public Rook(boolean colorWhite) {
        super(colorWhite);
    }

    public List<Cell> stepRook(int x, int y, Cell[][] f){
        List<Cell> list = new ArrayList<>();
        booleans = new boolean[10][10];
        this.field = f;
        Queue<Cell> queue = new LinkedList<>();
        queue.add(field[x][y]);
        booleans[x][y] = true;
        int size = 0;
        boolean white = field[x][y].getFigure().checkWhite();
        if(field[x][y].getClass().equals(Square.class)) {
            for(int[] ints : getStepC()){
                if(Edge(x + ints[0], y + ints[1])) {
                    if (!field[x + ints[0]][y + ints[1]].getClass().equals(Square.class) &&
                            yourAlien(white, field[x + ints[0]][y + ints[1]])) {
                        list.add(field[x + ints[0]][y + ints[1]]);
                        booleans[x + ints[0]][y + ints[1]] = true;
                        Cell cellNow = field[x + ints[0]][y + ints[1]];
                        if(field[cellNow.getX()][cellNow.getY()].getFigure()==null) {
                            for (int[] val : getStepD()) {
                                queue.add(cellNow);
                                testStep(queue, val[0], val[1], white,true,false,list);
                            }
                        }
                    } else if (field[x + ints[0]][y + ints[1]].getClass().equals(Square.class)) {
                        testStep(queue, ints[0], ints[1], white,true,true,list);
                        if (size != list.size() && list.get(list.size() - 1).getFigure() == null) {
                            Cell cellNow = list.get(list.size() - 1);
                            for (int[] val : getStepD()) {
                                if(Edge(cellNow.getX() + val[0], cellNow.getY() + val[1])&& (
                                        field[cellNow.getX() + val[0]][cellNow.getY() + val[1]].getFigure() == null ||
                                                yourAlien(white,field[cellNow.getX() + val[0]][cellNow.getY() + val[1]])) &&
                                        !field[cellNow.getX()][cellNow.getY()].getClass().equals(Square.class)&&
                                        !field[cellNow.getX() + val[0]][cellNow.getY() + val[1]].getClass().equals(Square.class)) {
                                    list.add(field[cellNow.getX() + val[0]][cellNow.getY() + val[1]]);
                                    booleans[cellNow.getX() + val[0]][cellNow.getY() + val[1]] = true;
                                }
                            }
                        }
                    }
                    queue.clear();
                    queue.add(field[x][y]);
                    size = list.size();
                }
            }
        }else {
            for(int[] ints : getStepD()){
                if(Edge(x + ints[0], y + ints[1])) {
                    if (field[x + ints[0]][y + ints[1]].getClass().equals(Square.class) &&
                            yourAlien(white, field[x + ints[0]][y + ints[1]])) {
                        list.add(field[x + ints[0]][y + ints[1]]);
                        booleans[x + ints[0]][y + ints[1]] = true;
                        Cell cellNow = field[x + ints[0]][y + ints[1]];
                        if(field[cellNow.getX()][cellNow.getY()].getFigure()==null) {
                            for (int[] val : getStepC()) {
                                queue.add(cellNow);
                                testStep(queue, val[0], val[1], white,false,true,list);
                            }
                        }
                    } else if (!field[x + ints[0]][y + ints[1]].getClass().equals(Square.class)) {
                        testStep(queue, ints[0], ints[1],white,false,false,list);
                        if (size != list.size() && list.get(list.size() - 1).getFigure() == null) {
                            Cell cellNow = list.get(list.size() - 1);
                            for (int[] val : getStepC()) {
                                if (Edge(cellNow.getX() + val[0], cellNow.getY() + val[1]) && (
                                        field[cellNow.getX() + val[0]][cellNow.getY() + val[1]].getFigure() == null ||
                                                yourAlien(white, field[cellNow.getX() + val[0]][cellNow.getY() + val[1]])) &&
                                        field[cellNow.getX()][cellNow.getY()].getClass().equals(Square.class) &&
                                        field[cellNow.getX() + val[0]][cellNow.getY() + val[1]].getClass().equals(Square.class)) {
                                    list.add(field[cellNow.getX() + val[0]][cellNow.getY() + val[1]]);
                                    booleans[cellNow.getX() + val[0]][cellNow.getY() + val[1]] = true;
                                }
                            }
                        }
                    }
                    queue.clear();
                    queue.add(field[x][y]);
                    size = list.size();
                }
            }
        }
        return list;
    }

    private boolean ifCheck(boolean startFromSq,boolean endInSq,int x,int y,int stepX,int stepY){
        if(startFromSq && endInSq){
            return field[x][y].getClass().equals(Square.class);
        }else if(startFromSq){
            return !field[x][y].getClass().equals(Square.class) && !field[x + stepX][y + stepY].getClass().equals(Square.class);
        }else if(!endInSq){
            return !field[x][y].getClass().equals(Square.class);
        }else {
            return field[x][y].getClass().equals(Square.class )&& field[x+stepX][y+stepY].getClass().equals(Square.class);
        }
    }

    private void testStep(Queue<Cell> queue, int stepX, int stepY,boolean white, boolean startFromSq,boolean endInSq,List<Cell> list) {
        while (!queue.isEmpty()) {
            Cell cellNow = queue.remove();
            int x = cellNow.getX(), y = cellNow.getY();
            if (Edge(x + stepX, y + stepY) && !booleans[x + stepX][y + stepY] &&
                    ifCheck(startFromSq, endInSq, x, y, stepX, stepY)) {
                if (field[x + stepX][y + stepY].getFigure() != null) {
                    if (white != field[x + stepX][y + stepY].getFigure().checkWhite()) {
                        list.add(field[x + stepX][y + stepY]);
                        queue.add(field[x + stepX][y + stepY]);
                        booleans[x + stepX][y + stepY] = true;
                    }
                    queue.clear();
                    break;
                } else {
                    list.add(field[x + stepX][y + stepY]);
                    queue.add(field[x + stepX][y + stepY]);
                    booleans[x + stepX][y + stepY] = true;
                }
            }
        }
    }
}