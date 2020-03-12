package ConsolePrinting;

import FilePrinting.File;
import GetTime.Time;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Console {

    private BufferedWriter bufferedWriter;
    private StringBuilder stringBuilder;
    private File file;

    public Console() throws IOException{
        bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        file = new File();

    }
    public void consolePrint(Object[] object, String log) throws IOException {
        Time time = new Time();
        stringBuilder = new StringBuilder();
        String date = time.getDate();

        stringBuilder.append(date).append(" ").append(log).append(" ");

        for(int i=0;i<object.length;i++)
        {
            stringBuilder.append(object[i]).append(" ");
        }
        stringBuilder.append(file.saveData(stringBuilder.toString()));
        stringBuilder.append("\n");

        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
    }
}
