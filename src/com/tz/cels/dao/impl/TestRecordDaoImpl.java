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
		//把测试记录持久化到指定的文件中
		ObjectOutputStream oos = null;
		try {
			//1.根据文件创建对象输出流
			oos = new ObjectOutputStream(new FileOutputStream(fileName));
			//2.调动持久化对象的方法
			oos.writeObject(records);
			//3.处理IO异常
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
		//从文件是读出持久化的对象数据
		ObjectInputStream ois = null;
		List<TestRecord> list = new ArrayList<>();
		File f=new File(fileName);
		if(f.length()==0){
			System.out.println("没有数据");
			List<TestRecord> temp = new ArrayList<>();
			return temp;
		}
			//1.根据文件创建对象输入流
			try {
				//2.调用读取对象的方法，并做强制类型转换
				ois = new ObjectInputStream(new FileInputStream(fileName));
				Object o = ois.readObject();
				list = (List<TestRecord>)o;
				//3.处理IO异常
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
		//4.返回
		return list;
	}
}
