package com.haoting.jbricks.sys.infrastructure.repository.mysql;

import com.haoting.jbricks.core.util.BeanCopierUtils;
import com.haoting.jbricks.core.util.UUIDUtil;
import com.haoting.jbricks.sys.application.dto.UserDTO;
import com.haoting.jbricks.sys.domain.model.User;
import com.haoting.jbricks.sys.infrastructure.dao.entity.UserEntity;
import com.haoting.jbricks.sys.infrastructure.dao.mapper.UserEntityMapper;
import com.haoting.jbricks.sys.infrastructure.repository.IUserRepository;
import com.haoting.jbricks.sys.infrastructure.repository.translator.UserRepositoryTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @author haoting.wang
 * @Date 2018/7/22
 */
@Repository
public class UserMysqlRepository implements IUserRepository {

    @Autowired
    private UserEntityMapper userEntityMapper;
    @Override
    public int addUser(User user) {

        UserEntity userEntity = new UserEntity();

        BeanCopierUtils.copyProperties(user,userEntity);
        userEntity.setUuid(UUIDUtil.uuid2());
        userEntity.setGmtCreated(new Date());
        userEntity.setGmtModified(new Date());

        return userEntityMapper.insertSelective(userEntity);
    }

    @Override
    public UserDTO findUserById(String userId) {

        UserEntity userEntity = new UserEntity();
        userEntity.setUuid(userId);
        userEntity = userEntityMapper.selectOne(userEntity);

        return UserRepositoryTranslator.fromPO(userEntity);

    }
}
