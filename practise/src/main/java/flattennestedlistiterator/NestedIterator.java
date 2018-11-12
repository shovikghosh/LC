package flattennestedlistiterator;

import java.util.*;

public class NestedIterator implements Iterator<Integer> {
    Iterator<NestedInteger> curIt;
    Stack<Iterator<NestedInteger>> stack;
    Integer nInt;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        curIt = nestedList.iterator();
        if (curIt.hasNext()) {
            nInt = getNext();
        } else {
            nInt = null;
        }
    }

    @Override
    public Integer next() {
        Integer temp = nInt;
        nInt = getNext();
        return temp;
    }

    @Override
    public boolean hasNext() {
        return nInt != null;
    }

    Integer getNext() {
        if (curIt.hasNext()) {
            NestedInteger ni = curIt.next();
            if (ni.isInteger()) {
                return ni.getInteger();
            } else {
                stack.push(curIt);
                curIt = ni.getList().iterator();
                return getNext();
            }
        } else {
            if (!stack.isEmpty()) {
                curIt = stack.pop();
                return getNext();
            } else {
                return null;
            }
        }
    }
}

