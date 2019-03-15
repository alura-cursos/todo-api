package br.com.alura.todoapi.service

import br.com.alura.todoapi.model.Task
import br.com.alura.todoapi.repository.TaskRepository
import org.springframework.stereotype.Service

@Service
class TaskService(
        val repository: TaskRepository) {

    fun findAll(): List<Task> = repository.findAll().toList()

    fun save(id: Long = 0, task: Task) = repository
            .save(task.copy(id = id))

    fun exists(id: Long) = repository.existsById(id)

    fun delete(id: Long) {
        if (exists(id)) {
            repository.deleteById(id)
        }
    }

}