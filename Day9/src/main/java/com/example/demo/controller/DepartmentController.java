package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Department;
import com.example.demo.service.DepartmentService;

@RestController
@RequestMapping("/dept")
public class DepartmentController {

	@Autowired
	private DepartmentService service;
	
	@GetMapping
	public ResponseEntity<List<Department>> getDepts(){
		return new ResponseEntity<>(service.getDepts(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Department> getDept(@PathVariable int id) {
		Department dept = service.getDept(id);
		
		if(dept == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		return new ResponseEntity<>(dept, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Department> addDept(@RequestBody Department department ) {
		return new ResponseEntity<>(service.addDept(department), HttpStatus.CREATED);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Department> updateDept(@PathVariable int id ,@RequestBody Department department) {
		Department updated = service.updateDept(id,department);
		if (updated == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
		 return new ResponseEntity<>(updated, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDept(@PathVariable int id) {
        boolean deleted = service.deleteDept(id);
        if (!deleted) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	
	
	
}
