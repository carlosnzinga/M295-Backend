package TodoList.highLevel;

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
public class HlevelController {

    private final HlevelService HlevelService;

    HlevelController(HlevelService HlevelService) {
        this.HlevelService = HlevelService;
    }

    @GetMapping("api/Hlevel")
    @RolesAllowed(Roles.Read)
    public ResponseEntity<List<Hlevel>> all() {
        List<Hlevel> result = HlevelService.getHlevels();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("api/Hlevel/{id}")
    @RolesAllowed(Roles.Read)
    public ResponseEntity<Hlevel> one(@PathVariable Long id) {
        Hlevel Hlevel = HlevelService.getHlevel(id);
        return new ResponseEntity<>(Hlevel, HttpStatus.OK);
    }

    @PostMapping("api/Hlevel")
    public ResponseEntity<Hlevel> newHlevel(@Valid @RequestBody Hlevel Hlevel) {
        Hlevel savedHlevel = HlevelService.insertHlevel(Hlevel);
        return new ResponseEntity<>(savedHlevel, HttpStatus.OK);
    }

    @PutMapping("api/Hlevel/{id}")
    public ResponseEntity<Hlevel> updateHlevel(@Valid @RequestBody Hlevel Hlevel, @PathVariable Long id) {
        Hlevel savedHlevel = HlevelService.updateHlevel(Hlevel, id);
        return new ResponseEntity<>(savedHlevel, HttpStatus.OK);
    }

    @DeleteMapping("api/Hlevel/{id}")
    @RolesAllowed(Roles.Admin)
    public void deleteHlevel(@PathVariable Long id) {
        HlevelService.deleteHlevel(id);
    }
}
