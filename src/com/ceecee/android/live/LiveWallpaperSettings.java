package com.ceecee.android.live;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

	public class LiveWallpaperSettings extends Activity implements OnCheckedChangeListener{
	
		private RadioGroup radioBackgroundGroup;
		private RadioButton radioBackgroundButton;
		private String mBackground;

		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			this.setContentView(R.layout.prefs);			
			radioBackgroundGroup = (RadioGroup) findViewById(R.id.radioBackground);	
			radioBackgroundGroup.setOnCheckedChangeListener(this);	
			
				}

		@Override
		protected void onPause() {
			// onPause(), we save the current value to the preference file.
			LiveWallpaperPreferences.getInstance().setBackground(mBackground);

			super.onPause();
		}

		@Override
		public void onCheckedChanged(RadioGroup group, int selectedId) {
			// TODO Auto-generated method stub

		selectedId = radioBackgroundGroup.getCheckedRadioButtonId();
		radioBackgroundButton = (RadioButton) findViewById(selectedId);
		mBackground = (String) radioBackgroundButton.getText();
	
		}

	}
		