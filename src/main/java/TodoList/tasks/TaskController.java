package TodoList.tasks;

import TodoList.security.Roles;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SecurityRequirement(name = "bearerAuth")
@Validated
public class TaskController {

    private final TaskService TaskService;

    TaskController(TaskService TaskService) {
        this.TaskService = TaskService;
    }

    @GetMapping("api/Task")
    @RolesAllowed(Roles.Read)
    public ResponseEntity<List<Task>> all() {
        List<Task> result = TaskService.getTasks();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("api/Task/{id}")
    @RolesAllowed(Roles.Read)
    public ResponseEntity<Task> one(@PathVariable Long id) {
        Task Task = TaskService.getTask(id);
        return new ResponseEntity<>(Task, HttpStatus.OK);
    }

    @PostMapping("api/Task")
    @RolesAllowed(Roles.Admin)
    public ResponseEntity<Task> newTask(@Valid @RequestBody Task Task) {
        Task savedTask = TaskService.insertTask(Task);
        return new ResponseEntity<>(savedTask, HttpStatus.OK);
    }

    @PutMapping("api/Task/{id}")
    @RolesAllowed(Roles.Admin)
    public ResponseEntity<Task> updateTask(@Valid @RequestBody Task Task, @PathVariable Long id) {
        Task savedTask = TaskService.updateTask(Task, id);
        return new ResponseEntity<>(savedTask, HttpStatus.OK);
    }

    @DeleteMapping("api/Task/{id}")
    @RolesAllowed(Roles.Admin)
    public void deleteTask(@PathVariable Long id) {
        TaskService.deleteTask(id);
    }
}
