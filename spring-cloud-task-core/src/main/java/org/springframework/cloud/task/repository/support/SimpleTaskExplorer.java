/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.task.repository.support;

import java.util.List;
import java.util.Set;

import org.springframework.cloud.task.repository.TaskExecution;
import org.springframework.cloud.task.repository.TaskExplorer;
import org.springframework.cloud.task.repository.dao.TaskExecutionDao;
import org.springframework.util.Assert;

/**
 * TaskExplorer for that gathers task information from a task repository.
 *
 * @author Glenn Renfro
 */
public class SimpleTaskExplorer implements TaskExplorer{

	private TaskExecutionDao taskExecutionDao;

	public SimpleTaskExplorer(TaskExecutionDao taskExecutionDao){
		Assert.notNull(taskExecutionDao, "taskExecutionDao must not be null");
		this.taskExecutionDao = taskExecutionDao;
	}

	@Override
	public TaskExecution getTaskExecution(String executionId) {
		return taskExecutionDao.getTaskExecution(executionId);
	}

	@Override
	public Set<TaskExecution> findRunningTaskExecutions(String taskName) {
		return taskExecutionDao.findRunningTaskExecutions(taskName);
	}

	@Override
	public List<String> getTaskNames() {
		return taskExecutionDao.getTaskNames();
	}

	@Override
	public long getTaskExecutionCount(String taskName) {
		return taskExecutionDao.getTaskExecutionCount(taskName);
	}

	@Override
	public List<TaskExecution> getTaskExecutionsByName(String taskName, int start, int count) {
		return taskExecutionDao.getTaskExecutionsByName(taskName, start, count);
	}
}
