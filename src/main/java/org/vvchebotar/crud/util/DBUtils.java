package org.vvchebotar.crud.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DBUtils {
    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void initialize() {
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();

            /**
             * Person_INFO
             */
            statement.execute("DROP TABLE IF EXISTS book");
            statement.executeUpdate("CREATE TABLE book(" + "ID SERIAL NOT NULL PRIMARY KEY, "
                    + "title_clmn VARCHAR(40) NOT NULL, " + "description_clmn VARCHAR(200), "
                    + "author_clmn VARCHAR(40) NOT NULL, isbn_clmn VARCHAR(13) NOT NULL, " +
                    "print_year_clmn INT, read_already_clmn BOOLEAN NOT NULL DEFAULT FALSE" + ")");
            for(int i = 1;i<36;i++) {
                statement.executeUpdate(
                        "INSERT INTO book" + "(title_clmn, description_clmn, author_clmn, isbn_clmn, print_year_clmn)" + "VALUES "
                                + "('book_"+ i +"', 'description_"+ i +"', 'author_"+ i +"', 'isbn_"+ i +"', 19"+ (i+10) +" )");
            }



            /**
             * ContactCard_INFO
             */
		/*	statement.executeUpdate("CREATE TABLE Person_INFO(" + "ID serial NOT NULL Primary key, "
					+ "firstName_clmn varchar(40) not null, " + "secondName_clmn varchar(40), "
					+ "lastName_clmn varchar(40) not null, fk_cc_id INT" + ")");
			statement.executeUpdate(
					"INSERT INTO Person_INFO" + "(firstName_clmn, secondName_clmn, lastName_clmn, fk_cc_id)" + "VALUES "
							+ "('Victor', 'Man', 'Red', '1')");*/

            /**
             * ContactCard_INFO
             */
//			statement.execute("DROP TABLE IF EXISTS ContactCard_INFO");
//			statement.executeUpdate("CREATE TABLE ContactCard_INFO(ID BIGINT UNSIGNED NOT NULL Primary key)");
//			statement.executeUpdate("INSERT INTO ContactCard_INFO" + "(ID)" + "VALUES " + "('1')");
//			statement.executeUpdate("INSERT INTO ContactCard_INFO" + "(ID)" + "VALUES " + "('2')");
//			statement.executeUpdate("INSERT INTO ContactCard_INFO" + "(ID)" + "VALUES " + "('3')");
//			statement.executeUpdate("INSERT INTO ContactCard_INFO" + "(ID)" + "VALUES " + "('4')");
            /**
             * Contact_INFO
             */
//			statement.execute("DROP TABLE IF EXISTS Contact_INFO");
//			statement.executeUpdate("CREATE TABLE Contact_INFO(" + "ID BIGINT UNSIGNED UNIQUE NOT NULL Primary key, "
//					+ "type_clmn varchar(40) not null, " + "provider_clmn varchar(40) not null" + ")");
//
//			statement.executeUpdate("INSERT INTO Contact_INFO" + "(ID, type_clmn, provider_clmn)"
//					+ "VALUES ('1', 'type_1', 'provider_1')");
//			statement.executeUpdate("INSERT INTO Contact_INFO" + "(ID, type_clmn, provider_clmn)"
//					+ "VALUES ('2', 'type_1', 'provider_1')");
//			statement.executeUpdate("INSERT INTO Contact_INFO" + "(ID, type_clmn, provider_clmn)"
//					+ "VALUES ('3', 'type_2', 'provider_2')");
//			statement.executeUpdate("INSERT INTO Contact_INFO" + "(ID, type_clmn, provider_clmn)"
//					+ "VALUES ('4', 'type_3', 'provider_2')");

            /**
             * EmailAddressContact_INFO
             */
//			statement.execute("DROP TABLE IF EXISTS EmailAddressContact_INFO");
//			statement.executeUpdate("CREATE TABLE EmailAddressContact_INFO("
//					+ "ID BIGINT UNSIGNED UNIQUE NOT NULL Primary key, " + "address_clmn varchar(40) not null" + ")");
//			statement.executeUpdate("INSERT INTO EmailAddressContact_INFO" + "(ID, address_clmn)"
//					+ "VALUES ('1', 'address1@service.com')");
//			statement.executeUpdate("INSERT INTO EmailAddressContact_INFO" + "(ID, address_clmn)"
//					+ "VALUES ('2', 'address2@service.com')");
//			statement.executeUpdate("INSERT INTO EmailAddressContact_INFO" + "(ID, address_clmn)"
//					+ "VALUES ('3', 'address3@service.com')");
//			statement.executeUpdate("INSERT INTO EmailAddressContact_INFO" + "(ID, address_clmn)"
//					+ "VALUES ('4', 'address4@service.com')");

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}