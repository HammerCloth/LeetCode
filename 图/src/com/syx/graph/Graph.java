package com.syx.graph;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author:syx
 * @date:2021/6/27 15:44
 * @version:v1.0
 */
public class Graph {
    public HashMap<Integer,Node> nodes;//点的集合
    public HashSet<Edge> edges;//点的集合

    public Graph(){
        this.edges = new HashSet<>();
        this.nodes = new HashMap<>();
    }
}
