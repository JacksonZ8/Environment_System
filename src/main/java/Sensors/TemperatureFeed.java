package Sensors;

public class TemperatureFeed {
    private float Temp;

    public TemperatureFeed(float temp) {
        Temp = temp;
    }

    public float getTemperature(int wardID) {
        return Temp;
    }
    public float getTemperatureideal(int wardID) {
        float idealTemp = 0;
        if (wardID == 0){
            idealTemp = 23;
        }
        else if (wardID == 1) {
            idealTemp = 22;
        }
        else if (wardID == 2) {
            idealTemp = 20;
        }
        return idealTemp;
    }
    public String getTempFeed(int wardID) {
        return "<html>"
                + "Name of ward" + wardID + "<br>" +
                "Current Temperature" + getTemperature(wardID) + "<br>" +
                "Ideal Temperature" + getTemperatureideal(wardID) + "<br>" +
                "Heater is " +
                "</html>";
    }
}
