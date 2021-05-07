package com.ragu.app.contoller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ragu.app.dto.EmployeeDTO;
import com.ragu.app.entity.Address;
import com.ragu.app.entity.Employee;
import com.ragu.app.service.IEntityService;

@Controller
@RequestMapping("/v1")
public class EmployeeController {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	@Qualifier("addressService")
	private IEntityService<Address> addressService;

	@Autowired
	@Qualifier("employeeService")
	private IEntityService<Employee> employeeService;
	
	@Autowired
	@Qualifier("employeeValidator")
	private Validator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(this.validator);
	}

	@GetMapping("/employees")
	public String listEmployees(Model model) throws Exception {
		try {
			List<Employee> employeeList = this.employeeService.findAll();
			List<EmployeeDTO> employees = this.convertEntityToDTO(employeeList);
			model.addAttribute("employees", employees);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return "list-employees";
	}

	@GetMapping("/employees/{employeeId}")
	public String showFormForAdd(@PathVariable("employeeId") int id, Model model) throws Exception {
		try {
			Employee emp = this.employeeService.findOne(id);
			List<Employee> empList = new ArrayList<Employee>();
			empList.add(emp);
			List<EmployeeDTO> employees = this.convertEntityToDTO(empList);
			model.addAttribute("employeeDTO", employees.get(0));
		} catch (Exception e) {
			throw new Exception(e);
		}
		return "employee-form";
	}

	@GetMapping("/employees/new")
	public String showFormForAdd(Model model) {
		try {
			EmployeeDTO employee = new EmployeeDTO();
			model.addAttribute("employeeDTO", employee);
		} catch (Exception e) {
			throw e;
		}
		return "employee-form";
	}

	@PostMapping("/employees")
	public String saveEmployee(@ModelAttribute("employeeDTO") @Validated EmployeeDTO employeeDTO, BindingResult result, Model model) {
		try {
			if (result.hasErrors()) {
				return  "employee-form";
			}
			Address address = this.mapper.map(employeeDTO, Address.class);
			addressService.save(address);
		} catch (Exception e) {
			throw e;
		}
		return "redirect:/v1/employees";
	}

	@GetMapping("/employees/{employeeId}/update")
	public String showFormForUpdate(@PathVariable("employeeId") int id, Model model) throws Exception {
		try {
			Employee employee = employeeService.findOne(id);
			List<Employee> empList = new ArrayList<Employee>();
			empList.add(employee);
			List<EmployeeDTO> employees = this.convertEntityToDTO(empList);
			model.addAttribute("employeeDTO", employees.get(0));
			employeeService.delete(id);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return "employee-form";
	}

	@GetMapping("/employees/{employeeId}/delete")
	public String deleteEmployee(@PathVariable("employeeId") int id) {
		try {
			employeeService.delete(id);
		} catch (Exception e) {

		}
		return "redirect:/v1/employees";
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception e) {
		ModelAndView model = new ModelAndView();
		model.addObject("exception", e);
		model.setViewName("error");
		return model;
	}

	private List<EmployeeDTO> convertEntityToDTO(List<Employee> employeeList) throws Exception{
		List<EmployeeDTO> employees = new ArrayList<EmployeeDTO>();
		employeeList.forEach(emp -> {
			Address address = this.addressService.findOne(emp.getId());
			EmployeeDTO empDto = new EmployeeDTO();
			empDto.setId(emp.getId());
			empDto.setFirstName(emp.getFirstName());
			empDto.setLastName(emp.getLastName());
			empDto.setEmail(emp.getEmail());
			empDto.setDoorNumber(address.getDoorNumber());
			empDto.setStreet(address.getStreet());
			empDto.setState(address.getState());
			empDto.setCountry(address.getCountry());
			empDto.setZipCode(String.valueOf(address.getZipCode()));
			employees.add(empDto);
		});
		return employees;
	}
}
