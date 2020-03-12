package FilePrinting;

import java.io.*;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class File {

    private ArrayList<String> location;
    private ArrayList<String> dataType;

    public File() throws IOException {
        location = new ArrayList<>();
        dataType = new ArrayList<>();

        getLocation();
    }
    public String saveData(String data) throws IOException {
        String result= "";

        for(int i=0;i<this.location.size();i++)
        {
            FileWriter fileWriter = new FileWriter(this.location.get(i)+"."+this.dataType.get(i),true
            );
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter) ;
            if(this.dataType.get(i).equals("txt")){
                result = saveDataAsText(bufferedWriter,data);
            }
            else
            {
                result = saveDataAsHTML(bufferedWriter,data);
            }
        }

        return result;
    }

    private String saveDataAsHTML(BufferedWriter bufferedWriter, String data) throws IOException {
        bufferedWriter.append("<p>");
        bufferedWriter.append(data);
        bufferedWriter.append("</p>");

        bufferedWriter.flush();

        return "Logs stored in "+location;
    }

    private String saveDataAsText(BufferedWriter bufferedWriter, String data) throws IOException {
        bufferedWriter.newLine();
        bufferedWriter.append(data);
        bufferedWriter.flush();

        return " Logs stored in "+location;
    }


    private void getLocation() throws IOException{
        final  String configFile="/MyLogger.json";
        final String configLocation = "logger.location";
        final String typeString  = "logger.fileType";

        InputStream inputStream = File.class.getResourceAsStream(configFile);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream
        ));
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while((line=bufferedReader.readLine())!=null){
            stringBuilder.append(line);
        }

        JSONArray jsonarray = new JSONArray(stringBuilder.toString());
        for(int i=0;i<jsonarray.length();i++)
        {
            JSONObject jsonObject = jsonarray.getJSONObject(i);
            this.location.add(jsonObject.getString(configLocation));
            this.dataType.add(jsonObject.getString(typeString));
        }


    }

}
