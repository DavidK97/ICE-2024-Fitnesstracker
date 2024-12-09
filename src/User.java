import java.sql.*;
import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private int age;
    private String gender;
    private int height;
    private double weight;
    private ArrayList<Run> runningLog;
    private ArrayList<Goal> goalLog;
    private TextUI ui = new TextUI();

    public User(String username, String password, int age, String gender, int height, double weight) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.runningLog = new ArrayList<>();
        this.goalLog = new ArrayList<>();
    }

    public void editGoal(Goal goal) {
        //Kode der gør at man kan
    }

    public void updateWeight() {
        String bold = "\u001B[1m";
        try {
            double newWeight = ui.promptNumeric(bold + "Type your updated weight in kg's: ");
            if (newWeight > 0) {
                ui.displayMsg(bold + "Weight has been updated from: " + weight + "kg., to: " + newWeight + "kg.");
                this.weight = newWeight;
            } else {
                ui.displayMsg(bold + "Invalid weight. Please type a positive number!");
                updateWeight();
            }
        } catch (Exception e) {
            System.out.println(bold + e);
        }
    }

    public void updateHeight() {
        String bold = "\u001B[1m";
        try {
            int newHeight = ui.promptNumeric(bold + "Type your updated height in cm's: ");
            if (newHeight > 0) {
                ui.displayMsg(bold + "Weight has been updated from: " + height + "cm., to: " + newHeight + "cm.");
                height = newHeight;
            }
            else {
                ui.displayMsg(bold + "Invalid height. Please type a positive number!");
                updateHeight();
            }
        } catch (Exception e) {
            System.out.println(bold + e);
        }
    }

    public void viewRunningLog(){
        try{
            for(Run run : runningLog){
                System.out.println(run);
            }
        } catch(Exception e){
            System.out.println(e);
        }
    }

    public void addRun(Run run){
        try {
            runningLog.add(run);
        } catch(Exception e){
            System.out.println(e);
        }
    }

    public void viewGoalLog() {
        try{
            for(Goal goal : goalLog){
                System.out.println(goal);
            }
        } catch(Exception e){
            System.out.println(e);
        }
    }

    public void addGoal(Goal goal){
        try {
            goalLog.add(goal);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Run> getRunningLog() {
        return runningLog;
    }

    public void save() {
      // DatabaseHandler.saveUser(this);
    }

}
