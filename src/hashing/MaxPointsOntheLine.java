package hashing;

import java.util.*;


public class MaxPointsOntheLine {
    public int maxPoints(ArrayList<Integer> x, ArrayList<Integer> y) {
        if(x.isEmpty()){
            return 0;
        }
        HashMap<String,Integer> slope = new HashMap<String,Integer>();
        int max = 0;
        for(int i =0;i<x.size();i++){
            int x1 = x.get(i);
            int y1 = y.get(i);
            int duplicates = 0;
            int localMax = 0;
            slope.clear();
            for(int j=i+1;j<x.size();j++){
                String slp = "";
                int x2 = x.get(j);
                int y2 = y.get(j);
                if(x1==x2 && y1==y2){
                    duplicates++;
                    continue;
                }
                else if(x1==x2){
                    slp = "Vertical";
                }
                else if(y1==y2){
                    slp = "Horizontal";
                }
                else{
                    slp = String.valueOf((1.0)*(y2-y1)/(x2-x1));
                }
                int count = slope.getOrDefault(slp,0);
                slope.put(slp,count+1);
                localMax = Math.max(localMax, count+1);
            }
            localMax += duplicates;
            max = Math.max(localMax,max);
        }
        return max+1;
    }


    public static void main(String[] args) {

        if (-0.0f == 0) {
            System.out.println("tak");
        }
        //4 -4 8 -4 -4 -4
        // 15 12 9 10 -16 3 -15 15 11
        System.out.println(new MaxPointsOntheLine().maxPoints(new ArrayList<>(Arrays.asList( 4, 8, -4

)),
                new ArrayList<>(Arrays.asList(-4, -4, -4
))));
    }
}

// 4 -4 8 -4 -4 -4
/*
if (x1 == x2 && y1 == y2) {
                    for (Pair<Float> key : map.keySet()) {
                        List<Pair<Integer>> pairs = map.get(key);
                        pairs.add(new Pair<>(x1, y1));
                        map.put(key, pairs);

                        max = Math.max(max, pairs.size());
                    }
                    duplicates++;
                    continue;
                } else if (x1 == x2) {
                    Pair<Float> verticalPair = new Pair<Float>((float)x1);
                    List<Pair<Integer>> pairs = map.getOrDefault(verticalPair, new ArrayList<>());
                    if (pairs.isEmpty()) {
                        for (int k = 0; k < duplicates + 1; k++) {
                            pairs.add(new Pair<>(x1, y1));
                        }
                    }
                    pairs.add(new Pair<>(x2, y2));
                    map.put(verticalPair, pairs);

                    max = Math.max(max, pairs.size());
                    continue;
                } else if (y1 == y2) {
                  a = 0;
                  b = y1;
                } else {
                        a = ((float)(y2-y1))/(float)(x2-x1);
                        b = (float)y1-(float)(a*(float)x1);

                }
                Pair<Float> key = new Pair<>(a, b);
                List<Pair<Integer>> pairList = map.getOrDefault(key, new ArrayList<>());
                if (pairList.isEmpty()) {
                    for (int k = 0; k < duplicates + 1; k++) {
                        pairList.add(new Pair<>(x1, y1));
                    }
                }
                pairList.add(new Pair<>(x2, y2));

                map.put(key, pairList);

                max = Math.max(max, pairList.size());

 */
