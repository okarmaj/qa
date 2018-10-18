package pl.jsystems.qa.qaapi.dbservice;

import pl.jsystems.qa.qaapi.model.UserDBTest;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public static UserDBTest getOneById(int id) {

        String sql = "select * from usertest where id =" + id;
        UserDBTest userDBTest = new UserDBTest();

        Statement statement = null;
        try {
            statement = DatabaseConnector.getConnection().createStatement();
            ResultSet wynik = statement.executeQuery(sql);
            while
            (wynik.next()) {
                userDBTest.setId(wynik.getInt(1));
                userDBTest.setName(wynik.getString(2));
                userDBTest.setSurname((wynik.getString(3)));
            }
            wynik.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userDBTest;
    }

    public static List<UserDBTest> getAll() {
        List<UserDBTest> testUsers = new ArrayList<UserDBTest>();
        try {
            Statement statement = DatabaseConnector.getConnection().createStatement();
            String sql = "select * from usertest";
            ResultSet wynik = statement.executeQuery(sql);
//            testUsers = ladujDane(wynik);
            while (wynik.next()) {
                UserDBTest testUser = new UserDBTest();
                testUser.setId(wynik.getInt(1));
                testUser.setName(wynik.getString(2));
                testUser.setSurname(wynik.getString(3));
                testUsers.add(testUser);
            }
            wynik.close();
            statement.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return testUsers;
    }

    public static void saveOne(UserDBTest testUser) {
        String sql = "insert into testUsers (id, name, surname) values (" + testUser.getId() + ", '" + testUser.getName() + "', '" + testUser.getSurname() + "')";
        try {
            DatabaseConnector.getConnection().createStatement().executeUpdate(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void update(UserDBTest testUser, int id) {
        String sql = "update usertest set id = " + testUser.getId() + ", name = "
                + testUser.getName() + ", surname = " + testUser.getSurname() + " where id = " + id;
        try {
            DatabaseConnector.getConnection().createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(int id) {
        String sql = "delete usertest where id = " + id;
        try {
            DatabaseConnector.getConnection().createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}