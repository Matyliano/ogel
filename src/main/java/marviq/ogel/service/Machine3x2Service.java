package marviq.ogel.service;

import marviq.ogel.converter.Machine3x2Converter;
import marviq.ogel.dto.Machine3x2Dto;
import marviq.ogel.entity.Machine3x2;
import marviq.ogel.repository.Machine3x2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Machine3x2Service {

    private final Machine3x2Repository machine3x2Repository;
    private final Machine3x2Converter converter;

    @Autowired
    public Machine3x2Service(Machine3x2Repository machine3x2Repository, Machine3x2Converter converter) {
        this.machine3x2Repository = machine3x2Repository;
        this.converter = converter;
    }

    public Page<Machine3x2Dto> findAll(Pageable pageable) {
        return machine3x2Repository.findAll(pageable).map(converter::convert);
    }

    public Optional<Machine3x2Dto> getMachine(Long id) {
        Optional<Machine3x2> machineById = machine3x2Repository.findById(id);
        return machineById.map(converter::convert);
    }

}
