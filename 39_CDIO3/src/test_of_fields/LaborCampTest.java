package test_of_fields;

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
	private LaborCamp LaborCampown1;
	private LaborCamp LaborCampown2;
	private LaborCamp LaborCampown3;
	private LaborCamp LaborCampown4;

	@Before
	public void setUp() throws Exception {
		this.player1 = new Player("Anders And", 1, 5000);
		this.player2 = new Player("Gooby and Mockey", 2, 5000);
		this.LaborCamp2500Buy = new LaborCamp("The pit",Color.GRAY,Color.CYAN,"Labor Camp, costs 2500",2500,null,100,false);
		this.LaborCamp300Rent = new LaborCamp("The pit",Color.GRAY,Color.CYAN,"Labor Camp, costs 2500",2500,null,100,false);
		this.LaborCampown1 = new LaborCamp("The pit 1",Color.GRAY,Color.CYAN,"Labor Camp, costs 2500",2500,null,100,false);
		this.LaborCampown2 = new LaborCamp("The pit 2",Color.GRAY,Color.CYAN,"Labor Camp, costs 2500",2500,null,100,false);
		this.LaborCampown3 = new LaborCamp("The pit 3",Color.GRAY,Color.CYAN,"Labor Camp, costs 2500",2500,null,100,false);
		this.LaborCampown4 = new LaborCamp("The pit 4",Color.GRAY,Color.CYAN,"Labor Camp, costs 2500",2500,null,100,false);
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
		LaborCampown1.setTesting(true);
		int expected1 = 5000;
		int actual1 = this.player1.getBalance();
		int expected2 = 5000;
		int actual2 = this.player2.getBalance();

		Assert.assertEquals(expected1, actual1);
		Assert.assertEquals(expected2, actual2);

		//Perform the action to be tested and give player1 money to own 4 fields
		this.player1.setBalance(20000);
		this.player2.setBalance(20000);
		this.LaborCampown1.landOnField(this.player1);
		this.LaborCampown2.landOnField(this.player1);
		this.LaborCampown3.landOnField(this.player1);
		this.LaborCampown4.landOnField(this.player1);
		this.LaborCampown1.landOnField(this.player2);

		expected1 = 20000 - 4*LaborCampown1.getPrice() + (LaborCampown1.getRent() * LaborCampown1.getLaborDiceRoll() * LaborCampown1.getOwner().getLaborCampCount());
		expected2 = 20000 - LaborCampown1.getRent() * LaborCampown1.getLaborDiceRoll() * LaborCampown1.getOwner().getLaborCampCount();

		actual1 = this.player1.getBalance();
		actual2 = this.player2.getBalance();

		Assert.assertEquals(expected1, actual1);
		Assert.assertEquals(expected2, actual2);
	}
}