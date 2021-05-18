package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public abstract class FilePersistence {
    private Path path;
    private File file;
    private String nameFile;
    private String pathFile;

    public String readFile() throws IOException {

        BufferedReader input = Files.newBufferedReader(path, Charset.defaultCharset());
        StringBuilder output = new StringBuilder();
        String line = null;
        while( ( line = input.readLine()) != null ){
            output.append( line + "\n" );
        }
        input.close();

        return output.toString();

    }

    public  void writeFile(String content) throws IOException{

        BufferedWriter output = Files.newBufferedWriter(path, Charset.defaultCharset(), StandardOpenOption.WRITE, StandardOpenOption.CREATE,StandardOpenOption.TRUNCATE_EXISTING);

        output.write( content );
        output.close();


    }
    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public String getPathFile() {
        return pathFile;
    }

    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }

    public void openFile(){
        path  = Paths.get(pathFile+nameFile);
    }

}
