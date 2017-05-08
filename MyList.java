/**
 * Created by vikrantyadav on 5/8/17.
 */
public class MyList {


    /**
     * Holds the integer value
     */
    private int value;

    /**
     * Hold the reference to next element
     */
    private MyList next;

    /**
     * Keep track whether list is empty;
     */
    private boolean empty = true;


    public boolean isEmpty(){
        return this.empty;
    }


    /**
     * Append an element into the linkedlist
     * @param value
     */
    public void add(int value) {

        // First Time Case
        if (this.isEmpty()) {
            this.value = value;
            this.empty = false;
            return;
        }

        //  Not first Item. Start traversing.
        MyList currentItem = this;
        while (true) {
            // Check if it's a last element
            if (currentItem.next == null) {
                // Create new item and assign the reference to current item.
                MyList nextItem = new MyList();
                nextItem.value = value;
                currentItem.next = nextItem;
                break;
            }else{
                currentItem = currentItem.next;
            }
        }
    }


    /**
     * Remove all element in the linkedlist that is great than a target value
     * @param value
     */
    public void removeMoreThan(int value) {

        // Empty Case
        if (this.isEmpty()) {
            return;
        }

        // Now traverse
        MyList current = this;
        while (true) {
            // If next element is null then we have reached end of the list
            if (current.next == null) {
                break;
            }
            // Evaluate next element value so that current element reference is updated to next.next element
            if (current.next.value > value) {
                // Candidate Found for removal
                MyList next =  current.next;
                current.next = next.next;
            }else{
                current = current.next;
            }

        }

        // First element handling.
        // Only next elements were evaluated so far..
        if (this.value > value) {
            // Move Next element to first position and discard next.
            if (this.next != null) {
                // More than one element case
                this.value = this.next.value;
                this.next = this.next.next;
            }else{
                // Only one element so empty out the list
                this.value = 0;
                this.empty = true;

            }
        }



    }

    /**
     * Remove the tail element from a linkedlist
     */
    public void removeLast() {
        // Nothing to remove
        if (this.isEmpty()) {
           return;
        }
        // Only one element
        if (!this.isEmpty() && this.next == null) {
            this.value = 0;
            this.empty = true;
            return;
        }

        // Traverse till last item and set it to null;
        // Code execute for 2 and more elements.
        MyList currentItem = this;
        while (true) {
            // Check if the next item is last
            if (currentItem.next.next == null) {
                // Candidate for removal.
                // Remove reference to next element
                currentItem.next = null;
                break;
            }else{
                // Keep moving up the list
                currentItem = currentItem.next;
            }
        }
    }


    /**
     *
     * @return
     */
    public String toString(){
        StringBuffer s = new StringBuffer();
        s.append("[");
        if (!this.empty) {
            MyList next = this;
            boolean isFirst = true;
            while (true) {
                if (next == null) {
                    break;
                }
                if (!isFirst) {
                    s.append(",");
                }
                s.append(next.value);
                isFirst = false;
                next = next.next;
            }
        }
        s.append("]");
        return s.toString();
    }



}
