package com.perfecto.runner;

import org.testng.TestNG;

import io.cucumber.core.runner.Runner;

public class TestStarter {

	public static void main(String[] args) {
		TestNG testng = new TestNG();
		testng.setTestClasses(new Class[] { webRunner.class });
		testng.run();
	}

}
