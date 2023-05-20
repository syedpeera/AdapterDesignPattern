package com.structural.AdatperDesignPattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.structural.AdatperDesignPattern.Adapter.WeightMachineAdapter;
import com.structural.AdatperDesignPattern.Adapter.WeightMachineAdapterImpl;

@SpringBootApplication
public class AdatperDesignPatternApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdatperDesignPatternApplication.class, args);
		WeightMachineAdapter weightMachineAdapter = new WeightMachineAdapterImpl();
		System.out.println(weightMachineAdapter.getWeightInKg());
	}
}