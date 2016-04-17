import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;


/**
 * Chrissy Soulakian
 * ObserverPattern Project
 * Created on 4/17/2016
 */
public class WeatherStationTest {

    private WeatherStation weatherStation = new WeatherStation("NBC", 70);
    private WeatherObserver observer1 = new WeatherCustomer("John", weatherStation);
    private WeatherObserver observer2 = new WeatherCustomer("Natalie", weatherStation);
    private WeatherObserver observer3 = new TVStation("NBC", weatherStation);

    private final ByteArrayOutputStream myOut = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(myOut));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }

    @Test
    public void testAddObserver() throws Exception {
        weatherStation.addObserver(observer1);
        assertTrue(weatherStation.getSetOfWeatherObservers().contains(observer1));
        weatherStation.addObserver(observer2);
        assertTrue(weatherStation.getSetOfWeatherObservers().contains(observer2));
        weatherStation.addObserver(observer3);
        assertTrue(weatherStation.getSetOfWeatherObservers().contains(observer3));
    }

    @Test
    public void testRemoveObserver() throws Exception {
        weatherStation.removeObserver(observer1);
        assertFalse(weatherStation.getSetOfWeatherObservers().contains(observer1));
        weatherStation.removeObserver(observer2);
        assertFalse(weatherStation.getSetOfWeatherObservers().contains(observer2));
        weatherStation.removeObserver(observer3);
        assertTrue(weatherStation.getSetOfWeatherObservers().isEmpty());
    }

    @Test
    public void testSetTemp() throws Exception {
        weatherStation.setTemp(72);
        assertEquals(72, weatherStation.getTemp());
        weatherStation.setTemp(78);
        assertEquals(78, weatherStation.getTemp());
    }

    @Test
    public void testGetTemp() throws Exception {
        assertEquals(70, weatherStation.getTemp());
        weatherStation.setTemp(68);
        assertEquals(68, weatherStation.getTemp());
        weatherStation.setTemp(65);
        assertEquals(65, weatherStation.getTemp());
    }

    @Test
    public void testSendNotificationOneObserver() throws Exception {
        weatherStation.addObserver(observer1);

        weatherStation.setTemp(73);

        String[] output = myOut.toString().split("\n");

        assertEquals(TestFixtures.oneObsResult1, output[1].trim());
        assertEquals(TestFixtures.oneObsResult2, output[2].trim());
    }

    @Test
    public void testSendNotificationTwoObservers() throws Exception {
        weatherStation.addObserver(observer1);
        weatherStation.addObserver(observer2);

        weatherStation.setTemp(78);

        String[] output = myOut.toString().split("\n");

        assertEquals(TestFixtures.twoObsResult1, output[1].trim());
        assertEquals(TestFixtures.twoObsResult2, output[2].trim());
        assertEquals(TestFixtures.twoObsResult3, output[3].trim());
    }

    @Test
    public void testSendNotificationRemoveObserver() throws Exception {
        weatherStation.addObserver(observer1);
        weatherStation.addObserver(observer2);

        weatherStation.setTemp(73);

        weatherStation.removeObserver(observer1);

        weatherStation.setTemp(71);
        String[] output = myOut.toString().split("\n");

        //skip the outputs tested in testSendNotificationTwoObservers
        assertEquals(TestFixtures.removeObsResult1, output[5].trim());
        assertEquals(TestFixtures.removeObsResult2, output[6].trim());
    }

}