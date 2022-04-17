import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PostAd implements ActionListener{
	
	Connection conn;
	JFrame frame;
	JButton b1,b2,b3;
	JTextField t1,t2,t3,t4,t5 ;
	JLabel head,name, croptype ,cropname, price, quantity;
	
	PostAd()
	{
		  frame = new JFrame();
		  frame.setTitle("Post Advertisement");
          frame.setSize(500,500);
          frame.setLayout(null);
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.setResizable(false);
          frame.setLocationRelativeTo(null);
          

          head=new JLabel("Post Your Advertisement Here");
          Font f=new Font("Algerian",Font.BOLD,25);
          head.setBounds(10,10,450,50);
          head.setForeground(Color.black);
          head.setFont(f);
          
          name = new JLabel("Trader's Name");
          name.setBounds(10,50,100,40);
          Font fe=new Font("Times New Roman",Font.BOLD,15);
          name.setForeground(Color.black);
          name.setFont(fe);
          t1 = new JTextField();
          t1.setBounds(150,53,170,30);;
          
          croptype = new JLabel("Crop Type");
          croptype.setBounds(10,90,100,40);
          croptype.setForeground(Color.black);
          croptype.setFont(fe);
          t2 = new JTextField();
          t2.setBounds(150,93,170,30);;
          
          cropname = new JLabel("Crop Name");
          cropname.setBounds(10,140,100,40);
          cropname.setForeground(Color.black);
          cropname.setFont(fe);
          t3 = new JTextField();
          t3.setBounds(150,143,170,30);;
          
          price = new JLabel("Price");
          price.setBounds(10,190,100,40);
          price.setForeground(Color.black);
          price.setFont(fe);
          t4 = new JTextField();
          t4.setBounds(150,193,170,30);;
          
          quantity = new JLabel("Quantity");
          quantity.setBounds(10,240,100,40);
          quantity.setForeground(Color.black);
          quantity.setFont(fe);
          t5 = new JTextField();
          t5.setBounds(150,243,170,30);
          
          b1 = new JButton("Post");
          b1.setBounds(110,320,100,30);
          b1.setFocusable(false);
          b1.addActionListener(this);
          b1.setBackground(Color.WHITE);
          b1.setForeground(Color.black);
          Cursor c1 =new Cursor(Cursor.HAND_CURSOR);
          b1.setCursor(c1);
          
	
          b2 = new JButton("Reset");
          b2.setBounds(260,320,100,30);
          b2.setFocusable(false);
          b2.addActionListener(this);
          b2.setBackground(Color.WHITE);
          b2.setForeground(Color.black);
          Cursor c2 =new Cursor(Cursor.HAND_CURSOR);
          b2.setCursor(c2);
          
          frame.setVisible(true);
          frame.add(head);
          frame.add(name);
          frame.add(t1);
          frame.add(croptype);
          frame.add(t2);
          frame.add(cropname);
          frame.add(t3);
          frame.add(price);
          frame.add(t4);
          frame.add(quantity);
          frame.add(t5);
          frame.add(b1);
          frame.add(b2);
          
          
          
          
	}
	public void connDB()
    {
          
               try{
            	   Class.forName("com.mysql.cj.jdbc.Driver");
   	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3305/ecaa" , "root" , "root"  ); 
               	  }
             catch(Exception e){  e.printStackTrace(); }
  }
	public void insertData()
	{
		connDB();
    	Statement stm;
		try {
			stm = conn.createStatement();
			String sql = "INSERT INTO ecaa.ads (postedby, croptype, cropname, price, quantity , traderid)"+ "VALUES('"+t1.getText()+"','" +t2.getText()+ "','"+t3.getText()+"'," + Integer.parseInt(t4.getText())+"," + Integer.parseInt(t5.getText()) + "," + getTraderId(t1.getText())+")";
			stm.executeUpdate(sql);
			System.out.println("Data inserted Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getTraderId(String name)
	{
		int id = 0;
		Statement stm;
		try {
			
			stm = conn.createStatement();
			String sql = "select traderid from ecaa.trader where Tname = '" + name + "'";
			
			ResultSet rs = stm.executeQuery(sql);
			System.out.println("Trader ID fetched");
			rs.next();
			id = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == b1)
		{
			insertData();
			frame.dispose();
		}
		if(e.getSource()==b2) {
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			
		}
		
	}

}
