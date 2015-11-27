package test;

import static org.junit.Assert.*;

import java.awt.Color;

import entity.LaborCamp;
import entity.Player;
import org.junit.*;

public class LaborCampTest {

	private Player player1;
	private Player player2;
	private LaborCamp LaborCamp2500Buy;
	private LaborCamp LaborCamp300Rent;
	


	
	@Before

	public void setUp() throws Exception {

		this.player1 = new Player("Anders And", 1, 5000);
		this.player2 = new Player("Gooby and Mockey", 2, 5000);

		this.LaborCamp2500Buy = new LaborCamp("The pit",Color.GRAY,Color.CYAN,"Labor Camp, costs 2500",2500,null,100,false);

		this.LaborCamp300Rent = new LaborCamp("The pit",Color.GRAY,Color.CYAN,"Labor Camp, costs 2500",2500,null,100,false);

	}

	@After

	public void tearDown() throws Exception {

	}

	@Test

	public void testEntities() {

		this.player1 = new Player("Anders And", 1, 5000);
		this.player2 = new Player("Dolan Duck", 2, 5000);

		//The fields are unaltered

		Assert.assertNotNull(this.player1);
		Assert.assertNotNull(this.player2);

		Assert.assertNotNull(this.LaborCamp2500Buy);

		Assert.assertNotNull(this.LaborCamp300Rent);

		Assert.assertTrue(this.LaborCamp2500Buy instanceof LaborCamp);

		Assert.assertTrue(this.LaborCamp300Rent instanceof LaborCamp);


	}

	@Test

	public void testLandOnFieldBuy2500() {

		int expected = 5000;

		int actual = this.player1.getBalance();

		Assert.assertEquals(expected, actual);

		//Perform the action to be tested

		this.LaborCamp2500Buy.landOnField(this.player1);

		expected = 5000 - 2500;

		actual = this.player1.getBalance();

		Assert.assertEquals(expected, actual);

	}

	@Test

	public void testLandOnField2000Twice() {

		int expected = 5000;

		int actual = this.player1.getBalance();

		Assert.assertEquals(expected, actual);

		//Perform the action to be tested

		this.LaborCamp2500Buy.landOnField(this.player1);

		this.LaborCamp2500Buy.landOnField(this.player1);

		expected = 5000 -2500-0;

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
		
		this.LaborCamp300Rent.landOnField(this.player1);
		this.LaborCamp300Rent.landOnField(this.player2);
		
		expected1= 5000-2000+LaborCamp300Rent.getRent();
		System.out.println(expected1);
		expected2 = 5000-LaborCamp300Rent.getRent();
		System.out.println(expected2);

		actual1 = this.player1.getBalance();
		actual2 = this.player2.getBalance();

		Assert.assertEquals(expected1, actual1);
		Assert.assertEquals(expected2, actual2);

	}

	

}