package r4r.unit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ExpirableArrayList<E> implements Serializable {

	private static final long serialVersionUID = -1723860067392748124L;
	private long timeToLiveInM;
	long time = System.currentTimeMillis();

	private class Element {

		E item;
		long expires;

		Element(E item, long expires) {
			this.item = item;
			this.expires = expires;
		}

	}

	private List<Element> contents = new ArrayList<>();

	private void expire() {

		contents.removeIf(el -> el.expires < time);
	}

	private boolean checkIsExpired(int index) {
		// long time = System.currentTimeMillis();
		Element el = contents.get(index);
		if (el.expires < time) {
			return true;
		} else
			return false;

	}

	private void resetTime(E item, int index) {

		contents.set(index, new Element(item, System.currentTimeMillis()
				+ timeToLiveInM));

	}

	public void add(E item, long timeToLive) {
		// expire();
		timeToLiveInM = timeToLive;
		contents.add(new Element(item, System.currentTimeMillis() + timeToLive));
	}

	public long size() {
		// expire();
		return contents.stream().filter(el -> el.expires > time).count();
	}

	public E get(int index) {
		// expire();
		E e = contents.get(index).item;
		if (!checkIsExpired(index)) {
			resetTime(e, index);
			return e;
		} else
			return null;
	}

	public E remove(int index) {
		// expire();
		E e = contents.get(index).item;
		if (!checkIsExpired(index)) {
			contents.remove(index);
			return null;
		} else
			return e;
	}

}