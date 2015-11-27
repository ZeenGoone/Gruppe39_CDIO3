package test;

import static org.junit.Assert.*;

import java.awt.Color;

import entity.Territory;
import entity.Player;
import org.junit.*;

public class TerritoryTest {

	private Player player1;
	private Player player2;
	private Territory Territory2000Buy;
	private Territory Territory300Rent;


	@Before

	public void setUp() throws Exception {

		this.player1 = new Player("Anders And", 1, 5000);
		this.player2 = new Player("Gooby and Mockey", 2, 5000);

		this.Territory2000Buy = new Territory("Tribe Encampment", Color.PINK, Color.ORANGE,"Territory, Costs 2000",2000,null,300, false);

		this.Territory300Rent = new Territory("Tribe Encampment", Color.PINK, Color.ORANGE,"Territory, Costs 2000",2000,null,300, true);

	}

	@After

	public void tearDown() throws Exception {

	}

	@Test

	public void testEntities() {

		this.player1 = new Player("Anders And", 1, 5000);

		//The fields are unaltered

		Assert.assertNotNull(this.player1);

		Assert.assertNotNull(this.Territory2000Buy);

		Assert.assertNotNull(this.Territory300Rent);

		Assert.assertTrue(this.Territory2000Buy instanceof Territory);

		Assert.assertTrue(this.Territory300Rent instanceof Territory);


	}

	@Test

	public void testLandOnFieldBuy2000() {

		int expected = 5000;

		int actual = this.player1.getBalance();

		Assert.assertEquals(expected, actual);

		//Perform the action to be tested

		this.Territory2000Buy.landOnField(this.player1);

		expected = 5000 - 2000;

		actual = this.player1.getBalance();

		Assert.assertEquals(expected, actual);

	}

	@Test

	public void testLandOnField2000Twice() {

		int expected = 5000;

		int actual = this.player1.getBalance();

		Assert.assertEquals(expected, actual);

		//Perform the action to be tested

		this.Territory2000Buy.landOnField(this.player1);

		this.Territory2000Buy.landOnField(this.player1);

		expected = 5000 -2000-0;

		actual = this.player1.getBalance();

		Assert.assertEquals(expected, actual);


	}

	@Test

	public void testLandOnOwnedField() {

		int expected1 = 5000;
		int actual1 = this.player1.getBalance();
		
		int expected2 = 5000;
		int actual2 = this.player2.getBalance();

		Assert.assertEquals(expected1, actual1);
		Assert.assertEquals(expected2, actual2);
		//Perform the action to be tested
		this.Territory300Rent.landOnField(this.player1);
		this.Territory300Rent.landOnField(this.player2);
		
		expected1= 5000-2000+300;
		expected2 = 5000-300;

		actual1 = this.player1.getBalance();
		actual2 = this.player2.getBalance();

		Assert.assertEquals(expected1, actual1);
		Assert.assertEquals(expected2, actual2);

	}

	

}