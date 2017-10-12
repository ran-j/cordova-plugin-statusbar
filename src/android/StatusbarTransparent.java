package de.dataexperts.cordova.plugin.statusbar;

import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;

import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.view.WindowManager.LayoutParams;

public class StatusbarTransparent extends CordovaPlugin {

	public void initialize(CordovaInterface crdv, CordovaWebView webView) {        	
		super.initialize(crdv, webView);
		
		if(VERSION.SDK_INT >= VERSION_CODES.KITKAT) {
			crdv.getActivity().runOnUiThread( new Runnable() {
				public void run() {
					cordova.getActivity().getWindow().clearFlags(LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
					cordova.getActivity().getWindow().addFlags(LayoutParams.FLAG_TRANSLUCENT_STATUS);
				}
			});			
		} 
	}
	
	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callback) throws JSONException {
		// grab the correct methods
		if(action.equalsIgnoreCase("enable")) {
			if(VERSION.SDK_INT >= VERSION_CODES.KITKAT) {
				cordova.getActivity().runOnUiThread( new Runnable() {
					public void run() {
						cordova.getActivity().getWindow().clearFlags(LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
						cordova.getActivity().getWindow().addFlags(LayoutParams.FLAG_TRANSLUCENT_STATUS);
					}
				});
				callback.success();
			} else {
				callback.error("not supported");
			}
			return true;
		} else if(action.equalsIgnoreCase("disable")) {
			if(VERSION.SDK_INT >= VERSION_CODES.KITKAT) {
				cordova.getActivity().runOnUiThread( new Runnable() {
					public void run() {
						cordova.getActivity().getWindow().clearFlags(LayoutParams.FLAG_TRANSLUCENT_STATUS);
					}
				});
				callback.success();
			} else {
				callback.error("not supported");
			}
			return true;
		} else {
			callback.error("Unknown Action: " + action);
			return false;
		}
	}
}
