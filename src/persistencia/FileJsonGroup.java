package persistencia;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Group;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class FileJsonGroup extends FilePersistence{

    public void dumpObjects(ArrayList<Group> groups) throws IOException {
        Gson jsonPretty = new GsonBuilder().setPrettyPrinting().create();
        String strJson = jsonPretty.toJson(groups);
        writeFile(strJson);
    }
    public ArrayList<Group> getGroups() throws IOException {
        String json = readFile();
        Type type = new TypeToken<ArrayList<Group>>(){}.getType();
        ArrayList<Group> groups = new Gson().fromJson(json,type);
        return groups;
    }

}
