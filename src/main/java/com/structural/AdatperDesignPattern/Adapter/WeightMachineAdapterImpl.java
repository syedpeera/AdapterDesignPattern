package com.structural.AdatperDesignPattern.Adapter;

import com.structural.AdatperDesignPattern.Adaptee.WeightMachine;
import com.structural.AdatperDesignPattern.Adaptee.WeightMachineForBabies;

public class WeightMachineAdapterImpl implements WeightMachineAdapter{
	private WeightMachine weightMachine;
	public WeightMachineAdapterImpl() {
		this.weightMachine = new WeightMachineForBabies();
	}
	@Override
	public double getWeightInKg() {
		double weightInPounds = weightMachine.getWeightInPound();
		double weightInKgs = weightInPounds * 0.45;
		return weightInKgs;
	}
}