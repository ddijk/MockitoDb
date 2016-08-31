package com.javacodegeeks;

import java.sql.Connection;
import java.sql.Statement;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;

public class DBConnectionTest {
	
	@InjectMocks private com.javacodegeeks.DBConnection dbConnection;
	@Mock private Connection mockConnection;
	@Mock private Statement mockStatement;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testMockDBConnection() throws Exception {
		Mockito.when(mockConnection.createStatement()).thenReturn(mockStatement);
		Mockito.when(mockStatement.executeUpdate(Mockito.anyString())).thenReturn(1);
		int value = dbConnection.executeQuery("");
		Assert.assertEquals(value, 1);
		Mockito.verify(mockConnection, times(1)).createStatement();
	}

}
