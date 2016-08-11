package com.sds.file;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.ShutdownChannelGroupException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FileCopyApp extends JFrame implements ActionListener {
	JLabel lb1, lb2;
	JTextField txt1, txt2;
	JButton bt1, bt2, bt3;
	JPanel p_north, p_center, p_south;
	JFileChooser chooser;
	FileInputStream fis;
	FileOutputStream fos;
	File file_open, file_save;
	String path_open, path_save;

	public FileCopyApp() {
		lb1 = new JLabel("원본");
		lb2 = new JLabel("경로");

		txt1 = new JTextField(20);
		txt2 = new JTextField(20);

		bt1 = new JButton("open");
		bt2 = new JButton("save");
		bt3 = new JButton("실행");

		// 오픈버튼과 리스터 연결
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);

		p_north = new JPanel();
		p_center = new JPanel();
		p_south = new JPanel();

		// chooser 생성!
		chooser = new JFileChooser();

		p_north.add(lb1);
		p_north.add(txt1);
		p_north.add(bt1);

		p_center.add(lb2);
		p_center.add(txt2);
		p_center.add(bt2);

		p_south.add(bt3);

		add(p_north, BorderLayout.NORTH);
		add(p_center);
		add(p_south, BorderLayout.SOUTH);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 150);
		setVisible(true);
	}

	// 파일오픈 메서드 만들기!!
	public void openFile() {
		int result = chooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			file_open = chooser.getSelectedFile();
			path_open = file_open.getAbsolutePath();
			txt1.setText(path_open);
		}
	}

	public void saveFile() {
		int result = chooser.showSaveDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			file_save = chooser.getSelectedFile();
			path_save = file_save.getAbsolutePath();
			txt2.setText(path_save);
		}
	}

	// 복사실행 함수 만들기!!
	public void copyFile() {
		try {
			fis = new FileInputStream(path_open);
			fos = new FileOutputStream(path_save);
			int data;
			while ((data = fis.read()) != -1) {
				fos.write(data);
			}
			JOptionPane.showMessageDialog(this, "복사가 완료되었습니다.");
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다.");
		} catch (IOException e) {
			System.out.println("파일 읽기 에러");
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
				}
			}
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(bt1)) {
			openFile();
		} else if (obj.equals(bt2)) {
			saveFile();
		} else if (obj.equals(bt3)) {
			copyFile();
		}
	}

	public static void main(String[] args) {
		new FileCopyApp();

	}

}
