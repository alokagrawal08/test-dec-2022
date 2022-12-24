package TestContainers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SamplePostgresSQLTest extends AbstractContainerDatabaseTest {
    private static PostgreSQLContainer<?> postgres;

    @BeforeEach
    public void setup() {
        postgres = new PostgreSQLContainer<>(DockerImageName.parse("postgres:11.13-alpine"));
    }

    @AfterEach
    public void teardown() {
        postgres.stop();
    }


    @Test
    public void testSimple() throws SQLException {
        postgres.start();
        ResultSet resultSet = performQuery(postgres, "SELECT 1");
        int resultSetInt = resultSet.getInt(1);
        System.out.println("ResultSet : " + resultSetInt);
        assertEquals(1, resultSetInt, "A basic SELECT query succeeds");
    }
}



