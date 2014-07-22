package br.com.boaviagem;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

public class DateControllerTest {

	@Test
	public void formatDateToStringTest01() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 2013);
		calendar.set(Calendar.MONTH, Calendar.DECEMBER);
		calendar.set(Calendar.DAY_OF_MONTH, 14);
		Assert.assertEquals("14/12/2013", DateController.format(calendar.getTime()));
	}

	@Test
	public void formatDateToStringTest02() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 2000);
		calendar.set(Calendar.MONTH, Calendar.JANUARY);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		Assert.assertEquals("01/01/2000", DateController.format(calendar.getTime()));
	}

	@Test
	public void formatLongToStringTest01() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 2013);
		calendar.set(Calendar.MONTH, Calendar.DECEMBER);
		calendar.set(Calendar.DAY_OF_MONTH, 14);
		Assert.assertEquals("14/12/2013", DateController.format(calendar.getTimeInMillis()));
	}

	@Test
	public void formatLongToStringTest02() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 2000);
		calendar.set(Calendar.MONTH, Calendar.JANUARY);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		Assert.assertEquals("01/01/2000", DateController.format(calendar.getTimeInMillis()));
	}

	@Test
	public void formatParamsToStringTest01() {
		Assert.assertEquals("14/12/2013", DateController.format(14, 12, 2013));
	}

	@Test
	public void formatParamsToStringTest02() {
		Assert.assertEquals("01/01/2000", DateController.format(1, 1, 2000));
	}

	@Test
	public void formatStringToDateTest01() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 2013);
		calendar.set(Calendar.MONTH, Calendar.DECEMBER);
		calendar.set(Calendar.DAY_OF_MONTH, 14);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		Assert.assertEquals(calendar.getTime(), DateController.format("14/12/2013"));
	}

	@Test
	public void formatStringToDateTest02() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 2000);
		calendar.set(Calendar.MONTH, Calendar.JANUARY);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		Assert.assertEquals(calendar.getTime(), DateController.format("01/01/2000"));
	}
}
