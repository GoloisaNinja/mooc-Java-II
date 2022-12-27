package FlightControl.ui;
import java.util.Scanner;

import FlightControl.domain.Airplane;
import FlightControl.logic.Airport;

public class UserInterface {
    private Scanner scanner;
    private Airport airport;
    public UserInterface(Scanner scanner, Airport airport) {
        this.scanner = scanner;
        this.airport = airport;
    }
    public void startAssetControl() {
        System.out.println("Airport Asset Control");
        while(true) {
            System.out.println("Choose an action:");
            System.out.println("[1] Add an airplane");
            System.out.println("[2] Add a flight");
            System.out.println("[x] Exit Airport Asset Control");
            String command = this.scanner.nextLine();
            if (command.equals("x")) {
                break;
            }
            if (command.equals("1")) {
                System.out.println("Give the airplane id:");
                String id = this.scanner.nextLine();
                System.out.println("Give the airplane capacity:");
                int capacity = Integer.parseInt(this.scanner.nextLine());
                this.airport.addPlane(id, capacity);
            } else if (command.equals("2")) {
                System.out.println("Give the airplane id:");
                String id = this.scanner.nextLine();
                Airplane airplane = this.airport.getAirplane(id);
                System.out.println("Give the departure airport id:");
                String departureID = this.scanner.nextLine();
                System.out.println("Give the target airport id: ");
                String destinationID = this.scanner.nextLine();
                this.airport.addFlight(airplane, departureID, destinationID);
            }
        }
        this.startFlightControl();
    }

    private void startFlightControl() {
        System.out.println("Flight Control");
        while(true) {
            System.out.println("Choose an action:");
            System.out.println("[1] Print airplanes");
            System.out.println("[2] Print flights");
            System.out.println("[3] Print airplane details");
            System.out.println("[x] Quit");
            String command = this.scanner.nextLine();
            if (command.equals("x")) {
                break;
            }
            if (command.equals("1")) {
                this.airport.printAirplanes();
            } else if (command.equals("2")) {
                this.airport.printFlights();
            } else if (command.equals("3")) {
                System.out.println("Give the airplane id:");
                String id = this.scanner.nextLine();
                Airplane airplane = this.airport.getAirplane(id);
                System.out.println(airplane);
            }
        }
    }
}
