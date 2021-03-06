// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    private Integer next;
    private Iterator<Integer> itr;
    private boolean hasNext = true;
 
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.{
        itr = iterator;
        next = itr.next();
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return next;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        if (hasNext) {
            Integer temp = next;
            next = itr.hasNext()? itr.next(): null;
            if (!itr.hasNext() && next == null) hasNext = false;
            return temp;
        } else {
            return next;
        }
	}
    
    @Override
    public boolean hasNext() {
        return hasNext;
    }
}
