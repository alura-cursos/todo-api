package br.com.alura.todoapi.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Task(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,
        @JsonProperty("descricao")
        val description: String,
        @JsonProperty("dataVencimento")
        val dueDate: LocalDate?)