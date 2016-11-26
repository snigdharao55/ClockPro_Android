package android.csulb.edu.ihav2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by chatura on 11/21/2016.
 */
public class Action extends Activity{
    String phone = "";
    String address = "";
    Button btnPhone;
    EditText editPhone;
    EditText editemail;
    Button btnemail;

        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.action_to_take);
            btnPhone = (Button) findViewById(R.id.butt);
            editPhone = (EditText) findViewById(R.id.edit);
            editemail = (EditText) findViewById(R.id.email);
            btnemail = (Button) findViewById(R.id.buttin1);
            btnPhone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    phone = editPhone.getText().toString();
                    call();
                }
            });
            btnemail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {

                    String emailText = "We’ll discuss the new project "
                            + "on Tue. at 9:00am @ room BU344"; String[] emailReceiverList = {editemail.getText().toString()};
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("vnd.android.cursor.dir/email"); intent.putExtra(Intent.EXTRA_EMAIL, emailReceiverList);  intent.putExtra(Intent.EXTRA_TEXT, emailText);
                    startActivity(Intent.createChooser(intent,
                            "To complete action choose:"));

                }
            });
        }
    public void call() {
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:"+phone));
        startActivity(callIntent);
    }




}



