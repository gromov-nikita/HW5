import debugging.FilesWorker;
import debugging.ReadDirectory;
import models.Admin;
import models.Manager;
import models.Worker;
import report.Report;
import repositories.UserRepository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Runner {
    public static void main(String[] args) throws IOException, InterruptedException {
        /*
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream("D://readme.txt");
            fileOutputStream = new FileOutputStream("D://writeme.txt");
            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer, 0, buffer.length);
            fileOutputStream.write(buffer, 0, buffer.length);
        }
        catch(IOException e) {
                System.out.println(e.getMessage());
        }
        finally {
            if(fileInputStream != null) {
                fileInputStream.close();
            }
            if(fileOutputStream != null) {
                fileOutputStream.close();
            }
        }
        */
        //File file = new File("D://readme.txt");
        ReadDirectory.readDirectory();
        UserRepository rep = new UserRepository();
        rep.saveUsers(new Admin("Nick1"));
        rep.saveUsers(new Worker("Nick2"));
        rep.saveUsers(new Admin("Nick3"));
        rep.saveUsers(new Worker("Nick4"));
        TimeUnit.SECONDS.sleep(3);
        rep.saveUsers(new Admin("Nick5"));
        rep.saveUsers(new Manager("Nick6"));
        rep.saveUsers(new Admin("Nick7"));
        Report.printReportToFile();
        FilesWorker.fileCopy(new File("src\\from.txt"), new File("src\\to.txt"));

    }
}