package generics;

import java.awt.Color;

public class Glove implements Clothing, Colored {
    private int size;
    private Color color;
    
    public Glove(int size, Color color) {
        this.size = size;
        this.color = color;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    @Override
    public int getSize() {
        return size;
    }


    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Glove{" + "size=" + size + ", color=" + color + '}';
    }

    
}
