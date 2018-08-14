package com.haoting.jbricks.sys.infrastructure.repository.translator;

import com.haoting.jbricks.core.util.BeanCopierUtils;
import com.haoting.jbricks.sys.application.dto.UserDTO;
import com.haoting.jbricks.sys.infrastructure.dao.entity.UserEntity;

/**
 * 将不同repository返回的entity翻译层domain层认识的model对象</br>
 * NOTE：通常情况下，我们可以直接使用domain层的model对象写入存储，这样就不需要translator存在了，比如demo中使用memory repository完成model的存取；
 * 实际项目中，并不会这么理想，往往有很多遗留的系统，需要我们使用translator做翻译。
 * 另一个常见的场景是：部分字段的值在持久化层的entity和domain层的model中是不一样的，比如：持久化层的isDelete是使用char表示（'0','1'），而在domain的model层则使用boolean类型表示，这时候就需要使用assembler进行翻译。
 * 
 * @author haoting.wang
 * @Date 2018/7/22
 */
public class UserRepositoryTranslator {

    public static UserDTO fromPO(UserEntity userEntity) {

        UserDTO userDTO = new UserDTO();
        BeanCopierUtils.copyProperties(userEntity,userDTO);
        return userDTO;
    }
}
