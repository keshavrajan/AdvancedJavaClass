package generics;

import java.awt.Color;

public class ClothingStore {
    public static void main(String[] args) {
        Pair<Glove> pg = new Pair<>(new Glove(8, Color.RED), new Glove(9, Color.RED));
//        pg.setLeft("");

        System.out.println("pair is" + (pg.isMatched()? "" : "n't")  + " matched");
        
//        Pair<String> ps;
    }
}
