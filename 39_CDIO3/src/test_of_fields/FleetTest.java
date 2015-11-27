package test_of_fields;

import static org.junit.Assert.*;
import java.awt.Color;
import entity.Fleet;
import entity.Player;
import org.junit.*;

public class FleetTest {

	private Player player1;
	private Player player2;
	private Fleet Fleet4000Buy;
	private Fleet Fleet300Rent;
	private Fleet FleetOwned;

	@Before
	public void setUp() throws Exception {
		this.player1 = new Player("Anders And", 1, 5000);
		this.player2 = new Player("Gooby and Mockey", 2, 5000);
		this.Fleet4000Buy = new Fleet("Second Sail",Color.GRAY,Color.ORANGE,"Fleet, costs 4000",4000,null,false);
		this.Fleet300Rent = new Fleet("Third Sail",Color.GRAY,Color.ORANGE,"Fleet, costs 4000",4000,null,false);
		this.FleetOwned = new Fleet("Fourth Sail",Color.GRAY,Color.ORANGE,"Fleet, costs 4000",4000,null,false);
	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testEntities() {
		this.player1 = new Player("Anders And", 1, 5000);
		//The fields are unaltered
		Assert.assertNotNull(this.player1);
		Assert.assertNotNull(this.Fleet4000Buy);
		Assert.assertNotNull(this.Fleet300Rent);
		Assert.assertTrue(this.Fleet4000Buy instanceof Fleet);
		Assert.assertTrue(this.Fleet300Rent instanceof Fleet);
	}

	@Test
	public void testLandOnFieldBuy4000() {

		int expected = 5000;
		int actual = this.player1.getBalance();
		Assert.assertEquals(expected, actual);

		//Perform the action to be tested
		this.Fleet4000Buy.landOnField(this.player1);
		expected = 5000 - 4000;
		actual = this.player1.getBalance();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testLandOnField2000Twice() {

		int expected = 5000;
		int actual = this.player1.getBalance();
		Assert.assertEquals(expected, actual);

		//Perform the action to be tested
		this.Fleet4000Buy.landOnField(this.player1);
		this.Fleet4000Buy.landOnField(this.player1);
		expected = 5000 -4000-0;
		actual = this.player1.getBalance();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testLandOnOwnedField() {
		this.player1.setBalance(5000);
		this.player2.setBalance(5000);
		int expected1 = 5000;
		int expected2 = 5000;
		int actual1 = this.player1.getBalance();
		int actual2 = this.player2.getBalance();

		Assert.assertEquals(expected1, actual1);
		Assert.assertEquals(expected2, actual2);
		
		//Perform the action to be tested
		this.FleetOwned.landOnField(this.player1);
		this.FleetOwned.landOnField(this.player2);
		
		expected1 = 5000-4000+500;
		expected2 = 5000-500;

		actual1 = this.player1.getBalance();
		actual2 = this.player2.getBalance();

		Assert.assertEquals(expected1, actual1);
		Assert.assertEquals(expected2, actual2);
	}
}