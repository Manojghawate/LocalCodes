package com.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
/**
 * @author manoj.ghawate
 * This Class explains different types of assertMethods
 */
class MathOperationsAsertTest {
	List<String>players = List.of("Sachin","Sehwagh","Ganguly","Rahul","Yuvraj");
	@Test
	void test() {
		assertEquals(true,players.contains("Sachin"));
		assertEquals(true,players.contains("Rahul"),"Rahul is not present in playsers list");
		assertTrue(players.contains("Yuvraj"),"Yuvraj is mising in team, Without him we cant wint the WC2015");
		assertFalse(players.contains("VijayShankar"),"We dont need 3D players");
		assertNotNull(players);
		assertArrayEquals(new String[] {"Virat","Dhoni"}, new String[] {"Virat","Dhoni"}); //sequence matters
	}

}
