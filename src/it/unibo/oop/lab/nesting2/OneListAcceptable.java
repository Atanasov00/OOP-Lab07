package it.unibo.oop.lab.nesting2;

import java.util.LinkedList;
import java.util.List;

public class OneListAcceptable<T> implements Acceptable<T> {

	
	private List<T> list = null;
	
	public OneListAcceptable(final List<T> list) {
		this.list = new LinkedList(list);
	}
	
	@Override
	public Acceptor<T> acceptor() {
		return new AcceptorList<T>();
	}
	
	private class AcceptorList<T> implements Acceptor<T>{

		@Override
		public void accept(T newElement) throws ElementNotAcceptedException{
			if(!list.contains(newElement)) {
				throw new ElementNotAcceptedException(newElement);
			}
			
		}

		@Override
		public void end() throws EndNotAcceptedException {
			throw new EndNotAcceptedException();
		}
		
	}

}
