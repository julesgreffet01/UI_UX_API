package fr.greffet.api_uiux.model.repository;

import fr.greffet.api_uiux.model.entity.ToDoTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoTaskRepository extends JpaRepository<ToDoTask, Integer> {
}
