import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    @Test
    public void ReturnsFalseWhenQueryNotInSubtasks() {
        Epic epic = new Epic(1, new String[]{"Subtask 1", "Subtask 2", "Subtask 3"});
        String query = "Subtask 4";
        boolean expected = false;
        boolean actual = epic.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ReturnsTrueWhenQueryInSubtasks() {
        String[] subtasks = {"Subtask 1", "Subtask 2", "Subtask 3"};
        Epic epic = new Epic(1, subtasks);
        String query = "Subtask 1";
        boolean expected = true;
        boolean actual = epic.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ReturnsTrueWhenQueryInTitle() {
        SimpleTask task = new SimpleTask(1, "task");
        String query = "task";
        boolean expected = true;
        boolean actual = task.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ReturnsFalseWhenQueryNotInTitle() {
        SimpleTask task = new SimpleTask(1, "task");
        String query = "one";
        boolean expected = false;
        boolean actual = task.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ReturnsTrueWhenQueryInTopic() {
        Meeting meeting = new Meeting(1, "Main topic", "A project", "2023-07-15T10:00:00Z");
        String query = "topic";
        boolean expected = true;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ReturnsTrueWhenQueryInProject() {
        Meeting meeting = new Meeting(1, "Main topic", "A project", "2023-07-15T10:00:00Z");
        String query = "project";
        boolean expected = true;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ReturnsFalseWhenQueryNotInTopicOrProject() {
        Meeting meeting = new Meeting(1, "Main topic", "A project", "2023-07-15T10:00:00Z");
        String query = "one";
        boolean expected = false;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }


}