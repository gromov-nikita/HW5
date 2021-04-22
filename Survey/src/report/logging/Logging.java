package report.logging;

import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Logging {
    private static final String PATH = "src\\report\\logging\\log.txt";
    public String getLogPath() {
        return PATH;
    }
    public static void printLogToFile(String s) throws IOException{
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(new File(PATH),true));
            writer.write(new GregorianCalendar().getTime() + " " + s + "\n");
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
        finally {
            if(writer != null) {
                writer.close();
            }
        }
    }
}
