package TodoList.department;

import org.springframework.stereotype.Service;

import TodoList.storage.EntityNotFoundException;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository repository;

    public DepartmentService(DepartmentRepository repository) {
        this.repository = repository;
    }

    public List<Department> getDepartments() {
        return repository.findByOrderByNameAsc();
    }

    public Department getDepartment(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id, Department.class));
    }

    public Department insertDepartment(Department department) {
        return repository.save(department);
    }

    public Department updateDepartment(Department department, Long id) {
        return repository.findById(id)
                .map(departmentOrig -> {
                    departmentOrig.setName(department.getName());
                    return repository.save(departmentOrig);
                })
                .orElseGet(() -> repository.save(department));
    }

    public void deleteDepartment(Long id) {
        repository.deleteById(id);
    }
}
