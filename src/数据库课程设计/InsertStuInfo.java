package ���ݿ�γ����;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InsertStuInfo  extends JFrame implements ActionListener{
	JLabel jl1=null;
	 JTextField jt1,jt2,jt3,jt4,jt5,jt6,jt7,jt8=null;
	 JPanel jp1,jp2,jp3,jp4,jp5,jp6,jp7,jp8,jp9,jp=null;
	 String username,mima,num,stuname,math,chinese,english,zhengzhi;
	 JButton jb1=null;
    public InsertStuInfo () {
	    jt1=new JTextField("�û���");
	    jt2=new JTextField("����");
	    jt3=new JTextField("ѧ��");
	    jt4=new JTextField("����");
	     jt5=new JTextField("��ѧ�ɼ�");
	     jt6=new JTextField("���ĳɼ�");
	     jt7=new JTextField("Ӣ��ɼ�");
	     jt8=new JTextField("���γɼ�");
	     jp1=new JPanel();
	     jp2=new JPanel();
	     jp3=new JPanel();
	     jp4=new JPanel();
	     jp5=new JPanel();
	     jp6=new JPanel();
	     jp7=new JPanel();
	     jp8=new JPanel();
	     jp9=new JPanel();
	     jp=new JPanel();
	     jp1.add(jt1);
	     jp2.add(jt2);
	     jp3.add(jt3);
	     jp4.add(jt4);
	     jp5.add(jt5);
	     jp6.add(jt6);
	     jp7.add(jt7);
	     jp8.add(jt8);
	     jb1=new JButton("���");
	     jb1.addActionListener(this);
	     jp9.add(jb1);
	     this.add(jp1);
	     this.add(jp2);
	     this.add(jp3);
	     this.add(jp4);
	     this.add(jp5);	
	     this.add(jp6);
	     this.add(jp7);
	     this.add(jp8);
	     this.add(jp9);
	     this.setLayout(new GridLayout(9,1));  
	       this.setTitle("ѧ���ɼ�����ϵͳ����ӳɼ�");  
	       this.setSize(500, 500);  
	       this.setLocation(150, 150);  
	       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	       this.setVisible(true);  
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("���")) {
			username=jt1.getText();
			mima=jt2.getText();
			num=jt3.getText();
			stuname=jt4.getText();
			math=jt5.getText();
			chinese=jt6.getText();
			english=jt7.getText();
			zhengzhi=jt8.getText();
			GetSQL.ConnectSQL();
			GetSQL.insertstu(username, mima, num, stuname, math, chinese, english, zhengzhi);
			this.dispose();
		}
			
	}
}
