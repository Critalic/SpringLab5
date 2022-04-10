package com.example.springlab5.DAO.MySQLImpl;

import com.example.springlab5.DAO.RateDAO;
import com.example.springlab5.model.Rate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;

@Repository
public class RateDAOImpl implements RateDAO {
    private JdbcTemplate template;

    public RateDAOImpl(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public Rate createRate(Rate rate) {
        template.update()
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
