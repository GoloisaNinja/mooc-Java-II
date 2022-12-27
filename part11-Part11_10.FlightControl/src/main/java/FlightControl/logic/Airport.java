package FlightControl.logic;

import FlightControl.domain.Airplane;
import FlightControl.domain.Flight;
import FlightControl.domain.Place;

import java.util.ArrayList;
import java.util.HashMap;

public class Airport {
    private HashMap<String, Flight> flights;
    private HashMap<String, Airplane> airplanes;
    private HashMap<String, Place> places;
    public Airport() {
        this.flights = new HashMap<>();
        this.airplanes = new HashMap<>();
        this.places = new HashMap<>();
    }
    public boolean addPlane(String id, int capacity) {
        if (!this.airplanes.containsKey(id)) {
            Airplane airplane = new Airplane(id, capacity);
            this.airplanes.put(id, airplane);
            return true;
        }
        return false;
    }

    public boolean addFlight(Airplane airplane, String departureID, String destinationID) {
        this.places.putIfAbsent(destinationID, new Place(destinationID));
        this.places.putIfAbsent(departureID, new Place(departureID));
        Flight flight = new Flight(airplane, departureID, destinationID);
        if (!this.flights.containsKey(flight.toString())) {
            this.flights.put(flight.toString(), flight);
            return true;
        }
        return false;
    }
    public Airplane getAirplane(String id) {
        return this.airplanes.get(id);
    }

    public void printAirplanes() {
        for (String key : this.airplanes.keySet()) {
            System.out.println(this.airplanes.get(key));
        }
    }

    public void printFlights() {
        for (String key : this.flights.keySet()) {
            System.out.println(key);
        }
    }


}
