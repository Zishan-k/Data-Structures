package graphs;

import java.util.*;
public class Graph {
    int u,v;
    static ArrayList<ArrayList<Integer>> edge;
    ArrayList<Integer> list= new ArrayList<>();
    Graph(int u, int v){
        this.u= u;
        this.v= v;
        list.add(u);
        list.add(v);
        edge.add(list);
    }

    static void printGraph(){
        for (ArrayList<Integer> integers : edge) {
            System.out.println(integers);
        }
    }
}





