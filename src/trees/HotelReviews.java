package trees;

import java.util.*;
import java.util.stream.Collectors;

public class HotelReviews {
    public ArrayList<Integer> solve(String A, ArrayList<String> B) {

        Map<Integer, Integer> res = new HashMap<>();
        Trie trie = new Trie();
        for (String s : A.split("_")) {
            trie.insert(s);
        }

        for (int i = 0; i < B.size(); i++) {
            int count = 0;
            for (String s : B.get(i).split("_")) {
                if (trie.search(s)) {
                    count++;
                }
            }
            res.put(i, count);
        }

        System.out.println(res);
        //List<Integer> list= new ArrayList<>(res.keySet());
        return res.keySet()
                .stream()
                .sorted((o1, o2) -> {
                    if (res.get(o1) > res.get(o2)) {
                        return -1;
                    }
                    if (res.get(o1) < res.get(o2)) {
                        return 1;
                    }
                    return 0;
                }).collect(Collectors.toCollection(ArrayList::new));
    }

    public static void main(String[] args) {
        System.out.println(new HotelReviews().solve("play_boy_boy", new ArrayList<>(Arrays.asList("smart_guy", "girl_and_boy_play", "play_ground"))));
    }

}
