import java.util.ArrayList;
import java.util.List;

public class King extends Figure {

    public King(boolean colorWhite) {super(colorWhite);}

    public List<Cell> stepKing(Cell start, Cell[][] field){
        List<Cell> list = new ArrayList<>();
        if(start.isCenter()){
            for (Cell[] cells : field) {
                for (int e = 0; e < field[0].length; e++) {
                    if (cells[e].getClass().equals(Square.class)) {
                        Square square = (Square) cells[e];
                        if((!square.checkChess() && (square.getFigure()==null ||
                                (square.getFigure()!=null && (square.getFigure().checkWhite() != start.getFigure().checkWhite())))))
                            list.add(cells[e]);
                    } else if (cells[e].getFigure() == null ||
                            (cells[e].getFigure() != null && start.getFigure().checkWhite() != cells[e].getFigure().checkWhite())) {
                        list.add(cells[e]);
                    }
                }
            }
        }else {
            oneStep(start,field,list);
        }
        return list;
    }

    private void oneStep(Cell start, Cell[][] field,List<Cell> list){
        for(int[] ints : getStepO()){
            if(Edge(start.getX()+ints[0],start.getY()+ints[1]) && yourAlien(start,field[start.getX()+ints[0]][start.getY()+ints[1]])){
                list.add(field[start.getX()+ints[0]][start.getY()+ints[1]]);
            }
        }
    }
}