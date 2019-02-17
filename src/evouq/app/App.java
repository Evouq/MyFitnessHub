package evouq.app;

import evouq.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args ){
        Club clubOne = new Club();
        Club clubTwo = new Club();

        Gym gymOne = new Gym();
        Gym gymTwo = new Gym();
        gymOne.setId(1);
        //gymOne.setLimitations();

        List<Gym> gyms = new ArrayList<>();
        gyms.add(gymOne);
        gyms.add(gymTwo);

        clubOne.setName("Lime");
        clubTwo.setName("Star");

        Branch branch = new Branch();
        branch = createBranch(clubOne);



        //clubOne.getTrainers().add(trainerOne);
        //clubTwo.getTrainers().add(trainerTwo);

        User userOne = new User();
        User userTwo = new User();
        User[] usersClub1={new User(), new User(), new User()};
        User[] usersClub2={new User(), new User(), new User()};

        //clubOne.getUsers().addAll(Arrays.asList(usersClub1));
        //clubTwo.getUsers().addAll(Arrays.asList(usersClub2));


        createSchedule(clubOne);
        createBranch(clubOne);
    }

    private static void createSchedule(Club club) {

//        club.getTrainers();
//
//        club.getTrainers();
//        Branch branch = club.getBranches().get(0);
//        branch.getGyms();
//        Activity activity = new Activity();
//
//        Schedule schedule = new Schedule();
//        schedule.setBranch(branch);
//        schedule.setActivity(activity);
    }

    private static Branch createBranch(Club club) {
        Branch branch = new Branch();



       /* branch.setId(1);
        branch.setClub(club);
        branch.setAddress("г.Брест, Машерова 1");
        branch.setEndHour(2200);


        //add gyms
        List<Gym> gyms = new ArrayList<>();
        gyms.add(createGyms(branch));
        gyms.add(createGyms(branch));
        gyms.add(createGyms(branch));

        branch.setGyms(gyms);

        for (Gym g:branch.getGyms()){
            System.out.println(g);
        }*/
        return branch;
    }

    /*private static Gym createGyms(Branch branch){
        Gym gym = new Gym();
        gym.setId(1);
        //gym.setLimitations();
        gym.setAddress("Московская 341");
        gym.setName("Star");
        gym.setBranch(branch);
        return gym;
    }*/
}
