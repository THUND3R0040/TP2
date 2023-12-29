import java.util.ArrayList;
import java.util.List;

public class CustomStack {
    private int capacity;
    private List<Integer> stack;

    public CustomStack(int capacity) {
        this.capacity = capacity;
        this.stack = new ArrayList<>();
    }

    public void addElement(int element) {
        if (stack.size() < capacity) {
            stack.add(element);
            System.out.println("Added " + element + " to the stack.");
        } else {
            System.out.println("Stack is full. Cannot add element.");
        }
    }

    public void removeElement() {
        if (stackIsEmpty()) {
            System.out.println("Stack is empty. Cannot remove element.");
        } else {
            int removedElement = stack.remove(stack.size() - 1);
            System.out.println("Removed " + removedElement + " from the stack.");
        }
    }

    public int lastInStack() {
        if (stackIsEmpty()) {
            System.out.println("Stack is empty.");
            return -1; // You can choose a different value to indicate an error or use an exception.
        } else {
            return stack.get(stack.size() - 1);
        }
    }

    public boolean stackIsEmpty() {
        return stack.isEmpty();
    }

    public boolean stackIsFull() {
        return stack.size() == capacity;
    }

    public static void main(String[] args) {
        int stackCapacity = 5;
        CustomStack customStack = new CustomStack(stackCapacity);

        customStack.addElement(1);
        customStack.addElement(2);
        customStack.addElement(3);
        customStack.addElement(4);
        customStack.addElement(5);

        System.out.println("Last element in the stack: " + customStack.lastInStack());

        customStack.addElement(6); // Trying to add to a full stack

        customStack.removeElement();
        customStack.removeElement();
        customStack.removeElement();
        customStack.removeElement();
        customStack.removeElement();

        System.out.println("Is stack empty? " + customStack.stackIsEmpty());
        System.out.println("Is stack full? " + customStack.stackIsFull());
    }
}
