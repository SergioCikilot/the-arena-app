package draft1.TheArenaApp1.api.controllers;

import draft1.TheArenaApp1.business.services.PlayerService;
import draft1.TheArenaApp1.core.utilities.results.ErrorDataResult;
import draft1.TheArenaApp1.entities.Pitch;
import draft1.TheArenaApp1.entities.Player;
import draft1.TheArenaApp1.entities.dtos.PlayerWithAgeDto;
import draft1.TheArenaApp1.entities.dtos.PlayerWithoutUserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/player")
public class PlayerController {

    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {

        this.playerService = playerService;

    }

    @GetMapping("/getAll")
    public List<Player> getAllPlayers(){

        return this.playerService.getAll();
    }

    @GetMapping("/getPlayersByTeam")
    public List<Player> getPlayersByTeam(@RequestParam int teamId){

        return this.playerService.getPlayersByTeam(teamId);
    }

    @GetMapping("/getPlayerAge")
    public String getPlayerAge(@RequestParam int playerId){

        Player player = this.playerService.getByPlayerPlayerId(playerId);
        return this.playerService.getPlayerAge(player);

    }

    @PostMapping("/add")
    public void addPlayer(@RequestBody PlayerWithoutUserDto playerWithoutUserDto){

        ModelMapper modelMapper = new ModelMapper();
        Player player = modelMapper.map(playerWithoutUserDto,Player.class);
        this.playerService.add(player);

    }

    @DeleteMapping("delete")
    public void deletePlayer(@RequestBody Player player){

        this.playerService.delete(player);

    }

    @PutMapping("/updateTeamOfPlayer")
    public void updateTeamOfPlayer(@RequestParam int teamId,@RequestParam int playerId){

        this.playerService.addTeam(teamId, playerId);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
        Map<String,String> validationErrors = new HashMap<String,String>();
        for (FieldError fieldError :exceptions.getBindingResult().getFieldErrors()) {

            validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());

        }
        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Validation Errors");
        return  errors;
    }

}
