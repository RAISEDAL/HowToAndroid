package ca.dal.cs.csci3130.android_advanced.facebook;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

import ca.dal.cs.csci3130.android_advanced.R;

public class FacebookActivity extends AppCompatActivity {

    AccessToken accessToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook);

        CallbackManager callbackManager = CallbackManager.Factory.create();
        LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Toast.makeText(getBaseContext(), "Login succeeded!", Toast.LENGTH_LONG).show();
                accessToken = AccessToken.getCurrentAccessToken();
            }

            @Override
            public void onCancel() {
            }

            @Override
            public void onError(@NotNull FacebookException e) {

            }
        });

        Button accessGraphButton = findViewById(R.id.accessGraphButton);
        accessGraphButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                accessGraphAPI();
            }
        });
    }

    protected void accessGraphAPI() {
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        GraphRequest request = GraphRequest.newMeRequest(accessToken, new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(@Nullable JSONObject jsonObject, @Nullable GraphResponse graphResponse) {
                try {
                    JSONObject response = graphResponse.getJSONObject();
                    String name = response.getString("name");
                    String id = response.getString("id");
                    Toast.makeText(getBaseContext(), "Name:" + name + ", ID:" + id, Toast.LENGTH_LONG).show();

                } catch (Exception exc) {
                    exc.printStackTrace();
                }
            }
        });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,name,link");
        request.setParameters(parameters);
        request.executeAsync();
    }


}