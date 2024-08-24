package UserMicroServicePkg.Entity;

import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Department {

    private UUID deptId;
    private String deptName;
    private String deptAddress;
    private Long deptZip;
}
