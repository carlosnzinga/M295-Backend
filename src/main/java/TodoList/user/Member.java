package TodoList.user;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import java.util.Date;

@Data
@Entity
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    @Size(max = 255)
    @NotEmpty
    private String name;

    @Column(nullable = false)
    @Size(max = 255)
    @NotEmpty
    private String lastname;

    @Column()
    private Long Age;

    @Column(nullable = false)
    @Size(max = 255)
    @NotEmpty
    private String Address;

    @Column(nullable = false)
    @Size(max = 255)
    @NotEmpty
    private String Todo_Name;

    public Member(){

    }
    public Member(String name, String lastname, long Age, String Todo_Name, String Address) {

        this.name = name;
        this.lastname = lastname;
        this.Todo_Name = Todo_Name;
        this.Age = Age;
        this.Address = Address;


    }

}
