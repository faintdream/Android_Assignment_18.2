package com.example.homepc.broadcastreceiversmsreader;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;


/**
 * Created by homepc on 01-03-2018.
 */

public class SMSReader extends BroadcastReceiver {
    final SmsManager smsManager=SmsManager.getDefault();


    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("mtag", "onReceive called");
        final   Bundle bundle=intent.getExtras();
        if (bundle!=null){
            Log.i("mtag", "SMS Received Intent");

            Object[] something=(Object[])bundle.get("pdus");
            Log.i("mtag", "pdus bundle value stored");
            SmsMessage smsMessage;
            Log.i("mtag", "pdu data stored on smsMessage");
            for(int i=0;i< something.length;i++){
                smsMessage = SmsMessage.createFromPdu((byte[])something[i]);
                Toast.makeText(context, "Message `Body -> "+smsMessage.getDisplayMessageBody().toString(), Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(context, "No send message found", Toast.LENGTH_SHORT).show();
        }
    }
}
