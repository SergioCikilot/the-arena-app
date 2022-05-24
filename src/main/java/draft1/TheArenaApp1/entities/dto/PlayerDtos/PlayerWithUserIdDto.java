package draft1.TheArenaApp1.entities.dto.PlayerDtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import draft1.TheArenaApp1.core.entities.foots.FootEnum;
import draft1.TheArenaApp1.core.entities.positions.PositionEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerWithUserIdDto {


    private int playerId ;

    private int userId;

    private String playerName;

    private String playerSirName;

    private int playerHeight;

    private boolean playerIsForward;

    private boolean playerIsMidfielder;

    private boolean playerIsDefender;

    private boolean playerIsGoalkeeper;
    @Enumerated
    private FootEnum playerFoot;

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    private LocalDate playerBirthDate;

}
