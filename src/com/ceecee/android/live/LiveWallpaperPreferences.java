package com.ceecee.android.live;


import android.content.Context;
import android.content.SharedPreferences;


public class LiveWallpaperPreferences {

	// Handle for the LiveWallpaperPreferences singleton instance
	private static LiveWallpaperPreferences INSTANCE;
	
	// String containing the live wallpaper's preferences name
	private static final String PREFERENCE_NAME = "LWP_PREFS";
	
	// String containing the key to the particle speed preference value
	private static final String BACKGROUND_KEY = "BACKGROUND_COLOR";
	private static final String DEFAULT_BACKGROUND = "Black";
	
	// Shared preference objects
	private SharedPreferences mSharedPreferences;
	private SharedPreferences.Editor mSharedPreferencesEditor;
	
	// Shared preference values
	private String mBackground;
	
	LiveWallpaperPreferences(){
		// Do nothing...
	}
	
	// Obtain the LiveWallpaperPreferences instance
	public static LiveWallpaperPreferences getInstance(){
		if(INSTANCE == null){
			INSTANCE = new LiveWallpaperPreferences();
		}
		return INSTANCE;
	}
	
	// Initialize the wallpaper's preference file
	public void initPreferences(Context pContext){
		if(mSharedPreferences == null){
			mSharedPreferences = pContext.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
			mSharedPreferencesEditor = mSharedPreferences.edit();
			
			mBackground = mSharedPreferences.getString(BACKGROUND_KEY, DEFAULT_BACKGROUND);
		}
	}
	
	// Return the saved value for the mParticleSpeed variable
	
	public String getBackground(){
		return mBackground;
	}
	
	public void setBackground(String pBackground){
		this.mBackground = pBackground;
		this.mSharedPreferencesEditor.putString(BACKGROUND_KEY, mBackground);
		this.mSharedPreferencesEditor.commit();
	}
}
