package ru.karasongs.karasongs.model.types;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;

@MappedTypes(Duration.class)
public class DurationTypeHandler extends BaseTypeHandler<Duration> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Duration parameter, JdbcType jdbcType) throws
            SQLException {
        ps.setLong(i, parameter.toMillis());
    }

    @Override
    public Duration getNullableResult(ResultSet rs, String columnName) throws SQLException {
        long millis = rs.getLong(columnName);
        return Duration.ofMillis(millis);
    }

    @Override
    public Duration getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        long millis = rs.getLong(columnIndex);
        return Duration.ofMillis(millis);
    }

    @Override
    public Duration getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        long millis = cs.getLong(columnIndex);
        return Duration.ofMillis(millis);
    }
}

