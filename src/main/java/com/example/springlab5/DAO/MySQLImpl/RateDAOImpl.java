package com.example.springlab5.DAO.MySQLImpl;

import com.example.springlab5.DAO.RateDAO;
import com.example.springlab5.model.Rate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
        template.update(
                String.format(resourceBundle.getString("create"),
                        rate.getCourse(),
                        rate.getEstimatedCurrency(),
                        rate.getRelativeCurrency(),
                        rate.getDate()));
    }

    @Override
    public Collection<Rate> readRates() {
        return null;
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
