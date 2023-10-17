package com.example.demo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BD {
    public BD() {
    }

    public static String select_brand(String brand) throws ClassNotFoundException, SQLException {

        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/cellphones";
        String username = "root";
        String password = "";

        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, username, password);

        String consultaSQL = "SELECT * FROM brand WHERE brand = ?";

        PreparedStatement statement = connection.prepareStatement(consultaSQL);
        statement.setString(1, brand);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            brand = resultSet.getString("brand");
            return brand;

        }
        // Cerrar recursos
        resultSet.close();
        statement.close();
        connection.close();
        return "";
    }

    public static Cellphone Select_cellphone(String code) throws ClassNotFoundException, SQLException {

        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/cellphones";
        String username = "root";
        String password = "";

        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, username, password);

        String consult_SQL = "SELECT * FROM cellphone WHERE code = ?";

        PreparedStatement statement = connection.prepareStatement(consult_SQL);
        statement.setString(1, code); // Establecer el valor del parámetro

        // Ejecutar la consulta
        ResultSet resultSet2 = statement.executeQuery();

        // Procesar el resultado si existe
        if (resultSet2.next()) {

            code = resultSet2.getString("code");
            String brand = resultSet2.getString("brand");
            String name = resultSet2.getString("name");
            String ram = resultSet2.getString("ram");
            String storage = resultSet2.getString("storage");
            String color = resultSet2.getString("color");

            return new Cellphone(code, brand, name, ram, storage, color);

        }
        // Cerrar recursos
        resultSet2.close();
        statement.close();
        connection.close();

        return new Cellphone(null,null,null,null,null, null);
    }

    public static int Delete(String code) throws ClassNotFoundException, SQLException {

        String driver2 = "com.mysql.cj.jdbc.Driver";
        String url2 = "jdbc:mysql://localhost:3306/cellphones";
        String username2 = "root";
        String pass2 = "";

        Class.forName(driver2);
        Connection connection2 = DriverManager.getConnection(url2, username2, pass2);

        String sentenciaSQL = "DELETE FROM cellphone WHERE code = ?";
        PreparedStatement prepareStatement = connection2.prepareStatement(sentenciaSQL);
        prepareStatement.setString(1, code);
        int f = prepareStatement.executeUpdate();

        if (f > 0){
            return 1;
        }else {
            return 0;
        }
    }

    public Cellphone register(String code, String brand, String name, String ram, String storage, String color) {

        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/cellphones";
        String username = "root";
        String password = "";

        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM cellphone");

            // Sentencia INSERT
            String sql = "INSERT INTO cellphone (code , brand, name, ram, storage, color) VALUES (?, ?, ?, ?, ?, ?)";

            // Preparar la sentencia
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, code);
            preparedStatement.setString(2, brand);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, ram);
            preparedStatement.setString(5, storage);
            preparedStatement.setString(6, color);

            // Ejecutar la sentencia
            int files = preparedStatement.executeUpdate();

            if (files > 0) {
                System.out.println("Celular agregado exitosamente.");
                return new Cellphone(code, brand, name, ram, storage, color);
            } else {
                System.out.println(Errors.error_register);
            }

            preparedStatement.close();
            connection.close();
            statement.close();
            resultSet.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new Cellphone(null,null,null,null,null, null);
    }

    public Cellphone edit(String code, String brand, String name, String ram, String storage, String color) throws ClassNotFoundException, SQLException {

        String driver2 = "com.mysql.cj.jdbc.Driver";
        String url2 = "jdbc:mysql://localhost:3306/cellphones";
        String username2 = "root";
        String pass2 = "";

        Class.forName(driver2);
        Connection connection2 = DriverManager.getConnection(url2, username2, pass2);

        Statement statement2 = connection2.createStatement();
        String consulta = "UPDATE cellphone SET brand = ?, name = ?, ram = ?, storage = ?, color = ? WHERE code = ?";

        PreparedStatement preparedStatement = connection2.prepareStatement(consulta);
        preparedStatement.setString(1, brand);
        preparedStatement.setString(2, name);
        preparedStatement.setString(3, ram);
        preparedStatement.setString(4, storage);
        preparedStatement.setString(5, color);
        preparedStatement.setString(6, code);

        int filasActualizadas = preparedStatement.executeUpdate();
        if (filasActualizadas > 0) {
            System.out.println("Celular actualizado exitosamente");
            return new Cellphone(code, brand, name, ram, storage, color);
        } else {
            System.out.println(Errors.error_edit);
        }

        preparedStatement.close();
        connection2.close();
        return new Cellphone(null,null,null,null,null, null);
    }

    public List<Cellphone> search() throws ClassNotFoundException, SQLException {

        String driver2 = "com.mysql.cj.jdbc.Driver";
        String url2 = "jdbc:mysql://localhost:3306/cellphones";
        String username2 = "root";
        String pass2 = "";

        Class.forName(driver2);
        Connection connection2 = DriverManager.getConnection(url2, username2, pass2);

        Statement statement2 = connection2.createStatement();

        ResultSet resultSet2 = statement2.executeQuery("SELECT * FROM cellphone");
        List<Cellphone> list = new ArrayList<>();

        while(resultSet2.next()){

            String code = resultSet2.getString("code");
            String brand = resultSet2.getString("brand");
            String name = resultSet2.getString("name");
            String ram = resultSet2.getString("ram");
            String storage = resultSet2.getString("storage");
            String color = resultSet2.getString("color");

            Cellphone cellphone1 = new Cellphone(code, brand, name, ram, storage, color);
            list.add(cellphone1);
        }
        return list;
    }
    }





