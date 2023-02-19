import java.util.Scanner;
import java.util.Stack;

public class Brackets {

    static int bracket_balance(String str)
    {   
        Stack<Bracket> stack = new Stack<Bracket>();
        for (int i = 0;i < str.length();i++)
        {
            char temp = str.charAt(i);
            if (temp == '(' || temp == '[' || temp == '{')
            {
                Bracket br = new Bracket();
                br.type = temp;
                br.pos = i;
                stack.push(br);
            }
            if(temp == ')' || temp == ']' || temp == '}')
            {   
                if (stack.isEmpty()) return(i);
                else
                {
                    Bracket temp_check = new Bracket();
                    switch(temp)
                    {
                        case ')':
                            temp_check = stack.pop();
                            if (temp_check.type == '{' || temp_check.type == '[')
                            {
                                return(temp_check.pos);
                            }
                            break;
                        case ']':
                            temp_check = stack.pop();
                            if (temp_check.type == '{' || temp_check.type == '(')
                            {
                                return(temp_check.pos);
                            }
                        break;
                        case '}':
                            temp_check = stack.pop();
                            if (temp_check.type == '(' || temp_check.type == '[')
                            {
                                return(temp_check.pos);
                            }
                            break;
                    }
                }
                
            }
        }
        if (stack.isEmpty()) return(-1);
        else
        {
            while(stack.isEmpty() == false)
            {   Bracket temp = new Bracket();
                temp = stack.pop();
                return(temp.pos);
            }
        }
        return(-1);
    }

	public static void main(String[] args) {
        Scanner sc;
		sc = new Scanner(System.in);
        String str = sc.nextLine(); 
		sc.close();
        if(str.length() >= 1 && str.length() <= 100000)
        {
            int result = bracket_balance(str);
            if(result == -1)
                System.out.println("Success");
            else
                System.out.println(result + 1);
        }    
	}

}

class Bracket
{
    char type;
    int pos;
}