package club.banyuan.project1.admin.dao;

import club.banyuan.project1.admin.entity.Admin;
import club.banyuan.project1.admin.entity.AdminVo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdminDao {

    @Select("select * from ums_admin where username=#{name}")
    @Results(id = ("adminMap"), value = {
            @Result(id = true,column ="id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(column = "email",property = "email"),
            @Result(column = "icon",property = "icon"),
            @Result(column = "note",property = "note"),
            @Result(column = "status",property = "status"),
            @Result(column = "nick_name",property = "nickName"),
            @Result(column = "create_time",property = "createTime"),
            @Result(column = "login_time",property = "loginTime"),
    })
    List<Admin> getAdminByName(String name);

    @Insert("insert into ums_admin(username,password,email,nick_name,note,status,icon,create_time,login_time) values" +
            " (#{username},#{password},#{email},#{nickName},#{note},#{status},#{icon},#{createTime},#{loginTime})")
    void addAdmin(AdminVo adminVo);

    @Update("update ums_admin set username=#{adminVo.username},password=#{adminVo.password},email=#{adminVo.email}," +
            "nick_name=#{adminVo.nickName},status=#{adminVo.status},note=#{adminVo.note} where id=#{id}")
    void updateAdmin(@Param("id")long id,@Param("adminVo") AdminVo adminVo);

    @Delete("delete from ums_admin where id=#{id}")
    void deleteAdmin(Long id);
    void deleteAdminByIds(List<Integer> adminList);

    @Select("select id,username,password,icon,email,nick_name as nickName,note,login_time as loginTime,create_time as createTime,status from ums_admin")
    @ResultMap("adminMap")
    List<Admin> getAdminList();

    @Select("select id,username,password,icon,email,nick_name as nickName,note,login_time as loginTime,create_time as createTime,status from ums_admin")
    List<AdminVo> getAdminVoList();
    List<Admin> getAdminListByName(String username);

    @Select("select * from ums_admin where username=#{keyword} or nick_name=#{keyword}")
    AdminVo getAdminByUsernameOrNickname(String keyword);

    @Select("select * from ums_admin where username=#{username} and password=#{password}")
    Admin getAdmin(Admin admin);
    Admin getAdminById(int id);

    List<Admin> getAdminListPage(int page,int row);

    @Select("select count(*) from ums_admin")
    int getAdminListPageCount();


}
