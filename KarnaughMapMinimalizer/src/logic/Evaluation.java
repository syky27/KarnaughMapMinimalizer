package logic;

import karnaughmapminimalizer.KarnaughMapMinimalizer;

public class Evaluation extends KarnaughMapMinimalizer{
   
    private boolean[][] map;
    private static final int SIZE = 4;

    public Evaluation() {
        map = new boolean[SIZE][SIZE];
    }
    
}