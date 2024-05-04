package pascalstriangle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0)
            return Collections.emptyList();
        if (numRows == 1)
            return List.of(List.of(1));
        List<Integer> row = List.of(1);
        List<List<Integer>> result = new LinkedList<>();
        result.add(row);
        for (int i = 1; i < numRows; i++) {
            row = generateNextRow(row);
            result.add(row);
        }
        return result;
    }

    public List<Integer> generateNextRow(List<Integer> prevRow) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        int i = 0;
        while (i < prevRow.size() - 1) {
            row.add(prevRow.get(i) + prevRow.get(i + 1));
            i++;
        }
        row.add(1);
        return row;
    }
}
