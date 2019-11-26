package marviq.ogel.service;

import marviq.ogel.converter.Machine3x2Converter;
import marviq.ogel.converter.Machine4x2Converter;
import marviq.ogel.dto.Machine3x2Dto;
import marviq.ogel.dto.Machine4x2Dto;
import marviq.ogel.entity.Machine3x2;
import marviq.ogel.entity.Machine4x2;
import marviq.ogel.repository.Machine3x2Repository;
import marviq.ogel.repository.Machine4x2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Machine4x2Service {

    private final Machine4x2Repository machine4x2Repository;
    private final Machine4x2Converter converter;

    @Autowired
    public Machine4x2Service(Machine4x2Repository machine4x2Repository, Machine4x2Converter converter) {
        this.machine4x2Repository = machine4x2Repository;
        this.converter = converter;
    }

    public Page<Machine4x2Dto> findAll(Pageable pageable) {
        return machine4x2Repository.findAll(pageable).map(converter::convert);
    }

    public Optional<Machine4x2Dto> getMachine(Long id) {
        Optional<Machine4x2> machineById = machine4x2Repository.findById(id);
        return machineById.map(converter::convert);
    }

}
