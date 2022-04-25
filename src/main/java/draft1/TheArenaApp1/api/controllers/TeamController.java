package draft1.TheArenaApp1.api.controllers;


import draft1.TheArenaApp1.business.services.TeamService;
import draft1.TheArenaApp1.core.utilities.results.ErrorDataResult;
import draft1.TheArenaApp1.entities.Player;
import draft1.TheArenaApp1.entities.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/team")
public class TeamController {

    private TeamService teamService;

    @Autowired

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/getAll")
    public List<Team> getAll(){

        return this.teamService.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody Team team){

        this.teamService.add(team);

    }
    @DeleteMapping("/delete")
    public void delete(@RequestBody Team team){

        this.teamService.delete(team);

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
