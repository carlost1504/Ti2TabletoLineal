package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Player;

class PlayerTest {

	private Player player;
	
	//Scenarios
	
	// Scenary 2: The player is null
	public void setupScenary2() {
		player = null;
	}
	
	
	//TestCases
	
	// TestCase 2: Create a player
	@Test
	public void createPlayerTest() {
		setupScenary2();
		player = new Player("@", 0);
		assertEquals(player.getId(), "@");
		assertEquals(player.getPosition(), "0");
	}
}
