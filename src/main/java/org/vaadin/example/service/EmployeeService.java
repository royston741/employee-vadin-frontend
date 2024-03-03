package org.vaadin.example.service;

import org.apache.http.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.vaadin.example.dto.Response;
import org.vaadin.example.entity.Employee;

@Service
public class EmployeeService {

    public final String BASE_URL="http://localhost:8081/employee/";
    @Autowired
    RestTemplate restTemplate;
    public Response<Employee> addEmployee(Employee employee){
        return restTemplate
                .exchange(
                        BASE_URL+"addEmployee"
                        ,HttpMethod.POST
                        ,new HttpEntity<>(
                                employee,
                                new HttpHeaders()),
                                new ParameterizedTypeReference<Response<Employee>>() {})
                .getBody();
    }
}
