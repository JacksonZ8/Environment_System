package org.example;

import Sensors.HumidityFeed;
import Sensors.PollutionFeed;
import Sensors.TemperatureFeed;

public class EnvironmentalSystem {
private TemperatureFeed temp;
private HumidityFeed Humid;
private PollutionFeed Pollution;
    public TemperatureFeed getTempFeed() {
        return temp;
    }

    public HumidityFeed getHumidityFeed() {
        return Humid;
    }

    public PollutionFeed getPollutionFeed() {
        return Pollution;
    }

    public void turnHeatingOn(int wardID, boolean on) {}// turn on=true, turn off=false

    public void turnDehumudifierOn(boolean on) {}// on=true off=false

    public void turnAirPurifierOn(boolean on) {}// on=true off=false

    public boolean isHeatingOn(int wardID) {
        if (turnHeatingOn(int wardID, boolean on)
        boolean status;
        return status)
        
    }

    public boolean isDehumudifierOn() {
        return status;
    }

    public boolean isAirPurifierOn(){
        return status;
    }

    public String getUltrasoundScannerStatus() {
        return null;
    }

    public String getCTScannerStatus() {
        return null;
    }
}
