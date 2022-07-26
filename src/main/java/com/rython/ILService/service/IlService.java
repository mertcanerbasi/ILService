package com.rython.ILService.service;

import com.rython.ILService.exception.ILNotFoundException;
import com.rython.ILService.model.Il;
import com.rython.ILService.repository.IlRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@Service
@AllArgsConstructor
public class IlService {

    private final IlRepository ilRepository;

    public List<Il> getIller() {
        return ilRepository.findAll();
    }

    public Il createIl(Il newIl) {
       return ilRepository.save(newIl);
    }

    public void deleteIl(String id) {
        ilRepository.deleteById(id);
    }

    public Il getIlById(String id) {
      return  ilRepository.findById(id).orElseThrow(()-> new ILNotFoundException("Il not found by id: "+id));
    }

    public void updateIl(String id, Il changedIl) {
        Il oldIl = getIlById(id);
         oldIl.setName(changedIl.getName());
         ilRepository.save(oldIl);
    }


}
