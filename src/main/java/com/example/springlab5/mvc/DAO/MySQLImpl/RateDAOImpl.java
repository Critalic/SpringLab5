package com.example.springlab5.mvc.DAO.MySQLImpl;

import com.example.springlab5.mvc.DAO.RateDAO;
import com.example.springlab5.mvc.model.Rate;
import com.example.springlab5.mvc.model.RateForRequest;
import com.example.springlab5.utils.PreparedStatementBuilder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Statement;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Currency;
import java.util.ResourceBundle;

@Repository
public class RateDAOImpl implements RateDAO {
    private final JdbcTemplate template;
    private final ResourceBundle resourceBundle = ResourceBundle.getBundle("mySQLCommands");

    public RateDAOImpl(JdbcTemplate template) {
        this.template = template;
    }
//TODO: exceptions
    @Override
    public Rate createRate(Rate rate) {
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(con -> new PreparedStatementBuilder(
                con.prepareStatement(resourceBundle.getString("create"), Statement.RETURN_GENERATED_KEYS))
                .setDouble(1, rate.getCourse())
                .setString(2, rate.getEstimatedCurrency().toString())
                .setString(3, rate.getRelativeCurrency().toString())
                .setObject(4, rate.getDate())
                .build(), keyHolder);
        return new Rate(keyHolder.getKey().intValue(), rate.getCourse(),
                rate.getEstimatedCurrency(), rate.getRelativeCurrency(), rate.getDate());
    }

    @Override
    public Collection<RateForRequest> readRates() {
        return template.query(resourceBundle.getString("selectAll"), (rs, rowNum) -> new RateForRequest(
                rs.getInt(1), rs.getDouble(2), rs.getString(3),
                rs.getString(4), rs.getString(5)));
    }

    @Override
    public void updateRate(Rate rateToUpdate, Rate updated) {
    }

    @Override
    public int deleteRate(Rate rateToDelete) {
        return template.update(con -> new PreparedStatementBuilder(
                con.prepareStatement(resourceBundle.getString("deleteSpecific")))
                .setDouble(1, rateToDelete.getCourse())
                .setString(2, rateToDelete.getEstimatedCurrency().toString())
                .setString(3, rateToDelete.getRelativeCurrency().toString())
                .setObject(4, rateToDelete.getDate())
                .build());
    }

    @Override
    public Collection<Rate> getRatesByDate(LocalDate date) {
        return null;
    }

    @Override
    public Collection<Rate> getRatesByCurrency(Currency currency) {
        return null;
    }
}
