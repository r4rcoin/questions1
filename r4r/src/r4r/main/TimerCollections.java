package r4r.main;

import r4r.unit.ExpirableArrayList;


public class TimerCollections {

	public static <E> void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// PassiveExpiringMap
		System.err.println("Test Exprired Collection..");

		ExpirableArrayList<E> arrayList = new ExpirableArrayList();
		arrayList.add((E) new String("qq"), 5);
		Thread.sleep(5);
		//System.err.println(arrayList.remove(0));
		System.err.println(arrayList.get(0));
	}

}
// https://commons.apache.org/proper/commons-collections/apidocs/org/apache/commons/collections4/map/PassiveExpiringMap.html
