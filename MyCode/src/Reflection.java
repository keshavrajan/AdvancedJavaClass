import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class Reflection {
	public static void foo() throws IllegalArgumentException, IllegalAccessException, ClassNotFoundException, InstantiationException
	{
        String name = "MyClass";
        
        Class cl = Class.forName(name);
        Object o = cl.newInstance();
        
//        if (o instanceof ThingIF) {
//            ThingIF t = (ThingIF)o;
//            ((ThingIF) o).doStuff("Hello");
//        }
        
        Field[] fields = cl.getDeclaredFields();
        for(Field f : fields)
        {
        	System.out.println(">" +f);
        	FieldAnnotation myFieldAnnotation = f.getAnnotation(FieldAnnotation.class);
        	if(myFieldAnnotation != null)
        	{
        		System.out.println("*** Setting Annotated Field\n ***" + f);
        		f.setAccessible(true);
        		f.set(o, "Hello Reflection" + Math.random());
        	}        	
        }
        
        for(Field f : fields)
        {
        	System.out.println("Field : " + f + " has Value : " + f.get(o));
        }

//        Method[] methods = cl.getDeclaredMethods();
//        for (Method m : methods) {
//            System.out.println(">" + m);
//            RunMe myAnnot = m.getAnnotation(RunMe.class);
//            if (myAnnot != null) {
//                System.out.println("*** Annotated RunMe");
//                m.setAccessible(true);
//                m.invoke(o, "Test!");
//            }

	}
}
