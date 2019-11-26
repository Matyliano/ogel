package marviq.ogel.service;

import marviq.ogel.converter.RuntimeConverter;
import marviq.ogel.dto.RuntimeDto;
import marviq.ogel.entity.Runtime;
import marviq.ogel.repository.RuntimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RuntimeService {

    private final RuntimeRepository runtimeRepository;
    private final RuntimeConverter runtimeConverter;

    @Autowired
    public RuntimeService(RuntimeRepository runtimeRepository, RuntimeConverter runtimeConverter) {
        this.runtimeRepository = runtimeRepository;
        this.runtimeConverter = runtimeConverter;
    }

    public Page<RuntimeDto> getRuntimeList(Pageable pageable) {
        return runtimeRepository.findAll(pageable).map(runtimeConverter::convert);

    }

    public Page<RuntimeDto> findByIsRunning(Integer isRunning, Pageable pageable) {

        return runtimeRepository.findByIsRunning(isRunning, pageable).map(runtimeConverter::convert);
    }

    public Page<RuntimeDto> findByIsRunningAndAndMachineName(Integer isRunning, String machineName, Pageable pageable) {
        return runtimeRepository.findByIsRunningAndAndMachineName(isRunning, machineName, pageable).map(runtimeConverter::convert);
    }

    public Page<RuntimeDto> findByDateTime(Date dateTime, Pageable pageable) {
        return runtimeRepository.findByDateTime(dateTime, pageable).map(runtimeConverter::convert);
    }

    public Optional<RuntimeDto> findById(Long id) {
        return runtimeRepository.findById(id).map(runtimeConverter::convert);
    }
}
