package com.lobemusonda.myfirstspringwebapp.todo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();
    private Logger logger = LoggerFactory.getLogger(TodoService.class);

    static {
        todos.add(new Todo(1, "admin01", "Learn AWS", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(2, "admin01", "Learn DevOps", LocalDate.now().plusYears(2), false));
        todos.add(new Todo(3, "admin01", "Learn Full Stack Development", LocalDate.now().plusYears(3), false));
    }

    public List<Todo> findByUsername(String username) {
        return todos.stream()
                .filter(todo -> todo.getUsername().equalsIgnoreCase(username))
                .toList();
    }

    public void add(String username, String description, LocalDate targetDate, boolean done) {
        Todo todo = new Todo(todos.size() + 1, username, description, targetDate, done);
        todos.add(todo);
    }

    public void delete(int id) {
        todos.removeIf(todo -> todo.getId() == id);
    }

    public Todo findById(int id) {
        return todos.stream()
                .filter(todo -> todo.getId() == id)
                .findFirst()
                .get();
    }

    public void update(int id, String description, LocalDate targetDate, boolean done) {
        Todo todo = findById(id);
        todo.setDescription(description);
        logger.debug("Target Date: " + targetDate);
        todo.setTargetDate(targetDate);
        todo.setDone(done);
    }
}
