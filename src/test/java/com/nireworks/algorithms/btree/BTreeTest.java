package com.nireworks.algorithms.btree;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BTreeTest {

    @Test
    public void testAddNode_Root() {
        BTree bTree = new BTree();

        Node addedRootNode = new Node(10);

        bTree.addNode(addedRootNode);

        Node actualRootNode = bTree.getRoot();

        assertNotNull(actualRootNode);
        assertEquals(addedRootNode.getValue(), actualRootNode.getValue());
    }

    @Test
    public void testAddNode_Left() {
        BTree bTree = new BTree();
        Node addedRootNode = new Node(10);
        Node expectedLeftNode = new Node(5);

        bTree.addNode(addedRootNode);
        bTree.addNode(expectedLeftNode);

        Node actualRootNode = bTree.getRoot();

        assertNotNull(actualRootNode);
        assertEquals(addedRootNode.getValue(), actualRootNode.getValue());

        Node actualLeftNode = actualRootNode.getLeft();

        assertNotNull(actualLeftNode);
        assertEquals(expectedLeftNode.getValue(), actualLeftNode.getValue());
    }

    @Test
    public void testAddNode_Right() {
        BTree bTree = new BTree();
        Node addedRootNode = new Node(10);
        Node expectedRightNode = new Node(15);

        bTree.addNode(addedRootNode);
        bTree.addNode(expectedRightNode);

        Node actualRootNode = bTree.getRoot();

        assertNotNull(actualRootNode);
        assertEquals(addedRootNode.getValue(), actualRootNode.getValue());

        Node actualRightNode = actualRootNode.getRight();

        assertNotNull(actualRightNode);
        assertEquals(expectedRightNode.getValue(), actualRightNode.getValue());
    }

    @Test
    public void testAddNode_Null() {
        BTree bTree = new BTree();

        bTree.addNode(null);
    }

    @Test
    public void testAddNodes_Null() {
        BTree bTree = new BTree();

        bTree.addNodes((Node) null);
        bTree.addNodes((Node[]) null);
    }

    @Test
    public void testAddNodes() {
        BTree bTree = new BTree();

        Node node1 = new Node(5);
        Node node2 = new Node(10);
        Node node3 = new Node(1);
        
        bTree.addNodes(node1, node2, node3);
        
        Node rootNode = bTree.getRoot();
        
        assertNotNull(rootNode);
        assertEquals(node1.getValue(), rootNode.getValue());

        Node rightNode = rootNode.getRight();
        assertNotNull(rightNode);
        assertEquals(node2.getValue(), rightNode.getValue());

        Node leftNode = rootNode.getLeft();
        assertNotNull(leftNode);
        assertEquals(node3.getValue(), leftNode.getValue());
    }


    @Test
    public void testGetSortedValues_Null() {
        BTree bTree = new BTree();

        List<Node> values = bTree.getSortedValues();

        assertNotNull(values);
        assertEquals("same length", 0, values.size());
    }

    @Test
    public void testGetSortedValues_One() {
        BTree bTree = new BTree();

        Node addedNode = new Node(10);

        bTree.addNode(addedNode);

        List<Node> values = bTree.getSortedValues();

        assertNotNull(values);
        assertEquals("same length", 1, values.size());
        assertEquals(addedNode.getValue(), values.get(0).getValue());
    }

    @Test
    public void testGetSortedValues_Many() {
        BTree bTree = new BTree();

        Node[] addedNodes = new Node[]{
                new Node(10),
                new Node(5),
                new Node(9),
                new Node(2),
                new Node(3),
        };

        bTree.addNodes(addedNodes);

        List<Node> values = bTree.getSortedValues();

        assertNotNull(values);
        assertEquals("length mismatch", addedNodes.length, values.size());

        assertEquals(2, values.get(0).getValue());
        assertEquals(3, values.get(1).getValue());
        assertEquals(5, values.get(2).getValue());
        assertEquals(9, values.get(3).getValue());
        assertEquals(10, values.get(4).getValue());
    }

    @Test
    public void testFind_Null() {
        BTree bTree = new BTree();

        Node foundNode = bTree.find(190);

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
}