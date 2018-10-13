import java.io.*;

public class Manifestlist {

    public void displayManifest(String fileName,String ServiceClass){
        int index = 0;

        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            String reservationInfo;

            while ((reservationInfo = in.readLine()) != null) {
                String[] csv = reservationInfo.split(",");
                System.out.println(csv[index + 2]+ ":"+ csv[index + 1]);

            }
            in.close();
        } catch (IOException e) {
            System.out.println("File Read Error");
        }

    }
}
