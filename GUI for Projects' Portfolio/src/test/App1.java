package test;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App1 extends Applet implements ActionListener {
	
	int a,b,s;
	String str1,str2,str3;
	Label l1,l2,l3;
	TextField t1,t2,t3;
	Button b1,b2;
	
	public void init()
	{
		l1=new Label("Enter a");
		l2=new Label("Enter b");
		l3 =new Label("Result");
		t1=new TextField(10);
		t2=new TextField(10);
		t3=new TextField(10);
		b1=new Button("Sum");
		b2=new Button("Subtract");
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(b1);
		add(b2);
		add(l3);
		add(t3);
		b1.addActionListener(this);
		b2.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		str1=t1.getText();
		str2=t2.getText();
				a=Integer.parseInt(str1);
				b=Integer.parseInt(str2);
		if(e.getSource()==b1)
		{
			s=a+b;
			str3=String.valueOf(s);
			t3.setText(str3);
		}
		if(e.getSource()==b2)
		{
			s=a-b;
			str3=String.valueOf(s);
			t3.setText(str3);
		}
	}

}
