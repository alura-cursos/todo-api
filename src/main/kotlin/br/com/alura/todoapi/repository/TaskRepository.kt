package br.com.alura.todoapi.repository

import br.com.alura.todoapi.model.Task
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TaskRepository : CrudRepository<Task, Long>