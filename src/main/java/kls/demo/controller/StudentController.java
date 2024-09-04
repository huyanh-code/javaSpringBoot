package kls.demo.controller;

import jakarta.validation.Valid;
import kls.demo.dto.NewOrEditStudentDTO;
import kls.demo.dto.StudentDTO;
import kls.demo.dto.StudentDetailsDTO;
import kls.demo.ex.MyException;
import kls.demo.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public String goHome(Model model) {
        model.addAttribute("sinhViens", studentService.findAll());
        return "index";
    }

    @GetMapping("/delete")
    public String xoa(@RequestParam(name = "id") String id) {
        studentService.delete(id);

        // addnew/update/delete xong thi quay ve index de hien all, nhung phai quay ve = method goHome() ben tren
        return "redirect:/students";
    }

    @GetMapping("/chuanbiedit")
    public String chuanBiEdit(@RequestParam(name = "id") String id, Model model) {
        StudentDetailsDTO stu = studentService.findDetails(id);

        NewOrEditStudentDTO newOrEditStudentDto = new NewOrEditStudentDTO();
        BeanUtils.copyProperties(stu, newOrEditStudentDto);
        newOrEditStudentDto.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").format(stu.getDob()));

        model.addAttribute("studentForNewOrUpdate", newOrEditStudentDto);

        return "edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("studentForNewOrUpdate") @Valid NewOrEditStudentDTO newOrEditStudentDto,
                         BindingResult rs,
                         Model model) {
        if (rs.hasErrors()) {
            return "edit";
        }

        try {
            studentService.update(newOrEditStudentDto);
        } catch (MyException e) {
            model.addAttribute("msg", e.getMessage());
            return "edit";
        }

        // addnew/update/delete xong thi quay ve index de hien all, nhung phai quay ve = method goHome() ben tren
        return "redirect:/students";
    }

    @GetMapping("/chuanbinew")
    public String chuanBiNew(Model model) {
        model.addAttribute("studentForNewOrUpdate", new NewOrEditStudentDTO());

        return "new";
    }

    @PostMapping("/addnew")
    public String addnew(@ModelAttribute("studentForNewOrUpdate") @Valid NewOrEditStudentDTO newOrEditStudentDto,
                         BindingResult rs,
                         Model model) {
        if (rs.hasErrors()) {
            return "new";
        }

        try {
            studentService.addNew(newOrEditStudentDto);
        } catch (MyException e) {
            model.addAttribute("msg", e.getMessage());
            return "new";
        }

        // addnew/update/delete xong thi quay ve index de hien all, nhung phai quay ve = method goHome() ben tren
        return "redirect:/students";
    }
}
