package com.averagebog.enginecalculatorshell;


import org.junit.Before;
import org.junit.Test;

import com.averagebog.enginecalculatorshell.service.EngineCalculationService;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.Is.*;

public class EngineCalculatorUnitTest {

	private EngineCalculationService testCalculator;
	
	@Before
	public void setUp() {
		testCalculator = new EngineCalculationService();
	}
	
	@Test
	public void test_commonHorsepower_correctValue() {
		double actualResponse = testCalculator.commonHorsepower(3000, 300);
		assertThat(actualResponse, is(171.36));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void test_commonHorsepower_NegavtiveRpm_ThrowsException() {
		double actualResponse = testCalculator.commonHorsepower(-3000, 300);
		assertThat(actualResponse, is(171.36));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void test_commonHorsepower_NegavtiveTorque_ThrowsException() {
		double actualResponse = testCalculator.commonHorsepower(3000, -300);
		assertThat(actualResponse, is(171.36));
	}
}
