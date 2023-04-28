package TodoList.highLevel;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HlevelRepository extends JpaRepository<Hlevel, Long> {
    List<Hlevel> findByOrderByNameAsc();
}
