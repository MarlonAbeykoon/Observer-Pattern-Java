/**
 * Chrissy Soulakian
 * ObserverPattern Project
 * Created on 4/17/2016
 */
public class ObserverPattern {

    public static void main(String[] args) {

        System.out.println("****** Creating new Weather Station Alpha with current " +
                "temperature of 70 degrees Fahrenheit. ******");
        WeatherStation weatherStation = new WeatherStation("Alpha", 70);

        WeatherCustomer wc1 = new WeatherCustomer("John");
        WeatherCustomer wc2 = new WeatherCustomer("Natalie");

        System.out.println("****** New customers John and Natalie have just subscribed " +
                "to Weather Station Alpha. ******");
        weatherStation.addObserver(wc1);
        weatherStation.addObserver(wc2);

        weatherStation.setTemp(77);

        System.out.println("\n****** Weather Station Alpha customer John has unsubscribed " +
                "from the weather station. ******");
        weatherStation.removeObserver(wc1);

        weatherStation.setTemp(68);
    }
}
