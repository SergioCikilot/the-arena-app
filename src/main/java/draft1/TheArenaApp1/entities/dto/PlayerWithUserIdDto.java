package draft1.TheArenaApp1.entities.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import draft1.TheArenaApp1.core.entities.positions.PositionEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerWithUserIdDto {

    private int playerId;

    private int userId;

    private String playerName;

    private String playerSirName;

    private PositionEnum positionEnum;

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Past
    private LocalDate ageBirthDate;

}