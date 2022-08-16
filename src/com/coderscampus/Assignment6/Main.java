package com.coderscampus.Assignment6;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Main {
	public static final String MODEL_3 = "model3.csv";
	public static final String MODEL_S = "modelS.csv";
	public static final String MODEL_X = "modelX.csv";

	public static void main(String[] args) throws IOException {

		FileService reader = new FileService();
		List<SalesData> model3SalesData = reader.readData(MODEL_3);
		PopulateSales.intiateReport(model3SalesData, "3");

		List<SalesData> modelSSalesData = reader.readData(MODEL_S);
		PopulateSales.intiateReport(modelSSalesData, "S");

		List<SalesData> modelXSalesData = reader.readData(MODEL_X);
		PopulateSales.intiateReport(modelXSalesData, "X");

	}

}
