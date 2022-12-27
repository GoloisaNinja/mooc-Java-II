package FlightControl.domain;

public class Flight {
    private Airplane airplane;
    private String departureID;
    private String destinationID;
    public Flight(Airplane airplane, String departureID, String destinationID) {
        this.airplane = airplane;
        this.departureID = departureID;
        this.destinationID = destinationID;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public String getDepartureID() {
        return departureID;
    }

    public String getDestinationID() {
        return destinationID;
    }

    @Override
    public String toString() {
        return this.airplane.toString() + " (" + this.departureID + "-" + this.destinationID + ")";
    }
}
