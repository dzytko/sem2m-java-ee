package com.example.lab4.Worker;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class WorkerDao {
    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public int save(Worker worker) {
        String sqlQuerry = "insert into worker (lastName,salary,companyName) "
                + "values('" + worker.getLastName() + "','" + worker.getSalary() + "','" + worker.getCompanyName() + "')";
        return template.update(sqlQuerry);
    }

    public List<Worker> getAll() {
        return template.query(
                "select * from worker",
                (resultSet, row) -> {
                    var worker = new Worker();
                    worker.setId(resultSet.getInt(1));
                    worker.setLastName(resultSet.getString(2));
                    worker.setSalary(resultSet.getFloat(3));
                    worker.setCompanyName(resultSet.getString(4));
                    return worker;
                }
        );
    }

    public void deleteById(int workerId) {
        String sqlQuery = "DELETE FROM worker WHERE id = ?";
        template.update(sqlQuery, workerId);
    }
}