import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JTableUniversity extends JFrame {
    private JTable table1;
    private JRadioButton studentRadioButton;
    private JRadioButton academicianRadioButton;
    private JButton btnDelete;
    private JButton btnUpdate;
    private JButton btnInsert;
    private JTextField nameField;
    private JTextField surnameField;
    private JTextField courseField;
    private JPanel panel1;
    private JScrollPane scrollPane1;
    DefaultTableModel model;
    public JTableUniversity() {
        setTitle("University Database");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 350);
        setVisible(true);
        add(panel1);

        ButtonGroup group = new ButtonGroup();
        group.add(studentRadioButton);
        group.add(academicianRadioButton);

        String[] column = {"ID", "Name", "Surname", "Course"};
        table1.setModel(new DefaultTableModel(null, column));
        model = (DefaultTableModel) table1.getModel();

        // Button Action Listeners
        btnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertRecord();
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteRecord();
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateRecord();
            }
        });

        studentRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshTable();
            }
        });

        academicianRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshTable();
            }
        });

        refreshTable();
    }
    private void insertRecord() {
        String sql;
        int newId = getMaxId() + 1;
        if (studentRadioButton.isSelected()) {
            sql = "INSERT INTO Student (idStudent, Student_name, Student_surname, Student_coursecode) VALUES (?, ?, ?, ?)";
        } else if (academicianRadioButton.isSelected()) {
            sql = "INSERT INTO Academician (idAcademician, Academician_name, Academician_surname, Academician_coursecode) VALUES (?, ?, ?, ?)";
        } else {
            JOptionPane.showMessageDialog(this, "Please select Student or Academician.");
            return;
        }

        try (Connection connection = DatabaseConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, newId);
            preparedStatement.setString(2, nameField.getText());
            preparedStatement.setString(3, surnameField.getText());
            preparedStatement.setString(4, courseField.getText());
            preparedStatement.executeUpdate();
            System.out.println("Record inserted successfully");
            refreshTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void deleteRecord() {
        String table;
        String idColumn;
        if (studentRadioButton.isSelected()) {
            table = "Student";
            idColumn = "idStudent";
        } else if (academicianRadioButton.isSelected()) {
            table = "Academician";
            idColumn = "idAcademician";
        } else {
            JOptionPane.showMessageDialog(this, "Please select Student or Academician.");
            return;
        }

        String sql = "DELETE FROM " + table + " WHERE " + idColumn + " = ?";
        int selectedRow = table1.getSelectedRow(); // It gets the index of the selected row in the JTable.

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.");
            return;
        }
        int id = (int) model.getValueAt(selectedRow, 0);

        try (Connection connection = DatabaseConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Record deleted successfully");
            refreshTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void updateRecord() {
        String sql;
        String idColumn;
        if (studentRadioButton.isSelected()) {
            sql = "UPDATE Student SET Student_name = ?, Student_surname = ?, Student_coursecode = ? WHERE idStudent = ?";
            idColumn = "idStudent";
        } else if (academicianRadioButton.isSelected()) {
            sql = "UPDATE Academician SET Academician_name = ?, Academician_surname = ?, Academician_coursecode = ? WHERE idAcademician = ?";
            idColumn = "idAcademician";
        } else {
            JOptionPane.showMessageDialog(this, "Please select Student or Academician.");
            return;
        }

        int selectedRow = table1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to update.");
            return;
        }
        int id = (int) model.getValueAt(selectedRow, 0);

        try (Connection connection = DatabaseConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, nameField.getText());
            preparedStatement.setString(2, surnameField.getText());
            preparedStatement.setString(3, courseField.getText());
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();
            System.out.println("Record updated successfully");
            refreshTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void refreshTable() {
        String sql;
        if (studentRadioButton.isSelected()) {
            sql = "SELECT idStudent, Student_name, Student_surname, Student_coursecode FROM Student";
        } else if (academicianRadioButton.isSelected()) {
            sql = "SELECT idAcademician, Academician_name, Academician_surname, Academician_coursecode FROM Academician";
        } else {
            return;
        }

        try (Connection connection = DatabaseConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            model.setRowCount(0); // Clear existing data

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String surname = resultSet.getString(3);
                String course = resultSet.getString(4);
                model.addRow(new Object[]{id, name, surname, course});
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private int getMaxId() {
        String sql;
        if (studentRadioButton.isSelected()) {
            sql = "SELECT MAX(idStudent) AS maxId FROM Student";
        } else if (academicianRadioButton.isSelected()) {
            sql = "SELECT MAX(idAcademician) AS maxId FROM Academician";
        } else {
            return 0;
        }

        try (Connection connection = DatabaseConnect.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                return resultSet.getInt("maxId");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        JTableUniversity jtu = new JTableUniversity();
        jtu.setVisible(true);
    }
}

