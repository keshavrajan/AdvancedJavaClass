package dynamic;


public class Thing implements ThingIF {
    private int x;
    
    public void doYetOtherStuff(String s) {
        System.out.println("doYetOtherStuff got " + s);
    }
    
    @RunMe(value="one", count=1)
    private void doOtherStuff(String s) {
        System.out.println("doOtherStuff got " + s);
    }
    
    @RunMe("Jim")
    public void doStuff(String s) {
        System.out.println("doStuff got " + s);
    }

    @Override
    public String toString() {
        return "Thing{" + "x=" + x + '}';
    }
    
    public Thing() {}
}
