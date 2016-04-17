/**
 * Chrissy Soulakian
 * ObserverPattern Project
 * Created on 4/17/2016
 *
 * This Subject provides an interface for adding and removing
 * observers that subscribe to the subject.
 */
public interface WeatherSubject {

    public void addObserver(WeatherObserver weatherObserver);

    public void removeObserver(WeatherObserver weatherObserver);

    public void sendNotification();

}
