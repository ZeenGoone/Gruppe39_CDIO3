package test_of_fields;

import static org.junit.Assert.*;

import java.awt.Color;

import entity.Refuge;
import entity.Player;
import org.junit.*;

public class RefugeTest {

	private Player player;

	private Refuge refuge200;

	private Refuge refuge0;

	private Refuge refugeNeg200;

	@Before

	public void setUp() throws Exception {

		this.player = new Player("Anders And", 1, 1000);

		this.refuge200 = new Refuge("Monastery", Color.BLUE, Color.YELLOW,"Refuge, you get 200",200);

		this.refuge0 = new Refuge("Monastery", Color.BLUE, Color.YELLOW,"Refuge, you get 0",0);

		this.refugeNeg200 = new Refuge("Monastery", Color.BLUE, Color.YELLOW,"Refuge, you get -200", -200);

	}

	@After

	public void tearDown() throws Exception {

	}

	@Test

	public void testEntities() {

		this.player = new Player("Anders And", 1, 1000);

		//The fields are unaltered

		Assert.assertNotNull(this.player);

		Assert.assertNotNull(this.refuge200);

		Assert.assertNotNull(this.refuge0);

		Assert.assertNotNull(this.refugeNeg200);

		Assert.assertTrue(this.refuge200 instanceof Refuge);

		Assert.assertTrue(this.refuge0 instanceof Refuge);

		Assert.assertTrue(this.refugeNeg200 instanceof Refuge);

	}

	@Test

	public void testLandOnField200() {

		int expected = 1000;

		int actual = this.player.getBalance();

		Assert.assertEquals(expected, actual);

		//Perform the action to be tested

		this.refuge200.landOnField(this.player);

		expected = 1000 + 200;

		actual = this.player.getBalance();

		Assert.assertEquals(expected, actual);

	}

	@Test

	public void testLandOnField200Twice() {

		int expected = 1000;

		int actual = this.player.getBalance();

		Assert.assertEquals(expected, actual);

		//Perform the action to be tested

		this.refuge200.landOnField(this.player);

		this.refuge200.landOnField(this.player);

		expected = 1000 + 200 + 200;

		actual = this.player.getBalance();

		Assert.assertEquals(expected, actual);


	}

	@Test

	public void testLandOnField0() {

		int expected = 1000;

		int actual = this.player.getBalance();

		Assert.assertEquals(expected, actual);

		//Perform the action to be tested

		this.refuge0.landOnField(this.player);

		expected = 1000;

		actual = this.player.getBalance();

		Assert.assertEquals(expected, actual);

	}

	@Test

	public void testLandOnField0Twice() {

		int expected = 1000;

		int actual = this.player.getBalance();

		Assert.assertEquals(expected, actual);

		//Perform the action to be tested

		this.refuge0.landOnField(this.player);

		this.refuge0.landOnField(this.player);

		expected = 1000;

		actual = this.player.getBalance();

		Assert.assertEquals(expected, actual);

	}

	@Test

	public void testLandOnFieldNeg200() {

		int expected = 1000;

		int actual = this.player.getBalance();

		Assert.assertEquals(expected, actual);

		//Perform the action to be tested

		this.refugeNeg200.landOnField(this.player);

		//It is not possible to deposit a negative amount

		expected = 1000;

		actual = this.player.getBalance();

		Assert.assertEquals(expected, actual);

	}

	@Test

	public void testLandOnFieldNeg200Twice() {

		int expected = 1000;

		int actual = this.player.getBalance();

		Assert.assertEquals(expected, actual);

		//Perform the action to be tested

		this.refugeNeg200.landOnField(this.player);

		this.refugeNeg200.landOnField(this.player);

		//It is still not possible to deposit a negative amount

		expected = 1000;

		actual = this.player.getBalance();

		Assert.assertEquals(expected, actual);

	}

}