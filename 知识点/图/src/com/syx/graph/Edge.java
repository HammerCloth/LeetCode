package com.syx.graph;

/**
 * @author:syx
 * @date:2021/6/27 15:44
 * @version:v1.0
 */
public class Edge {
    public int weight;//边的权重
    public Node from;//边的起点
    public Node to;//边的重点

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
