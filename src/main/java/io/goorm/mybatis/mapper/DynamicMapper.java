package io.goorm.mybatis.mapper;

import io.goorm.mybatis.board.Board;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DynamicMapper {

    List<Board> selectAll();

    List<Board> select2(@Param("orderBy") String orderBy,@Param("orderDirection") String orderDirection);

    List<Board> select3(@Param("ids") String[] ids);

    List<Board> select4(@Param("condition") String condition, @Param("searchtxt") String searchtxt);

}
