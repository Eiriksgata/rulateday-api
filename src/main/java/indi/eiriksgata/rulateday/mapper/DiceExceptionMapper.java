package indi.eiriksgata.rulateday.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import indi.eiriksgata.rulateday.pojo.DiceException;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author: create by Keith
 * version: v1.0
 * description: indi.eiriksgata.rulateday.mapper
 * date: 2021/5/20
 **/
@Mapper
@Repository
public interface DiceExceptionMapper extends BaseMapper<DiceException> {

    @Select("select * from dice_exception")
    List<DiceException> selectAll();

}
