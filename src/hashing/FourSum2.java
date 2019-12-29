package hashing;

import java.util.ArrayList;
import java.util.Collections;

public class FourSum2 {

    public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> a, int b) {
        Collections.sort(a);
        ArrayList<ArrayList<Integer>> out= new  ArrayList<ArrayList<Integer>>();
        for (int i=0; i<a.size()-3; i++){
            for (int j=i+1; j<a.size()-2; j++){
                int tot= b-a.get(i)-a.get(j);
                int k=j+1;
                int l=a.size()-1;
                while (k<l){
                    if (a.get(k)+a.get(l)>tot) l--;
                    else if (a.get(k)+a.get(l)<tot) k++;
                    else{
                        ArrayList<Integer> temp= new ArrayList<Integer>();
                        temp.add(a.get(i)); temp.add(a.get(j));
                        temp.add(a.get(k)); temp.add(a.get(l));
                        if (!out.contains(temp)) out.add(temp);
                        k++; l--;
                    }
                }
            }
        }
        return out;
    }
}
