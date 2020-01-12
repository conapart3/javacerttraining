package queues;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueRunner
{
    public static void main(String[] args)
    {
        // declare a queue as a queue we don't need double ended queue functionality
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        System.out.println("Queue: " +queue);
        System.out.println("Polling: " +queue.poll() + " Queue is now: " + queue);
        System.out.println("Peeking: " +queue.peek() + " Queue is now: " + queue);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("Stack: "+stack);
        System.out.println("Popping: " +stack.pop() + " Stack is now: " + stack);
        System.out.println("Peeking: " +stack.peek() + " Stack is now: " + stack);

    }
}

// make a stack of maps that you want to take off the top
// sell tickets to people in order they appear, tell them their position in line
//