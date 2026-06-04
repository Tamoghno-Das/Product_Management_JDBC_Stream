package com.example.service;

import com.example.model.Product;

import java.util.*;
import java.util.stream.Collectors;

public class ProductStreamService
{
    public static void executeAllStreams(List<Product> products)
    {
        System.out.println("\n1 Filter Price > 5000");
        products.stream()
                .filter(p -> p.getPrice() > 5000)
                .forEach(System.out::println);
        System.out.println("\n2 Map Product Names");
        products.stream()
                .map(Product::getProductName)
                .forEach(System.out::println);
        System.out.println("\n3 Reduce Total Price");
        double total=
                products.stream()
                        .map(Product::getPrice)
                        .reduce(0.0,Double::sum);
        System.out.println(total);
        System.out.println("\n4 Highest Price");
        products.stream()
                .max(Comparator.comparing(Product::getPrice))
                .ifPresent(System.out::println);
        System.out.println("\n5 Lowest Price");
        products.stream()
                .min(Comparator.comparing(Product::getPrice))
                .ifPresent(System.out::println);
        System.out.println("\n6 Sorting Asc");
        products.stream()
                .sorted(
                        Comparator.comparing(Product::getPrice))
                .forEach(System.out::println);
        System.out.println("\n7 Sorting Desc");
        products.stream()
                .sorted(
                        Comparator.comparing(Product::getPrice)
                                .reversed())
                .forEach(System.out::println);
        System.out.println("\n8 Distinct Categories");
        products.stream()
                .map(Product::getCategory)
                .distinct()
                .forEach(System.out::println);
        System.out.println("\n9 Group By Category");
        Map<String,List<Product>> map=
                products.stream()
                        .collect(Collectors.groupingBy(
                                Product::getCategory));
        map.forEach((k,v)->
                System.out.println(k+" -> "+v));
        System.out.println("\n10 Partition Price > 10000");
        Map<Boolean, List<Product>> partition=
                products.stream()
                        .collect(Collectors.partitioningBy(
                                p->p.getPrice()>10000));
        System.out.println(partition);
        System.out.println("\n11 Statistics");
        DoubleSummaryStatistics stat=
                products.stream()
                        .collect(Collectors.summarizingDouble(
                                Product::getPrice));
        System.out.println(stat);
        System.out.println("\n12 Any Match");
        System.out.println(
                products.stream()
                        .anyMatch(
                                p->p.getPrice()>50000));
        System.out.println("\n13 All Match");
        System.out.println(
                products.stream()
                        .allMatch(
                                p->p.getQuantity()>0));
        System.out.println("\n14 Count");
        long count=
                products.stream()
                        .count();
        System.out.println(count);

        System.out.println("\n15 Limit");
        products.stream()
                .limit(3)
                .forEach(System.out::println);

        System.out.println("\n16 Skip");
        products.stream()
                .skip(2)
                .forEach(System.out::println);

        System.out.println("\n17 Parallel Stream");
        products.parallelStream()
                .forEach(System.out::println);
        System.out.println("\n18 Collect To Set");
        Set<String> names=
                products.stream()
                        .map(Product::getProductName)
                        .collect(Collectors.toSet());
        System.out.println(names);
        System.out.println("\n19 Average Price");
        double avg=
                products.stream()
                        .collect(Collectors.averagingDouble(
                                Product::getPrice));
        System.out.println(avg);
        System.out.println("\n20 Product Value");
        int totalValue=
                products.stream()
                        .map(
                                p->(int)
                                        (p.getPrice()*p.getQuantity()))
                        .reduce(0,Integer::sum);
        System.out.println(totalValue);
    }
}
