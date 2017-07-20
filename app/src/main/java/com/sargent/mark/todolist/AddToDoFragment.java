package com.sargent.mark.todolist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by mark on 7/4/17.
 */

public class AddToDoFragment extends DialogFragment {

    private EditText toDo;
    private DatePicker dp;
    private Button add;
    private final String TAG = "addtodofragment";
    //instantiated ArrayAdapter as spinAdapter
    ArrayAdapter spinAdapter;
    //instantiated Spinner as spinner
    Spinner spinner;

    public AddToDoFragment() {
    }

    //To have a way for the activity to get the data from the dialog
    public interface OnDialogCloseListener {
        void closeDialog(int year, int month, int day, String description);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.fragment_to_do_adder, container, false );
        toDo = (EditText) view.findViewById( R.id.toDo );
        dp = (DatePicker) view.findViewById( R.id.datePicker );
        add = (Button) view.findViewById( R.id.add );

        final Calendar c = Calendar.getInstance();
        int year = c.get( Calendar.YEAR );
        int month = c.get( Calendar.MONTH );
        int day = c.get( Calendar.DAY_OF_MONTH );
        dp.updateDate( year, month, day );
        //spinner variable is used to call the spinner I used for a particular TODOItem
        spinner = (Spinner) view.findViewById( R.id.todo_spinner );

        // Create an ArrayAdapter using the string array and a default spinner layout
        spinAdapter = ArrayAdapter.createFromResource( this.getContext(), R.array.todo_array, android.R.layout.simple_spinner_item );
        // It is Specifying the layout being used when the list of choices appears
        spinAdapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
        //set the spinAdapter to the spinner
        spinner.setAdapter( spinAdapter );

        add.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnDialogCloseListener activity = (OnDialogCloseListener) getActivity();
                activity.closeDialog( dp.getYear(), dp.getMonth(), dp.getDayOfMonth(), toDo.getText().toString() );
                AddToDoFragment.this.dismiss();
            }
        } );

        return view;
    }

    //created a method called when checkbox is clicked
    public void onCheckboxClicked(View view) {
        //checked is a boolean variable used to store the status of checkbox. It will be true if checkbox is ticked and vice versa
        boolean checked = ((CheckBox) view).isChecked();
        //check which heckbox is clicked
        switch (view.getId()) {
            case R.id.checkbox_done:
                //if checkbox is checked if block will be executed
                if (checked) {

                }
                //if checkbox is not checked else block will be executed
                else {
                    break;
                }
        }

    }
}



