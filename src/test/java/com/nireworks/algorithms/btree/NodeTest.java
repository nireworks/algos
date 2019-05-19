package com.nireworks.algorithms.btree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class NodeTest {

    @Test
    public void testCreateNode() {
        Node node = new Node(10);

        assertNull(node.getLeft());
        assertNull(node.getRight());
    }
    @Test
    public void testAddNode_Null() {
        Node firstNode = new Node(10);

        firstNode.addNode(null);
        firstNode.addNodes((Node) null);
        firstNode.addNodes((Node[]) null);
    }


    @Test
    public void testAddNode() {
        Node firstNode = new Node(10);

        Node smallerNode = new Node(5);
        Node largerNode = new Node(15);

        firstNode.addNode(smallerNode);
        firstNode.addNode(largerNode);

        Node leftNode = firstNode.getLeft();

        assertNotNull(leftNode);
        assertEquals(smallerNode.getValue(), leftNode.getValue());

        Node rightNode = firstNode.getRight();

        assertNotNull(rightNode);
        assertEquals(largerNode.getValue(), rightNode.getValue());
    }

    @Test
    public void testAddNode_Deep() {
        Node firstNode = new Node(10);

        Node smallerNode = new Node(5);
        Node largerNode = new Node(10);

        Node evenSmallerNode = new Node(3);
        Node evenLargerNode = new Node(15);

        firstNode.addNodes(smallerNode, largerNode, evenLargerNode, evenSmallerNode);

        Node checkedSmallerNode = firstNode.getLeft().getLeft();
        
        assertNotNull(checkedSmallerNode);
        assertEquals(evenSmallerNode.getValue(), checkedSmallerNode.getValue());

        Node checkedLargerNode = firstNode.getRight().getRight();

        assertNotNull(checkedLargerNode);
        assertEquals(evenLargerNode.getValue(), checkedLargerNode.getValue());
        
    }

    @Test
    public void testAddSortedValues_Null() {
        Node node = new Node(92);
        node.addSortedValues(null);
    }

    @Test
    public void testAddSortedValues_One() {
        Node node = new Node(92);
        List<Node> list = new ArrayList<>();

        node.addSortedValues(list);

        assertEquals("length mismatch", 1, list.size());
        assertEquals(node.getValue(), list.get(0).getValue());
    }

    @Test
    public void testAddSortedValues_Many() {
        Node node = new Node(92);
        Node node2 = new Node(91);
        Node node3 = new Node(93);
        node.addNodes(node2, node3);

        List<Node> list = new ArrayList<>();

        node.addSortedValues(list);

        assertEquals("length mismatch", 3, list.size());
        assertEquals(node2.getValue(), list.get(0).getValue());
        assertEquals(node.getValue(), list.get(1).getValue());
        assertEquals(node3.getValue(), list.get(2).getValue());
    }

    @Test
    public void testFind_Actual() {
        Node node = new Node(190);

        Node foundNode = node.find(190);

        assertNotNull(foundNode);
        assertEquals(node.getValue(), foundNode.getValue());
    }

    @Test
    public void testFind_Many() {
        Node node = new Node(190);
        Node node2 = new Node(80);
        Node node3 = new Node(70);

        node.addNodes(node2, node3);

        Node foundNode = node.find(70);

        assertNotNull(foundNode);
        assertEquals(node3.getValue(), foundNode.getValue());
    }


    @Test
    public void testFind_NotFound() {
        Node node = new Node(190);

        Node foundNode = node.find(70);

        assertNull(foundNode);

    }
}