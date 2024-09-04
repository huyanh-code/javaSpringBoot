package kls.demo.service;

import kls.demo.dto.NewOrEditStudentDTO;
import kls.demo.dto.StudentDTO;
import kls.demo.dto.StudentDetailsDTO;
import kls.demo.ex.MyException;
import kls.demo.model.Student;
import kls.demo.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<StudentDTO> findAll(){
        List<Student> list = studentRepository.findAll();
        List<StudentDTO> results = new ArrayList<>();
        for(Student stu: list){
            StudentDTO dto = new StudentDTO();
            BeanUtils.copyProperties(stu, dto);

            results.add(dto);
        }
        return results;
    }

    public boolean delete(String id){
        Optional<Student> op = studentRepository.findById(id);
        studentRepository.delete(op.get());

        return true;
    }

    public StudentDetailsDTO findDetails(String id) {
        Optional<Student> op = studentRepository.findById(id);
        if (op.isPresent()) {
            Student stu = op.get();
            StudentDetailsDTO dto = new StudentDetailsDTO();
            BeanUtils.copyProperties(stu, dto);

            return dto;
        }
        return null;
    }

    public void addNew(NewOrEditStudentDTO dto) throws MyException{
        Optional<Student> op = studentRepository.findById(dto.getId());
        if(op.isPresent()){
            throw new MyException("ID " + dto.getId() + "Da ton tai nen khong add duoc");
        }

        Student stu = new Student();
        BeanUtils.copyProperties(dto, stu);
        stu.setCreatedAt(new Date());
        stu.setDob(this.convertDate(dto.getDateOfBirth()));

        studentRepository.save(stu);
    }

    public void update(NewOrEditStudentDTO dto) throws MyException{
        Optional<Student> op = studentRepository.findById(dto.getId());
        if(op.isEmpty()){
            throw new MyException("ID " + dto.getId() + " Khong ton tai nen khong update duoc");
        }

        Student stu = op.get();
        BeanUtils.copyProperties(dto, stu);
        stu.setUpdatedAt(new Date());
        stu.setDob(this.convertDate(dto.getDateOfBirth()));
    }

    private Date convertDate(String dateOfBirth){
        try{
            return new SimpleDateFormat("dd/MM/yyyy").parse(dateOfBirth);
        }catch (ParseException e){
            return null;
        }
    }
}
