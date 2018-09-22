package com.example.dbproj;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.stream.IntStream;

@RestController
@AllArgsConstructor
public class MyController {
    MyService myService;
    DataSource dataSource;

    @GetMapping(path = "/hello")
    public String hello() {
        System.out.println(myService.getChildren());

        return "";
    }

    @GetMapping(path = "/create")
    public String create(@RequestParam(name = "t") String table) throws SQLException {
        long t0 = System.currentTimeMillis();
        insertBatch(table);
        System.out.println(((System.currentTimeMillis() - t0) / 1000.0));
        return "Done";
    }

    private void insert(String table) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("insert " + table + "(i) values (?)");

        IntStream.range(0, 100000).forEach(v -> {
            try {
                statement.setInt(1, v);
                statement.execute();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    private void insertBatch(String table) throws SQLException {
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        IntStream.range(0, 100000).forEach(v -> {
            try {
                statement.addBatch("insert " + table + "(i) values (" + v +")");


                if (v % 10000 == 0) {
                    statement.executeBatch();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

}
