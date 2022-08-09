package com.sumup.datamodels;

import java.util.List;

public class FullTask extends Task {
	private List<String> requires;

	public List<String> getRequires() {
		return requires;
	}

	public void setRequires(List<String> requires) {
		this.requires = requires;
	}
}