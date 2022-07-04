package lab03;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.AbstractMap.SimpleEntry;
import java.util.Objects;

public class Manager {


    HashMap<String,Flight> flights = new HashMap<>();


    public void addNewFlight(String flight_code, int num_lins_exec, int num_cols_exec, int num_lins_tourist, int num_cols_tourist)
    {
        if (!flights.containsKey(flight_code)) { // if the flight does not exist
            Airplane airplane;
            if (num_lins_exec == 0 && num_cols_exec == 0) { //if it does not have executive class
                airplane = new Airplane (num_lins_tourist, num_cols_tourist);
            }
            else {     //if it has executive class
                airplane = new Airplane (num_lins_exec, num_cols_exec, num_lins_tourist, num_cols_tourist);
            }
            Flight flight = new Flight(flight_code, airplane);
            flights.put(flight_code, flight);
        }
        else {
            System.out.println("We regret to inform you that this flight already exists! Please add a new one.");
        }

    }

    //SimpleEntry works like a HashMap. It returns a boolean to know if the reservation could be booked or not.
    //The Arraylist returns the seats of the reservation

    public SimpleEntry<Boolean,ArrayList<String>> addReservation(String flight_code, String classes, int n_seats){

        if (!flights.containsKey(flight_code)) { //if the flight does not exist
            System.out.println("We regret to inform you that this flight does not exist. Please try another Flight Code.");
            System.exit(0);
        }

        else {
            Flight flight = flights.get(flight_code);
            Airplane airplane = flight.getAirplane();
            switch(classes){
                case("E"):
                    //check if it has executive class

                    int [][] matrixE = flight.getExecSeats();

                    int linesE = airplane.getLinesExec();
                    int colsE = airplane.getRowsExec();

                    if (linesE == 0 || colsE == 0) {
                        System.out.println("Sorry, executive class is not available in this flight.");
                        return new SimpleEntry<>(false, null);
                    }

                    return reserve(matrixE, flight, linesE, colsE, n_seats, classes);

                case("T"):
                    //T always exists

                    int [][] matrixT = flight.getTouristSeats();

                    int linesT = airplane.getLinesTourist();
                    int colsT = airplane.getRowsTourist();

                    return reserve(matrixT, flight, linesT, colsT, n_seats, classes);
                default:

                    System.out.println("That class does not exist! You have to choose (E)xecutive or (T)ourist. Please try again!");
                    return new SimpleEntry<>(false, null);
                }
            }
        return new SimpleEntry<>(false, null);
        }

    public SimpleEntry<Boolean, ArrayList<String>> reserve(int [][] matrix, Flight flight, int lines, int cols, int n_seats, String classes) {

        Airplane airplane = flight.getAirplane();
        int planeTotalSeats = airplane.getTotalSeats();
        int [] tempLines = new int [planeTotalSeats];
        int [] tempColumns = new int [planeTotalSeats];
        int reservationNumber = flight.getNReservation();
        ArrayList<String> reservedSeats = new ArrayList<>();
        int nSeatsRemaining = n_seats;
        int freeSeats = 0; // basically the number of free seats
        //fills all seats and counts how many are left
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < cols; j++ ) {
                if (matrix[i][j] == 0) {
                    tempLines[freeSeats] = i; //save the number and position of the seats available
                    tempColumns[freeSeats] = j;
                    freeSeats++;
                }
            }
        }
        if (n_seats <= freeSeats) { //if the number of seats that the user want to book is less or equal to the number of free seats
            for (int i = 0; i < lines; i++) {
                if (matrix[i][0] == 0) { //search for an empty line and books in the seats available
                    int line = i;
                    int col = 0;
                    while (nSeatsRemaining > 0 && line < lines) {
                        matrix[line][col] = reservationNumber; //add the reservation number to the seat
                        reservedSeats.add("" + ((char)(col+65)) + (line+1)); // +65 to translate to 'A' (ASCII) and line+1 because it begins with 0
                        nSeatsRemaining--; //decrease the number of seats remaining because a reservation was made
                        col++; //switch to the next row
                        if (col == cols) { //if it's gotten to the limit it switches to a new line from seat A (0)
                            line++;
                            col = 0;
                        }
                    }
                    break;
                }
            }
            boolean finishedSeatsRemaining = false; //it works like a flag to warn when there are no more seats available to book

            for (int i = 0; i < lines; i++) {
                for (int j = 0; j < cols; j++ ) {

                    if (matrix[i][j] == 0) { //if that seat is available
                        matrix[i][j] = reservationNumber;  //add the reservation number to the seat
                        reservedSeats.add("" + ((char)(j+65)) + (i+1)); //  +65 to translate to 'A' (ASCII) and i+1 because it begins with 0
                        nSeatsRemaining--;
                    }
                    if (nSeatsRemaining == 0) {
                        finishedSeatsRemaining = true; //when there are no more seats to book
                        break;
                    }
                }
                if (finishedSeatsRemaining) break; //when there are no more seats it breaks (there can not be more reservations)
            }

            if (Objects.equals(classes, "E")) { //if it's executive class it adds the matrix on the executive seats
                flight.setExecSeats(matrix);
            }
            else if (Objects.equals(classes, "T")) { //if it's tourist class it adds the matrix on the tourist seats
                flight.setTouristSeats(matrix);
            }

            return new SimpleEntry<>(true, reservedSeats); //the booking was successfully made
        }

        else {
            System.out.println("We regret to inform you that the flight is full! Please try to book in another one.");
            return new SimpleEntry<>(false, null);
        }
    }

    public void printPlaneMap(Flight flight) {
        Airplane airplane = flight.getAirplane();
        int horizontal = airplane.getLinesExec() + airplane.getLinesTourist();
        int vertical = Math.max(airplane.getRowsExec(), airplane.getRowsTourist());
        System.out.println("-------------------- MAP ------------------");
        System.out.print("  ");
        for (int v = -1; v < vertical; v++) {
            if (v != -1) {
                System.out.print(v + " ");
            }
            for (int h = 0; h < horizontal; h++) {
                if (v == -1) {
                    System.out.print(h+1 + " ");
                }
                else {
                    if (h >= 9) {
                        System.out.print(" ");
                    }
                    if (h < airplane.getLinesExec() && v < airplane.getRowsExec()) {
                        System.out.print(flight.getExecSeats()[h][v] + " ");
                    }
                    else if (v < airplane.getRowsTourist() && h >= airplane.getLinesExec()) {
                        System.out.print(flight.getTouristSeats()[h-airplane.getLinesExec()][v] + " ");
                    }
                    else {
                        System.out.print("  ");
                    }
                }
            }
            System.out.print("\n");
        }
    }

    public void cancelReservation(Flight flight, int reservationCode) {
        Airplane airplane = flight.getAirplane();

        //EXECUTIVE
        for (int i = 0; i < airplane.getLinesExec(); i++) {
            for (int j = 0; j < airplane.getRowsExec(); j++) {
                if (flight.getExecSeats()[i][j] == reservationCode) { //if it has a reservation there
                    flight.getExecSeats()[i][j] = 0; //it will change to 0, the seat will be available
                }
            }
        }
        //TOURIST
        for (int i = 0; i < airplane.getLinesTourist(); i++) {
            for (int j = 0; j < airplane.getRowsTourist(); j++) {
                if (flight.getTouristSeats()[i][j] == reservationCode) { //if it has a reservation there
                    flight.getTouristSeats()[i][j] = 0; //it will change to 0, the seat will be available
                }
            }
        }
    }
}

