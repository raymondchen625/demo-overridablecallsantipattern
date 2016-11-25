package com.raymondchen.overridablecallsantipattern;

public class Child extends Parent {
	
	public Child(double probability) {
		super(probability);
	}
	
	private boolean likely;

	@Override
	public void init(double probability) {
		if (probability>0.5d) {
			this.setLikely(true);
		} 
	}

	public static void main(String[] args) {
		for (int i=0;i<10;i++) {
			double p=Math.random();
			Child child=new Child(p);
			System.out.println("Child with p="+p+" has likelihood="+child.isLikely());
		}
	}

	public boolean isLikely() {
		return likely;
	}

	public void setLikely(boolean likely) {
		this.likely = likely;
	}
}
