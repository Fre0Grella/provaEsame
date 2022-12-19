package a04.e2;

import java.util.ArrayList;
import java.util.List;

public class LogicImpl implements Logic{

    private int count;
    private int size;
    private List<Pair<Integer, Integer>> buttonPosList;

    public LogicImpl(int size) {
        this.count = 0;
        this.size = size;
        buttonPosList = new ArrayList<>();
    }

    @Override
    public boolean isOver() {
        return buttonPosList.size() == size*size ? true : false;
    }

    @Override
    public boolean isFirst() {
        return count == 1 ? true : false;
    }

    @Override
    public boolean isValid(int x, int y) {
        count++;
        if (isFirst()) {
            buttonPosList.add(new Pair<Integer,Integer>(x, y));
        }
        return isFirst() || isNeighbour(x, y) ? true : false;
    }

    @Override
    public boolean isNeighbour(int x, int y) {
            int ny = -1;
            int nx = -1;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++ ){
                    for (Pair<Integer, Integer> pos : buttonPosList) {
                        if(pos.getX() == x+nx && pos.getY() == y+ny) {
                            buttonPosList.add(new Pair<Integer,Integer>(x, y));
                            return true;
                        }
                    }
                    nx++;
                }
                nx=-1;
                ny++;
            }
        return false;
    }
    
}
