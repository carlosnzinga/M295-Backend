package TodoList.lowlevel;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LlevelRepository extends JpaRepository<Llevel, Long> {
    List<Llevel> findByOrderByNameAsc();
}
