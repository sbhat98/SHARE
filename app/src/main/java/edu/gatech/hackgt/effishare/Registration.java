package edu.gatech.hackgt.effishare;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registration extends AppCompatActivity {

    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    Context curr_ctx = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Button mRegisterButton = findViewById(R.id.button_do_register);
        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptRegister();
            }
        });
    }

    private void attemptRegister() {
        final String username = ((TextView)findViewById(R.id.textInputUsername)).getText().toString();
        final String email = ((TextView)findViewById(R.id.textInputEmail)).getText().toString();
        String password = ((TextView)findViewById(R.id.textInputPassword)).getText().toString();
        Toast.makeText(curr_ctx, "Creating user...", Toast.LENGTH_LONG).show();
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).addOnSuccessListener(this, new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                String uid = authResult.getUser().getUid();
                User u = new User(username, email, uid);
                User.currentUser = u;
                u.writeToDatabase();
                // call link to Join_Create:
                curr_ctx.startActivity(new Intent(curr_ctx, Join_create.class));
            }
        }).addOnFailureListener(this, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.println(Log.ERROR, "Mickey Mouse", Log.getStackTraceString(e));
            }
        });
    }
}
