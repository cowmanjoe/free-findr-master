package com.example.jasonjinsooyoo.freefindr;

import com.example.jasonjinsooyoo.freefindr.Utilities.EventAdapter;

import java.util.ArrayList;

/**
 * Created by jasonjinsooyoo on 2017-03-18.
 */
public class EventManager {
    private static EventManager ourInstance = new EventManager();
    private ArrayList eventList;
    private EventAdapter eventAdapter;

    public static EventManager getInstance() {
        return ourInstance;
    }

    private EventManager() {
        eventList = new ArrayList<Event>();
    }

    public void setAdapter(EventAdapter ea) {
        eventAdapter = ea;
    }

    public void addEvent(Event e) {
        if (!eventList.contains(e)) {
            eventList.add(e);
            eventAdapter.addEvent(e);
        }
    }

    public ArrayList getEventList() {
        return eventList;
    }

    public Event getEvent(int id) {
        Event custom = new Event("filler");
        custom.setID(id);
        if (eventList.contains(custom)) return (Event) eventList.get(eventList.indexOf(custom));
        return null;
    }

    public void removeEvent(int id) {
        Event custom = new Event("filler");
        custom.setID(id);
        if (eventList.contains(custom)) eventList.remove(eventList.indexOf(custom));
    }
}
