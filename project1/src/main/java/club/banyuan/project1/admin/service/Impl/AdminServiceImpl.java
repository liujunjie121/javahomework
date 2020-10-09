package club.banyuan.project1.admin.service.Impl;

import club.banyuan.project1.admin.dao.AdminDao;
import club.banyuan.project1.admin.entity.Admin;
import club.banyuan.project1.admin.entity.AdminVo;
import club.banyuan.project1.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin login(Admin admin) {
        return adminDao.getAdmin(admin);
    }

    @Override
    public AdminVo getAdminByUsernameOrNickname(String keyword) {
        return adminDao.getAdminByUsernameOrNickname(keyword);
    }

    @Override
    public List<Admin> getAdminList(String usename) {
        return null;
    }

    @Override
    public void addAdmin(AdminVo adminVo) {
        adminDao.addAdmin(adminVo);
    }

    @Override
    public void updateAdmin(Long id, AdminVo adminVo) {
        adminDao.updateAdmin(id, adminVo);
    }

    @Override
    public void deleteAdmin(Long id) {
        adminDao.deleteAdmin(id);
    }

    @Override
    public List<Admin> getAdminList(int pageNum, int pageSize) {
        List<Admin> admins = adminDao.getAdminList();
        System.out.println(admins);
        int firstIndex = (pageNum - 1) * pageSize + 1;
        int lastIndex;
        if (admins.size() < (pageSize * pageSize)) {
            lastIndex = admins.size();
        } else {
            lastIndex = pageNum * pageSize;
        }
//        lastIndex=pageNum*pageSize;
        return admins.subList(firstIndex, lastIndex);
    }

    @Override
    public List<AdminVo> getAdminVoList(int pageNum, int pageSize, String keyword) {
        List<AdminVo> admins = adminDao.getAdminVoList();
        List<AdminVo> admins1 = new ArrayList<>();

        int firstIndex = (pageNum - 1) * pageSize;
        int lastIndex;
        if(keyword == null || keyword.trim().length() == 0){
//        if (keyword.equals("") || keyword.equals(null)) {
            for (AdminVo admin : admins) {
                admins1.add(admin);
            }
        } else {
            Pattern pattern = Pattern.compile(keyword);
            for (int i = 0; i < admins.size(); i++) {
                Matcher matcher1 = pattern.matcher(((AdminVo) admins.get(i)).getNickName());
                Matcher matcher2 = pattern.matcher(((AdminVo) admins.get(i)).getUsername());
                if (matcher1.find()) {
                    admins1.add(admins.get(i));
                }else if (matcher2.find()){
                    admins1.add(admins.get(i));
                }
            }
        }
        if (admins1.size() < pageSize * pageNum) {
            lastIndex = admins1.size();
        } else {
            lastIndex = pageSize * pageNum;
        }
        return admins1.subList(firstIndex,lastIndex);
    }


    @Override
    public int getAdminListCount() {
        return adminDao.getAdminListPageCount();
    }
}
