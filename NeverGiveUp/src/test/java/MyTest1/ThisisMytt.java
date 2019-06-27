package MyTest1;

import com.github.pagehelper.PageHelper;
import com.xiazhe.bean.Department;
import com.xiazhe.bean.UnQualifyApply;
import com.xiazhe.config.ApplicationIniter;
import com.xiazhe.config.SpringConfig;
import com.xiazhe.config.SpringMvcConfig;
import com.xiazhe.controller.unqualifyManger.unqualifyController;
import com.xiazhe.service.DepartmentService.DepartmentServiceImpl;
import com.xiazhe.service.unqulifyControllerService.UnqualifyServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class ThisisMytt {
    @Autowired
    UnqualifyServiceImpl my;
    @Autowired
 DepartmentServiceImpl my1;
    @Test
    public void Tets(){
        PageHelper pageHelper=new PageHelper();
        pageHelper.offsetPage(0,2);
        List<UnQualifyApply> applyList = my.getApplyList();
        for(UnQualifyApply c:applyList){
            System.out.println(c);
            System.out.println("------");
        }
        System.out.println(applyList);
    }
    @Test
    public void Tets11(){
        List<Department> list = my1.getList();
        System.out.println(list);
    }
}
