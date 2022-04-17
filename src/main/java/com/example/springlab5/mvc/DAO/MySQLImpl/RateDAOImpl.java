package com.example.springlab5.mvc.DAO.MySQLImpl;

import com.example.springlab5.mvc.DAO.RateDAO;
import com.example.springlab5.mvc.model.Rate;
import com.example.springlab5.mvc.model.RateForRequest;
import com.example.springlab5.utils.PreparedStatementBuilder;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    public int[] createRates(Rate... rates) {
        return template.batchUpdate(resourceBundle.getString("create"), new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setDouble(1, rates[i].getCourse());
                ps.setString(2, rates[i].getEstimatedCurrency().toString());
                ps.setString(3, rates[i].getRelativeCurrency().toString());
                ps.setObject(4, rates[i].getDate());
            }

            @Override
            public int getBatchSize() {
                return rates.length;
            }
        });
    }

    @Override
    public Collection<RateForRequest> readRates() {
        return template.query(resourceBundle.getString("selectAll"), (rs, rowNum) -> new RateForRequest(
                rs.getInt(1), rs.getDouble(2), rs.getString(3),
                rs.getString(4), rs.getString(5)));
    }

    @Override
    public int updateRate(Rate rateToUpdate, Rate updated) {
        return template.update(con -> new PreparedStatementBuilder(
                con.prepareStatement(resourceBundle.getString("updateSpecific")))
                .setDouble(1, updated.getCourse())
                .setString(2, updated.getEstimatedCurrency().toString())
                .setString(3, updated.getRelativeCurrency().toString())
                .setObject(4, updated.getDate())
                .setDouble(5, rateToUpdate.getCourse())
                .setString(6, rateToUpdate.getEstimatedCurrency().toString())
                .setString(7, rateToUpdate.getRelativeCurrency().toString())
                .setObject(8, rateToUpdate.getDate())
                .build()
        ) ;
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
    public int[] deleteRates(Rate... ratesToDelete) {
        return template.batchUpdate(resourceBundle.getString("deleteSpecific"), new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setDouble(1, ratesToDelete[i].getCourse());
                ps.setString(2, ratesToDelete[i].getEstimatedCurrency().toString());
                ps.setString(3, ratesToDelete[i].getRelativeCurrency().toString());
                ps.setObject(4, ratesToDelete[i].getDate());
            }

            @Override
            public int getBatchSize() {
                return ratesToDelete.length;
            }
        });
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
