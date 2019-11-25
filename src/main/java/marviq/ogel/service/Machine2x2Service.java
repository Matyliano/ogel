package marviq.ogel.service;

import marviq.ogel.converter.Machine2x2Converter;
import marviq.ogel.dto.Machine2x2Dto;
import marviq.ogel.entity.Machine2x2;
import marviq.ogel.repository.Machine2x2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Machine2x2Service {

    private Machine2x2Repository machine2x2Repository;
    private Machine2x2Converter converter;

    @Autowired
    public Machine2x2Service(Machine2x2Repository machine2x2Repository, Machine2x2Converter converter) {
        this.machine2x2Repository = machine2x2Repository;
        this.converter = converter;
    }

    public List<Machine2x2> findAll() {
        return machine2x2Repository.findAll();
    }

    public Optional<Machine2x2Dto> getMachine(Long id) {
        Optional<Machine2x2> machineById = machine2x2Repository.findById(id);
        return machineById.map(converter::convert);
    }

}
