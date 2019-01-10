package com.irs.mapper;

import com.irs.pojo.TbSearch;
import com.irs.pojo.TbSearchExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSearchMapper {
    long countByExample(TbSearchExample example);

    int deleteByExample(TbSearchExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbSearch record);

    int insertSelective(TbSearch record);

    List<TbSearch> selectByExample(TbSearchExample example);

    TbSearch selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbSearch record, @Param("example") TbSearchExample example);

    int updateByExample(@Param("record") TbSearch record, @Param("example") TbSearchExample example);

    int updateByPrimaryKeySelective(TbSearch record);

    int updateByPrimaryKey(TbSearch record);
}