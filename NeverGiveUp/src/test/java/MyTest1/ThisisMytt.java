package MyTest1;

import com.xiazhe.bean.UnQualifyApply;
import com.xiazhe.config.ApplicationIniter;
import com.xiazhe.config.SpringConfig;
import com.xiazhe.config.SpringMvcConfig;
import com.xiazhe.controller.unqualifyManger.unqualifyController;
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

    @Test
    public void Tets(){

        List<UnQualifyApply> applyList = my.getApplyList();
        System.out.println(applyList);
    }
}
