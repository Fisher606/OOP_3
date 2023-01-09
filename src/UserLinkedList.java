package com.example.playground.OOP_3;

import androidx.annotation.NonNull;

import java.util.Iterator;

public class UsersLinkedList implements Iterable<User> {

    private Node startingNode;
    private Node endingNode;

    static class Node {
        User payload;
        Node next;

        public Node(User payload, Node next) {
            this.payload = payload;
            this.next = next;
        }
    }

    public UsersLinkedList(User user) {
        addRecursive(user);
    }

    void add(User user) {
        Node node = wrapUser(user);

        // The first element adding
        if (startingNode == null) {
            startingNode = node;
            endingNode = node;
        } else {
            endingNode.next = node;
            endingNode = node;
        }
    }

    @NonNull
    @Override
    public Iterator<User> iterator() {
        return new Iterator<User>() {

            Node currentNode = startingNode;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public User next() {
                Node node = currentNode;
                currentNode = currentNode.next;
                return node.payload;
            }
        };
    }

    private Node wrapUser(User user) {
        return new Node(
                user,
                null
        );
    }

    private void addRecursive(User user) {
        add(user);
        if (user.getSubordinates() != null && user.getSubordinates().size() != 0) {
            for (User item : user.getSubordinates()) {
                addRecursive(item);
            }
        }
    }
}

