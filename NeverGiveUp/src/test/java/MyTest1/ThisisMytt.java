package MyTest1;


import com.github.pagehelper.PageHelper;
import com.xiazhe.bean.Department;
import com.xiazhe.bean.TechnologyPlan;
import com.xiazhe.bean.UnQualifyApply;
import com.xiazhe.config.SpringConfig;
import com.xiazhe.service.DepartmentService.DepartmentServiceImpl;
import com.xiazhe.service.EmployeeService.EmployeeService;
import com.xiazhe.service.plan.OrderServicesImpl;
import com.xiazhe.service.technologyService.TechnologyPlanService;
import com.xiazhe.service.technologyService.TechnologyRequirementService;
import com.xiazhe.service.unqulifyControllerService.UnqualifyServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class ThisisMytt {
    @Autowired
    OrderServicesImpl myservice111;
    @Autowired
    UnqualifyServiceImpl my;
    @Autowired
    DepartmentServiceImpl my1;
    @Autowired
    EmployeeService service;
    @Autowired
    TechnologyRequirementService myservice;
    @Autowired
    TechnologyPlanService technologyPlanService;
    @Test
    public void Tets() {
        PageHelper pageHelper = new PageHelper();
        pageHelper.offsetPage(0, 2);
        List<UnQualifyApply> applyList = my.getApplyList();
        for (UnQualifyApply c : applyList) {
            System.out.println(c);
            System.out.println("------");
        }

        System.out.println(applyList);
    }

    @Test
    public void Tets11() {
        List<Department> list = my1.getList();
        System.out.println(list);
    }

    @Test
    public void Tets1333() {
        ArrayList<TechnologyPlan> technologyPlans = technologyPlanService.queryAllTechnology();

        System.out.println(technologyPlans);

    }
    @Test
    public  void yyyy(){
        String[] s={"5"};
        List<UnQualifyApply> unQualifyApplies = my.serachLikeByName("椅");
        System.out.println(unQualifyApplies);
    }
    /*@Test
    public  void yyyy1111(){
        List<Order> getlist = myservice111.getlist();
        System.out.println(getlist);
    }*/
}
