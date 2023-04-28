package TodoList.lowlevel;

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
public class LlevelController {

    private final LlevelService LlevelService;

    LlevelController(LlevelService LlevelService) {
        this.LlevelService = LlevelService;
    }

    @GetMapping("api/Llevel")
    @RolesAllowed(Roles.Read)
    public ResponseEntity<List<Llevel>> all() {
        List<Llevel> result = LlevelService.getLlevels();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("api/Llevel/{id}")
    @RolesAllowed(Roles.Read)
    public ResponseEntity<Llevel> one(@PathVariable Long id) {
        Llevel Llevel = LlevelService.getLlevel(id);
        return new ResponseEntity<>(Llevel, HttpStatus.OK);
    }

    @PostMapping("api/Llevel")
    public ResponseEntity<Llevel> newLlevel(@Valid @RequestBody Llevel Llevel) {
        Llevel savedLlevel = LlevelService.insertLlevel(Llevel);
        return new ResponseEntity<>(savedLlevel, HttpStatus.OK);
    }

    @PutMapping("api/Llevel/{id}")
    public ResponseEntity<Llevel> updateLlevel(@Valid @RequestBody Llevel Llevel, @PathVariable Long id) {
        Llevel savedLlevel = LlevelService.updateLlevel(Llevel, id);
        return new ResponseEntity<>(savedLlevel, HttpStatus.OK);
    }

    @DeleteMapping("api/Llevel/{id}")
    @RolesAllowed(Roles.Admin)
    public void deleteLlevel(@PathVariable Long id) {
        LlevelService.deleteLlevel(id);
    }
}
