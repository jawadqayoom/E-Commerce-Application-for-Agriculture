
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javafx.*;

public class Homepage extends JFrame implements ActionListener {
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		JFrame frame =new JFrame();
	    JLabel header,wel,line1,line2;
	    static JButton post;
	    //JPanel main;
	    JButton[] button = new JButton[20];
	    JMenuBar bar ;
	    JMenu signup , help , signin , exit;
	    JMenuItem tradersup , farmersup , tradersin , farmersin ;
	    Connection conn;
	    TRegistration r ;
	    FRegistration r1;
	    LOGIN l;
	    public static boolean Tlogin = false;
		public static boolean Flogin = false;
	    
	         
	    Homepage(){
	                 
	       this.setTitle("AGRI-GO");
	       this.setSize(800,700);
	       this.setLayout(null);
	       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       this.setResizable(true);
	       this.setLocationRelativeTo(null); 
	       this.getContentPane().setBackground(Color.BLACK);
	       
	       
	       bar   = new JMenuBar() ;
	       
	       signup = new JMenu("SignUP");
	       
	       help  = new JMenu("Help");
	       
	       signin  = new JMenu("Signin");
	       
	       
	       

	       tradersup  = new JMenuItem("Register as a Trader");
	       tradersup.addActionListener(this);
	       
	       farmersup = new JMenuItem("Register as a Farmer");
	       farmersup.addActionListener(this);
	       
	       tradersin  = new JMenuItem("Login as Trader");
	       tradersin.addActionListener(this);
	       
	       farmersin  = new JMenuItem("Login as Farmer");
	       farmersin.addActionListener(this);
	       
	       exit  = new JMenu("Exit") ;
	       exit.addActionListener(this);

	       bar.add(signup);
	       bar.add(signin);
	       bar.add(help);
	       bar.add(exit);
	       signup.add(tradersup);
	       signup.add(farmersup);
	       signin.add(tradersin);
	       signin.add(farmersin);
	      
	       
	       //jp.setPreferredSize(new Dimension(1400,100));
	       wel=new JLabel("HOMEPAGE");
	       Font fw=new Font("Algerian",Font.BOLD,35);
	       wel.setBounds(280,15,230,60);
	       wel.setFont(fw);
	       wel.setForeground(Color.WHITE);
	       
	       line1=new JLabel("<html><br>_________________________________</html>");
	       line1.setBounds(280,45,320,20);
	       line1.setForeground(Color.WHITE);   
	      
	       MainPanel main = new MainPanel();	       
	       main.setBounds(10,100,500,500);
	       main.setVisible(true);
	       
	       JButton label = new JButton("Action");
	       label.setBounds(510,100,150,40);
	       label.setBackground(new Color(75,40,120));
	       label.setForeground(Color.WHITE);
	       label.setHorizontalTextPosition(JLabel.CENTER);
	       label.setFont(new Font("Comic Sans", Font.BOLD ,20));
	       label.setEnabled(false);
	       
	       int ypos =138 , xpos=510;
	       
	       button[0] = new JButton();
	       button[0].addActionListener(this);
	       button[0].setBounds(xpos,ypos,150,40);
	       button[0].setFont(new Font("Comic Sans", Font.BOLD ,10));
	       button[0].setBackground(new Color(75,40,120));
	       button[0].setForeground(Color.WHITE);
	       button[0].setText("Order");
	       button[0].setFocusable(false);
	       
	       button[1] = new JButton();
	       button[1].addActionListener(this);
	       button[1].setBounds(xpos,ypos+38,150,40);
	       button[1].setFont(new Font("Comic Sans", Font.BOLD ,10));
	       button[1].setBackground(new Color(75,40,120));
	       button[1].setForeground(Color.WHITE);
	       button[1].setText("Order");
	       button[1].setFocusable(false);
	       
	       button[2] = new JButton();
	       button[2].addActionListener(this);
	       button[2].setBounds(xpos,ypos+38*2,150,40);
	       button[2].setFont(new Font("Comic Sans", Font.BOLD ,10));
	       button[2].setBackground(new Color(75,40,120));
	       button[2].setForeground(Color.WHITE);
	       button[2].setText("Order");
	       button[2].setFocusable(false);
	       
	       button[3] = new JButton();
	       button[3].addActionListener(this);
	       button[3].setBounds(xpos,ypos+38*3,150,40);
	       button[3].setFont(new Font("Comic Sans", Font.BOLD ,10));
	       button[3].setBackground(new Color(75,40,120));
	       button[3].setForeground(Color.WHITE);
	       button[3].setText("Order");
	       button[3].setFocusable(false);
	       
	       button[4] = new JButton();
	       button[4].addActionListener(this);
	       button[4].setBounds(xpos,ypos+38*4,150,40);
	       button[4].setFont(new Font("Comic Sans", Font.BOLD ,10));
	       button[4].setBackground(new Color(75,40,120));
	       button[4].setForeground(Color.WHITE);
	       button[4].setText("Order");
	       button[4].setFocusable(false);
	       
	       button[5] = new JButton();
	       button[5].addActionListener(this);
	       button[5].setBounds(xpos,ypos+38*5,150,40);
	       button[5].setFont(new Font("Comic Sans", Font.BOLD ,10));
	       button[5].setBackground(new Color(75,40,120));
	       button[5].setForeground(Color.WHITE);
	       button[5].setText("Order");
	       button[5].setFocusable(false);
	       
	       button[6] = new JButton();
	       button[6].addActionListener(this);
	       button[6].setBounds(xpos,ypos+38*6,150,40);
	       button[6].setFont(new Font("Comic Sans", Font.BOLD ,10));
	       button[6].setBackground(new Color(75,40,120));
	       button[6].setForeground(Color.WHITE);
	       button[6].setText("Order");
	       button[6].setFocusable(false);
	       
	       button[7] = new JButton();
	       button[7].addActionListener(this);
	       button[7].setBounds(xpos,ypos+38*7,150,40);
	       button[7].setFont(new Font("Comic Sans", Font.BOLD ,10));
	       button[7].setBackground(new Color(75,40,120));
	       button[7].setForeground(Color.WHITE);
	       button[7].setText("Order");
	       button[7].setFocusable(false);
	       
	       button[8] = new JButton();
	       button[8].addActionListener(this);
	       button[8].setBounds(xpos,ypos+38*8,150,40);
	       button[8].setFont(new Font("Comic Sans", Font.BOLD ,10));
	       button[8].setBackground(new Color(75,40,120));
	       button[8].setForeground(Color.WHITE);
	       button[8].setText("Order");
	       button[8].setFocusable(false);
	       
	       button[9] = new JButton();
	       button[9].addActionListener(this);
	       button[9].setBounds(xpos,ypos+38*9,150,40);
	       button[9].setFont(new Font("Comic Sans", Font.BOLD ,10));
	       button[9].setBackground(new Color(75,40,120));
	       button[9].setForeground(Color.WHITE);
	       button[9].setText("Order");
	       button[9].setFocusable(false);
	       
	       button[10] = new JButton();
	       button[10].addActionListener(this);
	       button[10].setBounds(xpos,ypos+38*10,150,40);
	       button[10].setFont(new Font("Comic Sans", Font.BOLD ,10));
	       button[10].setBackground(new Color(75,40,120));
	       button[10].setForeground(Color.WHITE);
	       button[10].setText("Order");
	       button[7].setFocusable(false);
	       
	       button[11] = new JButton();
	       button[11].addActionListener(this);
	       button[11].setBounds(xpos,ypos+38*11,150,40);
	       button[11].setFont(new Font("Comic Sans", Font.BOLD ,10));
	       button[11].setBackground(new Color(75,40,120));
	       button[11].setForeground(Color.WHITE);
	       button[11].setText("Order");
	       button[11].setFocusable(false);
	       
	       post = new JButton();
	       post.addActionListener(this);
	       post.setBounds(10,25,150,40);
	       post.setFont(new Font("Comic Sans", Font.BOLD ,10));
	       post.setBackground(new Color(75,40,120));
	       post.setForeground(Color.WHITE);
	       post.setText("Post Ads");
	       post.setFocusable(false);
	       post.setVisible(false);
	       
	      
	         
	       this.add(wel);
	       this.add(line1);
	       this.add(post);
	       for(int i=0 ;i < 12;i++)
	       {
	    	   this.add(button[i]);
	       }
	       this.add(label);
	       this.add(main);
	       this.setJMenuBar(bar);
	       this.setVisible(true);
	       
	    }


		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==tradersup)
			{
				r = new TRegistration();
				r.b.addActionListener(this);
			}
			else if(e.getSource()==farmersup)
			{
				r1 = new FRegistration();
				r1.b.addActionListener(this);
			}
			if(e.getSource()==tradersin)
			{
				l = new LOGIN();
				
			}
			if(e.getSource() == farmersin)
			{
				l = new LOGIN();
			}
			if(e.getSource() == post)
			{
				PostAd ad = new PostAd();
			}
				
			if(e.getSource()==button[0])
			{
				if(Flogin)
				{
					
				}
				else l = new LOGIN();
			}
			if(e.getSource()==r.b)
			{
				r.insertData("Trader");
			}			
			else if(e.getSource()==r1.b)
			{
				r1.insertData("Farmer");
			}
			
			
		}
}