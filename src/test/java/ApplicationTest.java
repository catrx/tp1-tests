import model.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import service.StudentService;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
public class ApplicationTest {

    @Mock
    StudentService studentService;


    @Test
    @DisplayName("Should retrieve student names")
    void shouldFindAllStudentNames() {
        ArrayList<Student> students = new ArrayList<>(Arrays.asList(new Student("1", "adham"),  new Student("2", "Enzo")));
        Mockito.when(studentService.findAll()).thenReturn(students);


        Application application = new Application(studentService);

        var studentNames  = application.findAllStudentNames();

        Mockito.verify(studentService).findAll();

        ArrayList<String> expected = new ArrayList<>(Arrays.asList("Adham", "Enzo"));

        assertArrayEquals(studentNames.toArray(), expected.toArray());


    }

    @Test
    @DisplayName("Should retrieve student names with name Enzo")
    void shouldFindStudentNamesByName() {
        String filter = "Enzo";
        ArrayList<Student> students = new ArrayList<>(Arrays.asList(new Student("2", "Enzo"), new Student("3", "Enzo")));
        Mockito.when(studentService.findAll(filter)).thenReturn(students);

        Application application = new Application(studentService);

        var studentNames  = application.findAllStudentNames(filter);

        Mockito.verify(studentService).findAll(filter);

        ArrayList<String> expected = new ArrayList<>(Arrays.asList("Enzo", "Enzo"));

        assertArrayEquals(studentNames.toArray(), expected.toArray());

    }

    @Test
    @DisplayName("Should retrieve student names with name Henry")
    void shouldNotFindStudentNamesByName() {
        String filter = "Henry";
        ArrayList<Student> students = new ArrayList<>();
        Mockito.when(studentService.findAll(filter)).thenReturn(students);

        Application application = new Application(studentService);

        var studentNames  = application.findAllStudentNames(filter);

        Mockito.verify(studentService).findAll(filter);

        ArrayList<String> expected = new ArrayList<>();

        assertArrayEquals(studentNames.toArray(), expected.toArray());

    }

    @Test
    @DisplayName("Should retrieve student by Id 2")
    void shouldGetStudent() {
        String id = "2";
        Student student = new Student("2", "Enzo");

        Mockito.when(studentService.getStudent(id)).thenReturn(student);

        Application application = new Application(studentService);

        var studentName = application.getStudent(id);

        var expected = "Enzo";

        Mockito.verify(studentService, Mockito.times(2)).getStudent(id);

        assertEquals(expected, studentName, "Student does not exist");

    }

    @Test
    @DisplayName("Should return null when id 4")
    void shoudNotGetStudent(){
        String id = "4";

        Mockito.when(studentService.getStudent(id)).thenReturn(null);

        Application application = new Application(studentService);

        var studentName = application.getStudent(id);

        Mockito.verify(studentService, Mockito.times(1)).getStudent(id);

        assertNull(studentName, "Student exist");
    }
}
