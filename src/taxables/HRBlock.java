package taxables;

import java.util.List;

public class HRBlock {
    public static void computeTaxes(List<? extends Taxable> lt) {
        // Notice, assignment of return value of type "?" to a Taxable
        // Must be safe since ? extends Taxable (i.e. ? is assignment compatible
        // to Taxable...
        for (Taxable t : lt) {
            // do taxes for t.
            
        }
        
        // NOT Allowed. Cannot confidently assign Taxable to ?
        // because ? extends Taxable, not the other way round.
        Taxable t;
//        lt.add(t);
    }

    public static void collectClients(List<? super Taxable> lt) {
        // Notice, assignment of return value of type "?" to a Taxable fails!
//        for (Taxable t : lt) {
//            // do taxes for t.
//        }
        
        // This time, this is allowed. Can confidently assign Taxable to ?
        // because ? super Taxable.
        Taxable t = null;
        lt.add(t);
    }

    public static void tryToDoTaxes(List<Taxable> lt) {
        
    }
    
    public static void main(String[] args) {
        List<Person> lp = null;
        // Not allowed, List<Person> is not Liskov substituable for List<Taxable>
//        tryToDoTaxes(lp);
    }
}
