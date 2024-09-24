package com.restful.web.services.FirstApp.service.mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
/**
 * @author manoj.ghawate
 * This Class shows how we can mock the java.util.List
 */
class ListMockTest {

	@Test
	void simpleSizeTest() {
		List mockList = mock(List.class);
		when(mockList.size()).thenReturn(3);
		assertEquals(3, mockList.size()); //always return 3
		assertEquals(3, mockList.size());
	}
	@Test
	void simpleSizeMultipleTest() {
		List mockList = mock(List.class);
		when(mockList.size()).thenReturn(3).thenReturn(2);
		assertEquals(3, mockList.size()); //will return 3
		assertEquals(2, mockList.size()); // will return 2 hereonwards
		assertEquals(2, mockList.size());
	}

	@Test
	void specificParamTest() {
		List mockList = mock(List.class);
		mockList.add("Sachin");//added data will be ignored in when then functions
		mockList.add("Saurav");
		when(mockList.get(0)).thenReturn("Yuvraj");
		assertEquals("Yuvraj", mockList.get(0)); //will return Yuvraj
		assertEquals(null, mockList.get(1)); // will return null
	}
	@Test
	void genericParamTest() {
		List mockList = mock(List.class);
		mockList.add("Sehwagh");//added data will be ignored in when then functions
		mockList.add("Saurav");
		when(mockList.get(Mockito.anyInt())).thenReturn("Sachin");
		assertEquals("Sachin", mockList.get(0)); //will return Yuvraj
		assertEquals("Sachin", mockList.get(1)); // will return null
	}

}
