package com.hashmap.excercise.chapter2;

import java.util.ArrayList;

/**
 * Implement a class Queue, an unbounded queue of strings. Provide methods add, adding at the
 * tail, and remove, removing at the head of the queue. Store elements as a linked list of nodes.
 * Make Node a nested class. Should it be static or not?
 */

class Queue{

    private static class Node{
        String data;
        Node next;

        private Node(String data){
            this.data = data;
        }
    }

    class Iterator{
        int init = 0;
        int cur = 0;
        public String next(){
            return queue.get(cur++).data;
        }

        public boolean hasNext(){
            if(cur<queue.size())
                return true;
            return false;
        }
    }

    private ArrayList<Node> queue = new ArrayList<>();

    public void add(String data){
        Node node = new Node(data);

        if(queue.size()!=0)
            queue.get(queue.size()-1).next = node;

        queue.add(node);
    }

    public Node remove(){
        return queue.remove(0);
    }

    public Iterator iterator(){
        return new Iterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(" ");
        queue.forEach((n) -> { sb.append(n.data + " ");});

        return "Queue{" + sb +
                '}';
    }
}

public class Q16 {
    public static void main(String[] args) {
        Queue q = new Queue();
        for (int i=0; i<5; i++)
            q.add(""+(char)(65+i));

        System.out.println(q);

        q.remove();
        q.remove();

        System.out.println(q);

        q.add("A");
        q.add("B");

        Queue.Iterator iterator = q.iterator();

        while (iterator.hasNext())
            System.out.print(iterator.next()+" ");
    }



}
