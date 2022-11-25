import java.util.ArrayList;
import java.util.List;

public class GameLogic {

    public enum GameState {
        NOT_STARTED,
        PLAYING,
        WIN_WHITE,
        WIN_BLACK,
        DRAW
    }

    private boolean twoKingWhite;

    private boolean twoKingBlack;

    private boolean oneKingInCenterWhite;

    private boolean oneKingInCenterBlack;

    public GameState state = GameState.NOT_STARTED;

    private Cell[][] field = null;

    public void NewGame(){
        CreateField createField = new CreateField();
        field = createField.create();
        state = GameState.PLAYING;
        twoKingBlack = true;
        twoKingWhite = true;
        oneKingInCenterBlack = false;
        oneKingInCenterWhite = false;
    }

    public void step(int x,int y,int X,int Y){
        if (field[X][Y].getFigure() != null && field[X][Y].getFigure().getClass().equals(King.class)) stepOnKing(X, Y);
        if(field[x][y].getFigure() != null && field[x][y].getFigure().getClass().equals(King.class)) stepKing(x,y,X,Y);
        field[X][Y].setFigure(field[x][y].getFigure());
        field[x][y].setFigure(null);
    }

    private void stepOnKing(int x,int y){
        if(field[x][y].getFigure().checkWhite()){
            if(twoKingWhite) {
                if(!twoKingBlack) state = GameState.DRAW;
                else twoKingWhite = false;
            }else state = GameState.WIN_BLACK;
        }else{
            if(twoKingBlack) {
                if(!twoKingWhite) state = GameState.DRAW;
                else twoKingBlack = false;
            }else state = GameState.WIN_WHITE;
        }
    }

    private void stepKing(int x,int y,int X,int Y){
        if(field[X][Y].isCenter() && !field[x][y].isCenter()){
            if(field[x][y].getFigure().checkWhite() && twoKingWhite){
                if(oneKingInCenterWhite) state = GameState.WIN_WHITE;
                else oneKingInCenterWhite = true;
            }else if(!field[x][y].getFigure().checkWhite() && twoKingBlack){
                if(oneKingInCenterBlack) state = GameState.WIN_BLACK;
                else oneKingInCenterBlack = true;
            }
        }else{
            if(field[x][y].getFigure().checkWhite()) oneKingInCenterWhite = false;
            else oneKingInCenterBlack = false;
        }
    }

    public List<Cell> sort(int x,int y){
        List<Cell> list = new ArrayList<>();
        if(field[x][y].getFigure()!=null) {
            if (field[x][y].getFigure().getClass().equals(King.class)) {
                King king = (King) field[x][y].getFigure();
                list.addAll(king.stepKing(field[x][y],field));
            }else if(field[x][y].getFigure().getClass().equals(Pawn.class)){
                Pawn pawn = (Pawn) field[x][y].getFigure();
                list.addAll(pawn.stepPawn(field[x][y],field));
            }else if(field[x][y].getFigure().getClass().equals(Elephant.class)) {
                Elephant elephant = (Elephant) field[x][y].getFigure();
                list.addAll(elephant.stepElephant(x,y,field));
            }else if(field[x][y].getFigure().getClass().equals(Rook.class)){
                Rook rook = (Rook) field[x][y].getFigure();
                list.addAll(rook.stepRook(x,y,field));
            }
        }
        return list;
    }

    public Cell[][] getField(){
        return field;
    }
}