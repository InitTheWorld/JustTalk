package TestLab.JustTalk_Server.src.mapper;

import TestLab.JustTalk_Server.src.dao.UserProperty;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserPropertyMapper {
    @Select("select * from userproperty where user_id = #{id}")
    UserProperty findUserById(long id);

    @Select("select * from userproperty where user_mail = #{user_email}")
    UserProperty findUserByEmail(String user_email);

    @Insert("insert into userproperty (user_name,user_mail,user_epassword,user_state) value(#{user_name},#{user_mail},#{user_epassword},#{user_state})")
    @Options(useGeneratedKeys = true, keyProperty = "user_id")
    int insertUser(UserProperty userProperty);
}
