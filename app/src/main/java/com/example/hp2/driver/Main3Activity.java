package com.example.hp2.driver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class Main3Activity extends AppCompatActivity {

    Firebase f3;
    @InjectView(R.id.textView2)
    TextView value;
    ArrayList<User> userList;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        userList = new ArrayList<>();
        ButterKnife.inject(this);
        f3=new Firebase("https://driver-e8f62.firebaseio.com/user");

        f3.addValueEventListener(new ValueEventListener() {
            @Override
          /*  public void onDataChange(DataSnapshot dataSnapshot) {
                Map<String,String> map =dataSnapshot.getValue(Map.class);
                String email= map.get("email");
                String gender= map.get("gender");

                String name= map.get("name");
                String password= map.get("password");
                Log.v("E_value", "email" + email);
                Log.v("E_value", "email" +gender);
                Log.v("E_value", "name" +name);


            }*/

             //here user will sign in using his name so it is based on user, directory will change dynamically

                public void onDataChange(DataSnapshot dataSnapshot) {

                  //  User user = dataSnapshot.getValue(User.class);

                for (DataSnapshot messageSnapshot: dataSnapshot.getChildren()) {
                  //  String name = (String) messageSnapshot.child("name").getValue();
                   // String ema = (String) messageSnapshot.child("email").getValue();
                   // Map<String, Object> map = (Map<String, Object>) messageSnapshot.getValue();
                   user = messageSnapshot.getValue(User.class);
                   // int id =user.getId();
                    String name =user.getName();
                    String email =user.getEmail();
                    String password =user.getPassword();
                    String gender =user.getGender();
                    String city =user.getCity();
                    //String a = (String) map.get("email");
                   // String b = (String) map.get("name");

                    //Log.v("E_value", "ema" +b);
                   /// userList.add(new User(id,name,email,password,gender,city));
                    for(User d:userList) {
                        System.out.println(d);
                        Log.v("E_value", "ema" +d);
                        // prints [Tommy, tiger]
                    }
                }
                }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }


        });





    }

}
