package br.com.alura.todoapi.controller

import br.com.alura.todoapi.model.Task
import br.com.alura.todoapi.service.TaskService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("tasks")
class TasksController(val service: TaskService) {

    @GetMapping
    fun findAll(): ResponseEntity<List<Task>> {
        return ResponseEntity.ok(service.findAll())
    }

    @PostMapping
    fun save(@RequestBody task: Task): ResponseEntity<Task> {
        return ResponseEntity.ok(service.save(task = task))
    }

    @PutMapping("{id}")
    fun update(@PathVariable id: Long,
               @RequestBody task: Task): ResponseEntity<Task> {
        if (service.exists(id)) {
            return ResponseEntity.ok(service.save(id, task))
        }
        return ResponseEntity.notFound().build()
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Any> {
        service.delete(id)
        return ResponseEntity.ok().build()
    }

}