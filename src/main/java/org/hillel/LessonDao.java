package org.hillel;

import org.hillel.school.Homework;
import org.hillel.school.Lesson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LessonDao {
    private final DataBaseConnection dbConnection;

    public LessonDao(DataBaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public void addLesson(Lesson lesson) throws SQLException {
        String query = "INSERT INTO lesson (ls_name, homework_id) VALUES (?, ?)";
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, lesson.getName());
            statement.setInt(2, lesson.getHomework().getId());
            statement.executeUpdate();
        }
    }

    public void removeLesson(int lessonId) throws SQLException {
        String query = "DELETE FROM lesson WHERE id = ?";
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, lessonId);
            statement.executeUpdate();
        }
    }

    public List<Lesson> getAllLessons() throws SQLException {
        List<Lesson> lessons = new ArrayList<>();
        String query = "SELECT lesson.id, lesson.ls_name, homework.id, homework.name, homework.description " +
                "FROM lesson INNER JOIN homework ON lesson.homework_id = homework.id";
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int lessonId = resultSet.getInt(1);
                String lessonName = resultSet.getString(2);
                int homeworkId = resultSet.getInt(3);
                String homeworkName = resultSet.getString(4);
                String homeworkDescription = resultSet.getString(5);
                Homework homework = new Homework(homeworkId, homeworkName, homeworkDescription);
                Lesson lesson = new Lesson(lessonId, lessonName, homework);
                lessons.add(lesson);
            }
        }
        return lessons;
    }
}