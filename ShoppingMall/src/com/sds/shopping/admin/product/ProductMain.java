package com.sds.shopping.admin.product;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import com.sds.shopping.admin.main.AppMain;

public class ProductMain extends JPanel implements ItemListener, ActionListener, TableModelListener{
	// ����
	JPanel p_west;
	Choice ch_top, ch_sub;
	ImageIcon icon;
	JLabel la_img;
	JTextField t_productName;
	JTextField t_price;
	JTextField t_stock;
	JTextArea detail;
	JScrollPane scroll;
	JButton bt_regist;
	
	// ����
	JTable table;
	JScrollPane scroll2;
	ProductModel model;
	HashMap<String, Integer> topMap; // ����ī�װ� ������ ��� ���� ��
	HashMap<String, Integer> subMap; // ����ī�װ� ������ ��� ���� ��
	JFileChooser chooser;
	
	String savePath="C:/proudct_img"; // �̹��� ������ ����� ���!!
	FileInputStream fis;
	FileOutputStream fos;
	File file=null;
	
	
	public ProductMain() {
		// ����
		p_west = new JPanel();
		ch_top = new Choice();
		ch_sub = new Choice();
		icon = new ImageIcon(this.getClass().getClassLoader().getResource("onepiece.png"));
		la_img = new JLabel(icon);
		t_productName = new JTextField(10);
		t_price = new JTextField("0",10);
		t_stock = new JTextField("0",10);
		detail = new JTextArea(10,10);
		scroll = new JScrollPane(detail);
		bt_regist = new JButton("���");
		
		la_img.setPreferredSize(new Dimension(128, 128));
		// ������ ����
		t_productName.setHorizontalAlignment(SwingConstants.RIGHT);
		t_price.setHorizontalAlignment(SwingConstants.RIGHT);
		t_stock.setHorizontalAlignment(SwingConstants.RIGHT);
		
		ch_top.add("ī�װ� ����");
		ch_sub.add("ī�װ� ����");
		
		this.setLayout(new BorderLayout());
		
		p_west.add(ch_top);
		p_west.add(ch_sub);
		p_west.add(la_img);
		p_west.add(t_productName);
		p_west.add(t_price);
		p_west.add(t_stock);
		p_west.add(scroll);
		p_west.add(bt_regist);
		
		p_west.setPreferredSize(new Dimension(150, 550));
		add(p_west, BorderLayout.WEST);
		
		// ���Ϳ��� ����
		model = new ProductModel();
		table = new JTable(model);
		scroll2 = new JScrollPane(table);

		chooser = new JFileChooser("C:/Users/student/Downloads");
		add(scroll2);
		
		
		this.setPreferredSize(new Dimension
				(AppMain.CONTENT_WIDTH, AppMain.CONTENT_HEIGHT));
		
		// ���̽� ������Ʈ�� ������ ����
		ch_top.addItemListener(this);
		la_img.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int result=chooser.showOpenDialog(getParent());
				if(result==JFileChooser.APPROVE_OPTION){
					// c����̺��� ���������� �̹����� ��������!!
					
					// �Է½�Ʈ�� ����
					try {
						fis = new FileInputStream(file=chooser.getSelectedFile());
						// �� ���� ����!!
						fos = new FileOutputStream(savePath+"/"+file.getName());
						
						byte[] b = new byte[1024];
						int data;
						while((fis.read(b))!=-1){
							fos.write(b);
							fos.flush();
						}
						JOptionPane.showMessageDialog(getParent(), "��ϿϷ�");
						// �̹�������
						BufferedImage img=ImageIO.read(file); // �޸��� �ӵ����, ȿ������ ���ؼ� �̹����� ������ �� ���� ���δ�. 
						icon.setImage(img);
						la_img.updateUI(); // ������Ʈ ����
						
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					} finally {
						if(fos!=null){
							try {
								fos.close();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
						if(fis!=null){
							try {
								fis.close();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
					}
				}
			}
		});
		bt_regist.addActionListener(this);
		
		// ���̺�� ���콺 ������ ����
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row=table.getSelectedRow();
				int col=table.getSelectedColumn();
				System.out.println("�����"+row+","+col+"�� �ֱ���?");
			}
		});
		
		// ���̺�� �� �����ʿ��� ����
		table.getModel().addTableModelListener(this);
		
		topMap = new HashMap<String, Integer>();
		subMap = new HashMap<String, Integer>();
		
		getTopCategory();
	}
	
	// �ֻ��� ī�װ� ��� ��������
	public void getTopCategory(){
		Connection con = AppMain.getConnection();
		PreparedStatement pstmt=null;
		String sql = "select * from topcategory";
		
		ResultSet rs=null;
		
		// ���̽�������Ʈ�� ������ ä���!!
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				ch_top.add(rs.getString("title"));
				topMap.put(rs.getString("title"), rs.getInt("topcategory_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	// ���� ī�װ� ��� ��������
	public void getSubCategory(int subcategory_id){
		Connection con=AppMain.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql = "select * from subcategory where topcategory_id=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, subcategory_id);
			rs=pstmt.executeQuery();
			// ���� ���̽� ������ �����, subMap�� �����
			ch_sub.removeAll();
			subMap.clear();
			
			// ����ī�װ� ���̽� ������Ʈ ä���
			ch_sub.add("ī�װ� ����");
			while(rs.next()){
				ch_sub.add(rs.getString("title"));
				subMap.put(rs.getString("title"), rs.getInt("subcategory_id"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// ��ǰ���
	public void regist(){
		Connection con = AppMain.getConnection();
		PreparedStatement pstmt=null;
		
		// ��ȿ�� üũ, �Է��� ����� �ߴ��� ���θ� �˻�����
		// ��? �����ͺ��̽��� �� �������� ���Ἲ������!
		if(ch_top.getSelectedIndex()==0){
			JOptionPane.showMessageDialog(this, "����ī�װ��� �����ϼ���");
		}else if(ch_sub.getSelectedIndex()==0){
			JOptionPane.showMessageDialog(this, "����ī�װ��� �����ϼ���");
		}else if(t_productName.getText().length()==0){
			JOptionPane.showMessageDialog(this, "��ǰ���� �Է����ּ���");
			t_productName.requestFocus();
		}else if(t_price.getText().equals("0")){
			JOptionPane.showMessageDialog(this, "������ �Է��ϼ���");
			t_price.requestFocus();
		}else if(t_stock.getText().equals("0")){
			JOptionPane.showMessageDialog(this, "������ �Է��ϼ���");
			t_stock.requestFocus();
		}else if(detail.getText().length()==0){
			JOptionPane.showMessageDialog(this, "�󼼼����� �Է��ϼ���");
			detail.requestFocus();
		}else{
			JOptionPane.showMessageDialog(this, "DB�� �����Կ�");
			
			String sql = "insert into product(product_id, subcategory_id, product_name, price, stock, img, detail)";
			sql=sql +" values(seq_product.nextval,?,?,?,?,?,?)";
			
			try {
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, subMap.get(ch_sub.getSelectedItem()));
				pstmt.setString(2, t_productName.getText());
				pstmt.setInt(3, Integer.parseInt(t_price.getText()));
				pstmt.setInt(4, Integer.parseInt(t_stock.getText()));
				pstmt.setString(5, file.getName());
				pstmt.setString(6, detail.getText());
				
				int result=pstmt.executeUpdate();
				if(result!=0){
					JOptionPane.showMessageDialog(this, "��ϿϷ�");
					
					// ���̺� ������Ʈ
					model.selectAll();
					model.fireTableDataChanged();
					table.updateUI();
					
				} else {
					JOptionPane.showMessageDialog(this, "��Ͻ���");
				}				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				if(pstmt!=null){
					try {
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	// ���ڵ� 1�� ����
	public void update(){
		int row=table.getSelectedRow();
		int col=0;
		String product_id=(String)table.getValueAt(row, col);
		
		Connection con = AppMain.getConnection();
		PreparedStatement pstmt=null;
		
		String sql="update product set product_name=?, price=?, stock=?, detail=?";
		sql=sql+" where product_id=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, (String)table.getValueAt(row, 2));
			pstmt.setInt(2, Integer.parseInt((String)table.getValueAt(row, 3)));
			pstmt.setInt(3, Integer.parseInt((String)table.getValueAt(row, 4)));
			pstmt.setString(4, (String)table.getValueAt(row, 6));
			pstmt.setInt(5, Integer.parseInt((String)table.getValueAt(row, col)));
			
			int result = pstmt.executeUpdate();
			if(result!=0){
				JOptionPane.showMessageDialog(this, "�����Ϸ�");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// ���̽��� �������� �ٲ� ��, topcategory_id ���!!
		getSubCategory(topMap.get(ch_top.getSelectedItem()));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		regist();
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		System.out.println("���̺� ���� �ٲ��");
		update();
	}
}













