package test;

import static org.junit.Assert.*;

import org.junit.Test;

import entity.Player;

public class TestPiece {

	@Test
	public void test() {
		Player p1 = new Player();
		Player p2 = new Player();
		Player p3 = new Player();
		Player p4 = new Player();
		Player p5 = new Player();
		
		assertEquals(1, p1.getPiece().getPlayerNumber());
		assertEquals(2, p2.getPiece().getPlayerNumber());
		assertEquals(3, p3.getPiece().getPlayerNumber());
		assertEquals(4, p4.getPiece().getPlayerNumber());
		assertEquals(5, p5.getPiece().getPlayerNumber());
		
		assertEquals("Player 1", p1.getPiece().getPlayerName());
		assertEquals("Player 2", p2.getPiece().getPlayerName());
		assertEquals("Player 3", p3.getPiece().getPlayerName());
		assertEquals("Player 4", p4.getPiece().getPlayerName());
		assertEquals("Player 5", p5.getPiece().getPlayerName());
		
		int testAntal = (int) (Math.random()*10000);
		Player[] PlayerAntal = new Player[testAntal];
		for(int i = 0;i < testAntal;i++){
			PlayerAntal[i] = new Player();
		}
		Player sAntalTest = new Player();
		testAntal += 6;
		String testPlayer = "Player " + testAntal;
		assertEquals(testPlayer, sAntalTest.getPiece().getPlayerName());
		}

}
