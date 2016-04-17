# Observer-Pattern-Java
**Loyola University Chicago**

**COMP 373/473 - Objects/Frameworks/Patterns**

**Spring 2016 - Project 3 Observer Pattern**

The purpose of the observer pattern is represent a one-to-many dependency so that when one object changes its state, all of its dependencies are notified of the change and update automatically. The design allows the observer objects to synchronize their local state of the subject with the subject's current state. In this example, there are many observers (WeatherCustomer and TVStation) to one subject (WeatherStation). By subscribing to the weather station, the customers and TV stations will automatically have the current temperature whenever the station issues an update. Observer is a useful pattern for this case because the customers and TV stations do not have to continuously query the weather station to see if there have been any updates to the current temperature. They will instead be notified automatically when there is an update.

Resources:
- Design Patterns by Gamma, Helm, Johnson, and Vlissides (GoF)
- http://www.blackwasp.co.uk/Observer.aspx
- http://www.avajava.com/tutorials/lessons/observer-pattern.html?page=1
