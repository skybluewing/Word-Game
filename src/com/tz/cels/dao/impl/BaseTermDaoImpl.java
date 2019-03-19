package com.tz.cels.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.tz.cels.dao.IBaseTermDao;
import com.tz.cels.entity.Vocabulary;
import com.tz.cels.entity.Word;

public class BaseTermDaoImpl implements IBaseTermDao {

	@Override
	public Set<Word> getAllWords() {
		// 1.判断原始的单词数据文件是否存在
		File file = new File(WORD_FILE);
		BufferedReader br = null;
		Set<Word> words = new TreeSet<>();
		if (file.exists()) {
			// 2.利用IO流中的字符流来循环读到数据
			try {
				//br = new BufferedReader(new FileReader(file));
				br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
				while (br.ready()) {
					String input = br.readLine();
					// 2.1依次处理读到的每一行数据，每一行对应一个Word对象
					String[] inputs = input.split("\\s+");
					Word word = new Word(inputs[0], inputs[1]);
					// 2.2把创建好的Word对象添加到集合中
					words.add(word);
				}
				// 3.要处理IO异常
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		// 4.返回
		return words;
	}

	@Override
	public Set<Vocabulary> getAllvocabularies() {
		File file = new File(VOCABULARY_FILE);
		Set<Vocabulary> vSet = new TreeSet<>();
		BufferedReader br = null;
		if (file.exists()) {
			try {
				br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
				while (br.ready()) {
					String input = br.readLine();
					String[] inputs = new String[3];
					String[] splits = input.split("#");
					System.arraycopy(splits, 0, inputs, 0, splits.length);
					String acronym = inputs[2];
					if (null == acronym) {
						acronym = "";
					}
					Vocabulary vocabulary = new Vocabulary(inputs[0], inputs[1], acronym);
					vSet.add(vocabulary);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return vSet;
	}

	@Override
	public void writeToFile(Map<String, String> map, String filename) {
		// 此方法是把Map对象序列化到指定文件名中
		// 利用对象流完成Map对象的序列化
		// 1.创建File对象
		String HISTORY_DIR = "data/history";
		File file = new File(HISTORY_DIR, filename);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		ObjectOutputStream oos = null;
		// 2.判断此file是否是文件
		if (file.isFile()) {
			try {
				// 3.利用对象流完成写入
				oos = new ObjectOutputStream(new FileOutputStream(file));
				oos.writeObject(map);
				oos.flush();
				// 4.处理异常
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (oos != null){
					try {
						oos.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, String> readFromFile(String filename) {
		// 此方法是从fileName中读取一个Map对象
		Map<String, String> map = null;
		ObjectInputStream ois = null;
		String HISTORY_DIR = "data/history";
		File file = new File(HISTORY_DIR,filename);
		// 判断fileName是否存在
		if (file.exists()) {
			// 调用readObject方法直接读到
			try {
				ois = new ObjectInputStream(new FileInputStream(file));
				Object o = ois.readObject();
				map = (Map<String, String>)o;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		}
		// 正常返回
		return map;
	}

}
