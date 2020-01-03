package linkedlist;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author tongruochen
 * @since 2020/1/2
 */
public class StackSolutions {

    public ArrayList<ArrayList<Integer>> setOfStacks(int[][] ope, int size) {
        // write code here
        ArrayList<ArrayList<Integer>> setOfStacks = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> currentStack = new ArrayList<Integer>();
        ArrayList<Integer> lastStack = currentStack;
        for (int[] i : ope) {
            int operate = i[0];
            int value = i[1];
            if (size <= currentStack.size() && 1 == operate) {
                setOfStacks.add(currentStack);
                lastStack = currentStack;
                currentStack = new ArrayList<Integer>();
            }
            if (1 == operate) {
                currentStack.add(value);
            } else if (2 == operate) {
                if (0 >= currentStack.size()) {
                    currentStack = lastStack;
                    setOfStacks.remove(setOfStacks.size() - 1);
                }
                currentStack.remove(currentStack.size() - 1);
            }
        }
        setOfStacks.add(currentStack);

        return setOfStacks;
    }

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public ArrayList<Integer> twoStacksSort(int[] numbers) {
        // write code here
        Stack<Integer> initStack = new Stack<Integer>();
        for (int i : numbers) {
            initStack.push(i);
        }

        Stack<Integer> orderStack = new Stack<Integer>();
        while (!initStack.empty()) {
            if (orderStack.empty()) {
                orderStack.push(initStack.pop());
            } else {
                int value = initStack.pop();
                int top = orderStack.pop();
                if (value < top) {
                    initStack.push(top);
                    while (!orderStack.empty() && value < (top = orderStack.pop())) {
                        initStack.push(top);
                    }
                }
                if (value >= top) {
                    orderStack.push(top);
                }
                orderStack.push(value);
            }
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        while (!orderStack.empty()) {
            result.add(orderStack.pop());
        }

        return result;
    }

    public ArrayList<Integer> asylum(int[][] ope) {
        // write code here
        ArrayList<Integer> adopted = new ArrayList<Integer>();

        ArrayList<Integer> animals = new ArrayList<Integer>();
        for (int[] event : ope) {
            int operate = event[0];
            int type = event[1];
            switch (operate) {
                case 1:
                    animals.add(type);
                    break;
                case 2:
                    if (!animals.isEmpty()) {
                        switch (type) {
                            case 0:
                                adopted.add(animals.remove(0));
                                break;
                            case 1:
                                for (int i=0; i<animals.size(); i++) {
                                    if (0 < animals.get(i)) {
                                        adopted.add(animals.remove(i));
                                        break;
                                    }
                                }
                                break;
                            case -1:
                                for (int i=0; i<animals.size(); i++) {
                                    if (0 > animals.get(i)) {
                                        adopted.add(animals.remove(i));
                                        break;
                                    }
                                }
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                default:
                    break;
            }
        }

        return adopted;
    }
}
