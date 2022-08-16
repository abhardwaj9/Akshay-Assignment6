package com.coderscampus.Assignment6;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class PopulateSales {

	static void intiateReport(List<SalesData> carSalesData, String modelType) {

		System.out.println(modelType + " Yearly Sales Report");
		System.out.println("---------------------------");

		// create map containing an integer and the list of sales data
		Map<Integer, List<SalesData>> salesGroupedByYear = carSalesData.stream()
				.collect(Collectors.groupingBy(d -> d.getDate().getYear()));

		// find total yearly sales 
		String yearlySales = salesGroupedByYear.entrySet().stream()
				.map(x -> x.getKey() + " -> "
						+ x.getValue().stream().collect(Collectors.summingInt(SalesData::getMonthlySales)))
				.collect(Collectors.joining("\n"));

		System.out.println(yearlySales + "\n");

		// create sales data object for the max and min sales
		// best month for sales
		Optional<SalesData> maxSalesData = carSalesData.stream()
				.max((SalesData o1, SalesData o2) -> o1.getMonthlySales().compareTo(o2.getMonthlySales()));

		// worst month for sales
		Optional<SalesData> minSalesData = carSalesData.stream()
				.min((SalesData o1, SalesData o2) -> o1.getMonthlySales().compareTo(o2.getMonthlySales()));

		System.out.println("The best month for " + modelType + " was: "
				+ maxSalesData.orElse(new SalesData("Jan-00", "00")).getDate());
		System.out.println("The worst month for " + modelType + " was: "
				+ minSalesData.orElse(new SalesData("Jan-00", "00")).getDate() + "\n");

	}

}
