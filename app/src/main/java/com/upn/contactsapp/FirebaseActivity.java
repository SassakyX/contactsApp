package com.upn.contactsapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.upn.contactsapp.entities.Contact;

import java.lang.invoke.ConstantCallSite;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FirebaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);

        Button btn = findViewById(R.id.btnCreateOnFirebase);
        EditText etname =findViewById(R.id.etName);
        btn.setOnClickListener(v -> {
            // Write a message to the database
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference contactoRef = database.getReference("N00285706");
            List<Contact> Contacto= new ArrayList<>();
            contactoRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for (DataSnapshot child : dataSnapshot.getChildren()) {
                        Contact c = child.getValue(Contact.class);
                        Contacto.add(c);
                    }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }

                                              });

           // DatabaseReference table = myRef.child("Contacts");
          //  Contact c2 = new Contact("Miguel", "123456");
           // c2.uuid = UUID.randomUUID().toString();
           // String name = etname.getText().toString();
           // Contact c1 = new Contact(name, "999891919");
            //c1.uuid = UUID.randomUUID().toString();
            //table.child(c1.uuid).setValue(c1);
           // table.child(c2.uuid).setValue(c2);
           // table.child(c1.uuid).setValue(c1);

           // etname.setText("");
        });

    }
}