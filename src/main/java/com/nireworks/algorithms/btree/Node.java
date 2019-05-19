package com.nireworks.algorithms.btree;

import java.util.List;

public class Node {
    private final int value;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
    }

    public void addNode(Node node) {
        if (node == null) {
            return;
        }

        if (node.getValue() < value) {
            if (left != null) {
                left.addNode(node);
            } else {
                left = node;
            }
        } else {
            if (right != null) {
                right.addNode(node);
            } else {
                right = node;
            }
        }
    }

    public List<Node> getSortedChildren() {


        return null;
    }

    public void addNodes(Node ...nodes) {
        if (nodes == null) {
            return;
        }

        for (Node node : nodes) {
            addNode(node);
        }
    }

    public int getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void addSortedValues(List<Node> list) {
        if (list == null) {
            return;
        }

        if (left != null) {
            left.addSortedValues(list);
        }

        list.add(this);

        if (right != null) {
            right.addSortedValues(list);
        }
    }

    public Node find(int value) {
        if (right != null && value > this.value) {
            return right.find(value);
        }

        if (left != null && value < this.value) {
            return left.find(value);
        }

        if (value == this.value) {
            return this;
        }

        return null;
    }
}