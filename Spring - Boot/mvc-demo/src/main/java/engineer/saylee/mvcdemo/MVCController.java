package engineer.saylee.mvcdemo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

@Controller
public class MVCController {
    @RequestMapping("/")
    public String index(){
        return "Home";
    }

    @RequestMapping("/Dynamic")
    public String dynamic(Model model){
        int a = 10;
        model.addAttribute("var",10);
        return "Dynamic";
    }

    @RequestMapping("/add")
    public String add(){
        return "add";
    }
    @RequestMapping("/sub")
    public String sub(){
        return "sub";
    }

    @RequestMapping("/result")
    public String result(Model model,HttpServletRequest req){
        int num1 = Integer.parseInt(req.getParameter("num1"));
        int num2 = Integer.parseInt(req.getParameter("num2"));

        int res = num1 + num2;
        model.addAttribute("res", res);
        return "result";
    }
    @RequestMapping("/subresult")
    public String subresult(Model model,HttpServletRequest req){
        int num1 = Integer.parseInt(req.getParameter("num1"));
        int num2 = Integer.parseInt(req.getParameter("num2"));

        int res = num1 - num2;
        model.addAttribute("res", res);
        return "subresult";
    }

}
