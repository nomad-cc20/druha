package cz.upce.fei.inpda.druha.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class TemperatureDto {

    @NonNull
    private long roomId;

    @NonNull
    private double temperature;
}
