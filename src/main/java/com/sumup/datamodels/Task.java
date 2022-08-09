package com.sumup.datamodels;

public class Task {

	private String name;
	private String command;

	public Task() {
	}

	public Task(FullTask fullTask) {
		name = fullTask.getName();
		command = fullTask.getCommand();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

}