import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.HashMap;
import javax.swing.*;
import javafx.*;


import javafx.scene.image.Image;
public class LOGIN implements ActionListener{

    Connection conn;
	JFrame frame = new JFrame();
	JButton b1,b2,b3;
	JTextField userIDField ;
	JPasswordField userPasswordField ;
	JLabel user, Password,head,line ;
	JLabel messageLabel = new JLabel();
	public static boolean login=false;
    
	HashMap<String,String> logininfo = new HashMap<String,String>();
	
	LOGIN(){
		
//		logininfo = loginInfoOriginal;
                frame.setTitle("Login Page");
                frame.setSize(500,500);
		frame.setLayout(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
                
                ImageIcon img =new ImageIcon("login2.jpg");
//                Image i2=img.getImage().getScaledInstance(500, 500,Image.SCALE_DEFAULT);
//                ImageIcon i3=new ImageIcon(i2);
//                
                JLabel ll=new JLabel("",img,JLabel.CENTER);
                ll.setBounds(0,0,500,500);
                 frame.add(ll);
                 
                 head=new JLabel("Login Page");
                Font f=new Font("Algerian",Font.BOLD,35);
                head.setBounds(145,50,300,100);
                head.setForeground(Color.black);
                head.setFont(f);
        
                line=new JLabel("____________");
                line.setBounds(145,100,230,20);
                line.setForeground(Color.black);
		
                user = new JLabel("E-mail:");
                Font fe=new Font("Times New Roman",Font.BOLD,20);
                user.setBounds(100,150,100,60);
                user.setForeground(Color.black);
                user.setFont(fe);
                
                userIDField = new JTextField();
                userIDField.setBounds(200,165,170,30);;
                
                Password = new JLabel("Password:");
                Font fp=new Font("Times New Roman",Font.BOLD,20);
                Password.setBounds(100,220,100,60);
                Password.setForeground(Color.black);
                Password.setFont(fp);
		
		/*messageLabel.setBounds(125,250,250,35);
		messageLabel.setFont(new Font(null,Font.ITALIC,25));*/
		
                userPasswordField = new JPasswordField();
		userPasswordField.setBounds(200,235,170,30);
		
                
                b1 = new JButton("Login");
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
               
                 b3 = new JButton("Exits");
		b3.setBounds(185,380,100,30);
		b3.setFocusable(false);
		b3.addActionListener(this);
                 b3.setBackground(Color.WHITE);
                 b3.setForeground(Color.black);
                Cursor c8 =new Cursor(Cursor.HAND_CURSOR);
                b3.setCursor(c8);
               ll.add(b3);
                
                ll.add(head);
                ll.add(line);
		ll.add(user);
		ll.add(Password);
		ll.add(messageLabel);
		ll.add(userIDField);
		ll.add(userPasswordField);
		ll.add(b1);
		ll.add(b2);
		
		frame.setVisible(true);
		
	}
        public void close()
	{
		WindowEvent clswin=new WindowEvent(frame, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(clswin);
	} 
        public void connDB()
        {
              
                   try{
                	   Class.forName("com.mysql.cj.jdbc.Driver");
       	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3305/ecaa" , "root" , "root"  ); 
                   	  }
                 catch(Exception e){  e.printStackTrace(); }
      }
        public String[] getFEmail()
        {
        	connDB();
        	String[] email = new String[20];
    		Statement stm;
    		try {
    			
    			stm = conn.createStatement();
    			String sql = "select email from ecaa.farmer";
    			ResultSet rs = stm.executeQuery(sql);
    			int x=0;
    			while(rs.next())
    			{
    				//System.out.println("emails fetched");
    				email[x] = rs.getString(1);
        			x++;
    			}
    			
    			
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		return email;
        }
        public String getFPass(String email)
        {
        	String pass = "";
    		Statement stm;
    		try {
    			
    			stm = conn.createStatement();
    			String sql = "select pass from ecaa.farmer where email = '"+email+"'";
    			ResultSet rs = stm.executeQuery(sql);
    			
    			rs.next();
    			//System.out.println("pass fetched");
    			pass = rs.getString(1);
    			
    			
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		return pass;
        }
        public  boolean isFlogin()
        {
        	String userID = userIDField.getText();
			String password = String.valueOf(userPasswordField.getPassword());
			String[] email = getFEmail();
			
			for(int i=0; i<email.length ; i++)
			{
				if(userID.equals(email[i]))
				{
					if(password.equals(getFPass(email[i])))
					{
						
						//Homepage.post.setVisible(true);
						System.out.println("Farmer Login Successful");
						System.out.println(Homepage.Flogin);
						return true;
						
						
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "Incorrect Password");
						userIDField.setText("");
						userPasswordField.setText("");
					}
				}

			}
        	return false;
        }
        public String[] getTEmail()
        {
        	connDB();
        	String[] email = new String[20];
    		Statement stm;
    		try {
    			
    			stm = conn.createStatement();
    			String sql = "select email from ecaa.trader";
    			ResultSet rs = stm.executeQuery(sql);
    			int x=0;
    			while(rs.next())
    			{
    				//System.out.println("emails fetched");
    				email[x] = rs.getString(1);
        			x++;
    			}
    			
    			
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		return email;
        }
        public String getTPass(String email)
        {
        	String pass = "";
    		Statement stm;
    		try {
    			
    			stm = conn.createStatement();
    			String sql = "select pass from ecaa.trader where email = '"+email+"'";
    			ResultSet rs = stm.executeQuery(sql);
    			
    			rs.next();
    			//System.out.println("pass fetched");
    			pass = rs.getString(1);
    			
    			
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		return pass;
        }
        public  boolean isTlogin()
        {
        	String userID = userIDField.getText();
			String password = String.valueOf(userPasswordField.getPassword());
			String[] email = getTEmail();
			
			for(int i=0; i<email.length ; i++)
			{
				if(userID.equals(email[i]))
				{
					if(password.equals(getTPass(email[i])))
					{
						Homepage.Tlogin = true;
						Homepage.post.setVisible(true);
						System.out.println("Login Successful");
						System.out.println(Homepage.Tlogin);
						return true;
						
						
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "Incorrect Password");
						userIDField.setText("");
						userPasswordField.setText("");
					}
				}

			}
        	return false;
        }
    @Override
	public void actionPerformed(ActionEvent e) {
		
	if(e.getSource()==b2) {
			userIDField.setText("");
			userPasswordField.setText("");
		}
        
        if(e.getSource()==b1) 
        {
        	isTlogin();
        	isFlogin();
        	frame.dispose();
        }
        
        
          if(e.getSource()==b3) {   
                 frame.dispose();
                
             }
        
        }

}