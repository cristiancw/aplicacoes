package br.com.boaviagem;

import org.junit.Test;

import android.app.Activity;

public class PreferenceControllerTest {

	@Test
	public void getUserTest01() {
		Activity activity = new Activity();
		PreferenceController preferenceController = new PreferenceController(activity);
		preferenceController.getUser();
	}

}
