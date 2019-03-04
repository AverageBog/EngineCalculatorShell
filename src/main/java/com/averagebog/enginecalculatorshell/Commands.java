package com.averagebog.enginecalculatorshell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import com.averagebog.enginecalculatorshell.service.EngineCalculationService;

@ShellComponent
public class Commands {
	
	private final EngineCalculationService engineCalculator;
	
	@Autowired
	public Commands(EngineCalculationService engineCalculator) {
		super();
		this.engineCalculator = engineCalculator;
	}

	/**
	 * calculates simple horsepower given torque and RPM
	 * 
	 * @param torque, float
	 * @param rpm, int
	 * 
	 * @returns horsepower, double
	 * @throws IllegalArgumentException if RPM or torque is less than or equal to 0
	 * */
	@ShellMethod(value="Calculate a vechile's Horsepower given torque and RPM",key= {"hp","cal-hp"})
	public double horsepower(
			@ShellOption(value={"-torque","-T"}, help="Torque produced by vehicle at  a specific engine speed, can be found in vehicle's technical specifications or measured") float torque,
			@ShellOption(value= {"-rpm"}, defaultValue="3000", help="Revolutions per Minute, engine speed, measurement of how fast a vehicle;s crankshaft is rotating, measured on a tachometer") int rpm) {
		//parameter validation
		if(rpm <= 0) {
			throw new IllegalArgumentException("RPM cannot be zero or negative");
		}
		if(torque <= 0) {
			throw new IllegalArgumentException("Torque cannot be zero or negative");
		}
				
		return engineCalculator.commonHorsepower(rpm, torque);
		
	}
}
