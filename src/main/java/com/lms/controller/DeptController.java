package com.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lms.dao.DepartmentRepository;
import com.lms.entity.Department;
import com.lms.helper.Message;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class DeptController {
    //add-department
    @Autowired
    private DepartmentRepository departmentRepository;

    @RequestMapping(value = "/add-department", method=RequestMethod.GET)
    public String add_department(Model model) {
        model.addAttribute("title", "AddDepartment -  LMS");
        model.addAttribute("department", new Department());
        return "addDepartment";
    }
    @RequestMapping(value = "/save_department",method = RequestMethod.POST)
    public String saveBook(@Valid @ModelAttribute("department") Department department, BindingResult res, Model model,HttpSession session)  {

        try{
            if(res.hasErrors()){
                model.addAttribute("department", department);
                return "addDepartment";
            }
            Department existDept = departmentRepository.findByName(department.getName());
            if(existDept != null){
                throw new Exception("Department is alreday registered!");
            }
           Department result = this.departmentRepository.save(department);
           model.addAttribute("department", new Department());
           session.setAttribute("message", new Message("Successfullly Saved!!","alert-success"));
           return "addDepartment";
        }catch(Exception e){
           e.printStackTrace();
           model.addAttribute("department", department);
           session.setAttribute("message",new Message(e.getMessage(), "alert-danger"));
           return "addDepartment";
        }

    }
    
    
}
