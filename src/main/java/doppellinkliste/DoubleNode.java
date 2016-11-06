package doppellinkliste;

public class DoubleNode {
	private Object content;
	private DoubleNode pred;
	private DoubleNode succ;
	

	public DoubleNode(Object content){
		this.content = content;
		pred = null;
		succ = null;
	}
	
	public Object getContent() {

		return content;
	}

	public DoubleNode getPred() {
		return pred;
	}

	public void setPred(DoubleNode pred) {

		this.pred = pred;
	}

	public DoubleNode getSucc() {

		return succ;
	}

	public void setSucc(DoubleNode succ) {

		this.succ = succ;
	}

	@Override
	public String toString() {

		return "DoubleNode [content=" + content + "]";
	}
}
