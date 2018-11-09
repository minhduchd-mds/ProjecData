/*
 * Author TuanN
 **/
 import bean.DataBean;
 import javax.swing.*;
 import java.awt.event.*;
 import java.awt.*;
 import java.sql.*;
 import java.util.*;

 /** Lop hien thi chuong trinh them, sua record cho bang student */
 class StudentDetails extends JFrame implements ActionListener
 {

 	final String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
	final String url = "jdbc:odbc:Student";
	//final String serverName = "127.0.0.1";
	//final String portNumber = "1099";
	final String database = "Student";
	final String table = "Student";
	final String user = "sa";
	final String password = "sa";

	// Tao cac thanh phan hien thi tren Form
 	JLabel lbName 	= new JLabel("Ten sinh vien");
 	JLabel lbRollNo = new JLabel("Ma sinh vien");
 	JLabel lbClass	= new JLabel("Lop hoc");

 	JTextField tfName 	= new JTextField(30);
 	JTextField tfRollNo = new JTextField(30);
 	JTextField tfClass 	= new JTextField(30);

 	JButton btAdd 		= new JButton("Them");
 	JButton btDelete 	= new JButton("Xoa");
 	JButton btModify	= new JButton("Sua");
 	JButton btExit		= new JButton("Thoat");

 	JPanel pnRecord = new JPanel();
 	JPanel pnButton = new JPanel();

 	DataBean dataBean = new DataBean();
 	Statement statement;
 	Connection con;
	Vector<String> fieldName = new Vector<String>();

 	StudentDetails()
 	{
 		super("Student Details");
 		getContentPane().setLayout(new BorderLayout());

 		pnRecord.setLayout(new GridLayout(3, 2));
 		pnButton.setLayout(new GridLayout(1, 4));

 		// Thiet lap layout
 		pnRecord.add(lbName);
 		pnRecord.add(tfName);
 		pnRecord.add(lbRollNo);
 		pnRecord.add(tfRollNo);
 		pnRecord.add(lbClass);
 		pnRecord.add(tfClass);

 		pnButton.add(btAdd);
 		pnButton.add(btDelete);
 		pnButton.add(btModify);
 		pnButton.add(btExit);

 		getContentPane().add(pnRecord, BorderLayout.PAGE_START);
 		getContentPane().add(pnButton, BorderLayout.PAGE_END);

 		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		pack();
 		setSize(400, 300);
 		setVisible(true);

 		btAdd.addActionListener(this);
 		btDelete.addActionListener(this);
 		btModify.addActionListener(this);
 		btExit.addActionListener(this);

 		fieldName.add("Name");
 		fieldName.add("RollNo");
 		fieldName.add("Class");

 		// Ket noi co so du lieu
 		//try
 		{
            dataBean.setDriver(driver);
            dataBean.setUrl(url);
            dataBean.setUsername(user);
            dataBean.setPassword(password);
            dataBean.setTable(table);
            dataBean.setFields(fieldName);

            dataBean.setConnection(con);
            //con  = dataBean.getConnection();

            System.out.println("Da ket noi thanh cong");
 			statement = dataBean.getStatement();
 		}
 		/*
 		catch (SQLException sqlException)
 		{
 			System.out.println(sqlException);
 		}
 		/*
 		catch (ClassNotFoundException cnfException)
 		{
 			System.out.println(cnfException);
 		}
 		*/
 	}

 	public void actionPerformed(ActionEvent aEvent)
 	{
 		String strSql;

 		String name = tfName.getText();
 		String rollno = tfRollNo.getText();
 		String class_st = tfClass.getText();
 		int int_rollno;

 		System.out.println(rollno);
 		if (!rollno.equals(""))
 			int_rollno = Integer.parseInt(rollno);

 		{
 			if (aEvent.getSource().equals(btAdd))
 			{
 				Properties fieldValues = new Properties();
 				fieldValues.setProperty("Name", name);
 				fieldValues.setProperty("RollNo", rollno);
 				fieldValues.setProperty("Class", class_st);
 				dataBean.insert(fieldValues);

 				JOptionPane.showMessageDialog(this, "Da them gia tri moi");
 			}
 			else if (aEvent.getSource().equals(btDelete))
 			{
 				Properties fieldValues = new Properties();
 				if (!name.equals(""))
 					fieldValues.setProperty("Name", name);
 				if (!rollno.equals(""))
 					fieldValues.setProperty("RollNo", rollno);
 				if (!class_st.equals(""))
 					fieldValues.setProperty("Class", class_st);
 				dataBean.delete(fieldValues);

 				JOptionPane.showMessageDialog(this, "Da xoa ban ghi giong nhu tren");
 			}
 			else if (aEvent.getSource().equals(btModify))
 			{
 				Properties fieldValues = new Properties();
 				fieldValues.setProperty("Name", name);
 				fieldValues.setProperty("RollNo", rollno);
 				fieldValues.setProperty("Class", class_st);
 				dataBean.update(fieldValues);

 				JOptionPane.showMessageDialog(this, "Da thay ban ghi nhu tren");
 			}
 			else if (aEvent.getSource().equals(btExit))
 			{
 				System.exit(0);
 			}
 		}
 	}

 	public static void main(String arg[])
 	{
 		StudentDetails stDetailsForm = new StudentDetails();
 	}
 }
