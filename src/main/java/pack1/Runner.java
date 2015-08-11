package pack1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pack1.model.User;
import pack1.service.MockUserService;

import java.util.List;


/**
 * Created by Mihai7
 */
public class Runner {

    public static void main(String[] args) {
        ApplicationContext context =
         new ClassPathXmlApplicationContext("spring/spring-context.xml");

        MockUserService mockUSerService  =
                context.getBean("mockUserService", MockUserService.class);

        List<User> allUsers= mockUSerService.findAllUsers();
        System.out.println(allUsers);

    }
}
