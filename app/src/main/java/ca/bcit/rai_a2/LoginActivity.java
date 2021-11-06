package ca.bcit.rai_a2;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class LoginActivity extends AppCompatActivity {

    EditText editEmail, editPassword;
    Button btnRegister;
    FirebaseAuth fAuth;
    Button login;
    Button register;
    TextView tvLogin;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editEmail = findViewById(R.id.userEmail);
        editPassword = findViewById(R.id.userPassword);
        btnRegister = findViewById(R.id.login_button2);
        tvLogin = findViewById(R.id.login_button1);
        progressBar = findViewById(R.id.progressBar);
        fAuth = FirebaseAuth.getInstance();

        if (fAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editEmail.getText().toString().trim();
                String password = editPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    editEmail.setError("Email is required");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    editEmail.setError("Password is required");
                    return;
                }

                if (password.length() <6) {
                    editEmail.setError("Password must be >= 6 characters.");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);
                // register user
                fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "User Created", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        } else {
                            Toast.makeText(LoginActivity.this, "ERROR: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });

            }

        });

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                String email = editEmail.getText().toString().trim();
                String password = editPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    editEmail.setError("Email is required");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    editEmail.setError("Password is required");
                    return;
                }

                if (password.length() <6) {
                    editEmail.setError("Password must be >= 6 characters.");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                //authenticate user
                fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "Login successful!", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        } else {
                            Toast.makeText(LoginActivity.this, "ERROR: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
    }
    public void onLoginInClick(View view) {
        checkData();
        signIn(email, password);
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
    public void onRegisterClick(View view) {
        checkData();
        createAccount(email, password);
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
    private void reload() {
    }

    private void updateUI(FirebaseUser user) {

            }
        });
    }
}


//
//
//    EditText email;
//    EditText password;
//    Button login;
//    Button register;
//    private FirebaseAuth mAuth;
//    private static final String TAG = "EmailPassword";
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//        mAuth = FirebaseAuth.getInstance();
//        email = findViewById(R.id.userEmail);
//        password = findViewById(R.id.userPassword);
//        login = findViewById(R.id.login_button1);
//        register = findViewById(R.id.login_button2);
//
//        if (mAuth.getCurrentUser() != null) {
//            startActivity(new Intent(getApplicationContext(), MainActivity.class));
//            finish();
//        }
//
//        FileInputStream serviceAccount = null;
//
//        try {
//            serviceAccount = new FileInputStream("copm3717-a2-firebase-adminsdk-2qre2-1975443a95.json");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        FirebaseOptions options = new FirebaseOptions.setCredentials(GoogleCredentials.fromStream(serviceAccount))
//                .setDatabaseUrl("https://copm3717-a2-default-rtdb.firebaseio.com")
//                .build();
//
//        FirebaseApp.initializeApp(options);
//    }
//
//    @Override
//    public void onStart() {
//        super.onStart();
//        // Check if user is signed in (non-null) and update UI accordingly.
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        if (currentUser != null) {
//            reload();
//        }
//    }
//
//    void checkData() {
//        if (isEmpty(email)) {
//            Toast t = Toast.makeText(this, "You must enter email to register!", Toast.LENGTH_SHORT);
//            t.show();
//        }
//        if (isEmpty(password)) {
//            password.setError("Password is required!");
//        }
//    }
//
//    boolean isEmpty(EditText text) {
//        CharSequence str = text.getText().toString();
//        return TextUtils.isEmpty(str);
//    }
//
//    private void createAccount(EditText email, EditText password) {
//        // [START create_user_with_email]
//        mAuth.createUserWithEmailAndPassword(email.toString(), password.toString())
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            // Sign in success, update UI with the signed-in user's information
//                            Log.d(TAG, "createUserWithEmail:success");
//                            FirebaseUser user = mAuth.getCurrentUser();
//                            updateUI(user);
//                        } else {
//                            // If sign in fails, display a message to the user.
//                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
//                            Toast.makeText(LoginActivity.this, "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
//                            updateUI(null);
//                        }
//                    }
//                });
//        // [END create_user_with_email]
//    }
//
//    private void signIn(EditText email, EditText password) {
//        // [START sign_in_with_email]
//        mAuth.signInWithEmailAndPassword(email.toString(), password.toString())
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            // Sign in success, update UI with the signed-in user's information
//                            Log.d(TAG, "signInWithEmail:success");
//                            FirebaseUser user = mAuth.getCurrentUser();
//                            updateUI(user);
//                        } else {
//                            // If sign in fails, display a message to the user.
//                            Log.w(TAG, "signInWithEmail:failure", task.getException());
//                            Toast.makeText(LoginActivity.this, "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
//                            updateUI(null);
//                        }
//                    }
//                });
//    }
//    public void onSignInClick(View view) {
//        checkData();
//        signIn(email, password);
//        Intent i = new Intent(this, MainActivity.class);
//        startActivity(i);
//    }
//    public void onRegisterClick(View view) {
//        checkData();
//        createAccount(email, password);
//        Intent i = new Intent(this, MainActivity.class);
//        startActivity(i);
//    }
//    private void reload() {
//    }
//
//    private void updateUI(FirebaseUser user) {
//
//    }
