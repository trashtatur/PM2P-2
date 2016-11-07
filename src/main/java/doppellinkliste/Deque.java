package doppellinkliste;

import java.util.NoSuchElementException;

public class Deque {
	private DoubleNode head;
	private DoubleNode tail;

	public Deque() {
		head = new DoubleNode(null);
		tail = new DoubleNode(null);
		head.setSucc(tail);
		tail.setPred(head);
	}
	
	public void pushLeft(Object o){
		DoubleNode temp = new DoubleNode(null);
		temp.setSucc(head.getSucc());
		head.getSucc().setPred(temp);
		head.setSucc(temp);
	}
	
	public void pushRight(Object o){
		DoubleNode temp = new DoubleNode(o);
		temp.setPred(tail.getPred());
		tail.getPred().setSucc(tail);
		tail.setPred(temp);
	}
	
	public Object popLeft(){
		if(head.getSucc() == tail){
			throw new NoSuchElementException();
		}
		Object o = head.getSucc().getContent();
		head.setSucc(head.getSucc().getSucc());
		head.getSucc().setPred(head);
		return o;
	}
	
	public Object popRight(){
		if(tail.getPred() == head){
			throw new NoSuchElementException();
		}
		Object o = tail.getPred().getContent();
		tail.setPred(tail.getPred().getPred());
		tail.getPred().setSucc(tail);
		return o;
	}
	
	public Object peekLeft(){
		if(head.getSucc() == tail){
			throw new NoSuchElementException();
		}
		return head.getSucc().getContent();
	}
	
	public Object peekRight(){
		if(tail.getPred() == head){
			throw new NoSuchElementException();
		}
		return tail.getPred().getContent();
	}
	
	public int size(){
		int i = 0;
		DoubleNode snail = head;
		while (snail.getSucc() != tail) {
			++i;
			snail = snail.getSucc();
		}
		return i;
	}
	
	public boolean isEmpty(){
		return head.getSucc() != tail;
	}
}
