/*
Implement the programming language Treefuck, which is based on Brainfuck (another language). 

You should write an interpreter (takes in a program as a string and execute it)
and implement any necessary underlying data structure(s).

The language consists of nine commands, listed below. A Treefuck program is
a sequence of these commands, possibly interspersed with other
characters (which are ignored). The commands are executed sequentially, with
some exceptions: an instruction pointer begins at the first command, and each
command it points to is executed, after which it normally moves forward to
the next command. The program terminates when the instruction pointer moves
past the last command.

The Treefuck language uses a simple machine model consisting of the program
and instruction pointer, as well as an infinitely large binary tree, with each
node initialized to zero.

Commands:
< -> Move the data pointer to point to the left subtree of the current node
> -> Move the data pointer to point to the right subtree of the current node
| -> Move the data pointer to point to the parent of the current node

+ -> Increment the byte stored in the current node
- -> Decrement the byte stored in the current node

. -> Output the byte stored in the current node
, -> Read one byte of input, and store it in the current node

[ -> If the current node contains zero, jump the instruction pointer to the command after the matching ]. Otherwise continue
] -> If the current node does not contain zero, jump the instruction pointer to the command after the matching [. Otherwise continue

Examples
Read a byte as input, then count down from that byte, outputting each number
,[.-]

Read two bytes as input, then output their sum
<,|>,|<[-|+<]|>[-|+>]|.

Print "Hello World!"
++++++++[>++++[>++>+++>+++>+||||-]>+>+>->>+[|]|-]>>.>---.+++++++..+++.>>.|-.|.+++.------.--------.>>+.>++.

[+++].

*/
import java.util.*;



public class TreeFuck {
    
    private static Node head;
    
    private static Scanner input;
    
    private static void ReadInstructions(String instr) {
        
        if (head == null)
            head = new Node();
            
        Node pointer  = head;
        
        char[] arr = instr.toCharArray();

        Stack<Integer> bracks = new Stack<Integer>();
        
        for (int i=0; i < arr.length; i++) {
            if (arr[i] == '[') {
                if (pointer.data != 0) {
                    bracks.push(i);
                }
                else {

                    //while(arr[i] != ']')
                    //   i++;


                    /* ======================== ADDED AFTER INTERVIEW =============================*/
                    /* ======================== CORE CODE ADDITION ================================*/
                    int counter  = 1;
                    while (counter != 0) {
                        i++;
                        if (arr[i] == '[')
                            counter++;
                        else if (arr[i] == ']') 
                            counter--;
                    }
                    /*  =====================================================*/
                } 
                    
            }
            else if (arr[i] == ']') {
                if (pointer.data == 0) {
                    bracks.pop();
                }
                else {
                    i = bracks.peek();
                }
            }
            else {
                pointer = ReadSingleInstruction(arr[i], pointer);
            }
            
        }     
        // ADDED AFTER INTERVIEW
        head = null;
    }
    
    
    private static Node ReadSingleInstruction(char instr, Node head) {
        if (head == null)
            head = new Node();
            
        Node pointer = head;
        
        //char[] arr = instr.ToCharArray();
        //for (int i=0; i < arr.Length; i++) {
        
            if (instr == '<') {
                if (pointer.left == null) {
                    pointer.left = new Node((byte)0, pointer);
                }
                pointer = pointer.left;
            }    
            
            else if (instr == '>') {
                
                 if (pointer.right == null) {
                    pointer.right = new Node((byte)0, pointer);
                }
                pointer = pointer.right;
            }
            
            else if (instr == '|') {
                pointer = pointer.parent;
            }
            
            else if (instr == '+')
                Increment(pointer);
                
            else if (instr == '-')
                Decrement(pointer);
                
            else if (instr == '.')
                Output(pointer);

            /* ======================== ADDED AFTER INTERVIEW =============================*/
            else if (instr == 'o')
                OutputChar(pointer);
            /* =====================================================*/
                
            else if (instr == ',')
                pointer.data = ReadIn();
       // }
        
        return pointer;
    }
    
    private static byte ReadIn() {
        if (input == null)
            input = new Scanner(System.in);
        // ADDED AFTER INTERVIEW
        System.out.print("Please Enter Value: ");
        // =========
        byte b = input.nextByte();
        return b;
    }    
    
    private static byte Output(Node n) {
        System.out.println(n.data);
        return n.data;
    }

    /* ======================== ADDED AFTER INTERVIEW =============================*/
    private static byte OutputChar(Node n) {
        System.out.println((char)n.data);
        return n.data;
    }
    /* =====================================================*/
    
    private static byte Increment(Node n) {
        n.data++;
        return n.data;
    }
    
    private static byte Decrement(Node n) {
        n.data--;
        return n.data;
    }

    


    /* ======================== ADDED AFTER INTERVIEW =============================*/
    public static void main(String[] args) {
        
        String count = ",[.-]";
        ReadInstructions(count);

        String adder = "<,|>,|<[-|+<]|>[-|+>]|.";
        ReadInstructions(adder);

        String helloWorld = "++++++++[>++++[>++>+++>+++>+||||-]>+>+>->>+[|]|-]>>.>---.+++++++..+++.>>.|-.|.+++.------.--------.>>+.>++.";
        //ReadInstructions(helloWorld);

        String helloWorldInChars = "++++++++[>++++[>++>+++>+++>+||||-]>+>+>->>+[|]|-]>>o>---o+++++++oo+++o>>o|-o|o+++o------o--------o>>+o>++o";
        ReadInstructions(helloWorldInChars);
    }
    /* =====================================================*/
    
}

class Node {
    
    public byte data;
    public Node left;
    public Node right;
    
    public Node parent;
    
    public Node(byte b) {
        
        data = b;
        left = null;
        right = null;
    }
    
    public Node() {
        data = 0;
        left = null;
        right = null;
        
    }
    
    public Node(byte b, Node myParent) {
        data = b;
        left =  null;
        right = null;
        
        parent = myParent;
    }
    
}





