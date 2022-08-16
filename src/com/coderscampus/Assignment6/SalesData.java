package com.coderscampus.Assignment6;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class SalesData {

	private YearMonth date;
	private Integer monthlySales;

	public YearMonth getDate() {
		return date;
	}

	public void setDate(YearMonth date) {
		this.date = date;
	}

	public Integer getMonthlySales() {
		return monthlySales;
	}

	public void setMonthlySales(Integer monthlySales) {
		this.monthlySales = monthlySales;
	}

	public SalesData(String date, String monthlySales) {
		this.date = YearMonth.parse(date, DateTimeFormatter.ofPattern("MMM-yy", Locale.US));
		this.monthlySales = Integer.parseInt(monthlySales);
	}

	@Override
	public String toString() {
		return "SalesData [date=" + date + ", monthlySales=" + monthlySales + "]";
	}

}
