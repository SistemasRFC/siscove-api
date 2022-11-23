package siscove.siscovejava.Utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class utilData {

	public static DateFormat Calendar;

	public static class DateFormatExample {
		public static void Date(Date[] args) {
			Date date = DateFormat.getInstance().getTimeZone();
		}

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String today = DateTimeFormatter.format(date);

	}
}