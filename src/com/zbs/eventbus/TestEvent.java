package com.zbs.eventbus;

public class TestEvent extends BaseEvent {
	public String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "TestEvent [name=" + name + "]";
	}
	

}
