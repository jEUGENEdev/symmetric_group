package org.math.calc;

import java.util.*;
import java.util.regex.Pattern;

public class Group {
    public static Pattern pGroup = Pattern.compile("(\\((\\d+\\s?)+\\))+");
    private String[] groups;
    private String result;

    public Group(String[] groups) {
        this.groups = groups;
        equalityOfSets();
    }

    private void equalityOfSets() {
        List<Integer[][]> symGroupsMult = new ArrayList<>();
        for (String group : groups) {
            String[] groupOne = group
                    .replace(")(", "*")
                    .replace("(", "")
                    .replace(")", "")
                    .split("\\*");
            symGroupsMult.add(buildTable(groupOne));
        }
        System.out.println(toCycleNote(multiplication(symGroupsMult.get(0), symGroupsMult.get(1))));
    }

    private Integer[][] buildTable(String[] cycleNoteGroup) {
        int maxEl = 0;
        for (String cycle : cycleNoteGroup)
            for (String number : cycle.split("\\s")) {
                int cur = Integer.parseInt(number);
                if (cur > maxEl)
                    maxEl = cur;
            }
        Integer[][] group = new Integer[2][maxEl];
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

    private Integer[][] multiplication(Integer[][] groupInTable1, Integer[][] groupInTable2) {
        Integer[][] multi = new Integer[groupInTable1.length][groupInTable1[0].length];
        for (int i = 0; i < multi[1].length; i++) {
            multi[1][i] = groupInTable1[1][groupInTable2[1][i] - 1];
            multi[0][i] = i + 1;
        }
        return multi;
    }

    private String listToString(List<Integer> listInteger) {
        StringBuilder sb = new StringBuilder();
        for (int i : listInteger)
            sb.append(i).append(' ');
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private int searchDisplayFromA(int a, Integer[][] symGroupTable) {
        for (int i = 0; i < symGroupTable[0].length; i++)
            if (i + 1 == a)
                return symGroupTable[1][i];
        return -1;
    }

    private String toCycleNote(Integer[][] symGroupTable) {
        StringBuilder cycleNote = new StringBuilder();
        Set<Integer> tracking = new HashSet<>();
        for (int i = 0; i < symGroupTable.length; i++) {
            int first = symGroupTable[0][i];
            if (tracking.contains(first))
                continue;
            tracking.add(first);
            cycleNote.append('(');
            int cur = first;
            List<Integer> queue = new ArrayList<>();
            do {
                if (!queue.contains(cur))
                    queue.add(cur);
                tracking.add(cur);
                cur = searchDisplayFromA(cur, symGroupTable);
            } while (cur != first);
            cycleNote.append(listToString(queue)).append(')');
        }
        return cycleNote.toString();
    }
}
