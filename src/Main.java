import javax.xml.crypto.Data;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

       // User user = new User("William", "123", 23, "Male", 178, 78);
        //User user1 = new User("Jeppe", "123", 23, "Male", 187, 102);
        CPHFitness cphFitness = new CPHFitness();
        // CPHFitnessApp cphFitnessApp = new CPHFitnessApp();



        Connection conn = DatabaseHandler.connect();
        if (conn != null) {
            // Opret brugertabellen, hvis den ikke allerede eksisterer
            DatabaseHandler.createUserTable(conn);

            // Opret brugere
            User user = new User("William22", "123", 23, "Male", 178, 78);
            User user1 = new User("Jeppe", "123", 23, "Male", 187, 102);

            // Gem brugerne i databasen
            user.save();  // Gemme brugeren via User objektets save metode
            user1.save(); // Gemme den anden bruger

            DatabaseHandler.printAllUsers(conn);


        }

        cphFitness.startMenu();
    }
}