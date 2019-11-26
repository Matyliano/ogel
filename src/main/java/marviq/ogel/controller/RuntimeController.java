package marviq.ogel.controller;

import marviq.ogel.dto.RuntimeDto;
import marviq.ogel.entity.Machine2x2;
import marviq.ogel.exception.ErrorResponse;
import marviq.ogel.service.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("api/runtime")
public class RuntimeController {

    private final RuntimeService runtimeService;

    @Autowired
    public RuntimeController(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    @GetMapping
    public Page<RuntimeDto> getRuntimeList(@PageableDefault(size = 15) Pageable pageable) {
        return runtimeService.getRuntimeList(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneById(@PathVariable(value = "id") Long id) {
        Optional<RuntimeDto> runtime = runtimeService.findById(id);
        if (runtime.isPresent()) {
            return new ResponseEntity<>(runtime.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ErrorResponse("The runtime was not found", 404), HttpStatus.NOT_FOUND);
    }

    @GetMapping("/date")
    public Page<RuntimeDto> getOneByDate(@PageableDefault(size = 15) Pageable pageable, @RequestParam("dateTime") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateTime) {
        return runtimeService.findByDateTime(dateTime, pageable);

    }

    @GetMapping("/isRunning")
    public Page<RuntimeDto> getByIsRunning(@PageableDefault(size = 15) Pageable pageable, @RequestParam("isRunning") Integer isRunning) {
       try{
        return runtimeService.findByIsRunning(isRunning, pageable);
    } catch (NoSuchElementException ex){
           throw new NoSuchElementException("Value of isRunning was not found");
       }
    }

    @GetMapping("/isRunningAndMachine")
    public Page<RuntimeDto> getByIsRunningAndMachineName(@PageableDefault(size = 15) Pageable pageable, @RequestParam("isRunning") Integer isRunning, @RequestParam("machineName") String machineName) {
        return runtimeService.findByIsRunningAndAndMachineName(isRunning, machineName, pageable);
    }



}
