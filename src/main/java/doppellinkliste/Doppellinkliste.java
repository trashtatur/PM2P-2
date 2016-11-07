package doppellinkliste;

public class Doppellinkliste {
	private DoubleNode head;
	private DoubleNode tail;

	/**
	 * Creates a doublellinkedlist. Set head.succ to tail and tail.pred to head.
	 */
	public Doppellinkliste() {
		head = new DoubleNode(null);
		tail = new DoubleNode(null);
		head.setSucc(tail);
		tail.setPred(head);
	}

	/**
	 * Adds an Object to the list.
	 * 
	 * @param content
	 *            expects an Object
	 */
	public void add(Object content) {
		DoubleNode newContent = new DoubleNode(content);
		newContent.setPred(tail.getPred());
		newContent.setSucc(tail);
		tail.getPred().setSucc(newContent);
		tail.setPred(newContent);
	}

	public Object get(int index) {
		if (index < 0)
			throw new IndexOutOfBoundsException();
		DoubleNode snail = head;
		for (int i = 0; i < index; ++i) {
			if (snail.getSucc() == tail)
				throw new IndexOutOfBoundsException();
			snail = snail.getSucc();
		}
		return snail.getContent();
	}

	public int indexOf(Object content) {
		DoubleNode snail = head;
		int i = -1;
		while (snail != tail) {
			++i;
			if (snail.getSucc().equals(content))
				return i;
			snail = snail.getSucc();
		}
		return -1;
	}

	public void insert(int index, Object content) {
		if (index < 0)
			throw new IndexOutOfBoundsException();
		DoubleNode snail = head;
		for (int i = 0; i < index; ++i) {
			snail = snail.getSucc();
			if (snail == head)
				throw new IndexOutOfBoundsException();
		}
		DoubleNode newContent = new DoubleNode(content);
		newContent.setSucc(snail);
		newContent.setPred(snail.getSucc());
		snail.getSucc().setPred(newContent);
		snail.setSucc(newContent);
	}

	public boolean isEmtpy() {
		return head.getSucc() != tail;
	}

	public int size() {
		int i = 0;
		DoubleNode snail = head;
		while (snail.getSucc() != tail) {
			++i;
			snail = snail.getSucc();
		}
		return i;
	}

	boolean remove(Object content) {
		DoubleNode snail = head;
		while (snail.getSucc() != tail) {
			if (snail.getContent().equals(content)) {
				snail.getPred().setSucc(snail.getSucc());
				snail.getSucc().setPred(snail.getPred());
				return true;
			}
		}
		return false;
	}

	public void removeFirst() {
		if (head.getSucc() != tail) {
			head.setSucc(head.getSucc().getSucc());
			head.getSucc().setPred(head);
		}
	}

	public void removeLast() {
		if (tail.getPred() != head) {
			tail.setPred(tail.getPred().getPred());
			tail.getPred().setSucc(tail);
		}
	}

	@Override
	public String toString() {
		return "Doppellinkliste [head=" + head + ", toString()=" + super.toString() + "]";
	}

}
