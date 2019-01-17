package org.gadek.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
 
import org.gadek.model.AppUser;
import org.springframework.jdbc.core.RowMapper;
 
public class AppUserMapper implements RowMapper<AppUser> {
 
    public static final String BASE_SQL = "Select u.User_Id, u.User_Name, u.Encryted_Password, u.enabled From App_User u ";
    @Override
    public AppUser mapRow(ResultSet rs, int rowNum) throws SQLException {
 
        Long userId = rs.getLong("User_Id");
        String userName = rs.getString("User_Name");
        String encrytedPassword = rs.getString("Encryted_Password");
        boolean enabled =  rs.getBoolean("enabled");
 
        return new AppUser(userId, userName, encrytedPassword, enabled);
    }
}
 