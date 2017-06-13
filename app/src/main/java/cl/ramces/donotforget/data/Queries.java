package cl.ramces.donotforget.data;

import java.util.ArrayList;
import java.util.List;

import cl.ramces.donotforget.models.Event;

/**
 * Created by sebas on 24-05-2017.
 */

public class Queries {

    public List<Event> events(){

        List<Event> events = new ArrayList<>();
        List<Event> eventList = Event.find(Event.class, "done = 0");

        if (eventList != null && eventList.size() > 0){

            events.addAll(eventList);
        }

        return events;
    }
}
