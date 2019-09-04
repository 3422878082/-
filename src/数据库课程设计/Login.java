package ���ݿ�γ����;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
  JPanel jp1,jp2,jp3,jp4=null;//���
  JLabel username,userpassword,power=null;//��ǩ
  JButton Btnlogin,Btnreset,Btnexit=null;//��ť
  JTextField jtf=null;//�ı�
  JPasswordField jpf=null;//����
  JRadioButton jrb1,jrb2=null;  
  ButtonGroup bg=null;  
  
  //�˵���
  JMenuBar jMenuBar=null;
  JMenu jMenu=null;
  JMenuItem jmi1,jmi2=null;
  
  
  //�趨�û���������  
static String userword;
static String pwd;
 
  public static void main(String[] args) {
	Login ms=new Login();  
 }

public Login()
{
	

	Btnlogin=new JButton("��¼");
	Btnreset=new JButton("����");
	Btnexit=new JButton("�˳�");
	Btnlogin.addActionListener(this);
	Btnreset.addActionListener(this);
	Btnexit.addActionListener(this);
	
	jMenuBar=new JMenuBar();
	jMenu=new JMenu("ѡ��");
	jmi1=new JMenuItem("��ʼ");
	jmi2=new JMenuItem("�˳�ϵͳ");
	jMenu.add(jmi1);
	jMenu.add(jmi2);
	jMenuBar.add(jMenu);
	
    jrb1=new JRadioButton("��ʦ",true);  
    jrb2=new JRadioButton("ѧ��");  
    bg=new ButtonGroup();  
    bg.add(jrb1);  
    bg.add(jrb2);  
   // jrb2.setSelected(true); 
    jp1=new JPanel();
	jp2=new JPanel();
	jp3=new JPanel();
	jp4=new JPanel();
	username=new JLabel("�û���");
	userpassword=new JLabel("��  ��");
	power=new JLabel("Ȩ��");;
	jtf=new JTextField(10);	
	jpf=new JPasswordField(10);
	
	jp1.add(username);
	jp1.add(jtf);
	
	jp2.add(userpassword);
	jp2.add(jpf);
	
	jp3.add(power);
	jp3.add(jrb1);
	jp3.add(jrb2);
	
	jp4.add(Btnlogin);
	jp4.add(Btnreset);
	jp4.add(Btnexit);
	this.setJMenuBar(jMenuBar);
	this.add(jp1);
	this.add(jp2);
	this.add(jp3);
	this.add(jp4);
	
    //���ò��ֹ�����  
    this.setLayout(new GridLayout(4,1));  
    //���������ñ���  
    this.setTitle("ѧ���ɼ�����ϵͳ");  
    //���ô����С  
    this.setSize(300,250);  
    //���ô����ʼλ��  
    this.setLocation(200, 150);  
    //���õ��رմ���ʱ����֤JVMҲ�˳�  
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    //��ʾ����  
    this.setVisible(true);  
    this.setResizable(true);  
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
    if(e.getActionCommand()=="�˳�")
    	System.exit(0);
    else  if(e.getActionCommand()=="��¼")  
    {  
    	if(!jtf.getText().isEmpty()&&!jpf.getText().isEmpty())
    	{
    		GetSQL.ConnectSQL();
        if(jrb1.isSelected())
        {
        	GetSQL.querytea(jtf.getText());
        	if(GetSQL.pwd==null)
        	{
        		this.clear();
        	}else
        	{
        		this.tealogin();
        	}
        
        }else if(jrb2.isSelected())
        {
        	GetSQL.querystu(jtf.getText());
        	if(GetSQL.pwd==null)
        	{
        		this.clear();
        	}else
        	{
        		this.stulogin();
        	}
        }
    	}else if(jtf.getText().isEmpty())
    	{
    		JOptionPane.showMessageDialog(null, "�������û���", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
    		this.clear();
    	}else if(jpf.getText().isEmpty())
    	{
    		JOptionPane.showMessageDialog(null, "����������", "��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
    		this.clear();
    	}
    }
    else if(e.getActionCommand()=="����")  
    {
    	  this.clear();
    }
}


public void clear()
{
	jtf.setText("");
	jpf.setText("");
}


//��ʦ��¼�жϷ���
public void tealogin()
{
	if(GetSQL.pwd.equals(jpf.getText()))
	{
		JOptionPane.showMessageDialog(null, "��¼�ɹ�", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
		this.clear();
		dispose();
		Teacher t=new Teacher();
	}
	else if(jtf.getText().isEmpty()&&jpf.getText().isEmpty())
	{
		JOptionPane.showMessageDialog(null, "�������û���������", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
	}
	else if(jtf.getText().isEmpty())
	{
		 JOptionPane.showMessageDialog(null,"�������û�����","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
	}
	else if(jpf.getText().isEmpty())
	{
		  JOptionPane.showMessageDialog(null,"���������룡","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
    }
	else {
		  JOptionPane.showMessageDialog(null,"�û��������������\n����������","��ʾ��Ϣ",JOptionPane.ERROR_MESSAGE);  
          //��������  
          this.clear();  
	}
}
public void stulogin()
{
	if(GetSQL.pwd.equals(jpf.getText()))
	{
		JOptionPane.showMessageDialog(null, "��¼�ɹ�", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
	    this.clear();
	    dispose();
	    Stu_UI ui=new Stu_UI(jtf.getText());
	}
	else if(jtf.getText().isEmpty()&&jpf.getText().isEmpty())
	{
		JOptionPane.showMessageDialog(null, "�������û���������", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
	}
	else if(jtf.getText().isEmpty())
	{
		 JOptionPane.showMessageDialog(null,"�������û�����","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
	}
	else if(jpf.getText().isEmpty())
	{
		  JOptionPane.showMessageDialog(null,"���������룡","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
    }
	else {
		  JOptionPane.showMessageDialog(null,"�û��������������\n����������","��ʾ��Ϣ",JOptionPane.ERROR_MESSAGE);  
          //��������  
          this.clear();  
	}
}

  
}
