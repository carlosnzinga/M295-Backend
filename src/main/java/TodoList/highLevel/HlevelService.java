package TodoList.highLevel;

import TodoList.storage.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HlevelService {

    private final HlevelRepository repository;

    public HlevelService(HlevelRepository repository) {
        this.repository = repository;
    }

    public List<Hlevel> getHlevels() {
        return repository.findByOrderByNameAsc();
    }

    public Hlevel getHlevel(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id, Hlevel.class));
    }

    public Hlevel insertHlevel(Hlevel Hlevel) {
        return repository.save(Hlevel);
    }

    public Hlevel updateHlevel(Hlevel Hlevel, Long id) {
        return repository.findById(id)
                .map(HlevelOrig -> {
                    HlevelOrig.setName(Hlevel.getName());
                    HlevelOrig.setLastname(Hlevel.getLastname());
                    HlevelOrig.setSolution(Hlevel.getSolution());
                    HlevelOrig.setTodo_Name(Hlevel.getTodo_Name());




                    return repository.save(HlevelOrig);
                })
                .orElseGet(() -> repository.save(Hlevel));
    }

    public void deleteHlevel(Long id) {
        repository.deleteById(id);
    }
}
