package TodoList.tasks;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import org.springframework.stereotype.Service;

import TodoList.storage.EntityNotFoundException;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> getTasks() {
        return repository.findByOrderByNameAsc();
    }

    public Task getTask(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id, Task.class));
    }

    public Task insertTask(Task Task) {
        return repository.save(Task);
    }

    public Task updateTask(Task Task, Long id) {
        return repository.findById(id)
                .map(TaskOrig -> {
                    TaskOrig.setName(Task.getName());
                    TaskOrig.setTodo_Name(Task.getTodo_Name());
                    TaskOrig.setPriority(Task.getPriority());


                    return repository.save(TaskOrig);
                })
                .orElseGet(() -> repository.save(Task));
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
    }
}
