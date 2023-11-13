package org.spring2023.extern.converter;

import org.spring2023.app.entity.WorkoutEntity;
import org.spring2023.extern.dto.WorkoutDto;
import org.springframework.stereotype.Component;

@Component
public class WorkoutConverter {
    public WorkoutDto toDto(WorkoutEntity workoutEntity) {
        WorkoutDto workoutDto = new WorkoutDto();
        workoutDto.setName(workoutEntity.getName());
        workoutDto.setType(workoutEntity.getType());
        workoutDto.setPurpose(workoutEntity.getPurpose());
        workoutDto.setDifficulty(workoutEntity.getDifficulty());
        workoutDto.setDuration(workoutEntity.getDuration());
        workoutDto.setApproaches(workoutEntity.getApproaches());
        workoutDto.setEquipment(workoutEntity.getEquipment());
        workoutDto.setProgress(workoutEntity.getProgress());
        workoutDto.setPhoto(workoutEntity.getPhoto());
        workoutDto.setNote(workoutEntity.getNote());
        workoutDto.setDate(workoutEntity.getDate());
        workoutDto.setLocation(workoutEntity.getLocation());
        return workoutDto;
    }

    public WorkoutEntity toEntity(WorkoutDto workoutDto) {
        WorkoutEntity workoutEntity = new WorkoutEntity();
        workoutEntity.setName(workoutDto.getName());
        workoutEntity.setType(workoutDto.getType());
        workoutEntity.setPurpose(workoutDto.getPurpose());
        workoutEntity.setDifficulty(workoutDto.getDifficulty());
        workoutEntity.setDuration(workoutDto.getDuration());
        workoutEntity.setApproaches(workoutDto.getApproaches());
        workoutEntity.setEquipment(workoutDto.getEquipment());
        workoutEntity.setProgress(workoutDto.getProgress());
        workoutEntity.setPhoto(workoutDto.getPhoto());
        workoutEntity.setNote(workoutDto.getNote());
        workoutEntity.setDate(workoutDto.getDate());
        workoutEntity.setLocation(workoutDto.getLocation());
        return workoutEntity;
    }
}
