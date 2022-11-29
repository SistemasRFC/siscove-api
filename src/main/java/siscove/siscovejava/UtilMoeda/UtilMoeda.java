package siscove.siscovejava.UtilMoeda;

import java.text.DecimalFormat;

public class UtilMoeda {

	private static final String FORMATO_MOEDA = "###,###.00";

	public static String formataMoeda(Double moedaOriginal) {
		DecimalFormat df = new DecimalFormat(FORMATO_MOEDA);
		return df.format(moedaOriginal);

	}
}
