package trieimpl;

class TrieImpl {
    public static void main(String[] args) {
        Trie t = new Trie();
        String[] words = {"shovik", "ghosh", "dunzo"};
        for (String word : words) {
            t.insert(word);
        }
        System.out.println(t.searchWild("...."));
    }
}

class WordDictionary {
    /** Initialize your data structure here. */
    Trie trie;

    public WordDictionary() {
        trie = new Trie();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        trie.insert(word);
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to
     * represent any one letter.
     */
    public boolean search(String word) {
        return trie.searchWild(word);
    }
}


class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode('\u0000');
    }

    void insert(String word) {
        TrieNode t = root;
        TrieNode[] children = root.children;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            t = children[idx];
            if (t == null) {
                t = new TrieNode(c);
                children[idx] = t;
            }
            children = t.children;
        }
        t.isLeaf = true;
    }

    boolean searchWild(String word) {
        return searchWild(root, word);
    }

    boolean searchWild(TrieNode t, String word) {
        int len = word.length();
        if (t == null) {
            return false;
        }
        if (len == 0) {
            return t.isLeaf;
        }
        char ch = word.charAt(0);
        boolean found = false;
        if (ch == '.') {
            for (TrieNode tn : t.children) {
                found = found || searchWild(tn, word.substring(1));
            }
            return found;
        } else {
            int idx = ch - 'a';
            t = t.children[idx];
            if (t == null) {
                return false;
            } else {
                return searchWild(t, word.substring(1));
            }
        }
    }



    boolean searchWord(String word) {
        TrieNode t = searchNode(word);
        return t != null && t.isLeaf;
    }

    TrieNode searchNode(String word) {
        TrieNode t = root;
        TrieNode[] children = root.children;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            t = children[idx];
            if (t == null) {
                return null;
            }
            children = t.children;
        }
        return t;
    }
}


class TrieNode {
    private static final int ALPHABET_SIZE = 26;
    char c;
    TrieNode[] children;
    boolean isLeaf;

    TrieNode(char ch) {
        c = ch;
        children = new TrieNode[ALPHABET_SIZE];
    }
}
