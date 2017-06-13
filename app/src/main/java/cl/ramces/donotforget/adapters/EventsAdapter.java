package cl.ramces.donotforget.adapters;

import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

import cl.ramces.donotforget.R;
import cl.ramces.donotforget.data.Queries;
import cl.ramces.donotforget.models.Event;

/**
 * Created by sebas on 25-05-2017.
 */

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.ViewHolder> {

    private List<Event> events = new Queries().events();
    private EventsClick listener;

    public EventsAdapter(EventsClick listener) {
        this.listener = listener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_events, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Event event = events.get(position);
        holder.event.setText(event.getName());
        holder.date.setText(event.getDate());
        holder.hour.setText(event.getHour());

        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked){

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            int auxPosition = holder.getAdapterPosition();
                            Event auxEvent = events.get(auxPosition);
                            auxEvent.setDone(true);
                            auxEvent.save();
                            events.remove(auxPosition);
                            notifyItemRemoved(auxPosition);
                        }
                    },400);
                }
            }
        });

        holder.event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Event auxEvent = events.get(holder.getAdapterPosition());
                listener.clicked(auxEvent.getId());
            }
        });


    }


    public void addEvent(Event event){
        events.add(0, event);
        notifyItemInserted(0);
    }

    @Override
    public int getItemCount() {
        return events.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView event;
        private TextView date;
        private TextView hour;
        private CheckBox checkBox;

        public ViewHolder(View itemView) {
            super(itemView);

            hour = (TextView) itemView.findViewById(R.id.eventHourTv);
            date = (TextView) itemView.findViewById(R.id.eventDateTv);
            event = (TextView) itemView.findViewById(R.id.eventNameTv);
            checkBox = (CheckBox) itemView.findViewById(R.id.eventCb);
        }
    }
}
