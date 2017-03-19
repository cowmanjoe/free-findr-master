package com.example.jasonjinsooyoo.freefindr.Utilities;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.jasonjinsooyoo.freefindr.Event;
import com.example.jasonjinsooyoo.freefindr.R;

import java.util.ArrayList;

/**
 * Created by jasonjinsooyoo on 2017-03-18.
 */

public class EventAdapter extends ArrayAdapter<Event> {

    // Number of items to be stored
    int numOfItems;
    ArrayList displayedEvents;
    static int counter;



    public EventAdapter(Context context) {
        super(context, -1);
        this.numOfItems = numOfItems;
        displayedEvents = new ArrayList<Event>();
        counter=0;
    }


    public void addEvent(Event event) {
        for(int i = 0; i < getCount(); i++) {
            if (getItem(i).getID() == event.getID()) {
                return;
            }
        }
        add(event);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.event_list_item, parent, false);
        TextView eventName = (TextView) rowView.findViewById(R.id.event_name);
        TextView eventType = (TextView) rowView.findViewById(R.id.event_type);

        eventName.setText(getItem(position).getName());
        eventType.setText(getItem(position).getType());

        return rowView;
    }
}
