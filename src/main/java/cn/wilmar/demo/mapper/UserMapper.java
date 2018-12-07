package cn.wilmar.demo.mapper;

import cn.wilmar.demo.model.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface UserMapper extends Mapper<User> {

    User selectUserById(Long id);
}
