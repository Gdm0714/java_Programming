package Homework3;


class Node {
    int data;
    Node link;

    public Node(int data) {
        this.data = data;
        this.link = null;
    }

    public int getData() {
        return data;
    }
}

class List {
    Node head;
    Node stop;

    public List() {
        head = null;
    }

    public void insert(int pos, int item) {
        Node node = new Node(item);
        Node pre = head;
        for (int i = 1; i < pos - 1; i++) {
            pre = pre.link;
        }
        node.link = pre.link;
        pre.link = node;
    }

    public void insert_last(int item) {
        Node node = new Node(item);
        if (head != null) {
            Node tmp = head;
            while (tmp.link != null) {
                tmp = tmp.link;
            }
            tmp.link = node;
        } else {
            head = node;

        }

    }

    public void insert_first(int item) {
        Node node = new Node(item);
        node.link = head;
        head = node;
    }

    public void delete(int pos) {
        Node node = head;
        Node pre = null;
        for (int i = 1; i < pos; i++) {
            pre = node;
            node = node.link;
        }
        pre.link = node.link;
    }

    public void clear() {
        Node node = head;
        while (node.link != null) {
            node = null;
            node = node.link;
        }
    }

    public int get_entry(int pos) {
        Node node = head;
        for (int i = 0; i < pos; i++) {
            node = node.link;
        }
        int num = node.getData();
        return num;
    }

    public int get_length() {
        Node node = head;
        int count = 1;
        while (node.link != null) {
            node = node.link;
            count++;
        }
        return count;
    }

    public boolean is_empty() {
        if (head == null) {
            return true;
        }
        return false;
    }

    public boolean is_full() {
        Node node = head;
        int count = 0;
        while (node.link != null) {
            if (node == null) {
                return false;
            }
            node = node.link;
        }
        return true;
    }

    public void print_list() {
        Node node = head;
        System.out.print("Linked List : ");
        while (node.link != null) {
            System.out.print(node.getData() + "->");
            node = node.link;
        }
        System.out.println(node.getData() + "->");
    }

    public void changenode(int data) {
        Node node = head;
        Node result = head;
        while (node.link != null) {
            node = node.link;
        }
        while (result.link != null) {
            if (result.getData() == data) {
                node.link = result;
                stop = node.link;
                break;
            }
            if (result.getData() != data) {
                result = result.link;
            }
        }
        node.link = result;
    }

    public int hasCycle() {//한번에 하나의 노드를 이동하는 noed1과 두개의 노드를 이동하는 node2가 만나면 cycle 만나지 않으면 No cycle이다.
        Node node1 = head;//
        Node node2 = head.link;
        while (node2 != null && node2.link != null) {
            if (node1 == node2) return 1;
            node1 = node1.link;
            node2 = node2.link.link;
        }
        return 0;
        /*int count = 0;
        int size = 1;
        while(node.link != null){
            node = node.link;
            size++;
        }
        int []num = new int[size];
        while(result.link != null){
            num[count++] = result.getData();
            result = result.link;
        }
        if(result.link == null){
            return 0;
        }
        for(int i = 0; i<num.length; i++){
            if(node.getData() == num[i])
                return 1;
        }
        return 1;*/
    }

    public void printcycle() {
        Node node = head;
        while(node != stop){
            System.out.print(node.getData() + "->");
            node = node.link;
        }
        System.out.print(node.getData() + "->");
        node = node.link;
        while (node != stop) {
            System.out.print(node.getData() + "->");
            node = node.link;
        }
        System.out.println(node.getData() + "->");
    }
}

public class LinkedList {
    public static void main(String[] args) {
        List list = new List();
        List cycle = new List();
        if (list.is_empty())
            System.out.println("리스트가 비었음");//is_empty()를 이용해 리스트가 비었는지 확인
        list.insert_last(20);
        list.insert_last(30);
        list.insert_last(40);
        list.insert_last(50);
        list.insert_first(10);//20->30->40->50 의 첫번째에 10 추가

        list.print_list();
        if (list.is_full())
            System.out.println("리스트가 꽉 차있음");//is_full()을 이용해 리스트가 차있는지 확인
        if (list.hasCycle() == 0) {//hasCycle()이 0을 반환하면 사이클이아니고 1을 반환하면 사이클임.
            System.out.println("No cycle !");
        } else {
            System.out.println("Cycle!");
        }
        System.out.println("2번째 data는" + list.get_entry(1));
        System.out.println("리스트의 길이는" + list.get_length());
        list.delete(2);//2번째 데이타 20을 삭제.
        System.out.println("20을 삭제한 리스트 출력");
        list.print_list();
        list.insert(2, 20);
        System.out.println("다시 20을 추가한 리스트 출력");
        list.print_list();

        cycle.insert_last(10);
        cycle.insert_last(20);
        cycle.insert_last(30);
        cycle.insert_last(40);
        cycle.insert_last(50);
        cycle.changenode(20);//마지막노드의 link를 데이타 20을 갖고있는 노드로 연결
        System.out.println("마지막노드의 link를 데이타가 20인 곳에 연결한 리스트");
        cycle.printcycle();
        if (cycle.hasCycle() == 0) {
            System.out.println("No cycle !");
        } else {
            System.out.println("Cycle!");
        }

    }
}
