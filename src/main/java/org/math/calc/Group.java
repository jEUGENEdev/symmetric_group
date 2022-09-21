package org.math.calc;

import java.util.regex.Pattern;

public class Group {
    public static Pattern pGroup = Pattern.compile("(\\((\\d+\\s?)+\\))+");
    private String[] groups;
    private String result;

    public Group(String[] groups) {
        this.groups = groups;
    }
}
