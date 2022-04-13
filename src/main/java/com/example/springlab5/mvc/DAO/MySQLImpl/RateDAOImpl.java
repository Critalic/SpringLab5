package com.example.springlab5.mvc.DAO.MySQLImpl;

import com.example.springlab5.mvc.DAO.RateDAO;
import com.example.springlab5.mvc.model.Rate;
import com.example.springlab5.utils.PreparedStatementBuilder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.ResourceBundle;

@Repository
public class RateDAOImpl implements RateDAO {
    private final JdbcTemplate template;
    private final ResourceBundle resourceBundle = ResourceBundle.getBundle("mySQLCommands");

    public RateDAOImpl(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public Rate createRate(Rate rate) {
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(con -> new PreparedStatementBuilder(
                con.prepareStatement(resourceBundle.getString("create")))
                .setDouble(1, rate.getCourse())
                .setString(2, rate.getEstimatedCurrency().toString())
                .setString(3, rate.getRelativeCurrency().toString())
                .setObject(4, rate.getDate())
                .build(), keyHolder);
        return new Rate(keyHolder.getKey().intValue(), rate.getCourse(),
                rate.getEstimatedCurrency(), rate.getRelativeCurrency(), rate.getDate());
    }

    @Override
    public Collection<Rate> readRates() {
        template.queryForObject(resourceBundle.getString("selectAll"), new RowMapper<Rate>() {

            @Override
            public Rate mapRow(ResultSet rs, int rowNum) throws SQLException {
                rs.
            }
        });
    }

    @Override
    public void updateRate(Rate rateToUpdate, Rate updated) {
    }

    @Override
    public void deleteRate(Rate rateToDelete) {
    }

    @Override
    public Collection<Rate> getRatesByDate(LocalDate date) {
        return null;
    }

    @Override
    public Collection<Rate> getRatesByCurrency(LocalDate date) {
        return null;
    }
}
