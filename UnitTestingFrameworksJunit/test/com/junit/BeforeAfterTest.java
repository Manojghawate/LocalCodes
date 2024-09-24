package com.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * @author manoj.ghawate
 * This class explains before after annotations of test frameworks
 * NOTE: Methods with BeforeAll and AfterAll annotations should be static
 */

class BeforeAfterTest {
	
	//executes before each test
	@BeforeEach
	void testBeforeEach() {
		System.out.println("testBeforeEach");
	}
	
	//executes after each test
	@AfterEach
	void testAfterEach() {
		System.out.println("testAfterEach");
	}
	//executes before all tests
		@BeforeAll
		static void testBeforeAll() {
			System.out.println("testBeforeAll");
		}
		
		//executes after all tests
		@AfterAll
		static void testAfterAll() {
			System.out.println("testAfterAll");
		}
	@Test
	void test1() {
		System.out.println("Test1");
	}
	@Test
	void test2() {
		System.out.println("Test2");
	}
	@Test
	void test3() {
		System.out.println("Test3");
	}

}
