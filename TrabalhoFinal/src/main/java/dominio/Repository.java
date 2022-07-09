package dominio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

// responsabilidade: gravar e recuperar objetos salvaveis em arquivo de texto
public abstract class Repository {
    private String fileName;
    private File file;
    private FileWriter writer;
    private BufferedWriter bWriter;
    private FileReader reader;
    private BufferedReader bReader;

    public Repository(String fileName) {
        this.fileName = fileName;
    }

    public final void deleteFile() {
        file = new File(fileName);
        if (file.exists())
            file.delete();
    }

    private void openToWrite() throws IOException {
        file = new File(fileName);
        if (!file.exists())
            file.createNewFile();

        writer = new FileWriter(file, true);
        bWriter = new BufferedWriter(writer);
    }

    private void closeToWrite() throws IOException {
        bWriter.close();
        writer.close();
    }

    public final void writeObject(Salvable objSalvable) {
        try {
            openToWrite();
            bWriter.write(objSalvable.formatted());
            bWriter.newLine();
            closeToWrite();
        } catch(IOException ex) {
            ex.printStackTrace();
        }

    }

    private void openToRead() throws IOException {
        file = new File(fileName);
        if (!file.exists())
            file.createNewFile();

        reader = new FileReader(file);
        bReader = new BufferedReader(reader);
    }

    private void closeToRead() throws IOException {
        bReader.close();
        reader.close();
    }

    protected abstract Salvable getObject(String line) throws IllegalArgumentException;

    public final ArrayList<Salvable> readFile() {
        ArrayList<Salvable> salvables = new ArrayList<Salvable>();

        try {
            openToRead();

            while(bReader.ready()) {
                try {
                    Salvable salv = getObject(bReader.readLine());
                    salvables.add(salv);
                }catch(Exception ex) {
                    ex.printStackTrace();
                }
            }

            closeToRead();
        } catch(Exception ex) {
            ex.printStackTrace();
        }

        return salvables;
    }
}
