package org.math.calc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Group {
    public static Pattern pGroup = Pattern.compile("(\\((\\d+\\s?)+\\))+");
    private String[] groups;
    private String result;

    public Group(String[] groups) {
        this.groups = groups;
        System.out.println(equalityOfSets());
    }

    private boolean equalityOfSets() {
        Set<Integer> set = new HashSet<>();
        for (String group : groups) {
            String[] groupOne = group
                    .replace(")(", "*")
                    .replace("(", "")
                    .replace(")", "")
                    .split("\\*");
            buildTable(groupOne);
        }
        return true;
    }

    private int[][] buildTable(String[] cycleNoteGroup) {
        int maxEl = 0;
        for (String cycle : cycleNoteGroup)
            for (String number : cycle.split("\\s")) {
                int cur = Integer.parseInt(number);
                if (cur > maxEl)
                    maxEl = cur;
            }
        int[][] group = new int[2][maxEl];
        for (int i = 0; i < maxEl; i++)
            group[0][i] = i + 1;
        for (String cycle : cycleNoteGroup) {
            List<Integer> numbers = Arrays.stream(cycle.split("\\s")).map(Integer::parseInt).toList();
            for (int i = 0; i < numbers.size() - 1; i++)
                group[1][numbers.get(i) - 1] = numbers.get(i + 1);
            group[1][numbers.get(numbers.size() - 1) - 1] = numbers.get(0);
        }
        return group;
    }
}
