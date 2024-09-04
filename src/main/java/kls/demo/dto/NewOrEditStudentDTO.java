package kls.demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewOrEditStudentDTO {
    @NotNull(message = "ID is mandatory")
    private String id;

    @NotNull(message = "Name is mandatory")
    private String name;

    @NotNull(message = "Dob is mandatory")
    private String dateOfBirth;

    @Min(value = 0, message = "tuition > 0")
    private float tuition;

    @NotNull(message = "Class is mandatory")
    private String clazz;
}
