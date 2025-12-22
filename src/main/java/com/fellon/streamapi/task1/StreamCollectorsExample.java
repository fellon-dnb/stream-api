package com.fellon.streamapi.task1;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class StreamCollectorsExample {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("Laptop", 1200.0),
                new Order("Smartphone", 800.0),
                new Order("Laptop", 1500.0),
                new Order("Tablet", 500.0),
                new Order("Smartphone", 900.0),
                new Order("Audio Monitor", 1800.0),
                new Order("Audio Monitor", 1700.0)
        );
        System.out.println("byProduct");
        Map<String, List<Order>> ordersByProduct =
                orders.stream()
                        .collect(Collectors.groupingBy(Order::getProduct));
        System.out.println(ordersByProduct);

        System.out.println("byCost");
        Map<String, Double> totalCostByProduct =
                orders.stream()
                        .collect(Collectors.groupingBy(
                                Order::getProduct,
                                Collectors.summingDouble(Order::getCost)));
        System.out.println(totalCostByProduct);

        System.out.println("top3ByTotalCost");
        totalCostByProduct.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(3)
                .forEach(entry ->
                        System.out.println(entry.getKey() + " -> " + entry.getValue())
                );
    }
}



