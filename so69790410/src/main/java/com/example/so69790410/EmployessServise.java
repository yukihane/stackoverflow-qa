package com.example.so69790410;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployessServise {
@Autowired
private EmplployeesRepository repo;

@Autowired
private ModelMapper modelMapper;

public EmployessServise() {
}

public List<Employees_DTO> getAll_Emp(){
   return repo.findAll()
           .stream()
           .map(this::convertEntityToDto)
           .collect(Collectors.toList());
}

private Employees_DTO convertEntityToDto(TblEmployees tblEmployees){
   modelMapper.getConfiguration()
           .setMatchingStrategy(MatchingStrategies.LOOSE);
   Employees_DTO employees_dto=new Employees_DTO();
   employees_dto=modelMapper.map(tblEmployees,Employees_DTO.class);
   return employees_dto;
}

private TblEmployees convertEntityToDto(Employees_DTO employees_dto){
   modelMapper.getConfiguration()
           .setMatchingStrategy(MatchingStrategies.LOOSE);
   TblEmployees tblEmployees=new TblEmployees();
   tblEmployees=modelMapper.map(employees_dto,TblEmployees.class);
   return tblEmployees;
}
 }