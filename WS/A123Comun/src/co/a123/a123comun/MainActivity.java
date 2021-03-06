package co.a123.a123comun;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.gcm.GoogleCloudMessaging;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button tomarFoto;
	private Button tomarVideo;
	private Button llamarA123;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        checkPlayServices();
        
        
        tomarFoto = (Button) findViewById(R.id.tomarFoto);
        tomarVideo = (Button) findViewById(R.id.tomarVideo);
        llamarA123 = (Button) findViewById(R.id.llamarA123);
        
        tomarFoto.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				 
				int TAKE_PICTURE = 1;  
				Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			    startActivityForResult(intent, TAKE_PICTURE);
			    
			}
		});
        
        tomarVideo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				int VIDEO_CAPTURED = 2;
				Intent captureVideoIntent = new Intent(android.provider.MediaStore.ACTION_VIDEO_CAPTURE);
			    startActivityForResult(captureVideoIntent, VIDEO_CAPTURED);
				
			}
		});
        
        llamarA123.setOnClickListener(new OnClickListener() {
			
			@Override
			public void  onClick(View v) {
			
				Intent callIntent = new Intent(Intent.ACTION_CALL);
			    callIntent.setData(Uri.parse("tel:123"));
			    startActivity(callIntent);
				
			}
		});
        
    }
    
    private boolean checkPlayServices() {
    	   
    	int resultCode =GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext());
    	   
    	if (resultCode != ConnectionResult.SUCCESS) {
    	      if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
    	         GooglePlayServicesUtil.getErrorDialog(resultCode,this,1).show();
    	      } else {
    	         Log.i("grokkingandroid","This device is not supported.");
    	      }
    	      return false;
    	}
    	return true;
   }
}

