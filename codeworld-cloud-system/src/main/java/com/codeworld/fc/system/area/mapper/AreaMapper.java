package com.codeworld.fc.system.area.mapper;

import com.codeworld.fc.system.area.entity.Area;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AreaMapper {

    List<Area> getAllArea();
}
