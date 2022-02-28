package com.kacyper.library.DbManager;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DbManagerTest {

    @Test
    void testConnection() throws SQLException {
        //Given & //When
        DbManager dbManager = DbManager.getInstance();
        //Then
        assertNotNull(dbManager.getConnection());
    }

}