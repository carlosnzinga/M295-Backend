package TodoList.tasks;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jdk.jfr.Enabled;
import lombok.Data;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import java.time.DateTimeException;
import java.util.Date;

@Data
@Entity
public class Task {

    @Id
    @GeneratedValue
    private Long Ticket_Number;

    @Column(nullable = false)
    @Size(max = 255)
    @NotEmpty
    private String name;


    @Column(nullable = false)
    private Date Date;

    @Column(nullable = false)
    @Size(max = 255)
    @NotEmpty
    private String Todo_Name;

    @Column(nullable = false)
    @GeneratedValue
    private long Priority ;


    public Task() {
    }
}
