import java.util.ArrayList;

public class RunningLog {
ArrayList <Run> runningLog;

   public RunningLog (){
       runningLog = new ArrayList<>();
   }

    public void viewRunningLog(){
        try{
            for(Run run : runningLog){
                System.out.println(run);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void addRun(Run run){
        try {
            runningLog.add(run);
        }catch(Exception e){
            System.out.println(e);
        }
    }


}

