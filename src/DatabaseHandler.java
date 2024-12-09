import java.sql.*;

public class DatabaseHandler {
    private static final String DB_URL = "jdbc:sqlite:C:/Users/David/IdeaProjects/ICE-2024-Fitnesstracker/res/CPHFitnessDB";
    private static Connection connection;

    // Metode til at oprette forbindelse til databasen
    public static Connection connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(DB_URL);

            // Aktiver auto-commit
            connection.setAutoCommit(true); // Skift til true for automatisk commit

            if (connection != null) {
                System.out.println("Connected to the database.");
            }
            return connection;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Failed to connect to database: " + e.getMessage());
            return null;
        }
    }

    // Metode til at oprette brugertabellen
    public static void createUserTable(Connection conn) {
        String sql = """
        CREATE TABLE IF NOT EXISTS users (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            username TEXT NOT NULL UNIQUE,
            password TEXT NOT NULL,
            age INTEGER,
            gender TEXT,
            height INTEGER,
            weight REAL
        );
        """;
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.execute();
            System.out.println("User table created or already exists.");
        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
        }
    }

    // Metode til at gemme brugeren i databasen
    public static void saveUser(Connection conn, User user) {
        String checkSql = "SELECT id FROM users WHERE username = ?";
        String insertSql = """
    INSERT INTO users (username, password, age, gender, height, weight)
    VALUES (?, ?, ?, ?, ?, ?);
    """;

        try (PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {
            // Tjek om brugernavnet allerede findes i databasen
            checkStmt.setString(1, user.getUsername());
            ResultSet rs = checkStmt.executeQuery();

            // Hvis brugernavnet findes, returner en fejlbesked
            if (rs.next()) {
                System.out.println("Username " + user.getUsername() + " already exists.");
                return;
            }

            // Hvis brugernavnet ikke findes, indsæt den nye bruger
            try (PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
                insertStmt.setString(1, user.getUsername());
                insertStmt.setString(2, user.getPassword());
                insertStmt.setInt(3, user.getAge());
                insertStmt.setString(4, user.getGender());
                insertStmt.setInt(5, user.getHeight());
                insertStmt.setDouble(6, user.getWeight());

                insertStmt.executeUpdate();
                conn.commit();

                System.out.println("User saved successfully.");
            }
        } catch (SQLException e) {
            System.out.println("Error saving user: " + e.getMessage());
        }
    }
    public static void printAllUsers(Connection conn) {
        String sql = "SELECT id, username, password, age, gender, height, weight FROM users";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            // Udskriv resultaterne, hvis der er nogen
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                int age = rs.getInt("age");
                String gender = rs.getString("gender");
                int height = rs.getInt("height");
                double weight = rs.getDouble("weight");

                // Udskriv brugerens informationer
                System.out.println("ID: " + id + ", Username: " + username + ", Password: " + password
                        + ", Age: " + age + ", Gender: " + gender + ", Height: " + height + ", Weight: " + weight);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving users: " + e.getMessage());
        }
    }


    public static Connection getConnection() {
        return connection;
    }
}
