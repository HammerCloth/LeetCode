package com.syx.graph;

import java.util.ArrayList;

/**
 * @author:syx
 * @date:2021/6/27 15:44
 * @version:v1.0
 */
public class Node {
    public int value;//节点的值
    public int in;//节点的入度
    public int out;//节点的出度
    public ArrayList<Node> nexts;//节点的已连接的下一个节点
    public ArrayList<Edge> edges;//以节点为起点的边

    public Node(int value){
        this.value = value;
        this.in = 0;
        this.out = 0;
        this.nexts = new ArrayList<>();
        this.edges = new ArrayList<>();
    }
}
