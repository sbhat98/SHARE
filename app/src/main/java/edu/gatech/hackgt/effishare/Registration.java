package edu.gatech.hackgt.effishare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registration extends AppCompatActivity {

    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

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
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).addOnSuccessListener(this, new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                String uid = authResult.getUser().getUid();
                User u = new User(username, email, uid);
                User.currentUser = u;
                u.writeToDatabase();
            }
        });
    }
}
