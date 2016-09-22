package dynamic;

import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Properties;

public class Reflect {

    public static void main(String[] args) throws Throwable {
        // Note, security manager can prevent the suppressing of access checks
//        System.setSecurityManager(new SecurityManager());

        Properties p = new Properties();
        p.load(new FileReader("keys.txt"));

        String name = "dynamic.Thing";

        Class cl = Class.forName(name);
        Object o = cl.newInstance();

//        if (o instanceof ThingIF) {
//            ThingIF t = (ThingIF)o;
//            ((ThingIF) o).doStuff("Hello");
//        }
        Method[] methods = cl.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println(">" + m);
            RunMe myAnnot = m.getAnnotation(RunMe.class);
            if (myAnnot != null) {
                System.out.println("*** Annotated RunMe");
                m.setAccessible(true);
                m.invoke(o, p.get(myAnnot.value()));
            }
        }
    }
}
