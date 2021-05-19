package persistencia;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Student;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class FileJsonStudent extends FilePersistence{


    public  void dumpObjects(ArrayList<Student> students) throws IOException {

        Gson jsonPretty = new GsonBuilder().setPrettyPrinting().create();
        String strJson = jsonPretty.toJson(students);
        writeFile(strJson);

    }
    public ArrayList<Student> getObjects() throws IOException {

        String json = readFile();
        Type type = new TypeToken<ArrayList<Student>>(){}.getType();
        ArrayList<Student> students = new Gson().fromJson(json,type);
        return students;


    }
}
