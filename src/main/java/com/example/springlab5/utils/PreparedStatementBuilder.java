package com.example.springlab5.utils;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementBuilder {
    private final PreparedStatement preparedStatement;

    public PreparedStatementBuilder(PreparedStatement preparedStatement) {
        this.preparedStatement = preparedStatement;
    }

    public PreparedStatementBuilder setString(int parameterIndex, String string) throws SQLException {
        preparedStatement.setString(parameterIndex, string);
        return this;
    }

    public PreparedStatementBuilder setInt(int parameterIndex, Integer string) throws SQLException {
        preparedStatement.setInt(parameterIndex, string);
        return this;
    }

    public PreparedStatementBuilder setDouble(int parameterIndex, Double aDouble) throws SQLException {
        preparedStatement.setDouble(parameterIndex, aDouble);
        return this;
    }

    public PreparedStatementBuilder setObject(int parameterIndex, Object obj) throws SQLException {
        preparedStatement.setObject(parameterIndex, obj);
        return this;
    }

    public PreparedStatement build() {
        return this.preparedStatement;
    }
}
