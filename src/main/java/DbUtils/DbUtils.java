package DbUtils;

import java.sql.*;
import java.util.ArrayList;


public class DbUtils {
    private static final String URL = "jdbc:postgresql://localhost:5432/motorsport_user";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "GfhjkmGjEvjkxfyb.123qwe";


    public static String getUserConfirmationToken(String email) {
        Connection connection = null;
        String token = null;

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE email = ?");
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                token = resultSet.getString("email_confirmation_token");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return token;
    }

    public void deleteSubscribe(String email) {
        Connection connection = null;
        String URL_CONTENT = "jdbc:postgresql://localhost:5432/motorsport_subscription";

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            String SQL = "SELECT id FROM users WHERE email like '%" + email + "%'";
            ResultSet resultSet;
            resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                int idUser = resultSet.getInt("id");

                connection = DriverManager.getConnection(URL_CONTENT, USERNAME, PASSWORD);
                PreparedStatement deleteFromTransactionStatement = connection.prepareStatement("DELETE FROM transactions WHERE user_id = ?");
                deleteFromTransactionStatement.setInt(1, idUser);
                deleteFromTransactionStatement.executeUpdate();

                PreparedStatement deleteReceipt = connection.prepareStatement("DELETE FROM provider_receipts WHERE subscription_id in (SELECT id from subscriptions WHERE user_id = ?) ");
                deleteReceipt.setInt(1, idUser);
                deleteReceipt.executeUpdate();

                PreparedStatement deleteSnapshotStmt = connection.prepareStatement("DELETE FROM subscription_snapshot WHERE subscription_id in (SELECT id from subscriptions WHERE user_id = ?) ");
                deleteSnapshotStmt.setInt(1, idUser);
                deleteSnapshotStmt.executeUpdate();

                PreparedStatement deleteStatement = connection.prepareStatement("DELETE FROM subscriptions WHERE user_id = ? ");
                deleteStatement.setInt(1, idUser);
                deleteStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteUser(String email) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement statement = connection.prepareStatement("DELETE FROM users WHERE email = ?");
            statement.setString(1, email);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    public void deletePPVCodeAccess(String email) {
        Connection connection = null;
        try {
            String URL_CONTENT = "jdbc:postgresql://localhost:5432/motorsport_admin";
            String USERNAME_CONTENT = "postgres";
            String PASSWORD_CONTENT = "GfhjkmGjEvjkxfyb.123qwe";

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            String SQL = "SELECT ID FROM users WHERE email = '" + email + "'";
            Integer idUser = null;
            ArrayList<String> idAccessList = new ArrayList<>();

            ResultSet resultSet;
            resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                idUser = resultSet.getInt("id");
            }
            connection = DriverManager.getConnection(URL_CONTENT, USERNAME_CONTENT, PASSWORD_CONTENT);
            PreparedStatement statementForAccessList = connection.prepareStatement("SELECT * FROM access_list WHERE owner_id = ?");
            statementForAccessList.setInt(1, idUser);

            ResultSet resultSetForAccessList;
            resultSetForAccessList = statementForAccessList.executeQuery();
            while (resultSetForAccessList.next()) {
                idAccessList.add(String.valueOf(resultSetForAccessList.getInt("id")));
            }

            statementForAccessList = connection.prepareStatement("DELETE FROM access_snpashots WHERE access_id = ANY(?)");
            statementForAccessList.setArray(1, connection.createArrayOf("integer", idAccessList.toArray()));
            statementForAccessList.executeUpdate();

            statementForAccessList = connection.prepareStatement("DELETE FROM transaction_request_payload WHERE transaction_id IN (SELECT id FROM transactions WHERE payer_id = ?)");
            statementForAccessList.setInt(1, idUser);
            statementForAccessList.executeUpdate();

            statementForAccessList = connection.prepareStatement("DELETE FROM transactions WHERE payer_id = ?");
            statementForAccessList.setInt(1, idUser);
            statementForAccessList.executeUpdate();

            statementForAccessList = connection.prepareStatement("DELETE FROM access_list WHERE id = ANY(?)");
            statementForAccessList.setArray(1, connection.createArrayOf("integer", idAccessList.toArray()));
            statementForAccessList.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }



}
