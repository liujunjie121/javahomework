package club.banyuan.project1;

import club.banyuan.project1.admin.dao.AdminDao;
import club.banyuan.project1.admin.entity.Admin;
import club.banyuan.project1.admin.service.AdminService;
import club.banyuan.project1.admin.service.Impl.AdminServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MallApplicationTests {

    @Autowired
    private AdminDao adminDao;
    @Autowired
    private AdminService adminService;

    @Test
    void getAdminByNameTest() {
//        Admin admin=new Admin();
//        admin=adminDao.getAdmin("liu","123");
//        System.out.println(admin);
//        Admin admin1=adminService.login("liu","123");
//        System.out.println(admin);

    }

}