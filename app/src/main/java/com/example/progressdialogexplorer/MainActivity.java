package com.example.progressdialogexplorer;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.google.android.material.progressindicator.LinearProgressIndicator;

public class MainActivity extends AppCompatActivity {

    LinearProgressIndicator indeterminateLinearProgressBar;
    CircularProgressIndicator indeterminateCircularProgressBar;
    ProgressBar indeterminateProgressBar;
    ProgressDialog progressDialog;
    AlertDialog progressDialog2, alertDialog;
    TextView tvProgressDialogMessage, tvAlertDialogMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        indeterminateLinearProgressBar = (LinearProgressIndicator) findViewById(R.id.indeterminateLinearProgressBar);
        indeterminateCircularProgressBar = (CircularProgressIndicator) findViewById(R.id.indeterminateCircularProgressBar);
        indeterminateProgressBar = (ProgressBar) findViewById(R.id.indeterminateProgressBar);

        indeterminateLinearProgressBar.setVisibility(View.VISIBLE);
        indeterminateCircularProgressBar.setVisibility(View.VISIBLE);
        indeterminateProgressBar.setVisibility(View.VISIBLE);

        /**
         * The ProgressDialog class, which allowed us to create a progress dialog without any xml layout by simply using Java code and a theme/style was deprecated because it was considered outdated and inefficient.
         * Inefficient: The ProgressDialog class was based on a thread-based approach for updating the progress bar, which could lead to performance issues and potential UI freezes.
         * Lack of flexibility: The ProgressDialog class offered limited customization options and could not easily be integrated with modern UI design patterns and frameworks.
         * Deprecated API usage: The ProgressDialog class relied on deprecated APIs, making it less maintainable and harder to use in newer Android versions.
         * To replace it, use an AlertDialog.Builder with custom xml layout and a theme of parent Theme.MaterialComponents.Light.Dialog.Alert that has a background item that defines the background color of the whole alert.
         */

        //Deprecated ProgressDialog
        progressDialog = new ProgressDialog(this, R.style.Theme_ProgressDialog);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Please wait...");
        //progressDialog.show();
        //progressDialog.dismiss();

        //ProgressDialog using AlertDialog.Builder to build a custom progress dialog.
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, R.style.Theme_AlertProgressDialog); //The style sets the background color of the entire alert(inflated layout + button row background)
        LayoutInflater inflater = this.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.progress_dialog, null));
        builder.setCancelable(false);

        progressDialog2 = builder.create();
        progressDialog2.show(); //Note: If you comment this out, you also have to comment out the lines below that set the button text color and textview.

        tvProgressDialogMessage = (TextView) progressDialog2.findViewById(R.id.tvProgressDialogMessage);
        tvProgressDialogMessage.setText("Please wait...");

        //AlertDialog using AlertDialog.Builder.
        AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this, R.style.Theme_AlertDialog); //The style sets the background color of the entire alert(inflated layout + button row background)
        LayoutInflater inflater2 = this.getLayoutInflater();
        builder2.setView(inflater2.inflate(R.layout.alert_dialog, null));
        builder2.setCancelable(false);

        builder2.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder2.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });

        alertDialog = builder2.create();
        /*alertDialog.show(); //Note: If you comment this out, you also have to comment out the lines below that set the button text color and textview.

        Button positiveButton = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE);
        Button negativeButton = alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE);
        positiveButton.setTextColor(ContextCompat.getColor(this, R.color.colorRed));
        negativeButton.setTextColor(ContextCompat.getColor(this, R.color.colorRed));

        tvAlertDialogMessage = (TextView) alertDialog.findViewById(R.id.tvAlertDialogMessage);
        tvAlertDialogMessage.setText("This is an ordinary alert dialog...");*/
    }
}