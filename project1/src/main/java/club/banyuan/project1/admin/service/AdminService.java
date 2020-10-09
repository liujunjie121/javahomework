package club.banyuan.project1.admin.service;

import club.banyuan.project1.admin.entity.Admin;
import club.banyuan.project1.admin.entity.AdminVo;

import java.util.List;

public interface AdminService {
    Admin login(Admin admin);
    AdminVo getAdminByUsernameOrNickname(String keyword);
    List<Admin> getAdminList(String username);
    void addAdmin(AdminVo adminVo);
    void updateAdmin(Long id,AdminVo adminVo);
    void deleteAdmin(Long id);
    List<Admin> getAdminList(int pageNum,int pageSize);
    List<AdminVo> getAdminVoList(int pageNum, int pageSize,String keyword);
    int getAdminListCount();
}
