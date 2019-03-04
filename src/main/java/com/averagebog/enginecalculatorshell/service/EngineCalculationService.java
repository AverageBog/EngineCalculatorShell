package com.averagebog.enginecalculatorshell.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
/**
 * contains common engine calculation formulas 
 * */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class EngineCalculationService {

	private static final int PRECISION = 2;
	
	/**
	 * simple formula to calculate horsepower given RPM and Torque.
	 * 
	 * rpm * torque / 5252
	 * 
	 * @param rpm  int, Revolutions per Minute
	 * @param torque  double, torque produced at rpm
	 * 
	 * @return horsepower to 2 decimal points
	 * @throws IllegalArgumentException if rpm or torque is less than or equal to 0
	 * 
	 * @see BigDecimal
	 * */
	public double commonHorsepower(int rpm, double torque) {
		//parameter validation
		if(rpm <= 0) {
			throw new IllegalArgumentException("RPM cannot be zero or negative");
		}
		if(torque <= 0) {
			throw new IllegalArgumentException("Torque cannot be zero or negative");
		}
		
		double horsepower = rpm * torque / 5252;
		
		BigDecimal bd = new BigDecimal(Double.toString(horsepower));
	    bd = bd.setScale(PRECISION, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
}
