package palinpairs;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        // String[] words1 = {"abcd", "dcba", "lls", "s", "sssll"};
        // System.out.println(s.palindromePairs(words1));
        // String[] words2 = {"bat", "tab", "cat"};
        // System.out.println(s.palindromePairs(words2));

        String[] words3 = {"a", ""};
        System.out.println(s.palindromePairs(words3));

        // Trie t = new Trie();
        // String[] words = {"abcd", "dcba", "lls", "s", "sssll"};
        // String[] words = { "lls", "s"};
        // for (int i = 0; i < words.length; i++) {
        // t.insert(words[i], i);
        // }
        // System.out.println(t.getPalinSubs(t.searchNode("sammas")));
        // System.out.println(t.getWordNodes("s"));
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> results = new LinkedList<>();
        Trie reversedTrie = createReverseTrie(words);
        int len = words.length;
        for (int i = 0; i < len; i++) {
            String word = words[i];
            TrieNode t = reversedTrie.searchNode(word);
            List<Integer> longerPalins = new LinkedList<>();;
            if (t != null) {
                longerPalins = reversedTrie.getPalinSubs(t);
            }

            List<Integer> shorterEqual = reversedTrie.getWordNodes(word);
            for (Integer shIdx : shorterEqual) {
                String shortWord = words[shIdx];
                if (reversedTrie.checkPalin(word.substring(shortWord.length()))) {
                    longerPalins.add(shIdx);
                }
            }
            for (Integer idx : longerPalins) {
                if (i == idx) {
                    continue;
                }
                List<Integer> tuple = new LinkedList<>();
                tuple.add(i);
                tuple.add(idx);
                results.add(tuple);
            }
        }
        return results;
    }

    Trie createReverseTrie(String[] words) {
        Trie tr = new Trie();
        int len = words.length;
        for (int i = 0; i < len; i++) {
            String word = words[i];
            String reversedWord = (new StringBuilder(word)).reverse().toString();
            tr.insert(reversedWord, i);
        }
        return tr;
    }
}


class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode(' ');
    }

    List<Integer> getPalinIndexes(TrieNode t) {
        List<Integer> palins = new LinkedList<>();
        return palins;
    }

    void insert(String word, int idx) {
        HashMap<Character, TrieNode> children = root.children;
        int len = word.length();
        TrieNode t = root;
        for (int i = 0; i < len; i++) {
            char ch = word.charAt(i);

            if (children.containsKey(ch)) {
                t = children.get(ch);
            } else {
                t = new TrieNode(ch);
                children.put(ch, t);
            }
            children = t.children;
        }
        t.wordIndex = idx;
    }

    TrieNode searchNode(String prefix) {
        int len = prefix.length();
        HashMap<Character, TrieNode> children = root.children;
        TrieNode t = root;
        for (int i = 0; i < len; i++) {
            char ch = prefix.charAt(i);
            if (children.containsKey(ch)) {
                t = children.get(ch);
                children = t.children;
            } else {
                return null;
            }
        }
        return t;
    }

    boolean hasPrefix(String prefix) {
        return searchNode(prefix) != null;
    }

    boolean searchWord(String word) {
        TrieNode t = searchNode(word);
        return t != null && t.wordIndex >= 0;
    }

    List<Integer> getWordNodes(String word) {
        List<Integer> li = new LinkedList<>();
        if (root.wordIndex >= 0) {
            li.add(root.wordIndex);
        }
        getWordNodes(word, li);
        return li;
    }

    private void getWordNodes(String word, List<Integer> list) {
        int len = word.length();
        HashMap<Character, TrieNode> children = root.children;
        TrieNode t = root;
        for (int i = 0; i < len; i++) {
            char ch = word.charAt(i);
            if (children.containsKey(ch)) {
                t = children.get(ch);
                if (t.wordIndex >= 0 && i < len - 1) {
                    list.add(t.wordIndex);
                }
                children = t.children;
            } else {
                return;
            }
        }
    }

    List<Integer> getPalinSubs(TrieNode t) {
        List<Integer> li = new LinkedList<>();
        getPalinSubs(t, "", li);
        return li;
    }

    private void getPalinSubs(TrieNode t, String prefix, List<Integer> uptilNow) {
        if (t == null) {
            return;
        }
        if (t.wordIndex >= 0 && checkPalin(prefix)) {
            uptilNow.add(t.wordIndex);
        }

        // prefix = prefix + Character.toString(t.c);
        // System.out.println("node props :" + Character.toString(t.c) + ": index: " + t.wordIndex);
        // System.out.println("Calling getPalinSubs:" + prefix);
        for (Map.Entry<Character, TrieNode> each : t.children.entrySet()) {
            getPalinSubs(each.getValue(), prefix + Character.toString(each.getKey()), uptilNow);
        }
        return;
    }

    boolean checkPalin(String word) {
        // System.out.println("check palin called:" + word);
        int len = word.length();
        for (int i = 0; i < len / 2; i++) {
            int comp = len - i - 1;
            // System.out.println("len:"+ len + ": i: " + i + ":comp:" + comp);
            if (word.charAt(i) != word.charAt(comp)) {
                return false;
            }
        }
        return true;
    }
}


class TrieNode {
    HashMap<Character, TrieNode> children;
    char c;
    int wordIndex;

    TrieNode(char c) {
        this.c = c;
        wordIndex = -1;
        children = new HashMap<>();
    }
}
