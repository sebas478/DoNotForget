package cl.ramces.donotforget;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cl.ramces.donotforget.adapters.EventsAdapter;
import cl.ramces.donotforget.adapters.EventsClick;
import cl.ramces.donotforget.models.Event;
import cl.ramces.donotforget.views.DetailsActivity;

/**
 * Created by sebas on 30-05-2017.
 */

public class EventListFragment extends Fragment implements EventsClick{

    private EventsAdapter adapter;
    public static final String EVENT_ID = "cl.ramces.donotforget.KEY.EVENT_ID";

    public EventListFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_events, container ,false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = (RecyclerView) view;
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);



        adapter = new EventsAdapter(this);

        recyclerView.setAdapter(adapter);
    }

    public void addEvent(Event event){
        adapter.addEvent(event);

        Log.d("Events", event.getName());
    }


    @Override
    public void clicked(long id) {
        Intent intent = new Intent(getActivity(), DetailsActivity.class);
        intent.putExtra(EVENT_ID, id);
        startActivity(intent);

    }

}
