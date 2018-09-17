package com.hpe.tolet.Google;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.hpe.tolet.IconTextTabsActivity;
import com.hpe.tolet.R;

public class GoogleActivity extends AppCompatActivity {

    private static final int RC_SIGN_IN = 123;
    private static final String TAG ="Tag" ;
    GoogleSignInClient mGoogleSignInClient;
    FirebaseAuth mAuth;
String email1,url1;
    //
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google);
        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        //intialize mgooglesigninclient
        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        //initialize
        mAuth=FirebaseAuth.getInstance();
        //
        findViewById(R.id.sign_in_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });

        preferences=getApplicationContext().getSharedPreferences("Myprefs", Context.MODE_PRIVATE);
       editor=preferences.edit();

    }
    public void signIn() {
        Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show();
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Toast.makeText(this, "Google sign in failed"+ e, Toast.LENGTH_SHORT).show();
                Log.w(TAG, "Google sign in failed", e);
                // ...
            }
        }
    }

    //
    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(GoogleActivity.this, "signInWithCredential:success", Toast.LENGTH_SHORT).show();
                            Log.d(TAG, "signInWithCredential:success");

                            FirebaseUser user = mAuth.getCurrentUser();
                            mAuth=FirebaseAuth.getInstance();
                            FirebaseUser firebaseUser=mAuth.getCurrentUser();
                            assert firebaseUser != null;
                            email1=firebaseUser.getEmail();
                            url1= String.valueOf(firebaseUser.getPhotoUrl());
                            editor.putString("gmail",email1);
                            editor.putString("url",url1);
                            editor.apply();
                            Toast.makeText(GoogleActivity.this, "gmail stored"+firebaseUser.getEmail(), Toast.LENGTH_SHORT).show();

                            Intent intent=new Intent(GoogleActivity.this, IconTextTabsActivity.class);
                            startActivity(intent);
                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Toast.makeText(GoogleActivity.this, "Authentication Failed.", Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }

                        // ...
                    }
                });
    }

//profile activity


    @Override
    protected void onStart() {
        super.onStart();
        if (mAuth.getCurrentUser()!=null)
        {
            mAuth=FirebaseAuth.getInstance();
            FirebaseUser firebaseUser=mAuth.getCurrentUser();
email1=firebaseUser.getEmail();
url1= String.valueOf(firebaseUser.getPhotoUrl());
            editor.putString("gmail",email1);
            editor.putString("url",url1);
           editor.apply();
            Toast.makeText(this, "gmail stored"+firebaseUser.getEmail(), Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(GoogleActivity.this, IconTextTabsActivity.class);
            startActivity(intent);
            finish();

        }
    }
}
