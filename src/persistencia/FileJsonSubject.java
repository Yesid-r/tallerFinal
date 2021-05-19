package persistencia;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Subject;


import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class FileJsonSubject extends FilePersistence {

    public void dumpObjects(ArrayList<Subject> subjects) throws IOException {
        Gson jsonPretty = new GsonBuilder().setPrettyPrinting().create();
        String strJson = jsonPretty.toJson(subjects);
        writeFile(strJson);
    }
    public ArrayList<Subject> getSubjects() throws IOException {
        String json = readFile();
        Type type = new TypeToken<ArrayList<Subject>>(){}.getType();
        ArrayList<Subject> subjects = new Gson().fromJson(json,type);
        return subjects;
    }

}
