package ru.tcreator;

import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    protected int treshold;

    public Filter(int treshold) {
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        return source.stream()
                .filter(el -> {
                    boolean condition = el > treshold;
                    if(condition) logger.log("Элемент " + el + " подходит");
                    else logger.log("Элемент " + el + " не подходит");
                    return condition;
                })
                .collect(Collectors.toList());
    }

}
