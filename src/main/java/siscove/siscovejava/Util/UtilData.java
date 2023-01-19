package siscove.siscovejava.Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilData {

	private static final String FORMATO_DATA = "dd/MM/yyyy";
	
	public static String formataData(Date dataOriginal) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMATO_DATA);
		return simpleDateFormat.format(dataOriginal);
	}
}