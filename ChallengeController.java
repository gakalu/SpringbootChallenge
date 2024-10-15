package com.getachew.challengeApp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/challenges")
@CrossOrigin(origins = "http://localhost:3000")
public class ChallengeController {
    private ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @GetMapping
    public List<Challenge> getAllChallenges() {

        return challengeService.getAllChallenges();
    }


    @PostMapping

    public String addChallenge(@RequestBody Challenge challenge) {

        boolean isChallengeAdded = challengeService.addChallenges(challenge);
        if (isChallengeAdded)
            return "Challenge added successfully";
        else
            return "Challenge is not added successfully";
    }
    @GetMapping("/{month}")
    public ResponseEntity<Challenge> getChallenge(@PathVariable String month) {
         //what is the solution that make value that will be nice value
        //The code value will be rem
        Challenge challenge= challengeService.getChallenge(month);
        if(challenge!=null)
            return new ResponseEntity<>(challenge, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/{id}")

    public ResponseEntity<String> updateChallenge(@PathVariable Long id,@RequestBody Challenge updatedChallenge) {

        boolean isChallengeUpdated= challengeService.updateChallenge(id,updatedChallenge);
        if (isChallengeUpdated)
            return new ResponseEntity<>("Challenge updated successfully",HttpStatus.OK);
        else
            return new ResponseEntity<>( "Challenge is not updated successfully",HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")

    public ResponseEntity<Challenge> deleteChallenge(@PathVariable Long id) {

        boolean isChallengeDeleted=challengeService.deleteChallenge(id);
        if(isChallengeDeleted)
            return new ResponseEntity("Challenge deleted successfully",HttpStatus.OK);
        else
            return new ResponseEntity("Challenge not deleted successfully",HttpStatus.NOT_FOUND);
    }
}




