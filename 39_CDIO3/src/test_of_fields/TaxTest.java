package test_of_fields;

import static org.junit.Assert.*;

import java.awt.Color;

import entity.Tax;
import entity.Player;
import org.junit.*;

public class TaxTest {

	private Player player;

	private Tax Tax2000;

	private Tax Tax4000;

	private Tax Tax10Percent;

	@Before

	public void setUp() throws Exception {

		this.player = new Player("Anders And", 1, 5000);

		this.Tax2000 =  new Tax("Goldmine",Color.GRAY,Color.BLUE,"Tax, pay 2000",2000,false);

		this.Tax4000 = new Tax("Goldmine",Color.GRAY,Color.BLUE,"Tax, pay 4000 or 10%",4000,false);

		this.Tax10Percent = new Tax("Goldmine",Color.GRAY,Color.BLUE,"Tax, pay4000 or 10%",4000,true);

	}

	@After

	public void tearDown() throws Exception {

	}

	@Test

	public void testEntities() {

		this.player = new Player("Anders And", 1, 5000);

		//The fields are unaltered

		Assert.assertNotNull(this.player);

		Assert.assertNotNull(this.Tax2000);

		Assert.assertNotNull(this.Tax4000);

		Assert.assertNotNull(this.Tax10Percent);

		Assert.assertTrue(this.Tax2000 instanceof Tax);

		Assert.assertTrue(this.Tax4000 instanceof Tax);

		Assert.assertTrue(this.Tax10Percent instanceof Tax);

	}

	@Test

	public void testLandOnField2000() {

		int expected = 5000;

		int actual = this.player.getBalance();

		Assert.assertEquals(expected, actual);

		//Perform the action to be tested

		this.Tax2000.landOnField(this.player);

		expected = 5000 - 2000;

		actual = this.player.getBalance();

		Assert.assertEquals(expected, actual);

	}


	@Test

	public void testLandOnFieldTaxPercent() {

		int expected = 5000;

		int actual = this.player.getBalance();

		Assert.assertEquals(expected, actual);

		//Perform the action to be tested

		this.Tax10Percent.landOnField(this.player);

		expected = 5000-(5000/100*10);

		actual = this.player.getBalance();
		System.out.println("actual" +actual);
		System.out.println("expected" + expected);
		Assert.assertEquals(expected, actual);

	}

	@Test

	public void testLandOnField4000() {

		this.player.setBalance(41000);		
		int expected = 41000;

		int actual = this.player.getBalance();

		Assert.assertEquals(expected, actual);

		//Perform the action to be tested

		this.Tax4000.landOnField(this.player);

		expected = 41000-4000;

		actual = this.player.getBalance();

		Assert.assertEquals(expected, actual);

	}

	
}