package kls.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class StudentDTO {
    private String id;
    private String name;
    private Date dob;
    private float tuition;
    private String clazz;
}
