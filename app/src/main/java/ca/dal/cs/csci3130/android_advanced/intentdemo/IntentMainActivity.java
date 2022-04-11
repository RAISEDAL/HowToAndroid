package ca.dal.cs.csci3130.android_advanced.intentdemo;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import ca.dal.cs.csci3130.android_advanced.R;

public class IntentMainActivity extends AppCompatActivity {

    public static String NAME = "student.name";
    public static String CSID = "student.csid";

    int selectedButtonID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_main);

        Button moveButton = findViewById(R.id.switchButton);
        moveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (selectedButtonID) {
                    case R.id.webButton:
                        browseWeb();
                        break;
                    case R.id.webQueryButton:
                        searchWithSearchEngine();
                        break;
                    case R.id.callMeButton:
                        callMe();
                        break;
                    case R.id.readContactButton:
                        getContacts();
                        break;
                    case R.id.sendDataButton:
                        move2TargetWithData();
                        break;
                    case R.id.sendEmailButton:
                        sendEmail();
                        break;
                    default:
                        move2Target();
                        break;
                }
            }
        });

        RadioGroup optionList = findViewById(R.id.optionList);
        optionList.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                selectedButtonID = optionList.getCheckedRadioButtonId();
            }
        });
    }


    protected void move2Target() {
        Intent intent = new Intent(IntentMainActivity.this, IntentTargetActivity.class);
        startActivity(intent);
    }

    protected void move2TargetWithData() {
        Intent intent = new Intent(IntentMainActivity.this, IntentTargetActivity.class);
        intent.putExtra(NAME, "Max Payne");
        intent.putExtra(CSID, "max123");
        startActivity(intent);
    }

    protected void getContacts() {
        Intent read = new Intent();
        read.setAction(android.content.Intent.ACTION_VIEW);
        read.setData(ContactsContract.Contacts.CONTENT_URI);
        startActivity(read);
    }

    protected void browseWeb() {
        Intent browse = new Intent();
        browse.setAction(Intent.ACTION_VIEW);
        browse.setData(Uri.parse("http://www.google.ca"));
        startActivity(browse);
    }

    protected void searchWithSearchEngine() {
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, "Max Payne");
        startActivity(intent);
    }

    protected void callMe() {
        Intent call = new Intent();
        call.setAction(Intent.ACTION_VIEW);
        call.setData(Uri.parse("tel:13062419293"));
        startActivity(call);
    }

    protected void sendEmail() {
        String[] to={"masud.rahman@dal.ca"};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "How to excel in CSCI 3130?");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Consult these tutorials properly!");
        try {
            startActivity(Intent.createChooser(emailIntent, "Sending email ..."));
            finish();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }


}