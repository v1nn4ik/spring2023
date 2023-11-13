package org.spring2023.extern.converter;

import org.spring2023.app.entity.ExerciseEntity;
import org.spring2023.extern.dto.ExerciseDto;
import org.springframework.stereotype.Component;

@Component
public class ExerciseConverter {
    public ExerciseDto toDto (ExerciseEntity exerciseEntity) {
        ExerciseDto exerciseDto = new ExerciseDto();
        exerciseDto.setName(exerciseEntity.getName());
        exerciseDto.setType(exerciseEntity.getType());
        exerciseDto.setPurpose(exerciseEntity.getPurpose());
        exerciseDto.setDifficulty(exerciseEntity.getDifficulty());
        exerciseDto.setDuration(exerciseEntity.getDuration());
        exerciseDto.setApproaches(exerciseEntity.getApproaches());
        exerciseDto.setEquipment(exerciseEntity.getEquipment());
        return exerciseDto;
    }

    public ExerciseEntity toEntity (ExerciseDto exerciseDto) {
        ExerciseEntity exerciseEntity = new ExerciseEntity();
        exerciseEntity.setName(exerciseDto.getName());
        exerciseEntity.setType(exerciseDto.getType());
        exerciseEntity.setPurpose(exerciseDto.getPurpose());
        exerciseEntity.setDifficulty(exerciseDto.getDifficulty());
        exerciseEntity.setDuration(exerciseDto.getDuration());
        exerciseEntity.setApproaches(exerciseDto.getApproaches());
        exerciseEntity.setEquipment(exerciseDto.getEquipment());
        return exerciseEntity;
    }
}
