package com.raymondchen.overridablecallsantipattern;

public abstract class Parent {
	public Parent(double probability) {
		init(probability);
	}
	public abstract void init(double probability) ;
}
