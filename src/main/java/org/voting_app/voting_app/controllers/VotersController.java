package org.voting_app.voting_app.controllers;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.voting_app.voting_app.dtos.request.DeleteVotedCandidateRequest;
import org.voting_app.voting_app.dtos.request.PredictWinnerRequest;
import org.voting_app.voting_app.dtos.request.VoteForCandidateRequest;
import org.voting_app.voting_app.dtos.response.DeleteVotedCandidateResponse;
import org.voting_app.voting_app.dtos.response.PredictWinnerResponse;
import org.voting_app.voting_app.dtos.response.VoteForCandidateResponse;
import org.voting_app.voting_app.services.interfaces.VoterService;

@RestController
@RequestMapping("/Api/v1")
@AllArgsConstructor
public class VotersController {


    private final VoterService voterService;

    @PostMapping("Vote")
    public ResponseEntity<?> voteForCandidate(@RequestBody VoteForCandidateRequest request){
        try{
            VoteForCandidateResponse response = voterService.voteForCandidate(request);
            return new ResponseEntity<>( response, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>( e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @DeleteMapping("DeleteVote")
    public ResponseEntity<?> deleteVoteForCandidate(@RequestBody DeleteVotedCandidateRequest request){
        try{
            DeleteVotedCandidateResponse response = voterService.deleteCandidate(request);
            return new ResponseEntity<>( response, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>( e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("predicateWinner")
    public ResponseEntity<?> predictWinner(@RequestBody PredictWinnerRequest request){
        try{
            PredictWinnerResponse response = voterService.predictWinner(request);
            return new ResponseEntity<>( response, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>( e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
