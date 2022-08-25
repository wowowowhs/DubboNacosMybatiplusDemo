package com.whs.dubbonacosmybatisplusprovider.dao;

import com.whs.dubbonacosmybatisplusapi.entity.Person;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 巫浩盛
 * @since 2021-06-30
 */
//public interface PersonDao extends BaseMapper<Person> {   //逆向工程生成的
@Mapper
public interface PersonDao{

    List<Person> getAllPerson();
}
