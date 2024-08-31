package UserMicroServicePkg.Controller;


import UserMicroServicePkg.Entity.Department;
import UserMicroServicePkg.Entity.User;
import UserMicroServicePkg.ResponseTemplate.ResponseTemplate;
import UserMicroServicePkg.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    public UserService service;

    @Autowired
    public RestTemplate restTemplate;

    @PostMapping("/")
    public ResponseEntity saveUser(@RequestBody User user){
//        Optional<User> userResp = service.saveUser(user);
//
//        return userResp
//                .map(u -> new ResponseEntity(u, HttpStatus.CREATED))
//                .orElseGet(() -> new ResponseEntity(Map.of("Error", "User with payload is not saved"), HttpStatus.BAD_REQUEST));
        log.info("Inside saveUser of UserController");
        return new ResponseEntity(service.saveUser(user), HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ResponseTemplate> getUserById(@PathVariable(value = "id") UUID userid){
        log.info("Inside getUserById of UserController");
        Optional<User> user = service.getUserById(userid);

        ResponseTemplate responseTemplate = new ResponseTemplate();

        responseTemplate.setUser(user.get());

        Department department = restTemplate
                .getForObject("http://localhost:8201/dept/"+user.get().getDepartmentId(), Department.class);

        responseTemplate.setDepartment(department);

        HttpHeaders customHeaders = new HttpHeaders();
        customHeaders.add("cust-controller-header","cust-controller-header-resp");

        return new ResponseEntity<>(responseTemplate, customHeaders, HttpStatus.OK);
    }
}
