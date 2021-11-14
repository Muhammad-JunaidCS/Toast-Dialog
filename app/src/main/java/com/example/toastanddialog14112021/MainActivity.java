package com.example.toastanddialog14112021;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button toastButton,dialogButton,customToastButton,customDialogButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //binding buttons
       toastButton=findViewById(R.id.toast);
       dialogButton=findViewById(R.id.dialog);
       customToastButton=findViewById(R.id.customToast);
       customDialogButton=findViewById(R.id.customDialog);

       //setting click listener for each button
        toastButton.setOnClickListener(this);
        dialogButton.setOnClickListener(this);
        customDialogButton.setOnClickListener(this);
        customToastButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.toast:
                Toast toast =  Toast.makeText(this, "Toast Text", Toast.LENGTH_LONG);
                toast.show();
                break;
            case R.id.dialog:
                // Create the object of AlertDialog Builder class
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                // Set the message show
                builder.setMessage("Message  to be show");
                // Set Alert Title
                builder.setTitle("Alert !");
                // Set Cancelable false for when the user clicks on the outside the Dialog Box then it will remain show
                builder.setCancelable(false);
                builder.setPositiveButton("Positive Button",new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int asdf)
                    {
                        finish();
                    }
                });
                builder.setNegativeButton("Negative Button",new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        dialog.cancel();
                    }});
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                break;
            case R.id.customToast:
                LayoutInflater layoutInflater = getLayoutInflater();
                View myLayout=layoutInflater.inflate(R.layout.custom_layout,(ViewGroup)findViewById(R.id.cusToast) );

//                ImageView cameraIamge=myLayout.findViewById(R.id.imageViewCamera);
//                cameraIamge.setImageResource(R.drawable.ic_baseline_local_see_24);
//                TextView myMessage=(TextView)myLayout.findViewById(R.id.textViewCameraInfo);
//                myMessage.setText("My Custom Toast");
                Toast myToast=new Toast(getApplicationContext());
                myToast.setDuration(Toast.LENGTH_LONG);
                myToast.setView(myLayout);
                myToast.show();
                break;
            case R.id.customDialog:
                break;
        }
    }
}