package br.com.boaviagem;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class PreferenceController {

	private final SharedPreferences preferences;

	public PreferenceController(Activity activity) {
		preferences = activity.getPreferences(Activity.MODE_PRIVATE);
	}

	public String getUser() {
		return preferences.getString(EnPreference.USER.toString(), null);
	}

	public void setUser(String user) {
		Editor edit = preferences.edit();
		edit.putString(EnPreference.USER.toString(), user);
		edit.commit();
	}

	public String getPass() {
		return preferences.getString(EnPreference.PASS.toString(), null);
	}

	public void setPass(String pass) {
		Editor edit = preferences.edit();
		edit.putString(EnPreference.PASS.toString(), pass);
		edit.commit();
	}

	public boolean isKeepLoged() {
		return preferences.getBoolean(EnPreference.KEEP_LOGGED.toString(), false);
	}

	public void setKeepLoged(boolean keeplogged) {
		Editor edit = preferences.edit();
		edit.putBoolean(EnPreference.KEEP_LOGGED.toString(), keeplogged);
		edit.commit();
	}
}
