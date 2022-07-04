package ex1;

public class VectorGeneric<T> {
	private T[] vec;		
	private int nElem;	      
	private final static int ALLOC = 50;   
	private int dimVec = ALLOC;     

	@SuppressWarnings("unchecked")
	public VectorGeneric() {
		vec = (T[]) new Object[dimVec];
		nElem = 0;
	}
	
	public boolean addElem(T elem) {
		if (elem == null)
			return false;
		ensureSpace();
		vec[nElem++] = elem;
		return true;
	}

	private void ensureSpace() {
		if (nElem>=dimVec) {
			dimVec += ALLOC;
			@SuppressWarnings("unchecked")
			T[] newArray = (T[]) new Object[dimVec];
			System.arraycopy(vec, 0, newArray, 0, nElem );
			vec = newArray;
		}
	}

	public boolean removeElem(T elem) {
		for (int i = 0; i < nElem; i++) {
			if (vec[i].equals(elem)) {
				if (nElem-i-1 > 0) // not last element
					System.arraycopy(vec, i+1, vec, i, nElem-i-1 );
				vec[--nElem] = null; // libertar último objecto para o GC
				return true;
			}
		}
		return false;
	}

	public int totalElem() {
		return nElem;
	}
	
	public T getElem(int i) {
		return (T) vec[i];
	}

	public class Iterator<T> implements java.util.Iterator<T> {
			public Iterator() {
				this.i = 0;
			}
			private int i = 0;
			
			public boolean hasNext() {
				return i < nElem;
			}

			
			public T next() {
				if(hasNext()){
					return (T) vec[i++];
				}
				throw new IndexOutOfBoundsException("No more elements");
			}


			public void remove() {
				throw new UnsupportedOperationException("Operação remove não é permitida");
			}
	}
	

	public class ListIterator<T> implements java.util.ListIterator<T>{
		
			private int i = 0;

			public ListIterator() {
				this.i = 0;
			}

			public ListIterator(int i) {
				this.i = i;
			}

			public boolean hasNext() {
				return i < nElem;
			}


			public T next() {
				if(hasNext()){
					return (T) vec[i++];
				}
				throw new IndexOutOfBoundsException("No more elements");
			}

			
			public void remove() {
				throw new UnsupportedOperationException("Operação remove não é permitida");
			}

			
			public void add(T e) {
				throw new UnsupportedOperationException("Operação add não é permitida");
			}

			
			public boolean hasPrevious() {
				return i > 0;
			}

			
			public T previous() {
				if(hasPrevious()){
					return (T) vec[--i];
				}
				throw new IndexOutOfBoundsException("No more elements");
			}

			
			public int nextIndex() {
				if(hasNext()){
					return i;
				}
				throw new IndexOutOfBoundsException("No more elements");

			}

			
			public int previousIndex() {
				if(hasPrevious()){
					return i-1;
				}
				throw new IndexOutOfBoundsException("No more elements");
			}

			
			public void set(T e) {
				throw new UnsupportedOperationException("Operação set não é permitida");
			}
		

	}

	public Iterator<T> Iterator() {
		return new Iterator<T>();
	}

	public ListIterator<T> listIterator() {
		return new ListIterator<T>();
	}

	public ListIterator<T> listIterator(int i) {
		return new ListIterator<T>(i);
	}


}
