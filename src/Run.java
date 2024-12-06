public class Run {

    private int hours;
    private int minutes;
    private int seconds;
    private String date;
    private float distance;

    public Run(int hours, int minutes, int seconds, String date, float distance){

        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.date = date;
        this.distance = distance;

    }

    public Run(int hours, int minutes, int seconds, float distance){

        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.distance = distance;

    }

}
