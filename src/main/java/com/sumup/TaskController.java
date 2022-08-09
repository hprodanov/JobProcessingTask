package com.sumup;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sumup.datamodels.FullTasks;
import com.sumup.datamodels.Task;

@RestController
public class TaskController {

	@PostMapping("/")
	public List<Task> processTasks(@RequestBody FullTasks fullTasks) {
		return TasksOrdering.orderByRequirements(fullTasks);
	}

	@PostMapping("/bash")
	public String generateBashScript(@RequestBody FullTasks fullTasks) {
		return TasksOrdering.orderByRequirementsBash(fullTasks);
	}

}