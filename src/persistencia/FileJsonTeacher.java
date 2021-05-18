package persistencia;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Teacher;


import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class FileJsonTeacher extends FilePersistence{

    public  void dumpObjects(ArrayList<Teacher> objects) throws IOException {
        Gson jsonPretty = new GsonBuilder().setPrettyPrinting().create();
        String strJson = jsonPretty.toJson(objects);
        writeFile(strJson);

    }
    public ArrayList<Teacher> getTeachers() throws IOException {
        String json = readFile();
        Type type = new TypeToken<ArrayList<Teacher>>(){}.getType();
        ArrayList<Teacher> objects = new Gson().fromJson(json, type);
        return  objects;
    }
}
