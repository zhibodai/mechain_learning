package com.yc.bean_11_LinkedList;

import java.util.Scanner;

class Data {
	String key; // ���Ĺؼ���
	String name;
	int age;
}

class LinkedListType // ��������ṹ
{
	Data nodeData = new Data();
	LinkedListType nextNode;

	LinkedListType append(LinkedListType head, Data nodeData) // ׷�ӽ��
	{
		LinkedListType node, htemp;
		if ((node = new LinkedListType()) == null) {
			System.out.print("�����ڴ�ʧ�ܣ�\n");
			return null; // �����ڴ�ʧ��
		}
		node.nodeData = nodeData; // ��������
		node.nextNode = null; // ���ý��ָ��Ϊ�գ���Ϊ��β
		if (head == null) // ͷָ��
		{
			head = node;
			return head;
		}
		htemp = head;
		while (htemp.nextNode != null) // ���������ĩβ
		{
			htemp = htemp.nextNode;
		}
		htemp.nextNode = node;
		return head;

	}

	LinkedListType addFirst(LinkedListType head, Data nodeData) {
		LinkedListType node;
		if ((node = new LinkedListType()) == null) {
			System.out.print("�����ڴ�ʧ�ܣ�\n");
			return null; // �����ڴ�ʧ��
		} else {
			node.nodeData = nodeData; // ��������
			node.nextNode = head; // ָ��ͷָ����ָ���
			head = node; // ͷָ��ָ���������
			return head;
		}
	}

	LinkedListType findNodeByKey(LinkedListType head, String key) // ���ҽ��
	{
		LinkedListType htemp;
		htemp = head; // ��������ͷָ��
		while (htemp != null) // �������Ч������в���
		{
			if (htemp.nodeData.key.compareTo(key) == 0) // �����ؼ����봫��ؼ�����ͬ
			{
				return htemp; // ���ظý��ָ��
			}
			htemp = htemp.nextNode; // ������һ���
		}
		return null; // ���ؿ�ָ��
	}

	LinkedListType insert(LinkedListType head, String findkey, Data nodeData) // ������
	{
		LinkedListType node, nodetemp;
		if ((node = new LinkedListType()) == null) // ���䱣���������
		{
			System.out.print("�����ڴ�ʧ�ܣ�\n");
			return null; // �����ڴ�ʧ��
		}
		node.nodeData = nodeData; // �������е�����
		nodetemp = findNodeByKey(head, findkey);
		if (nodetemp != null) // ���ҵ�Ҫ����Ľ��
		{
			node.nextNode = nodetemp.nextNode; // �²�����ָ��ؼ�������һ���
			nodetemp.nextNode = node; // ���ùؼ����ָ���²�����
		} else {
			System.out.print("δ�ҵ���ȷ�Ĳ���λ�ã�\n");
		}
		return head; // ����ͷָ��
	}

	int delete(LinkedListType head, String key) {
		LinkedListType node, htemp; // node����ɾ������ǰһ���
		htemp = head;
		node = head;
		while (htemp != null) {
			if (htemp.nodeData.key.compareTo(key) == 0) // �ҵ��ؼ��֣�ִ��ɾ������
			{
				node.nextNode = htemp.nextNode; // ʹǰһ���ָ��ǰ������һ���
				return 1;
			} else {
				node = htemp; // ָ��ǰ���
				htemp = htemp.nextNode; // ָ����һ���
			}
		}
		return 0; // δɾ��
	}

	int length(LinkedListType head) // ����������
	{
		LinkedListType htemp;
		int Len = 0;
		htemp = head;
		while (htemp != null) // ������������
		{
			Len++; // �ۼӽ������
			htemp = htemp.nextNode; // ������һ���
		}
		return Len; // ���ؽ������
	}

	void showAllNode(LinkedListType head) // ��������
	{
		LinkedListType htemp;
		Data nodeData;
		htemp = head;
		System.out.printf("��ǰ������%d����㡣���������������£�\n", length(head));
		while (htemp != null) // ѭ����������ÿ�����
		{
			nodeData = htemp.nodeData; // ��ȡ�������
			System.out.printf("���(%s,%s,%d)\n", nodeData.key, nodeData.name,
					nodeData.age);
			htemp = htemp.nextNode; // ������һ���
		}
	}

}

public class Test {

	public static void main(String[] args) {
		LinkedListType node, head = null;
		LinkedListType CL = new LinkedListType();
		String key, findkey;
		Scanner input = new Scanner(System.in);

		System.out.print("������ԡ������������е����ݣ���ʽΪ���ؼ��� ���� ����\n");
		do {
			Data nodeData = new Data();
			nodeData.key = input.next();
			if (nodeData.key.equals("0")) {
				break; // ������0�����˳�
			} else {
				nodeData.name = input.next();
				nodeData.age = input.nextInt();
				head = CL.append(head, nodeData);// ������β����ӽ��
			}
		} while (true);
		CL.showAllNode(head); // ��ʾ���н��

		System.out.printf("\n��ʾ�����㣬�������λ�õĹؼ��֣�");
		findkey = input.next(); // �������λ�ùؼ���
		System.out.print("��������������(�ؼ��� ���� ����):");
		Data nodeData = new Data();
		nodeData.key = input.next();
		nodeData.name = input.next();
		nodeData.age = input.nextInt();// �������������
		head = CL.insert(head, findkey, nodeData); // ���ò��뺯��
		CL.showAllNode(head); // ��ʾ���н��

		System.out.print("\n��ʾɾ����㣬����Ҫɾ���Ĺؼ���:");

		key = input.next(); // ����ɾ�����ؼ���
		CL.delete(head, key); // ����ɾ����㺯��
		CL.showAllNode(head); // ��ʾ���н��

		System.out.printf("\n��ʾ�������в��ң�������ҹؼ���:");
		key = input.next(); // ������ҹؼ���
		node = CL.findNodeByKey(head, key); // ���ò��Һ��������ؽ��ָ��
		if (node != null) // �����ؽ��ָ����Ч
		{
			nodeData = node.nodeData; // ��ȡ��������
			System.out.printf("�ؼ���%s��Ӧ�Ľ��Ϊ(%s,%s,%d)\n", key, nodeData.key,
					nodeData.name, nodeData.age);
		} else // �����ָ����Ч
		{
			System.out.printf("��������δ�ҵ��ؼ���Ϊ%s�Ľ�㣡\n", key);
		}

	}

}
