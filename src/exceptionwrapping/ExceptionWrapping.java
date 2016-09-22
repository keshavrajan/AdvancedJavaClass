package exceptionwrapping;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;


interface EFunction<E,F> {
    F apply(E e) throws Throwable;
}

public class ExceptionWrapping {
    public static <E,F> Function<E,Optional<F>> wrap(EFunction<E,F> fn) {
        return e->{
            Optional<F> rv;
            try {
                rv = Optional.of(fn.apply(e));
            } catch (Throwable t) {
                System.err.println("Exception being wrapped " + t);
                rv = Optional.empty();
            }
            return rv;
        };
    } 
    
    public static void main(String[] args) {
        Stream.of("this.txt", "that.txt", "theOther.txt")
                .map(wrap(p->Files.lines(Paths.get(p))))
                .peek(o->{ if (!o.isPresent()) System.err.println("got a dead file");})
                .filter(Optional::isPresent)
                .map(Optional::get)
                .flatMap(Function.identity())
                .forEach(System.out::println);
    }
}
