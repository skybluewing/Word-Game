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
		// 1.�ж�ԭʼ�ĵ��������ļ��Ƿ����
		File file = new File(WORD_FILE);
		BufferedReader br = null;
		Set<Word> words = new TreeSet<>();
		if (file.exists()) {
			// 2.����IO���е��ַ�����ѭ����������
			try {
				//br = new BufferedReader(new FileReader(file));
				br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
				while (br.ready()) {
					String input = br.readLine();
					// 2.1���δ��������ÿһ�����ݣ�ÿһ�ж�Ӧһ��Word����
					String[] inputs = input.split("\\s+");
					Word word = new Word(inputs[0], inputs[1]);
					// 2.2�Ѵ����õ�Word������ӵ�������
					words.add(word);
				}
				// 3.Ҫ����IO�쳣
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
		// 4.����
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
		// �˷����ǰ�Map�������л���ָ���ļ�����
		// ���ö��������Map��������л�
		// 1.����File����
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
		// 2.�жϴ�file�Ƿ����ļ�
		if (file.isFile()) {
			try {
				// 3.���ö��������д��
				oos = new ObjectOutputStream(new FileOutputStream(file));
				oos.writeObject(map);
				oos.flush();
				// 4.�����쳣
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
		// �˷����Ǵ�fileName�ж�ȡһ��Map����
		Map<String, String> map = null;
		ObjectInputStream ois = null;
		String HISTORY_DIR = "data/history";
		File file = new File(HISTORY_DIR,filename);
		// �ж�fileName�Ƿ����
		if (file.exists()) {
			// ����readObject����ֱ�Ӷ���
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
		// ��������
		return map;
	}

}
