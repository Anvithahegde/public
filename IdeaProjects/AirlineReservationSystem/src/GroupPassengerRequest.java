import java.io.*;

public class GroupPassengerRequest {

    String ClassOfServicePreferred;
    String[] passengerNames = new String[128];
    String passengercount;

    public void SetGroupPassengerRequest(String ClassOfService, String[] pnames)
    {
        ClassOfServicePreferred = ClassOfService;

        for(int i = 0; i < pnames.length ; i++)
        {
            passengerNames[i] = pnames[i];
        }
    }

}
