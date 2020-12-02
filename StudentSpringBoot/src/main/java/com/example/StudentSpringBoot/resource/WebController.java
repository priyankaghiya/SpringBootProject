package com.example.StudentSpringBoot.resource;

import com.example.StudentSpringBoot.model.Student;
import com.example.StudentSpringBoot.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value="/stdHome")
public class WebController
{
    @Autowired
    StudentRepo sr;


    @GetMapping(value="/")
    public ModelAndView getHome()
    {
        ModelAndView mod=new ModelAndView();
        mod.setViewName("index");
        return mod;

    }

    @RequestMapping(value = "/ShowAll")
    public ModelAndView show(Model model,@RequestParam("sub5")String sub)
    {
        ModelAndView mod=new ModelAndView();
        if(sub.equals("SHOW RECORDS")) {

            List<Student> stdList = sr.findAll();
            model.addAttribute("slist", stdList);
            mod.setViewName("showdata");
            mod.addObject(model);
        }
        else if(sub.equals("UPDATE RECORDS"))
        {
            mod.setViewName("updaterecord");
        }
        else if(sub.equals("DELETE RECORDS"))
        {
            mod.setViewName("deleterecord");
        }
        return mod;
    }

    @PostMapping(value="/updPass")
    public ModelAndView updatePassword(@RequestParam("tid")String id,@RequestParam("tpa")String pass)
    {
        ModelAndView mod=new ModelAndView();

        sr.changePassword(Integer.parseInt(id),"pass");
        mod.setViewName("home");
        return mod;
    }



    @PostMapping(value="/authen")
    public ModelAndView authenticate(@RequestParam("tid")String id,@RequestParam("tpa")String pa,
                                     @RequestParam("sub")String sub)
    {
        ModelAndView mod=new ModelAndView();
        if(sub.equals("REGISTER")){
            Student s1=new Student(Integer.parseInt(id),pa);
            sr.save(s1);
            System.out.println("RECORD INSERTED.......");

            mod.setViewName("index");

        }
        else if(sub.equals("LOGIN")){
            Student st=sr.findByStdIdAndStdPass(Integer.parseInt(id),pa);
            if(st==null)//unauthorized user
            {
                mod.setViewName("error");
            }
            else
            {
                mod.setViewName("home");
            }
        }

        return mod;
    }

}
