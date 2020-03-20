package com.endava.exercise;

public class Airplane {
    private Pilot pilot;
    private int numberOfPassengers;

    public Airplane() {
    }

    public Airplane(Pilot pilot, int numberOfPassengers) {
        this.pilot = pilot;
        this.numberOfPassengers = numberOfPassengers;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "pilot=" + pilot +
                ", numberOfPassengers=" + numberOfPassengers +
                '}';
    }
}
