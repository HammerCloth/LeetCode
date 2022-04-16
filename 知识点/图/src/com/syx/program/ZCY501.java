package com.syx.program;


import com.syx.graph.Node;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 宽度优先遍历
 * 1.利用队列实现
 * 2.从源节点开始依次按照宽度进队列，然后弹出
 * 3.每弹出一个节点，把该节点所有没有进过队列的临接点放入队列
 * 4.直到队列变空
 * @author:syx
 * @date:2021/6/27 15:54
 * @version:v1.0
 */
public class ZCY501 {

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        head.nexts.add(node2);
        head.nexts.add(node3);
        head.nexts.add(node4);
        node2.nexts.add(head);
        node2.nexts.add(node4);
        node3.nexts.add(node5);
        node3.nexts.add(head);
        node4.nexts.add(head);
        node4.nexts.add(node2);
        node4.nexts.add(node5);
        node5.nexts.add(node4);
        node5.nexts.add(node3);

        bfs(node2);

    }

    public static void bfs(Node head){
        Queue<Node> queue = new LinkedList<>();
        Set<Node> set = new HashSet<>();
        queue.offer(head);
        set.add(head);
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            System.out.println(temp.value);
            for (Node node:temp.nexts){
                if (!set.contains(node)){
                    set.add(node);
                    queue.offer(node);
                }
            }
        }
    }
}
