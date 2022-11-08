import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        int T;
        char[] ch;
		Stack<Character> stack;
		for(int test_case = 1; test_case <= 10; test_case++)
		{
            stack = new Stack<>();
            T=sc.nextInt();
            ch = sc.next().toCharArray();
            for(int i = 0; i<T; i++){
                if(stack.isEmpty())
                    stack.push(ch[i]);
                else if(stack.peek() == ch[i])
                    stack.pop();
                else
                    stack.push(ch[i]);
            }
            System.out.print( "#" + test_case + " ");
            for(int i = 0; i < stack.size(); i++)
                System.out.print(stack.get(i));
            System.out.println();
            sc.close();
		}
	}
}