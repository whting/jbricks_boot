package com.haoting.jbricks.sys.application.assembler;

import com.haoting.jbricks.core.util.BeanCopierUtils;
import com.haoting.jbricks.sys.application.dto.UserDTO;
import com.haoting.jbricks.sys.domain.model.User;
import org.springframework.stereotype.Component;

/**
 * User模块的组装器，完成domain、DTO对象之间的转换，组装职责包括：</br>
 * 1、完成类型转换、数据格式化；如日志格式化，状态enum装换为前端认识的string；</br>
 * 2、将多个domain组合成一个DTO，一并返回。</br>
 * 3、将多个DTO组合成一个domain，一并返回。
 * 
 * @author haoting.wang
 * @Date 2018/7/22
 */
@Component
public class UserAssembler {

    public User fromDTO(UserDTO userDTO) {

        User user = new User();
        BeanCopierUtils.copyProperties(userDTO,user);

        return user;

    }
}
