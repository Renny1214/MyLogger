import ConsolePrinting.Console;
import com.sun.org.apache.xpath.internal.objects.XObject;

import java.io.IOException;

public class MyLogger {
    private Console console;
    private String text;
    public MyLogger() throws IOException {
        console = new Console();
    }

    public  void printText(Object... objects) throws IOException {
        text = "log";
        console.consolePrint(objects,text);
    }
    public void debugText(Object... objects) throws IOException {
        text = "debug";
        console.consolePrint(objects,text);
    }
    public void errorText(Object... objects) throws IOException {
        text = "error";
        console.consolePrint(objects,text);
    }
}
