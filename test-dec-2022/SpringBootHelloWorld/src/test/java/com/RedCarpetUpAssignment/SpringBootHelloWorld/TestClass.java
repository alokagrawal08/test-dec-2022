package com.RedCarpetUpAssignment.SpringBootHelloWorld;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.TestPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.mysql.cj.xdevapi.Statement;

import jakarta.activation.DataSource;

@SpringBootTest
@Testcontainers
@TestPropertySource(properties = "spring.datasource.url=jdbc:tc:mysql://localhost/test")
public class TestClass {

    @ClassRule
    private static final MySQLContainer MYSQL_CONTAINER = new MySQLContainer("mysql:latest");
    static {
    	MYSQL_CONTAINER.start();
    	}

    	@Autowired
    	private DataSource dataSource;

    	@BeforeEach
    	public void setUp() {
    	
	
    	TestPropertyValues.of(
    	"spring.datasource.url=" + MYSQL_CONTAINER.getJdbcUrl(),
    	"spring.datasource.username=" + MYSQL_CONTAINER.getUsername(),
    	"spring.datasource.password=" + MYSQL_CONTAINER.getPassword()
    	);
    	}
    	   @Test
    	    public void testConnection() throws Exception {
    	        Connection conn = DriverManager.getConnection(MYSQL_CONTAINER.getJdbcUrl(), MYSQL_CONTAINER.getUsername(), MYSQL_CONTAINER.getPassword());
    	        Statement stmt = (Statement) conn.createStatement();
    	        ResultSet rs = ((java.sql.Statement) stmt).executeQuery("SELECT 1");
    	        rs.next();
    	        int result = rs.getInt(1);
    	        assertEquals(1, result);
    	    }
    }





