package ua.axellos.kanbanrider.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ua.axellos.kanbanrider.dto.AgileBoardColumnDto;
import ua.axellos.kanbanrider.model.AgileBoardColumn;

import java.util.List;

@Mapper
public interface AgileBoardColumnMapper {

    AgileBoardColumnMapper INSTANCE = Mappers.getMapper(AgileBoardColumnMapper.class);

    AgileBoardColumn map(AgileBoardColumnDto columnDto);

    List<AgileBoardColumn> map(List<AgileBoardColumnDto> columnDtoList);
}
