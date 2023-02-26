package org.example;
import java.sql.*;
/*
1.Создать таблицу с данными студентов группы.
Создать Java приложение для получения списка всех
студентов группы.

2.Улучшить основное задание. Создать таблицу с городами,
где живут студенты. Вывести информацию о каждом студенте группы
и его родном городе. Предусмотреть операции добавления новых городов,
новых студентов, удаления студентов и удаления городов.
*/

public class Main {
    public static void main(String[] args) throws SQLException {
    MySQLDriverManager driverManager = MySQLDriverManager.getInstance();
    Connection connection = driverManager.getConnection();
    Statement statement = null;
    ResultSet resultSet = null;
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from students");
            while (resultSet.next()) {
                System.out.print("["+resultSet.getInt("id")+"|");
                System.out.print(resultSet.getString("name")+"]"+"\n");
            }
        }
        catch (Exception e){
            System.out.println("Exception!!!");
        }
        finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}