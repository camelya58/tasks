package exceptions;

import java.io.Closeable;

/**
 * Class MultipleExceptionsExample demonstrates suppressing and replacing of the exceptions.
 *
 * @author Kamila Meshcheryakova
 * created by 03.02.2021
 */
public class MultipleExceptionsExample {


    static class IOManip implements Closeable {
        @Override
        public void close() {
            throw new RuntimeException("from IOManip.close");
        }
    }

    public static void main(String[] args) {
        try(IOManip ioManip = new IOManip()){ // the exception from close() has suppressed in try-with-resources
            throw new RuntimeException("from try!");
        }catch(Exception e){
            throw new RuntimeException("from catch!");
        }
        finally{
            throw new RuntimeException("from finally!");
        }
    }
}
/* output:
Exception in thread "main" java.lang.RuntimeException: from finally!
	at exceptions.MultipleExceptionsExample.main(MultipleExceptionsExample.java:29)

without finally:
Exception in thread "main" java.lang.RuntimeException: from catch!
	at exceptions.MultipleExceptionsExample.main(MultipleExceptionsExample.java:27)

without finally and catch:
Exception in thread "main" java.lang.RuntimeException: from try!
	at tasks.Main.main(Main.java:25)
	Suppressed: java.lang.RuntimeException: from IOManip.close
		at tasks.Main$IOManip.close(Main.java:17)
		at tasks.Main.main(Main.java:24)
 */