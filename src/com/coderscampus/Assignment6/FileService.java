package com.coderscampus.Assignment6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.AccessException;
import java.util.ArrayList;
import java.util.List;

public class FileService {

	public List<SalesData> readData(String fileName) throws IOException {

		List<SalesData> salesDataList = new ArrayList<>();

		BufferedReader reader = new BufferedReader(new FileReader(fileName));

		String line = reader.readLine();
		try {
			while ((line = reader.readLine()) != null) { // null check
				String[] values = line.split(",");
				salesDataList.add(new SalesData(values[0], values[1]));
			}
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
		return salesDataList;

	}
}
