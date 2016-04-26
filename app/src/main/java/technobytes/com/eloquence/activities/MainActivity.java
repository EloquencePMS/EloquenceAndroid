package technobytes.com.eloquence.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.App;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.rest.spring.annotations.RestService;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestClientException;

import technobytes.com.eloquence.R;
import technobytes.com.eloquence.rest.Data;
import technobytes.com.eloquence.rest.responses.AuthenticateLogin;
import technobytes.com.eloquence.utils.Globals;


@EActivity(R.layout.main)
public class MainActivity extends AppCompatActivity {

    AuthenticateLogin login;

    LinkedMultiValueMap<String, String> formData;
    Context context;

    @RestService
    Data restClient;

    @App
    Globals app;

    @ViewById
    EditText etUserName, etPassword;

    @ViewById
    Button btnLogin;

    @ViewById
    TextView title;

    @AfterInject
    void AfterInject(){
        context = MainActivity.this;

    }

    @AfterViews
    void AfterViews(){
        etUserName.setText("GeneralManager");
        etPassword.setText("generalManager");
    }

    @Click(R.id.btnLogin)
    void clickedLogin(){
        if (etUserName.getText().length() <= 0 || etPassword.getText().length() <= 0){
            return;
        }

        formData = new LinkedMultiValueMap<String, String>();
        formData.add("user", etUserName.getText().toString());
        formData.add("password", etPassword.getText().toString());

        login(formData);




    }

    @Background
    void login(LinkedMultiValueMap formData){
        try {
            login = restClient.authenticateLogin(formData);
        }catch (RestClientException e) {
            Log.d("shiz", "Login done messed up " + e.getMessage());
        }
        if (login != null) {
            Gson gson = new Gson();
            Log.d("responses ", "Login json response " + gson.toJson(login));

            app.setToken(login.getToken());

            goToDashboard();


        }


    }

    @UiThread(propagation = UiThread.Propagation.REUSE)
    void goToDashboard(){
        Dashboard_.intent(context).start();

    }

}
