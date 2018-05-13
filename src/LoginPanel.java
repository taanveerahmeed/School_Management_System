import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;

class ImageBack extends JPanel{
	 private BufferedImage img;
	ImageBack (){
		try{
			//img = ImageIO.read(new File("C:\\Users\\Taanveer Ahmeed\\Desktop\\wp\\back-to-school-wallpaper-5 - Copy.jpeg"));
			img = ImageIO.read(getClass().getResource("kateschool2008d_1024.jpg"));
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }
	
}

class LoginPanel extends JPanel{
	
	JButton admin ;
	JTextField username;
	JPasswordField password;
	JButton login;
	ImageBack tb = new ImageBack ();
	
	LoginPanel (){
		
		setLayout(new GridLayout (1,0));
		
		add(tb);
		
		Font adminFont = new Font ("Serif",Font.BOLD+Font.ITALIC,25);
		
		JPanel outer = new JPanel();
		outer.setLayout(new BorderLayout());
		outer.add(admin = new JButton("Go to Admin Panel"),BorderLayout.PAGE_START);
		admin.setFont(adminFont);
		
		JPanel p2 = new JPanel ();
		p2.setLayout(new GridLayout (7,1));
		
		JPanel schoolPanel = new JPanel ();
		JLabel school = new JLabel ("School Management System");
		Font f2 = new Font ("Serif",Font.BOLD+Font.ITALIC,38);
		
		school.setFont(f2);
		schoolPanel.add(school);
		
		JPanel signPanel= new JPanel ();
		JLabel sign = new JLabel ("Sign in with your Organizational ID");
		Font font = new Font ("Serif",Font.BOLD+Font.ITALIC,35);
		sign.setFont(font);
		signPanel.add(sign);
		
		
		JPanel usernamePanel = new JPanel ();
		JLabel signin;
		Font signinfont = new Font ("Serif",Font.ITALIC+Font.BOLD,30);
		usernamePanel.add(signin = new JLabel ("Username "));
		signin.setFont(signinfont);
		usernamePanel.add(username = new JTextField(10));
		username.setFont(signinfont);;
		
		JPanel passwordPanel = new JPanel ();
		JLabel pass;
		
		passwordPanel.add(pass = new JLabel ("Password "));
		pass.setFont(signinfont);
		passwordPanel.add(password = new JPasswordField(10));
		password.setFont(signinfont);;
		
		JPanel p3 = new JPanel ();
		p3.add(login = new JButton("Login"));
		
		login.setFont(signinfont);
		p2.add(schoolPanel);
		p2.add(signPanel);
		p2.add(usernamePanel);
		p2.add(passwordPanel);
		p2.add(p3);
		
		/*schoolPanel.setBackground(Color.lightGray);
		signPanel.setBackground(Color.lightGray);
		usernamePanel.setBackground(Color.lightGray);
		passwordPanel.setBackground(Color.lightGray);
		p3.setBackground(Color.lightGray);
		p2.setBackground(Color.LIGHT_GRAY);*/
		outer.add(p2,BorderLayout.CENTER);
		
		
		//outer.add(p3,BorderLayout.PAGE_END);
		add(outer);
		//add (admin = new JButton("Admin"));
		
		/*JPanel p1 = new JPanel ();
		
		p1.add(admin = new JButton("Admin"));
		p1.setBackground(Color.BLUE);
		add(p1);
		
		JPanel p2 = new JPanel ();
		p2.setBackground(Color.red);
		p2.add(new JLabel ("Username : "));
		p2.add(username = new JTextField (15));
		add(p2);
		
		JPanel p3 = new JPanel ();
		p3.add(new JLabel ("Password: "));
		p3.add(password = new JPasswordField (15));
		add(p3);
		
		JPanel p4 = new JPanel ();
		p4.add(login = new JButton("Login"));
		add(p4);*/
		
		
		
	}
}