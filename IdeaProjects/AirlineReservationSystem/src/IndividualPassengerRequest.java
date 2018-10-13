import java.io.*;

public class IndividualPassengerRequest {
    String passengerName;
    String SeatPreference;
    String ClassOfServicePreference;

    String SeatAssigned;

    public void setIndividualPassengerRequest(String pname, String SeatPreferred, String ClassOfService) {
        passengerName = pname;
        SeatPreference = SeatPreferred;
        ClassOfServicePreference = ClassOfService;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getSeatPreference() {
        return SeatPreference;
    }

    public String getClassOfServicePreference() {
        return ClassOfServicePreference;
    }

    public void processIndividualRequest(String fileName) {
        ReservationProgram reservationProgram = new ReservationProgram();
        reservationProgram.CheckSeatAvailabilityandAssignSeat(fileName,passengerName,ClassOfServicePreference,SeatPreference);
    }
}


