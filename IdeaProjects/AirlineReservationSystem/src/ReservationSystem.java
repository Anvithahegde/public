import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ReservationSystem {
    public static void main(String[] args) {
        String flightName = args[0];
        String in;
        try {
            File f = new File(flightName);

            if (f.exists() == false) {
                f.createNewFile();
            }

            in = DisplayPromptToUserAndReceiveInput(flightName);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String DisplayPromptToUserAndReceiveInput(String flightName) {
        Scanner reader = new Scanner(System.in);
        while (true) {
            System.out.println("\nAdd [P]assenger,Add [G]roup,[C]ancel Reservations,\nPrint Seat [A]vailability Chart," +
                    "Print [M]anifest,[Q]uit\n");
            String n = reader.next();
            ActOnUserInput(n, flightName);
            if (n.equals("Q"))
                break;
        }
        reader.close();
        return "Q";
    }

    public static void ActOnUserInput(String s, String flightName) {

        String pname;
        String ServiceClass;
        String SeatPreferred;
        String UserChoiceOfCancellation;
        Scanner key = new Scanner(System.in);

        ReservationProgram reservationProgram = new ReservationProgram();

        if ((s.equals("P"))) {
            reservationProgram.UpdateSeatMap(flightName);
            System.out.print("Name: ");
            pname = key.nextLine();
            System.out.print("Service Class Preference[First/Economy]: ");
            ServiceClass = key.nextLine();
            if ((ServiceClass.equals("First")) || (ServiceClass.equals("Economy"))) {
                System.out.print("Seat Preference: ");
                SeatPreferred = key.nextLine();
                if ((SeatPreferred.equals("W")) || (SeatPreferred.equals("C")) || (SeatPreferred.equals("A"))) {
                    IndividualPassengerRequest individualPassengerRequest = new IndividualPassengerRequest();
                    individualPassengerRequest.setIndividualPassengerRequest(pname, SeatPreferred, ServiceClass);
                    individualPassengerRequest.processIndividualRequest(flightName);
                }
            }
        } else if ((s.equals("Q"))) {
            reservationProgram.WritePassengerDetailsToFile(flightName);
        } else if ((s.equals("C"))) {
            System.out.print("Do you want to cancel Individual or Group Reservation? : ");
            UserChoiceOfCancellation = key.nextLine();
            if(UserChoiceOfCancellation.equals("Individual")){
                System.out.print("Name: ");
            }
            else if(UserChoiceOfCancellation.equals("Group")) {
                System.out.print("Group Name: ");
            }
            pname = key.nextLine();
            reservationProgram.CancelReservation(pname);
        }
        else if((s.equals("A"))){
            reservationProgram.UpdateSeatMap(flightName);
            System.out.print("Service Class Preference[First/Economy]: ");
            ServiceClass = key.nextLine();
            reservationProgram.displaySeatAvailabiltyChart(flightName,ServiceClass);
        }
        else if((s.equals("M"))){
            reservationProgram.UpdateSeatMap(flightName);
            System.out.print("Service Class Preference[First/Economy]: ");
            ServiceClass = key.nextLine();
            reservationProgram.displayManifestList(flightName,ServiceClass);
        }
    }
}



