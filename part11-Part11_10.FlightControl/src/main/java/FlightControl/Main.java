package FlightControl;

import FlightControl.logic.Airport;
import FlightControl.ui.UserInterface;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Airport airport = new Airport();
        UserInterface ui = new UserInterface(scanner, airport);
        ui.startAssetControl();
    }
}
