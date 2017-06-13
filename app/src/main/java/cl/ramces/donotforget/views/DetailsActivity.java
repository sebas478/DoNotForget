package cl.ramces.donotforget.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import cl.ramces.donotforget.EventListFragment;
import cl.ramces.donotforget.R;
import cl.ramces.donotforget.models.Event;

public class DetailsActivity extends AppCompatActivity {

    private Event event;
    private EditText descriptionInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

      long id = getIntent().getLongExtra(EventListFragment.EVENT_ID, 0);
        event = Event.findById(Event.class ,id);
        descriptionInput = (EditText) findViewById(R.id.descriptionEt);
        getSupportActionBar().setTitle(event.getName());

        String description = event.getDetails();
        if (description != null){
            descriptionInput.setText(description);
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        event.setDetails(descriptionInput.getText().toString());
        event.save();
    }
}
