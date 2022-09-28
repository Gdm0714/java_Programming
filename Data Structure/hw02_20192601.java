package hw02;

class Stack {
	int[] st;
	int top;
	int index;

	public Stack(int top) {
		index = -1;
		this.top = top;
		st = new int[top];
	}

	public boolean full() {
		if (top - 1 == index) {
			return true;
		}
		return false;
	}

	public boolean empty() {
		if (index == -1) {
			return true;
		}
		return false;
	}

	public boolean push(int n) {
		if (index < top) {
			st[++index] = n;
			return true;
		}
		return false;
	}

	public int pop(int n) {
		if (index > -1) {
			n = st[index--];
			return n;
		}
		return 0;
	}

	public int peek() {
		return st[index];
	}

	public void print() {
		System.out.println("printQueue����");
		for (int i = 0; i < index; i++) {
			System.out.print(st[i] + " ");
		}
		System.out.println();
	}
}

class Queue {
	int[] qu;
	int top;
	int index;
	Stack st, st2;

	public void create() {
		st = new Stack(10);
		st2 = new Stack(10);
	}

	public void init() {
		int num = 0;
		for (int i = 0; i < st.index; i++) {
			st.pop(num);
			st2.pop(num);
		}
	}

	public boolean is_empty() {
		if (st.empty())
			return true;
		return false;
	}

	public boolean is_full() {
		if (st.full())
			return true;
		return false;
	}

	public boolean enqueue(int num) {
		if (st.push(num))
			return true;
		return false;
	}

	public int dequeue(int num) {
		if (st2.empty()) {//st2������ ���������
			while (!st.empty()) {//st������ ������� �ʴٸ�
				st2.push(st.pop(num));//st���ÿ��� ���� ���� st2���ÿ� Ǫ��
			}
		}
		return st2.pop(num);//�ٽ� st2������ ���ϸ� ť������ dequeue�� ������.
	}
	public void printQueue() {
		st.print();
	}
}

public class hw02_20192601 {
	public static void main(String[] args) {
		Stack stack = new Stack(10);
		int num = 0;
		;
		if (stack.empty())
			System.out.println("stack empty");

		for (int i = 1; i <= 10; i++) {
			if (stack.push(i)) {
				System.out.print(i + "push�Ϸ�" + ", ");
				System.out.println(stack.peek());
			}
		}
		if (stack.full())
			System.out.println("stack full");

		for (int i = 0; i < 10; i++) {
			if (i < 9)
				System.out.print(stack.pop(num) + "pop �Ϸ�, ");
			else
				System.out.println(stack.pop(num) + "pop �Ϸ�");
		}
		if (stack.empty())
			System.out.println("stack empty");
		Queue q = new Queue();
		q.create();
		if(q.is_empty())
			System.out.println("Queue empty");
		for (int i = 1; i <= 10; i++) {
			if (q.enqueue(i))
				if (i < 9)
					System.out.print(i + "enqueue�Ϸ�" + ", ");
				else 
					System.out.println(i + "enqueue�Ϸ�");
				
		}
		q.printQueue();
		if (q.is_full())
			System.out.println("Queue full");
		for (int i = 0; i < 10; i++) {
			if (i < 9)
				System.out.print(q.dequeue(num) + "dequeue �Ϸ�, ");
			else
				System.out.println(q.dequeue(num) + "dequeue �Ϸ�");
		}
		
	}
}
