package bitlab.techorda.g1.studentgrades.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Student {
    private Long id;
    private String name;
    private String surname;
    private int exam;
    private String mark;
}
