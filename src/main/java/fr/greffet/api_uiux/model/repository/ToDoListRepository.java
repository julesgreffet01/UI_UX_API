package fr.greffet.api_uiux.model.repository;

import fr.greffet.api_uiux.model.entity.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {
}
