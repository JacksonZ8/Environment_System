package Sensors;

import static java.lang.Math.abs;

public class HumidityFeed {
private int Inhum;
private int Outhum;

    public HumidityFeed(int inhum, int outhum) {
        Inhum = inhum;
        Outhum = outhum;
    }

    public int getInsideHumidity() {
        return Inhum;
    }
    public int getOutsideHumidity() {
        return Outhum;
    }
    public String getHumidityFeed(int wardID) {
        return "<html>" +
                "Inside Humidity is " + getInsideHumidity() + "<br>" +
                "Outside Humidity is " + getOutsideHumidity() + "<br>" +
                "Humidity Difference is " + abs(getInsideHumidity()-getOutsideHumidity()) + "<br>" +
                "Dehumidifier is " +
                "</html>";
    }

}
