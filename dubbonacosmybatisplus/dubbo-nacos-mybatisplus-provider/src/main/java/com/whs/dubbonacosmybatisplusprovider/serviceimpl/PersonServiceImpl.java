package com.whs.dubbonacosmybatisplusprovider.serviceimpl;

//import com.whs.dubbonacosmybatisplusapi.entity.Person;
import com.alibaba.dubbo.config.annotation.Service;
import com.whs.dubbonacosmybatisplusapi.entity.Person;
import com.whs.dubbonacosmybatisplusapi.service.PersonService;
import com.whs.dubbonacosmybatisplusprovider.dao.PersonDao;
//import com.whs.dubbonacosmybatisplusapi.service.PersonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 巫浩盛
 * @since 2021-06-30
 */
//@Service
//public class PersonServiceImpl extends ServiceImpl<PersonDao, Person> implements PersonService {     //逆向工程生成的
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;

    @Override
    public List<Person> getAllS() {
        List<Person> resultperson = personDao.getAllPerson();
        return resultperson;
    }
}
