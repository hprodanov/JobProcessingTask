package com.sumup;

import java.util.ArrayList;
import java.util.List;

import com.sumup.datamodels.FullTask;
import com.sumup.datamodels.FullTasks;
import com.sumup.datamodels.Task;

public class TasksOrdering {

	public static List<Task> orderByRequirements(FullTasks fullTasks) {
		List<Task> sortedTasks = new ArrayList<Task>();
		boolean isAdded = false;

		for (FullTask task : fullTasks.getTasks()) {
			if (task.getRequires() == null) {
				sortedTasks.add(new Task(task));
				continue;
			}

			for (int i = sortedTasks.size() - 1; i >= 0; i--) {
				if (task.getRequires().contains(sortedTasks.get(i).getName())) {
					sortedTasks.add(i + 1, new Task(task));
					isAdded = true;
					break;
				}
			}

			if (!isAdded) {
				sortedTasks.add(new Task(task));
			}

		}

		return sortedTasks;
	}

	public static String orderByRequirementsBash(FullTasks fullTasks) {
		List<Task> sortedTasks = new ArrayList<Task>();
		List<String> sortedCommands = new ArrayList<String>();
		StringBuilder bashScript = new StringBuilder();
		boolean isAdded = false;

		for (FullTask task : fullTasks.getTasks()) {
			if (task.getRequires() == null) {
				sortedTasks.add(task);
				sortedCommands.add(task.getCommand());
				continue;
			}

			for (int i = sortedTasks.size() - 1; i >= 0; i--) {
				if (task.getRequires().contains(sortedTasks.get(i).getName())) {
					sortedTasks.add(i + 1, task);
					sortedCommands.add(i + 1, task.getCommand());

					isAdded = true;
					break;
				}
			}

			if (!isAdded) {
				sortedTasks.add(task);
				sortedCommands.add(task.getCommand());
			}

		}

		for (String command : sortedCommands) {
			bashScript.append(command);
			bashScript.append("\n"); // na poslednata iteraciq da mahnem prazniq red
		}

		bashScript.setLength(bashScript.length() - 1);

		return bashScript.toString();
	}

}