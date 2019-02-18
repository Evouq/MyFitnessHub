package evouq.app;

import evouq.model.*;

import java.io.*;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static java.lang.System.*;

public class CsvParser {
    public static void main(String[] args) throws IOException, ParseException {
        readCsv();

        String line = "";
        String separator = ";";
        File folder = new File("C:\\Users\\vetlk\\Documents\\MyFitnessHub\\Table");


        //Parsing file club.
        File fileClubs = new File(folder, "club.csv");
        BufferedReader br = new BufferedReader(new FileReader(fileClubs));
        Map<Long, Club> clubs = new TreeMap<>();
        long key = 1;
        //1;Power;pow@gmail.com;785986
        while((line = br.readLine()) != null) {
            String[] values = line.split(separator);
            Club club = new Club();
            club.setId(Long.parseLong(values[0]));
            club.setName(values[1]);
            club.setEmail(values[2]);
            club.setContNumber(values[3]);
            clubs.put(key, club);
            key++;
        }
        br.close();
        //printClub(clubs);


        //Parsing file user
        File fileUsers = new File(folder, "user.csv");
        br = new BufferedReader(new FileReader(fileUsers));
        LinkedList<User> users = new LinkedList<>();
        //id;;name;age;phone;isDeleted;login;password;idClub;createAt
        //1;Новиков Максим Вадимович;23;375000000000;0;nov23;123456;2;01.02.2019
        while((line = br.readLine()) != null) {
            String[] values = line.split(separator);
            User user = new User();
            user.setId(Long.parseLong(values[0]));
            user.setName(values[1]);
            user.setAge(Long.parseLong(values[2]));
            user.setPhone(values[3]);
            user.setDeleted(Long.parseLong(values[4]));
            user.setLogin(values[5]);
            user.setPassword(values[6]);
            user.setClub(clubs.get(Long.parseLong(values[7])));
            user.setCreatedAt(parseDate(values[8]));
            //user.setRole(Roles.valueOf(values[9].toUpperCase()));
            users.add(user);
        }
        br.close();
        printUser(users);

        //out.print(users);

        //Parsing file branch
        final String  PATTERN = "K:mm";
        SimpleDateFormat simpleDateFormatIn = new SimpleDateFormat(PATTERN);
        SimpleDateFormat simpleDateFormatOut = new SimpleDateFormat("KK:mm");
        File fileBranch = new File(folder, "branch.csv");
        br = new BufferedReader(new FileReader(fileBranch));
        Map<Long, Branch> branches = new TreeMap<>();
        key =1;
        //id;idClub;idUser;            address;startHour;endHour;
        // 1;     1;     10;Brest, Mascherova 1;        9;      20
        while ((line = br.readLine()) != null) {
            String[] values = line.split(separator);
            Branch branch = new Branch();
            branch.setId(Long.parseLong(values[0]));
            Club userClub = clubs.get(Long.parseLong(values[1]));
            branch.setClub(userClub);
            int idUser = Integer.parseInt(values[2]) - 1;
            branch.setUser(users.get(idUser));
            branch.setAddress(values[3]);
            try {
                branch.setStartHour(Time.valueOf(simpleDateFormatOut.format(simpleDateFormatIn.parse(values[4]))));
                branch.setEndHour(Time.valueOf(simpleDateFormatOut.format(simpleDateFormatIn.parse(values[5]))));
            } catch (ParseException e) {
                out.printf("Failed tp parse date. exception;%s with pattern %s",e.getMessage(), PATTERN);
            }
            branches.put(key, branch);
            key++;
        }
        br.close();

        //Parsing file gym
        File fileGym = new File(folder, "gym.csv");
        br = new BufferedReader(new FileReader(fileGym));
        Map<Long, Gym> gyms = new TreeMap<>();
        key =1;
        //1;1;Brest, Mascherova 1;789456
        //idGym;idBranch;address;phone;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(separator);
            Gym gym = new Gym();
            gym.setId(Long.parseLong(values[0]));
            Branch gymBranch = branches.get(Long.parseLong(values[1]));
            gym.setBranch(gymBranch);
            gym.setAddress(values[2]);
            gym.setPhone(values[3]);
            gyms.put(key, gym);
            key++;
        }
        br.close();

        //Parsing file activityType
        File fileActivityType = new File(folder, "activityType.csv");
        br = new BufferedReader(new FileReader(fileActivityType));
        Map<Long, ActivityType> activityTypes = new TreeMap<>();
        key = 1;
        //id;name;duration;
        //1;Bodyflex;40
        while((line = br.readLine()) != null){
            String[] values = line.split(separator);
            ActivityType activityType = new ActivityType();
            activityType.setId(Long.parseLong(values[0]));
            activityType.setName(values[1]);
            activityType.setDuration(Long.parseLong(values[2]));
            activityTypes.put(key, activityType);
            key++;
        }
        br.close();

        //Parsing file ticketType
        File fileTicketType = new File(folder, "ticketType.csv");
        br = new BufferedReader(new FileReader(fileTicketType));
        Map<Long, TicketType> ticketTypes = new TreeMap<>();
        key =1;
        //id;name;limVisits;
        //1;single;1
        while((line = br.readLine()) != null) {
            String[] values = line.split(separator);
            TicketType ticketType = new TicketType();
            ticketType.setId(Long.parseLong(values[0]));
            ticketType.setName(values[1]);
            ticketType.setLimVisits(Long.parseLong(values[2]));
            ticketTypes.put(key, ticketType);
            key++;
        }
        br.close();

        //Parsing file activitiesTickets
        File fileActivitiesTickets = new File(folder, "activitiesTickets.csv");
        br = new BufferedReader(new FileReader(fileActivitiesTickets));
        Map<Long, ActivityTicket> activitiesTickets = new TreeMap<>();
        key = 1;
        //id;idTicketType;idActivityType;  createdAt; price;idBranch
        //1;            1;             2; 10.01.2019;    40;    2
        while ((line = br.readLine()) != null) {
            String[] values = line.split(separator);
            ActivityTicket activityTicket = new ActivityTicket();
            activityTicket.setId(Long.parseLong(values[0]));
            activityTicket.setTicketType(ticketTypes.get(Long.parseLong(values[1])));
            activityTicket.setActivityType(activityTypes.get(Long.parseLong(values[2])));
            activityTicket.setCreatedAt(values[3]);
            activityTicket.setPrice(Long.parseLong(values[4]));
            activityTicket.setBranch(branches.get(Long.parseLong(values[5])));
            activitiesTickets.put(key, activityTicket);
            key++;
        }
        br.close();


       /* //Parsing file Schedule
        File fileSchedule = new File(folder, "schedule.csv");
        br = new BufferedReader(new FileReader(fileSchedule));
        Map<Long, Schedule> scheduls = new TreeMap<>();
        key =1;

        simpleDateFormatIn = new SimpleDateFormat(PATTERN);
        simpleDateFormatOut = new SimpleDateFormat("KK:mm");
        //id;idTrainer;idGym;      date; startHour;dayOfWeek;idActivityType
        //1;         4;    5;01.02.2019;      9:00;  Monday ;             4
        while ((line = br.readLine()) != null ) {
            String[] values = line.split(separator);
            Schedule schedule = new Schedule();
            schedule.setId(Long.parseLong(values[0]));
            schedule.setTrainer(trainers.get(Long.parseLong(values[1])));
            schedule.setGym(gyms.get(Long.parseLong(values[2])));
            schedule.setDate(values[3]);

            try {
                schedule.setStartHour( simpleDateFormatOut.format(simpleDateFormatIn.parse(values[4])));
            } catch (ParseException e) {
                out.printf("Failed tp parse date. exception;%s with pattern %s",e.getMessage(), PATTERN);
            }

            schedule.setDayOfWeek(values[5]);
            schedule.setActivityType(activityTypes.get(Long.parseLong(values[6])));
            scheduls.put(key, schedule);
            key++;
        }
        br.close();*/

        /*//Parsing file userTicket
        File fileUserTicket = new File(folder, "userTicket.csv");
        br = new BufferedReader(new FileReader(fileUserTicket));
        LinkedList<UserTicket> userTickets = new LinkedList<>();
        //id;idUser;        to;      from; purchaseDate;idActivityTicket;idSchedule;countVisits
        // 1;     3;01.02.2019;01.02.2019;   05.02.2019;               2;         1;          1
        while ((line = br.readLine()) != null) {
            String[] values = line.split(separator);
            UserTicket userTicket = new UserTicket();
            userTicket.setId(Long.parseLong(values[0]));
            //subtract 1
            int idUser = Integer.parseInt(values[1]) - 1;

            userTicket.setUser(users.get(idUser));
            userTicket.setTo(values[2]);
            userTicket.setFrom(values[3]);
            userTicket.setPurchaseDate(values[4]);
            userTicket.setActivityTicket(activitiesTickets.get(Long.parseLong(values[5])));
            userTicket.setSchedule(scheduls.get(Long.parseLong(values[6])));
            userTicket.setCountVisit(Long.parseLong(values[7]));
            userTickets.add(userTicket);
        }
        br.close();*/

        //printGym(gyms);
        //out.print(scheduls);

    }

    private static void readCsv() {
        File myDirect = new File("C:\\Users\\vetlk\\Documents\\MyFitnessHub\\Table");
        out.println(myDirect.isDirectory());
        File[] files = myDirect.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".csv");
            }
        });


        for (File file : files){
            out.println(file.getName());
        }
    }

    /*private static Map<Long, Administrator> extractAdmin(LinkedList<User> users, Roles role){
        Map<Long, Administrator> admins = new TreeMap<>();
        long key =1;
        for (User counter : users){
            if (counter.getRole() == role){
                Administrator admin = new Administrator();
                admin.setId(key);
                admin.setUser(counter);
                admins.put(key, admin);
                key++;
            }
        }
        return admins;
    }

    private static Map<Long, Trainer> extractTrainer(LinkedList<User> users, Roles role){
        Map<Long, Trainer> trainers = new TreeMap<>();
        long key =1;
        for (User counter : users){
            if (counter.getRole() == role){
                Trainer trainer = new Trainer();
                trainer.setId(key);
                trainer.setUser(counter);
                trainers.put(key, trainer);
                key++;
            }
        }
        return trainers;
    }*/


    private static void printGym(Map<Long, Gym> gyms){
        String[] splits = {"\n","; ","\t\t\t\t\t"};
        out.println("*******Print Gyms*********");
        for (Map.Entry<Long, Gym> counter : gyms.entrySet()){
            out.println("key: " + counter.getKey());
            Gym gym = counter.getValue();
            Branch branch = gym.getBranch();
            Club club = branch.getClub();
            User user = branch.getUser();
            out.println("idGym: " + gym.getId());
            out.print("Branch-> id: " + branch.getId());
            out.println(" Club-> id: " + club.getId() + splits[0] +
                        splits[2] + "name: " + club.getName() + splits[0] +
                        splits[2] + "email: " + club.getEmail() + splits[0] +
                        splits[2] + "contNumber: " + club.getContNumber() + splits[1] +
                    "Admin-> id: " + user.getId() + splits[1] +
                    "address: " + branch.getAddress() + splits[1] +
                    "startHour: " +branch.getStartHour() + splits[1] +
                    "endHour: " + branch.getEndHour() + splits[0] +
                    "address: " + gym.getAddress() + splits[0] +
                    "phone: " + gym.getPhone());
        }

    }



    private static void printClub(Map<Long, Club> map){
        out.println("*******Your List Clubs******");
        for (Map.Entry<Long, Club> counter : map.entrySet()){
            out.print("key: " + counter.getKey());
            Club club = counter.getValue();
            String split = "; ";
            out.println(" {id: " + club.getId() + split +
                    "name: " + club.getName() + split +
                    "email: " + club.getEmail() + split +
                    "contNumb: " + club.getContNumber() + "}");
        }
    }

    private static void printUser(List<User> users){
        out.println();
        String[] splits = {"\n","; "};
        for (User counter : users){
            out.println("id: " + counter.getId() + splits[0] +
                    "Name: " + counter.getName() + splits[0] +
                    "age: " + counter.getAge() + splits[0] +
                    "phone: " + counter.getPhone() + splits[0] +
                    "isDeleted: " + counter.getDeleted() + splits[0] +
                    "login: " + counter.getLogin() + splits[0] +
                    "password: " + counter.getPassword()+ splits[0] +
                    "createdAt: " + counter.getCreatedAt());
            Club userClub = counter.getClub();
            out.println("Club: id: " + userClub.getId() + splits[1] +
                    "name: " + userClub.getName() + splits[1] +
                    "email: " + userClub.getEmail() + splits[1] +
                    "contNumber: " + userClub.getContNumber() + splits[1]);
        }
    }

    private static Date parseDate (String date) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date formatedDate = dateFormat.parse(date);
        return formatedDate;
    }

}
