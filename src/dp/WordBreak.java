package dp;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {

    class Trie {
        boolean isLeaf;
        List<Trie> children;

        Trie() {
            children = new ArrayList();

            for (int i = 0; i < 26; i++) {
                children.add(null);
            }
        }

        void insert(String key) {
            Trie current = this;
            for (int i = 0; i < key.length(); i++) {
                int c = key.charAt(i) - 'a';
                if (current.children.get(c) == null) {
                    current.children.set(c, new Trie());
                }
                current = current.children.get(c);
            }
            current.isLeaf = true;
        }

        void search(String key, int ind, boolean[] dp) {
            Trie current = this;
            for (int i = ind; i < key.length(); i++) {
                int c = key.charAt(i) - 'a';
                Trie t = current.children.get(c);
                if (t == null) {
                    return;
                }
                current = t;
                if (current.isLeaf) {
                    dp[i] = true;
                }
            }


        }
    }

    ;

    public int wordBreak(String A, ArrayList<String> B) {
        Trie trie = new Trie();
        for (String s : B) {
            trie.insert(s);
        }
        boolean dp[]= new boolean[A.length()];
        for (int i = 0; i < A.length(); i++) {

            if (i == 0 || dp[0]) {
                trie.search(A, i, dp);
            }

        }
        return dp[A.length() - 1] ? 1 : 0;
    }

    /*
    // SECOND SOLUTION
    public int wordBreak(String a, ArrayList<String> b) {
	    int[] dp = new int[a.length()];
	    int ans = solve(0, dp, a, b);
	    return ans == 1 ? 1 : 0;

	}

	static boolean startsWith(int index, String word, String a){
	    if((index + word.length()) > a.length()) return false;
	    for(int i = 0; i < word.length(); i++)
	        if(a.charAt(i + index) != word.charAt(i)) return false;
        return true;
	}

	static int solve(int l, int[] dp, String a, ArrayList<String> b){
	    if(l == a.length())  return 1;
	    if(dp[l] != 0) return dp[l];
	    int ans = -1;
	    for(int i = 0; i < b.size(); i++)
	        if(startsWith(l, b.get(i), a) && solve(l + b.get(i).length(), dp, a, b) == 1){
                ans = 1;
                break;
            }
            dp[l] = ans;
	    return ans;
	}
     */

}


