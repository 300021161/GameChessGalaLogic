public class litter {
    /*
    private void stepInCr(Queue<Cell> queue, int stepX, int stepY, boolean white){
        while(!queue.isEmpty()){
            Cell cellNow = queue.remove();
            int x = cellNow.getX(), y = cellNow.getY();
            if(Edge(x+stepX,y+stepY)&&!booleans[x+stepX][y+stepY]&&!field[x][y].getClass().equals(Square.class)&&
                    !field[x+stepX][y+stepY].getClass().equals(Square.class)){
                if(field[x+stepX][y+stepY].getFigure()!=null) {
                    if(yourAlien(white,field[x+stepX][y+stepY])) {
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

    private void stepInDi(Queue<Cell> queue, int stepX, int stepY, boolean white){
        while(!queue.isEmpty()){
            Cell cellNow = queue.remove();
            int x = cellNow.getX(), y = cellNow.getY();
            if(Edge(x+stepX,y+stepY)&&!booleans[x+stepX][y+stepY]&&field[x][y].getClass().equals(Square.class)&&
                    field[x+stepX][y+stepY].getClass().equals(Square.class)){
                if(field[x+stepX][y+stepY].getFigure()!=null) {
                    if(yourAlien(white,field[x+stepX][y+stepY])) {
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

    private void stepFromCr(Queue<Cell> queue, int stepX, int stepY){
        Cell cell = queue.remove();
        queue.add(cell);
        while(!queue.isEmpty()){
            Cell cellNow = queue.remove();
            int x = cellNow.getX(), y = cellNow.getY();
            if(Edge(x+stepX,y+stepY)&&!booleans[x+stepX][y+stepY]&&!field[x][y].getClass().equals(Square.class)){
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

    private void stepFromDi(Queue<Cell> queue, int stepX, int stepY,boolean white){
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
     */
}
