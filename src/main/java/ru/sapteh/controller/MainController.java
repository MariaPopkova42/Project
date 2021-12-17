package ru.sapteh.controller;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.model.Student;
import ru.sapteh.service.StudentService;


public class MainController {

    ObservableList<Student> students = FXCollections.observableArrayList();

    private final StudentService studentService;

    public TableView<Student> userTableView;

    public TableColumn<Student,Integer> idColumn;

    public TableColumn<Student,String> firstNameColumn;

    public TableColumn<Student,String> lastNameColumn;

    public TableColumn<Student,Integer> ageColumn;

    public TextField searchTxt;

    public Button searchButton;

    public Label countLbl;

    public MainController() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        this.studentService = new StudentService(factory);
    }

    public void initialize() {
        students.addAll(studentService.findAll());

        idColumn.setCellValueFactory(u -> new SimpleObjectProperty<>(u.getValue().getId()));
        firstNameColumn.setCellValueFactory(u -> new SimpleObjectProperty<>(u.getValue().getFirst_name()));
        lastNameColumn.setCellValueFactory(u -> new SimpleObjectProperty<>(u.getValue().getLast_name()));
        ageColumn.setCellValueFactory(u -> new SimpleObjectProperty<>(u.getValue().getAge()));
        userTableView.setItems(students);

    }

    public void saveUserButton(ActionEvent actionEvent) {
    }

    public void deleteUserButton(ActionEvent actionEvent) {
    }

    public void updateUserButton(ActionEvent actionEvent) {
    }
}