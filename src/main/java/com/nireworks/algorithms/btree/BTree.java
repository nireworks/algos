package com.nireworks.algorithms.btree;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class BTree {

    private Node root;

    public Node getRoot() {
        return root;
    }

    public void addNode(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.addNode(node);
        }
    }

    public void addNodes(Node ...nodes) {
        if (nodes == null) {
            return;
        }

        for (Node node : nodes) {
            addNode(node);
        }
    }


    public List<Node> getSortedValues() {
        List<Node> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        root.addSortedValues(list);

        return list;
    }

    public Node find(int value) throws NoSuchElementException {
        if (root == null) {
            throw new NoSuchElementException();
        }

        if (root.getValue() == value) {
            return root;
        }

        Node foundNode = root.find(value);

        if (foundNode == null) {
            throw new NoSuchElementException();
        }

        return foundNode;
    }
}
