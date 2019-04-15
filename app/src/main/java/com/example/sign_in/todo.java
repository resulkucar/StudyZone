package com.example.sign_in;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class todo extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener{
    //Decalring variables to be used in todo class

    //The text field
    private EditText itemET;
    //the add button
    private Button btn;
    //The item list that is displayed under the text field
    private ListView itemsList;
    //array list of strings that contain the items in the ListView
    private ArrayList<String> items;
    //adapter is used to add the items to the list (required)
    private ArrayAdapter<String> adapter;

    private Button reminders;
//    private Button home;
    private Button music;

    /**
     * onCreate
     * initializes all of the class scope variables when the app is launched
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);
        itemET = findViewById(R.id.item_edit_text);
        btn = findViewById(R.id.add_btn);
        itemsList = findViewById(R.id.items_list);
        reminders = findViewById(R.id.reminderBtn);
        music = findViewById(R.id.musicBtn);
//        home = findViewById(R.id.homeBtn);
        FileHelper fileHelper = new FileHelper();
        items = fileHelper.readData(this);
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,items);
        itemsList.setAdapter(adapter);
        btn.setOnClickListener(this);
//        reminders.setOnClickListener(this);
//        home.setOnClickListener(this);
//        music.setOnClickListener(this);
        itemsList.setOnItemClickListener(this);

    }

    /**
     * onClick
     * required by the View.onClickListener interface, it is used for the add button only in this class (can be expanded by adding another case for the switch.
     * @param v
     */
    @Override
    public void onClick(View v) {
        //switch that looks at the view and checks to see which button is pressed ( in this case there is only the add button
        switch(v.getId()){
            //case for the add button
            case R.id.add_btn:
                //String that stores what the text that was entered into the EditText
                String itemEntered = itemET.getText().toString();
                if (itemEntered.equals("")){
                    Toast.makeText(this,"You cant add nothing...",Toast.LENGTH_SHORT).show();break;
                }
                //add to the adapter that was previously defined to be a simple list layout in the onCreate method
                //also add it the the items arrayList
                adapter.add(itemEntered);
                //reset the EditText to an empty string
                itemET.setText("");
                //write the data to the file
                FileHelper fileHelper = new FileHelper();
                fileHelper.writeData(items,this);
                //Toast the user with a simple "Items Added" popup
                Toast.makeText(this, "Item Added", Toast.LENGTH_SHORT).show();
                break;
//            case R.id.homeBtn:
//                Intent intent = new Intent(todo.this, HomeActivity.class);
//                startActivity(intent);
//                break;
//            case R.id.remindersBtn:
//                Intent intent1 = new Intent(todo.this, pickActivity.class);
//                startActivity(intent1);
//                break;
//            case R.id.musicBtn:
//                Intent intent2 = new Intent(todo.this, playlistPicker.class);
//                startActivity(intent2);
//                break;
        }
    }

    /**
     * onItemClick
     * required by the OnItemClickListener interface, used if something in the list under the EditText is click on by the user
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //remove that item from the arrayList
        items.remove(position);
        //notify the adapter that a change has been made in the ArrayList and to update (effectively removing the item that is display on the screen that was clicked on)
        adapter.notifyDataSetChanged();
        //rewrite the data to the file so it remains updated
        FileHelper fileHelper = new FileHelper();
        fileHelper.writeData(items, this);
        //Toast the user and show that the item has been deleted
        Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
    }
}
