package soft.dev.academy.coachapp.springinversionofcontrol;

import soft.dev.academy.coachapp.Coach;

public class MyApp {

    public static void main(String[] args) {

        //create the object
        Coach theCoach = new TrackCoach();

        //use the object
        System.out.println(theCoach.getDailyWorkout());

    }

}
