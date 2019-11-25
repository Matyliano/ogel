package marviq.ogel.converter;

import marviq.ogel.dto.RuntimeDto;
import marviq.ogel.entity.Runtime;
import org.springframework.stereotype.Component;

@Component
public class RuntimeConverter {

    public RuntimeDto convert(Runtime sourceOfData) {
        RuntimeDto runtimeDto = new RuntimeDto();
        runtimeDto.setMachineName(sourceOfData.getMachineName());
        runtimeDto.setDateTime(sourceOfData.getDateTime());
        runtimeDto.setIsRunning(sourceOfData.getIsRunning());
        return runtimeDto;
    }

    public Runtime convert(RuntimeDto sourceOdData) {
        Runtime runtime = new Runtime();
        runtime.setMachineName(sourceOdData.getMachineName());
        runtime.setDateTime(sourceOdData.getDateTime());
        runtime.setIsRunning(sourceOdData.getIsRunning());
        return runtime;
    }
}
