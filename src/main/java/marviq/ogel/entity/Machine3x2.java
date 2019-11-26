package marviq.ogel.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "machine3x2prod")
@Data
public class Machine3x2 extends AbstractEntity {

    @DateTimeFormat
    @Column(name = "datetime_from")
    @NotNull
    private LocalDateTime startDate;

    @DateTimeFormat
    @Column(name = "datetime_to")
    @NotNull
    private LocalDateTime endDate;

    @Column(name = "production")
    @NotNull
    private Double grossProduction;

    @Column(name = "scrap")
    @NotNull
    private Double scrap;

    @Column(name = "core_temperature")
    @NotNull
    private Double coreTemperature;

}
