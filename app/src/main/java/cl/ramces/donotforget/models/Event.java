package cl.ramces.donotforget.models;

import com.orm.SugarRecord;

/**
 * Created by sebas on 23-05-2017.
 */

public class Event extends SugarRecord {

    private boolean done;
    private String name, date, hour, details;


    public Event() {
    }

    public Event(boolean done, String name, String date, String hour, String details) {
        this.done = done;
        this.name = name;
        this.date = date;
        this.hour = hour;
        this.details = details;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
