package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Node;

class NodeTest {

	private Node node;
	
	//Scenarios
	
	// Scenary 1: The node is null
	public void setupScenary1() {
		node = null;
	}
	
	
	//TestCases
	
	// TestCase 1: Create a node
	@Test
	public void createNodeTest() {
		setupScenary1();
		node = new Node(3);
		assertEquals(node.getId(), 3);
	}
}
