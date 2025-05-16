package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Department;
import com.example.demo.model.repository.DepartmentRepo;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepo repo;
	
	public List<Department> getDepts(){
		return repo.findAll();
		
	}
	
	public Department getDept(int id) {
		return repo.findById(id).orElse(null);
	}
	
	public Department updateDept(int id , Department department) {
		if(!repo.existsById(id)) 
			return null;
		department.setId(id);
		
		return repo.save(department);
		
	}
	public boolean deleteDept(int id) {
		if(!repo.existsById(id)) return false;
		
		repo.deleteById(id);
		return true;
	}

	
}

