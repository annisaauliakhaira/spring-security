package tugas.com.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tugas.com.security.details.RegisterServiceImpl;
import tugas.com.security.dto.RegisterDto;
import tugas.com.security.models.Employee;
import tugas.com.security.repositories.EmployeeRepository;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RegisterServiceImpl registerService;

    @PostMapping("/register")
    public RegisterDto register(@RequestBody RegisterDto registerDto){
        return registerService.saveRegister(registerDto);
    }

    @GetMapping("/findall")
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

}
