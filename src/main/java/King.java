public class King extends Figure {

    public King(boolean colorWhite) {
        super(colorWhite);
    }

    public void stepFigure(Cell start, Cell end, Cell[][] field){
        getList().clear();
        stepKing(start,field);
        GameLogic.printStep(getList());
        for(Cell cell : getList()){
            if(cell.getX()==end.getX()&&cell.getY()==end.getY()) {
                field[end.getX()][end.getY()].setFigure(field[start.getX()][start.getY()].getFigure());
                field[start.getX()][start.getY()].setFigure(null);
            }
        }
    }

    public void stepKing(Cell start, Cell[][] field){
        if(start.isCenter()){
            for (Cell[] cells : field) {
                for (int e = 0; e < field[0].length; e++) {
                    if (cells[e].getClass().equals(Square.class)) {
                        Square square = (Square) cells[e];
                        if (cells[e].getFigure() == null ||
                                (square.checkChess() && square.checkWhite() != cells[e].getFigure().checkWhite())) {
                            getList().add(cells[e]);
                        }
                    } else if (cells[e].getFigure() == null ||
                            (cells[e].getFigure() != null && yourAlien(start, cells[e]))) {
                        getList().add(cells[e]);
                    }
                }
            }
        }else {
            oneStep(start,field);
        }
    }
}