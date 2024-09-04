package kls.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class StudentDetailsDTO {
    private String id;
    private String name;
    private Date dob;
    private float tienHocPhi;
    private String clazz;
    private Date createdAt;
    private Date updatedAt;
}
