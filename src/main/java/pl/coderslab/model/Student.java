package pl.coderslab.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class Student {

    private String firstName;

    private String lastName;

    private String gender;

    private String country;

    private String notes;

    private boolean mailingList;

    private List<String> programmingSkills;

    private List<String> hobbies;


}
