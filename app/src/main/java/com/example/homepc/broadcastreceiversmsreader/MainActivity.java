package com.example.homepc.broadcastreceiversmsreader;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    IntentFilter intentFilter = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
    SMSReader smsReader = new SMSReader();


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            registerReceiver(smsReader, intentFilter);
            Log.i("mtag", "Permission Granted");
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("mtag", "onCreate called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //        Toast.makeText(this, "SMSReader initiated", Toast.LENGTH_SHORT).show();

//       if(Build.VERSION.SDK.equals(23)) {
//           int permission = checkSelfPermission(Manifest.permission.READ_SMS);
//
//           if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED) {
//
//               this.requestPermissions(new String[]{Manifest.permission.READ_SMS}, 100);
//           } else {
//               registerReceiver(smsReader, intentFilter);
//           }
//       }
        registerReceiver(smsReader,intentFilter);
    }
}
