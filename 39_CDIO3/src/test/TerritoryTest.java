package test;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

import entity.Player;
import entity.Territory;
import entity.Field;

public class TerritoryTest {
private Player player;
private Field territory1500;

	
	
	
	@Before
	public void SetUp() throws Exception {
		this.player = new Player();
		this.territory1500 = new Territory("Tribe Encampment", Color.PINK, Color.ORANGE,"Territory, Costs 1000",1000,null,100, false);
		
	}
	
	
	public void testLandOnField1500() {
		int expected  = 1000;
	}
	
	
	
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
