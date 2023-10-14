package ua.axellos.kanbanrider.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ua.axellos.kanbanrider.dto.AgileBoardDto;
import ua.axellos.kanbanrider.model.AgileBoard;

import java.util.List;

@Mapper
public interface AgileBoardMapper {

    AgileBoardMapper INSTANCE = Mappers.getMapper(AgileBoardMapper.class);

    @Mapping(source = "timestamps.createdAt", target = "createdAt")
    @Mapping(source = "timestamps.updatedAt", target = "updatedAt")
    AgileBoardDto map(AgileBoard agileBoard);

    AgileBoard map(AgileBoardDto agileBoardDto);

    List<AgileBoardDto> map(List<AgileBoard> agileBoards);
}
