package org.example;

import Sensors.HumidityFeed;
import Sensors.PollutionFeed;
import Sensors.TemperatureFeed;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;

public class System extends JPanel {

    private static PrintStream out;
    private final EnvironmentalSystem envSystem;
    private final TemperatureFeed tempFeed;
    private final HumidityFeed humidityFeed;
    private final PollutionFeed pollutionFeed;
    private final JLabel statusLabel;
    private int logCounter;

    public System() {
        envSystem = new EnvironmentalSystem();
        tempFeed = envSystem.getTempFeed();
        humidityFeed = envSystem.getHumidityFeed();
        pollutionFeed = envSystem.getPollutionFeed();
        statusLabel = new JLabel();
        add(statusLabel);

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateReadings();
                logCounter = (logCounter + 1) % 30;
                if (logCounter == 0) {
                    logStatus();
                }
            }
        });
        timer.start();
    }

    private void updateReadings() {
        StringBuilder status = new StringBuilder("<html>");
        updateWardStatus(status, 0, "North Ward", tempFeed.getTemperatureideal(0));
        updateWardStatus(status, 1, "Central Ward", tempFeed.getTemperatureideal(1));
        updateWardStatus(status, 2, "South Ward", tempFeed.getTemperatureideal(2));
        updateHumidityStatus(status);
        updatePollutionStatus(status);
        status.append("</html>");
        statusLabel.setText(status.toString());
    }

    private void updateWardStatus(StringBuilder status, int wardId, String wardName, float idealTemp) {
        float currentTemp = tempFeed.getTemperature(wardId);
        boolean heatingOn = envSystem.isHeatingOn(wardId);
        status.append("Name of Ward is " + wardName + "<br>" +
                "Current Temperature is " + currentTemp + "<br>" +
                "Ideal Temperature is "+ idealTemp + "<br>" +
                "Heater is " + heatingOn );
    }

    private void updateHumidityStatus(StringBuilder status) {
        int insideHumidity = humidityFeed.getInsideHumidity();
        int outsideHumidity = humidityFeed.getOutsideHumidity();
        int diff = insideHumidity - outsideHumidity;
        boolean dehumidifierOn = envSystem.isDehumudifierOn();
        status.append("<html>" +
                "Inside Humidity is " + insideHumidity + "<br>" +
                "Outside Humidity is " + outsideHumidity + "<br>" +
                "Humidity Difference is " + diff + "<br>" +
                "Dehumidifier is " + dehumidifierOn + "<br>" +
                "</html>");
    }

    private void updatePollutionStatus(StringBuilder status) {
        float pollution = pollutionFeed.getPollution();
        boolean purifierOn = envSystem.isAirPurifierOn();
        status.append("<html>" +
                "Pollution is " + pollution + "<br>" +
                "Air Purifier is " + purifierOn + "<br>" +
                "</html>");
    }

    private void logStatus() {
        System.out.println("CT Scanner: " + envSystem.getCTScannerStatus());
        System.out.println("Ultrasound Scanner: " + envSystem.getUltrasoundScannerStatus());
    }
}
