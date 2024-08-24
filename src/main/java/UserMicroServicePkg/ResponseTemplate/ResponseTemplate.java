package UserMicroServicePkg.ResponseTemplate;

import UserMicroServicePkg.Entity.Department;
import UserMicroServicePkg.Entity.User;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class ResponseTemplate {

    public User user;
    public Department department;
}
