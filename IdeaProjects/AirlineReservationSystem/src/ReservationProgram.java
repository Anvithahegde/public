
import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

public class ReservationProgram {

    AirplaneSeatMap seatMap = new AirplaneSeatMap();
    static int seatCount = 0;
    String SeatAssigned;
    static int WindowSeatsOccupied = 0;
    static int WindowSeatsOccupiedInEconomyClass = 0;

    static Hashtable h = new Hashtable(128);

    public void UpdateSeatMap(String fileName) {

        int filecounter = 0;
        int index;
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            String reservationInfo;

            while ((reservationInfo = in.readLine()) != null) {
                String[] csv = reservationInfo.split(",");
                index = Integer.parseInt(csv[filecounter]);
                seatMap.arrayList.set(index,csv[filecounter+1]);
            }
            in.close();
        } catch (IOException e) {
            System.out.println("File Read Error");
        }
    }

    public void CheckSeatAvailabilityandAssignSeat(String fileName, String pname, String Class, String SeatPreference) {

        boolean seatAssigned = false;
        int index;
        int row;

        switch (Class) {
            case "First":
                index = 0;
                row = 1;
                if (SeatPreference.equals("W")) {
                    if(WindowSeatsOccupied < 4) {
                        while (seatAssigned != true) {
                            if (seatMap.arrayList.get(index).equals("")) {
                                seatMap.arrayList.add(index, pname);
                                seatAssigned = true;
                                WindowSeatsOccupied = WindowSeatsOccupied + 1;
                                SeatAssigned = Integer.toString((row)) + "A";
                            } else if (seatMap.arrayList.get(index + 3).equals("")) {
                                seatMap.arrayList.add(+3, pname);
                                seatAssigned = true;
                                WindowSeatsOccupied = WindowSeatsOccupied + 1;
                                SeatAssigned = Integer.toString((row)) + "D";
                            }
                            index = index + 4;
                            row = row + 1;
                        }
                    }
                } else if ((SeatPreference.equals("C")) || (SeatPreference.equals("A"))) {
                    while (seatAssigned != true) {
                        if (seatMap.arrayList.get(index + 1).equals("")) {
                            seatMap.arrayList.add(index + 1, pname);
                            seatAssigned = true;
                            SeatAssigned = Integer.toString((row)) + "B";
                        } else if (seatMap.arrayList.get(index + 2).equals("")) {
                            seatMap.arrayList.add(+2, pname);
                            seatAssigned = true;
                            SeatAssigned = Integer.toString((row)) + "C";
                        }
                        index = index + 4;
                        row = row + 1;
                    }

                }
                if(seatAssigned) {
                    System.out.println("\nThe Passenger is assigned the seat: " + SeatAssigned);
                    h.put(pname, SeatAssigned);
                }
                else
                {
                    System.out.println("\nPlease choose a different seat as the Preferred seat is not available");
                }
                break;

            case "Economy":
                index = 8;
                row = 10;

                if (SeatPreference.equals("W")) {
                    if(WindowSeatsOccupiedInEconomyClass < 40) {
                        while (seatAssigned != true) {
                            if (seatMap.arrayList.get(index).equals("")) {
                                seatMap.arrayList.add(index, pname);
                                SeatAssigned = Integer.toString((row)) + "A";
                                seatAssigned = true;
                                WindowSeatsOccupiedInEconomyClass = WindowSeatsOccupiedInEconomyClass + 1;
                            } else if (seatMap.arrayList.get(index + 5).equals("")) {
                                seatMap.arrayList.add(index + 5, pname);
                                SeatAssigned = Integer.toString((row)) + "F";
                                seatAssigned = true;
                                WindowSeatsOccupiedInEconomyClass = WindowSeatsOccupiedInEconomyClass + 1;
                            }
                            index = index + 6;
                            row = row + 1;
                        }
                    }
                } else if (SeatPreference.equals("C")) {
                    while (seatAssigned != true) {
                        if (seatMap.arrayList.get(index + 1).equals("")) {
                            seatMap.arrayList.add(index + 1, pname);
                            SeatAssigned = Integer.toString((row)) + "B";
                            seatAssigned = true;
                        } else if (seatMap.arrayList.get(index + 4).equals("")) {
                            seatMap.arrayList.add(index + 4, pname);
                            SeatAssigned = Integer.toString((row)) + "E";
                            seatAssigned = true;
                        }
                        index = index + 6;
                        row = row + 1;
                    }
                } else if (SeatPreference.equals("A")) {
                    while (seatAssigned != true) {
                        if (seatMap.arrayList.get(index + 2).equals("")) {
                            seatMap.arrayList.add(index + 2, pname);
                            SeatAssigned = Integer.toString((row)) + "C";
                            seatAssigned = true;
                        } else if (seatMap.arrayList.get(index + 3).equals("")) {
                            seatMap.arrayList.add(index + 3, pname);
                            SeatAssigned = Integer.toString((row)) + "D";
                            seatAssigned = true;
                        }
                        index = index + 6;
                        row = row + 1;
                    }
                }
                System.out.println("\nThe Passenger is assigned the seat: " + SeatAssigned);
                h.put(pname,SeatAssigned);
                break;
        }
    }

    public void WritePassengerDetailsToFile(String fileName) {
        int seatAssignedindex;
        String seatNumber;
            try {
                BufferedWriter out = new BufferedWriter(new FileWriter(fileName, true));
                try {
                    Set<String> keys = h.keySet();
                    for (String object : keys) {
                        if ((object.equals(""))) {
                            ;
                        } else {
                            seatAssignedindex = seatMap.arrayList.indexOf(object);
                            out.write(Integer.toString((seatAssignedindex)));
                            out.write(",");
                            out.write(object);
                            out.write(",");
                            seatNumber = (String) (h.get(object));
                            out.write(seatNumber);
                            out.newLine();
                        }
                    }
                } catch (IOException e) {
                    System.out.println("exception occurred" + e);
                }
                out.close();
            } catch (IOException e) {
                System.out.println("exception occurred" + e);
            }

    }

    public void CancelReservation(String pname) {

        int arrayListIndex;

        arrayListIndex = seatMap.arrayList.indexOf(pname);
        seatMap.arrayList.remove(arrayListIndex);
    }

    public void displaySeatAvailabiltyChart(String filename,String ServiceClass) {
        SeatAvailabiltyChart seatAvailabiltyChart = new SeatAvailabiltyChart();
        seatAvailabiltyChart.displayChart(filename,ServiceClass);
    }

    public void displayManifestList(String filename,String ServiceClass) {
        Manifestlist manifestlist = new Manifestlist();
        manifestlist.displayManifest(filename,ServiceClass);
    }
}
