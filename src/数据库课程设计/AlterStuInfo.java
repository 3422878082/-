package ���ݿ�γ����;

import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class AlterStuInfo extends JFrame implements ActionListener{
	 JLabel jl1=null;
	 JTextField jt1,jt2,jt3,jt4=null;
	 JPanel jp1,jp2,jp3,jp4,jp5,jp=null;
	 String math,chinese,english,zhengzhi;
	 JButton jb1=null;
	 String stunum;
     public AlterStuInfo (String num) {
	     GetSQL.ConnectSQL();	
	     GetSQL.querystu(num);
	     stunum=num;
	     jl1=new JLabel("ѧ������");
	     jt1=new JTextField("��ѧ�ɼ�");
	     jt2=new JTextField("���ĳɼ�");
	     jt3=new JTextField("Ӣ��ɼ�");
	     jt4=new JTextField("���γɼ�");
	     jp1=new JPanel();
	     jp2=new JPanel();
	     jp3=new JPanel();
	     jp4=new JPanel();
	     jp5=new JPanel();
	     jp=new JPanel();
	     jp1.add(jt1);
	     jp2.add(jt2);
	     jp3.add(jt3);
	     jp4.add(jt4);
	     jb1=new JButton("�޸�");
	     jp5.add(jb1);
	     jb1.addActionListener(this);
	     this.add(jp1);
	     this.add(jp2);
	     this.add(jp3);
	     this.add(jp4);
	     this.add(jp5);	 
	     this.setLayout(new GridLayout(6,1));  
	       this.setTitle("ѧ���ɼ�����ϵͳ���޸ĳɼ�");  
	       this.setSize(500, 500);  
	       this.setLocation(150, 150);  
	       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	       this.setVisible(true);  
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("�޸�")) {
			math=jt1.getText();
			chinese=jt2.getText();
			english=jt3.getText();
			zhengzhi=jt4.getText();
			GetSQL.ConnectSQL();
			GetSQL.alterstu(stunum, math, chinese, english,zhengzhi);
			this.dispose();
		}
			
	}
}
