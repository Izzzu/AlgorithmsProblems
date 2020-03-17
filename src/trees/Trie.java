package trees;

import java.util.ArrayList;
import java.util.List;

public class Trie {

    public static final int ALPHABET_SIZE = 26;
    List<Trie> children;
    private boolean isLeaf;

    public Trie() {
        this.isLeaf = false;
        this.children = new ArrayList<>();
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            children.add(null);
        }
    }

    public void insert(String key) {

        Trie current = this;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            int index = c - 'a';
            if (current.children.get(index) == null) {
                current.children.set(index, new Trie());
            }
            current = current.children.get(index);
        }
        current.isLeaf = true;
    }


    public boolean search (String key) {
        Trie current = this;

        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            int index = c - 'a';
            Trie trie = current.children.get(index);
            if (trie == null) {
                return false;
            }
            current = trie;
        }
        return current != null && current.isLeaf;
    }
}
