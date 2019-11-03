package cz.upce.fei.inpda.druha.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class RoomTempDto {

    @NonNull
    private long roomId;

    @NonNull
    private String name;

}
