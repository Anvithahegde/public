import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class SeatAvailabiltyChart {

    public void displayChart(String fileName,String serviceClass) {

        ArrayList<String> availabilitychart = new ArrayList<String>(Collections.nCopies(128, ""));
        if(serviceClass.equals("First")){
            int filecounter = 0;
            int index;
            int k = 0;
            char ch;
            try {
                BufferedReader in = new BufferedReader(new FileReader(fileName));
                String reservationInfo;

                while ((reservationInfo = in.readLine()) != null) {
                    String[] csv = reservationInfo.split(",");
                    index = Integer.parseInt(csv[filecounter]);
                    availabilitychart.set(index,csv[filecounter+1]);
                }
                System.out.println("\n Availability Chart");
                for (int i = 1; i <= 2; i++) {
                    ch = 'A';
                    System.out.println("\n");
                    System.out.print(Integer.toString(i) + ":");
                    for (int j = 0; j < 4 ; j++) {
                        if(availabilitychart.get(k).equals("")) {
                            System.out.print(ch + ",");
                        }
                            ch++;
                            k++;
                    }
                }
                System.out.println();
                in.close();
            } catch (IOException e) {
                System.out.println("File Read Error");
            }

        }
    }
}

