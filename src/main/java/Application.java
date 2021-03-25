import service.StudentService;

import java.util.List;
import java.util.stream.Collectors;

public class Application {
    private StudentService studentService;

    public Application (StudentService studentService) {
        this.studentService = studentService;
    }

    List<String> findAllStudentNames() {
        var students = studentService.findAll();
        return students.stream().map(item -> StringUtils.capitalize(item.getName())).collect(Collectors.toList());
    }

    List<String> findAllStudentNames(String str) {
        var students = studentService.findAll(str);
        return students.stream().map(item -> StringUtils.capitalize(item.getName())).collect(Collectors.toList());
    }

    String getStudent(String id) {
        if(studentService.getStudent(id) == null) {
            return null;
        }
        return StringUtils.capitalize(studentService.getStudent(id).getName());
    }
}
