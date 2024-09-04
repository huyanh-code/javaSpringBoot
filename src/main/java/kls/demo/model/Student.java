package kls.demo.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name ="T_STUDENTS")
@Getter
@Setter
public class Student {
    @Id
    @Column(name = "roll_no")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "date_of_birth")
    private Date dob;

    @Column(name = "tuition")
    private float tuition;

    @Column(name = "class_name")
    private String clazz;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;
}
