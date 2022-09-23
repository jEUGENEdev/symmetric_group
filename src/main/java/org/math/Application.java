package org.math;

import org.math.calc.Group;
import org.math.exc.ArgsFailException;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws ArgsFailException {
        try(Scanner scanner = new Scanner(System.in)) {
            String expr = scanner.nextLine();
            G g = checkIsGroups(expr);
            if (!g.is())
                throw new ArgsFailException();
            Group group = new Group(g.groups());
            group.start();
            System.out.printf("""
                    Result in cycle note:
                                
                    %s
                                
                    Result in table note
                                
                    %s""", group.getCycleNoteResult(), group.getTableNoteResult());
        }
    }

    record G(String[] groups, boolean is) {}

    public static G checkIsGroups(String expr) {
        String[] groups = expr.split("\s*\\*\s*");
        for(String group : groups)
            if(!Group.pGroup.matcher(group).matches() || groups.length < 2)
                return new G(groups, false);
        return new G(groups, true);
    }
}
