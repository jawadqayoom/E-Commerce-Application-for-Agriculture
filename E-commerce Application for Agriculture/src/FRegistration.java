import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;
import javax.swing.border.Border;

public class FRegistration implements ActionListener{

    JFrame frame = new JFrame();
    JFrame f;
    JLabel id,id1,id2,id3,id4,gend,id5,id6,id7,id8,id9,id10,id11,id12,id15,id16,id17,gender,lab,lab1,lab2;
    JTextField t,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13;
    JButton b,back,b1,b2,b3;
    JComboBox c1,c2;
    JRadioButton m1,f1;
    JPasswordField userPasswordField,userPasswordField11;
    Connection conn;
    String gen="Male";
    
       
    Random ran = new Random();
    long first4 = (ran.nextLong() % 9L) + 1L;
    long first = Math.abs(first4);
    
    Connection con=null;
    PreparedStatement stat=null;
    private Object userPasswordField1;
    
    FRegistration(){
    
       f = new JFrame("Registration");
        f.getContentPane().setBackground(Color.black);
         f.setSize(800,550);
       f.setLocation(400,150);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null); 
        f.setLayout(null);
        f.setResizable(false);
       
        
      
       
        back=new JButton("Back");
        back.setBounds(2,5,70,25);
        back.addActionListener(this);
         back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        Cursor cub =new Cursor(Cursor.HAND_CURSOR);
        back.setCursor(cub);
        back.setFocusable(false);
        //back.setOpaque(false);
        f.add(back);
        
        id8 = new JLabel("Registration Form");
        id8.setBounds(230,20,500,50);
        id8.setFont(new Font("Algerian",Font.BOLD,30));
        id8.setForeground(Color.WHITE);
        f.add(id8);

 
        id1 = new JLabel("Name");
        id1.setBounds(50,100,100,30);
        id1.setFont(new Font("serif",Font.BOLD,20));
        id1.setForeground(Color.WHITE);
        f.add(id1);

        t1=new JTextField();
        t1.setBounds(200,100,150,30);
        f.add(t1);

        id2 = new JLabel("City");
        id2.setBounds(400,100,200,30);
        id2.setFont(new Font("serif",Font.BOLD,20));
        id2.setForeground(Color.WHITE);
        f.add(id2);

        t2=new JTextField();
        t2.setBounds(600,100,150,30);
        f.add(t2);

        id3= new JLabel("Age");
        id3.setBounds(50,150,100,30);
        id3.setFont(new Font("serif",Font.BOLD,20));
        id3.setForeground(Color.WHITE);
        f.add(id3);

        t3=new JTextField();
        t3.setBounds(200,150,150,30);
        f.add(t3);

        id4= new JLabel("DOB (yyyy-mm-dd)");  
        id4.setBounds(400,150,200,30);
        id4.setFont(new Font("serif",Font.BOLD,20));
        id4.setForeground(Color.WHITE);
        f.add(id4);

        t4=new JTextField();
        t4.setBounds(600,150,150,30);
        f.add(t4);

        gend= new JLabel("Gender");
        gend.setBounds(50,200,100,30);
        gend.setFont(new Font("serif",Font.BOLD,20));
        gend.setForeground(Color.WHITE);
        f.add(gend);

          ButtonGroup bg=new ButtonGroup();
        m1 =new JRadioButton("Male"); 
        m1.setBounds(200,200,70,30);
        m1.setFocusable(false);
        m1.setOpaque(false);
        m1.setForeground(Color.WHITE);
        bg.add(m1);
        f.add(m1);
        
        f1 =new JRadioButton("Female");
       f1.setBounds(280,200,70,30);
       f1.setFocusable(false);
       f1.setOpaque(false);
       f1.setForeground(Color.WHITE);
        bg.add(f1);
        f.add(f1);
        

        id6= new JLabel("Phone");
        id6.setBounds(400,200,100,30);
        id6.setFont(new Font("serif",Font.BOLD,20));
        id6.setForeground(Color.WHITE);
        f.add(id6);

        t6=new JTextField();
        t6.setBounds(600,200,150,30);
        f.add(t6);

        id7= new JLabel("E-mail");
        id7.setBounds(50,250,100,30);
        id7.setFont(new Font("serif",Font.BOLD,20));
        id7.setForeground(Color.WHITE);
        f.add(id7);

        t7=new JTextField();
        t7.setBounds(200,250,150,30);
        f.add(t7);

        id9= new JLabel("Address");
        id9.setBounds(400,250,130,30);
        id9.setFont(new Font("serif",Font.BOLD,20));
        id9.setForeground(Color.WHITE);
        f.add(id9);

        t8=new JTextField();
        t8.setBounds(600,250,150,30);
//        t8.setText("1"+first);
        f.add(t8);

        id10= new JLabel("Password");
        id10.setBounds(50,300,130,30);
        id10.setFont(new Font("serif",Font.BOLD,20));
        id10.setForeground(Color.WHITE);
        f.add(id10);

        userPasswordField = new JPasswordField();
        userPasswordField.setBounds(200,300,150,30);
        f.add(userPasswordField);


        id11= new JLabel("Confrim Passowrd");
        id11.setBounds(400,300,180,30);
        id11.setFont(new Font("serif",Font.BOLD,20));
        id11.setForeground(Color.WHITE);
        f.add(id11);

        userPasswordField11 = new JPasswordField();
        userPasswordField11.setBounds(600,300,150,30);
        f.add(userPasswordField11);
//
//        id12= new JLabel("Address");
//        id12.setBounds(50,350,150,30);
//        id12.setFont(new Font("serif",Font.BOLD,20));
//        id12.setForeground(Color.WHITE);
//        f.add(id12);
////
//        t11=new JTextField();   
//        t11.setBounds(200,350,150,30);
//        f.add(t11);
        
        b = new JButton("Submit");
        b.setBackground(Color.WHITE);
        b.setForeground(Color.BLACK);
        b.setBounds(250,420,150,40);
        b.setFocusable(false);
        Cursor cu =new Cursor(Cursor.HAND_CURSOR);
        b.setCursor(cu);
        f.add(b);

        b1=new JButton("Reset");   
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
        b1.setBounds(450,420,150,40);
        b1.setFocusable(false);
        Cursor c =new Cursor(Cursor.HAND_CURSOR);
        b1.setCursor(c);
        f.add(b1);
        
        b.addActionListener(this);
        b1.addActionListener(this);
        
        f.setVisible(true);
       
       
    }
    public void connDB()
    {
          
               try{
            	   Class.forName("com.mysql.cj.jdbc.Driver");
   	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3305/ecaa" , "root" , "root"  ); 
               	  }
             catch(Exception e){  e.printStackTrace(); }
  }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource()==back){
       
          f.dispose();
//      Students sty=new Students();
       
       }
        
        if(ae.getSource()==b1){
              
          t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            userPasswordField.setText("");
             userPasswordField11.setText("");
            t6.setText("");
            t7.setText("");
            t8.setText("");
            
       
       }
        if(ae.getSource()==b){
            
            
                String a = t1.getText();
                String bb = t2.getText();
                String c = t3.getText();
                String d = t4.getText();
                 if(f1.isSelected()){
                 gen="Female"; 
                 }
                String id6 =t6.getText();
               
                 if(!id6.matches( "[0-9]+") ){
                    
                 JOptionPane.showMessageDialog(null, "Number is Required And Enter only 11  Digit ");
                 }
                String  id7=t7.getText();
                 if(! id7.contains("@")){
                  JOptionPane.showMessageDialog(null,"@ is required");
                 }
                String h = t8.getText();
                String Password = String.valueOf(userPasswordField.getPassword());
                String ComfrimPassword = String.valueOf(userPasswordField11.getPassword());
                 if(! Password.matches(ComfrimPassword)){
                     JOptionPane.showMessageDialog(null,"Password and Confrim Password must be same ");
                 }
                 
                 // After all condition we show the final result of registration form
                 if(id7.contains("@") && id6.matches( "[0-9]+") &&  Password.matches(ComfrimPassword)  ){
                
                 JOptionPane.showMessageDialog(null,"Name: "+  a +"\nCity: "+ bb +"\nAge: "+ c +"\nDOB: "+ d +"\nGender: "+gender+ "\nNumber: "+id6 +
                  "\nEmail: " +id7 +"\nAddress: "+h + "\nPassword: "+Password + "\nConfrim Password: "+ComfrimPassword   );
      
                     
                 }        
                
        }
        
    }
    
    public void insertData(String AccType)
    {
    	connDB();
    	Statement stm;
		try {
			stm = conn.createStatement();
			String sql = "INSERT INTO " + AccType +"(Fname, email, contact, accountType, Taddress, age, gender, DOB, pass)"+ "VALUES('"+t1.getText()+"','" +t7.getText()+ "','"+t6.getText()+"','" +AccType+"','"+t8.getText()+"','" + t3.getText() + "','" + gen + "',DATE '" + t4.getText() +"','" + String.valueOf(userPasswordField.getPassword()) +"')";
			stm.executeUpdate(sql);
			System.out.println("Data inserted Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
    	
    }
