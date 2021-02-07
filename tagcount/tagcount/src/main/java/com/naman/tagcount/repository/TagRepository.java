package com.naman.tagcount.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.naman.tagcount.bean.Tag;

import org.springframework.stereotype.Repository;

@Repository
public class TagRepository {

  // inserting or initializing the first value of the tagNumber

  public Tag insertFirstValue() throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.jdbc.Driver");
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/naman", "root", "root");
    PreparedStatement smt = connection.prepareStatement("Insert into number(tag_id, number) values(?,?)");
    smt.setString(1, "N01");
    smt.setInt(2, 1);
    smt.executeUpdate();
    connection.close();
    Tag tag = findOne("N01");
    return tag;
  }

  // finding the number from the database

  public Tag findOne(String tagId) throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.jdbc.Driver");
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/naman", "root", "root");
    PreparedStatement statement = connection.prepareStatement("Select * from number where tag_id =? ");
    statement.setString(1, "N01");
    ResultSet rSet = statement.executeQuery();
    Tag tag = null;
    while (rSet.next()) {
      tag = new Tag();
      tag.setTagId(rSet.getString(1));
      tag.setNumber(rSet.getInt(2));
    }
    connection.close();
    return tag;
  }

  // Updating the number back into to the database

  public boolean save(Tag tag) throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/naman", "root", "root");
    PreparedStatement smt = conn.prepareStatement("Update number set number=? where tag_id=?");
    smt.setInt(1, tag.getNumber());
    smt.setString(2, tag.getTagId());
    smt.execute();
    conn.close();
    return true;
  }

}