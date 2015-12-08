package yaddaSpace;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Mihai7 on 12/8/2015.
 */

@Controller
public class BlogEntryController {
    @RequestMapping("/test")
    public String test()
    {
        return "view";
    }
}
