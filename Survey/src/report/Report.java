package report;

import models.Person;
import repositories.UserRepository;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Report {
    public static void printReportToFile() throws IOException {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(new File("src\\report\\report.txt")));
            writer.write(makeReport());
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        finally {
            if(writer != null) {
                writer.close();
            }
        }
    }
    private static String makeReport() {
        String report = "";
        UserRepository rep = new UserRepository();
        List<Person> persons = rep.findUsers();
        for (Person person : rep.findUsers()) {
            report += "ID : " + person.getId() + " Role : " + person.getRole() + " Name : "
                    + person.getName() + " Date : " + person.getRegistrationDate() + "\n";
        }
        return report;
    }
}
