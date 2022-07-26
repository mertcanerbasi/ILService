package com.rython.ILService.controller;

import com.rython.ILService.exception.ILNotFoundException;
import com.rython.ILService.model.Il;
import com.rython.ILService.service.IlService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/iller")
@AllArgsConstructor
public class ILController {

    private final IlService ilService;


    @GetMapping
    public ResponseEntity<List<Il>> getIller(){

        return new ResponseEntity<>(ilService.getIller(), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Il> getIl(@PathVariable String id){

            return new ResponseEntity<>(getIlById(id),OK);

    }


    @PostMapping
    public ResponseEntity<Il> createIl(@RequestBody Il newIl){
        return new ResponseEntity<>(ilService.createIl(newIl),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> changeIl(@PathVariable String id,@RequestBody Il changedIl){
        ilService.updateIl(id,changedIl);
        return new ResponseEntity<>("Change Done",HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteIl(@PathVariable String id){
        ilService.deleteIl(id);
        return new ResponseEntity<>("Delete done", OK);
    }

    public Il getIlById(String id){
        return ilService.getIlById(id);
        }

    @ExceptionHandler(ILNotFoundException.class)
    public ResponseEntity<String> handleIlNotFoundException(ILNotFoundException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
