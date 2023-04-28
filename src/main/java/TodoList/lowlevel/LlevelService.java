package TodoList.lowlevel;

import TodoList.storage.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LlevelService {

    private final LlevelRepository repository;

    public LlevelService(LlevelRepository repository) {
        this.repository = repository;
    }

    public List<Llevel> getLlevels() {
        return repository.findByOrderByNameAsc();
    }

    public Llevel getLlevel(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id, Llevel.class));
    }

    public Llevel insertLlevel(Llevel Llevel) {
        return repository.save(Llevel);
    }

    public Llevel updateLlevel(Llevel Llevel, Long id) {
        return repository.findById(id)
                .map(LlevelOrig -> {
                    LlevelOrig.setName(Llevel.getName());
                    LlevelOrig.setLastname(Llevel.getLastname());
                    LlevelOrig.setSolution(Llevel.getSolution());
                    LlevelOrig.setTodo_Name(Llevel.getTodo_Name());
                    return repository.save(LlevelOrig);
                })
                .orElseGet(() -> repository.save(Llevel));
    }

    public void deleteLlevel(Long id) {
        repository.deleteById(id);
    }
}
