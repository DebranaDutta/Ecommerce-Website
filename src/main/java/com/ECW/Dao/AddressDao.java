package com.ECW.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ECW.Model.Address;

public class AddressDao {
	Connection connection;

	public AddressDao(Connection connection) {
		super();
		this.connection = connection;
	}

	// INSERT INTO `ecommerce`.`address` (`addressid`, `addressdetails`, `city`,
	// `state`, `zip`, `userid`) VALUES ('1', 'nfaonf', 'nfahb', 'anv', '5654',
	// '65564');
	public boolean addNewAddress(Address address) {
		boolean stat = false;
		try {
			String query = "INSERT INTO ecommerce.address (addressid, addressdetails, city, state, zip, userid, contactNo) VALUES (?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = this.connection.prepareStatement(query);
			preparedStatement.setInt(1, address.getAddressId());
			preparedStatement.setString(2, address.getAddressDetails());
			preparedStatement.setString(3, address.getCity());
			preparedStatement.setString(4, address.getState());
			preparedStatement.setInt(5, address.getZip());
			preparedStatement.setLong(6, address.getUserId());
			preparedStatement.setString(7, address.getContactNo());
			int i = preparedStatement.executeUpdate();
			if (i > 0) {
				stat = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stat;
	}

	// select * from ecommerce.address where userid=?;
	public List<Address> getAllAddressDetails(long userId) {
		List<Address> addresses = new ArrayList<Address>();
		try {
			String query = "select * from ecommerce.address where userid=?;";
			PreparedStatement preparedStatement = this.connection.prepareStatement(query);
			preparedStatement.setLong(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int addressid = resultSet.getInt("addressid");
				String addressdetails = resultSet.getString("addressdetails");
				String city = resultSet.getString("city");
				String state = resultSet.getString("state");
				int zip = resultSet.getInt("zip");
				String contactNo = resultSet.getString("contactNo");

				Address address = new Address(addressid, addressdetails, city, state, zip, userId, contactNo);
				addresses.add(address);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return addresses;
	}

	// DELETE FROM `ecommerce`.`address` WHERE (`addressid` = '9262');
	public boolean removeAddress(int addressId) {
		boolean stat = false;
		try {
			String query = "DELETE FROM ecommerce.address WHERE (addressid = ?);";
			PreparedStatement preparedStatement = this.connection.prepareStatement(query);
			preparedStatement.setInt(1, addressId);
			int i = preparedStatement.executeUpdate();
			if (i > 0) {
				stat = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stat;
	}
}
