package TodoList.department;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import jdk.jfr.Enabled;
import lombok.Data;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import java.time.DateTimeException;
import java.util.Date;

@Data
@Entity
public class Department {

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
    private String nachname;

    @Column()
    private int alter;

    @Column(nullable = false)
    @Size(max = 255)
    @NotEmpty
    private String adresse;

    @Column(nullable = false)
    @Size(max = 255)
    @NotEmpty
    private Date datum;

    @Column(nullable = false)
    @Size(max = 255)
    @NotEmpty
    private String titel;

    @Column(nullable = false)
    @Size(max = 255)
    @NotEmpty
    private String text;


    public Department() {
    }
}
