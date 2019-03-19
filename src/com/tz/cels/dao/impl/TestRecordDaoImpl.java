package com.tz.cels.dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.tz.cels.dao.ITestRecordDao;
import com.tz.cels.entity.TestRecord;

public class TestRecordDaoImpl implements ITestRecordDao {

	@Override
	public void write(List<TestRecord> records, String fileName) {
		//�Ѳ��Լ�¼�־û���ָ�����ļ���
		ObjectOutputStream oos = null;
		try {
			//1.�����ļ��������������
			oos = new ObjectOutputStream(new FileOutputStream(fileName));
			//2.�����־û�����ķ���
			oos.writeObject(records);
			//3.����IO�쳣
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (oos != null){
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	@Override
	public List<TestRecord> read(String fileName) {
		//���ļ��Ƕ����־û��Ķ�������
		ObjectInputStream ois = null;
		List<TestRecord> list = new ArrayList<>();
		File f=new File(fileName);
		if(f.length()==0){
			System.out.println("û������");
			List<TestRecord> temp = new ArrayList<>();
			return temp;
		}
			//1.�����ļ���������������
			try {
				//2.���ö�ȡ����ķ���������ǿ������ת��
				ois = new ObjectInputStream(new FileInputStream(fileName));
				Object o = ois.readObject();
				list = (List<TestRecord>)o;
				//3.����IO�쳣
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				if (ois != null){
					try {
						ois.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		//4.����
		return list;
	}
}
