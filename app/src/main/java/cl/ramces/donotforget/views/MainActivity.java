package cl.ramces.donotforget.views;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;

import cl.ramces.donotforget.EventListFragment;
import cl.ramces.donotforget.R;
import cl.ramces.donotforget.models.Event;

public class MainActivity extends AppCompatActivity {

    private EventListFragment eventsListFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        eventsListFragment = (EventListFragment) getSupportFragmentManager().findFragmentById(R.id.eventListFragment);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(MainActivity.this, R.style.FullscreenTheme_Background);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_event);
                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
                ImageButton button = (ImageButton) dialog.findViewById(R.id.saveBtn);
                final EditText editText = (EditText) dialog.findViewById(R.id.nameEt);
                final EditText editText1 = (EditText) dialog.findViewById(R.id.dateEt);
                final EditText editText2 = (EditText) dialog.findViewById(R.id.hourEt);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = editText.getText().toString();
                        String day = editText1.getText().toString();
                        String hour = editText2.getText().toString();
                        if (name.trim().length()>0){

                            Event event = new Event();
                            event.setName(name);
                            event.setDate(day);
                            event.setHour(hour);
                            event.setDone(false);
                            eventsListFragment.addEvent(event);
                            event.save();


                        }
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
    }
}
