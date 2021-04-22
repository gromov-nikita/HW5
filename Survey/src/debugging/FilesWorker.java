package debugging;

import java.io.*;

public class FilesWorker {
    public static void fileCopy(File from, File to) throws IOException {
        writeToFile(to, readFile(from));
    }
    public static byte[] readFile(File file) throws IOException {
        FileInputStream input = null;
        byte[] array = null;
        try {
            input = new FileInputStream(file);
            input.read(array = new byte[input.available()]);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        finally {
            if(input != null) {
                input.close();
            }
        }
        return array;
    }
    public static void writeToFile(File file, byte[] array) throws IOException {
        FileOutputStream output = null;
        try {
            output = new FileOutputStream(file);
            output.write(array);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        finally {
            if(output != null) {
                output.close();
            }
        }
    }
}
