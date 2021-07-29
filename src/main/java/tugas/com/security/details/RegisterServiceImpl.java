package tugas.com.security.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import tugas.com.security.dto.RegisterDto;
import tugas.com.security.models.Department;
import tugas.com.security.models.Employee;
import tugas.com.security.models.User;
import tugas.com.security.repositories.EmployeeRepository;
import tugas.com.security.repositories.RoleRepository;
import tugas.com.security.repositories.UserRepository;
import tugas.com.security.services.UserService;

@Service
public class RegisterServiceImpl{
    private EmployeeRepository employeeRepository;

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public RegisterServiceImpl(EmployeeRepository employeeRepository, UserRepository userRepository, RoleRepository roleRepository) {
        this.employeeRepository = employeeRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public RegisterDto saveRegister(RegisterDto registerDto) {
//        System.out.println(registerDto.toString());
        Employee employee = new Employee();
        employee.setFirstName(registerDto.getFirstName());
        employee.setLastName(registerDto.getLastName());
        employee.setAddress(registerDto.getAddress());
        employee.setEmail(registerDto.getEmail());
        employee.setDepartment(new Department(registerDto.getDepartment_id()));

        User user = new User();
        user.setUsername(registerDto.getUsername());
        user.setPassword(registerDto.getPassword());
        user.setEmployee(employeeRepository.save(employee));
        userRepository.save(user);

        return registerDto;
    }

}
