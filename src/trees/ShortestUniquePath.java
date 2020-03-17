package trees;

import java.util.*;

public class ShortestUniquePath {

    public ArrayList<String> prefix(ArrayList<String> A) {

        Map<String, Integer> map = new HashMap<>();

        ArrayList<String> result = new ArrayList<>();
        for (String s : A) {
            for (int i = 0; i <= s.length(); i++) {
                String sub = s.substring(0, i);
                Integer val = map.getOrDefault(sub, 0);
                map.put(sub, val+1);
            }
        }


        for (String s : A) {
            for (int i = 0; i <= s.length(); i++) {
                String sub = s.substring(0, i);
                if (map.get(sub) == 1) {
                    result.add(sub);
                    break;
                }
            }
        }

        return result;

    }

    public ArrayList<String> prefixTrieSolution(ArrayList<String> A) {

        ArrayList<String> result = new ArrayList<>();
        Trie trie = new Trie();
        for (String s : A) {
            trie.insert(s);
        }

        for (String s : A) {
            result.add(trie.searchForPrefix(s));
        }

        return result;




    }

    class Trie {
        private int counter;
        private boolean end;
        private List<Trie> childs;

        Trie() {
            this.counter = 0;
            this.childs = new ArrayList<>();
            for (int i = 0; i < 26; i++) {
                this.childs.add(null);

            }
        }

        void insert(String word) {
            Trie current = this;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                Trie child = current.childs.get(index);
                if (child == null) {
                    child = new Trie();
                    child.counter = 1;
                    current.childs.set(index, child);
                } else {
                    child.counter += 1;
                }
                current = child;
            }
            current.end = true;
        }

        String searchForPrefix(String word) {
            ArrayList<String> result = new ArrayList<>();
            Trie current = this;
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                Trie child = current.childs.get(index);
                builder.append(word.charAt(i));
                if (child.counter == 1) {
                    break;
                }
                current = child;
            }
            return builder.toString();

        }
    }

    public static void main(String[] args) {
        System.out.println(new ShortestUniquePath().prefixTrieSolution(new ArrayList<>(Arrays.asList("zebra", "dog", "duck", "dot"))));
    }


}
