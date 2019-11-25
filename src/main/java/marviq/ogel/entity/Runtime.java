package marviq.ogel.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "runtime")
@Data
public class Runtime extends AbstractEntity {

    @Column(name = "machine_name")
    @NotNull
    private String machineName;

    @DateTimeFormat
    @Column(name = "datetime")
    @NotNull
    private LocalDateTime dateTime;

    @Column(name = "isrunning")
    @NotNull
    private int isRunning;

}
