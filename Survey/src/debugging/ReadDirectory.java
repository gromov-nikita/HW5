package debugging;
import java.io.File;
public class ReadDirectory {
    public static void readDirectory() {
        for(File f : new File(".").listFiles()) {
            if(f.isDirectory()) {
                printFileName(f);
                readDirectory(f);
            }
            else {
                printFileName(f);
            }
        }
    }
    private static void readDirectory(File file) {
        for(File f : file.listFiles()) {
            if(f.isDirectory()) {
                readDirectory(f);
            }
            else {
                printFileName(f);
            }
        }
    }
    private static void printFileName(File file) {
        System.out.println(file.getAbsolutePath());
    }
}
