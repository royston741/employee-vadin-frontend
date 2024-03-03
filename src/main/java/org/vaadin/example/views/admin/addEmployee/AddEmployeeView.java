package org.vaadin.example.views.admin.addEmployee;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.example.constants.Role;
import org.vaadin.example.dto.Response;
import org.vaadin.example.entity.Employee;
import org.vaadin.example.service.EmployeeService;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.stream.Collectors;

@SpringComponent
@Route("/addEmployee")
public class AddEmployeeView extends VerticalLayout {

    @Autowired
    EmployeeService employeeService;
    private FormLayout addEmployeeForm = new FormLayout();
    private TextField firstName = new TextField("First name");
    private TextField lastName = new TextField("Last name");
    private EmailField email = new EmailField("Email");
    private TextField phoneNo = new TextField("Phone no");
    private PasswordField password = new PasswordField("Password");
    private ComboBox<Role> role = new ComboBox<>("Role");
    private Button submitBtn = new Button("Submit");

    Employee employee = new Employee();
    Binder<Employee> binder = new BeanValidationBinder<>(Employee.class);

    @PostConstruct
    public void build() {
        binder.bindInstanceFields(this);
        initializeForm();
        add(addEmployeeForm);
    }

    public void initializeForm() {
        role.setItems(Arrays.stream(Role.values()).collect(Collectors.toList()));
        binder
                .forField(phoneNo)
                .withValidator(value -> value.length() == 10, "phone no should consist of 10 digits")
                .withValidator(value -> value.matches("^[0-9]*$"), "Enter valid phone number")
                .bind(Employee::getPhoneNo, Employee::setPhoneNo);
        initializeSubmitBtn();
        addEmployeeForm.add(firstName, lastName, email, phoneNo, password, role, submitBtn);
        addEmployeeForm.setColspan(submitBtn, 2);
    }

    public void initializeSubmitBtn() {
        submitBtn.addClickListener(onSubmitClick());
        submitBtn.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
    }

    private ComponentEventListener<ClickEvent<Button>> onSubmitClick() {
        return clickEvent -> {
//            errMessageList.forEach(err -> errMessages.remove(err));
            try {
                binder.writeBean(employee);
                System.out.println(employee);
                Response<Employee> resposne = employeeService.addEmployee(employee);
                System.out.println("REsult");
                System.out.println(employee);
            } catch (Exception e) {
                if (e instanceof ValidationException) {
                    Notification.show("Employee not registered");
//                } else if (e instanceof ErrorResponseException errorResponse) {
//                    log.info(errorResponse.getResponse().getErrMssg().toString());
//                } else {
//                    errMessages.add(new Paragraph("User Registration Failed"));
//                    log.error("Error in onLogInBtnClick {}", e);
                }
            }
        };
    }
}
