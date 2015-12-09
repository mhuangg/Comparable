//Mei Huang
//APCS1- pd 5
//HW #43 - This or That
//2015-12-09

//skeleton file for class Binary

public class Binary {
    //instance variables 
    private int _decNum;
    private String _binNum;

    /*=====================================
      default constructor
      pre:  n/a
      post: initializes _decNum to 0, _binNum to "0"
      =====================================*/
    public Binary() { 
        _decNum = 0;
	_binNum = "0"; 
    }

    /*=====================================
      overloaded constructor
      pre:  n >= 0
      post: sets _decNum to n, _binNum to equiv string of bits
      =====================================*/
    public Binary( int n ) {
	_decNum = n;
	_binNum = decToBin(n); 
    }

    /*=====================================
      overloaded constructor
      pre:  s is String representing non-negative binary number
      post: sets _binNum to input, _decNum to decimal equiv
      =====================================*/
    public Binary( String s ) {
	_binNum = s;
	_decNum = binToDec(s); 
    }
    
    /*=====================================
      String toString() -- returns String representation of this Object
      pre:  n/a
      post: returns String of 1's and 0's representing value of this Object
      =====================================*/
    public String toString() {
	return _binNum; 
    }

    /*=====================================
      String decToBin(int) -- converts base-10 input to binary
      pre:  n >= 0
      post: returns String of bits
      eg  decToBin(0) -> "0"
      decToBin(1) -> "1"
      decToBin(2) -> "10"
      decToBin(3) -> "11"
      decToBin(14) -> "1110"
      =====================================*/
    
    public static String decToBin( int n ) {
    	String binary = "";
    	while (n > 0) {  // creates a loop 
    	    binary = (n%2) + binary; // either 0 or 1 is added to the string plus binary after that b/c of order of algorithm  
	    n /= 2; // int is divided by 2 & loop continues 
	}
    	return binary; // returns final string
    }

    /*=====================================
      String decToBinR(int) -- converts base-10 input to binary, recursively
      pre:  n >= 0
      post: returns String of bits
      eg  decToBinR(0) -> "0"
      decToBinR(1) -> "1"
      decToBinR(2) -> "10"
      decToBinR(3) -> "11"
      decToBinR(14) -> "1110"
      =====================================*/
    public static String decToBinR( int n ) { 
	String binary = "";  
	if (n == 0) // base case 
	    binary = "0"; 
	else if (n == 1) // base case 
	    binary = "1";
	    else
		binary = decToBinR(n/2) + (n % 2); // calls the method with the input's quotient + remainder(either 0 or 1)
	return binary; //return binary 
	}
                                     
  
    /*=====================================
      String binToDec(String) -- converts base-10 input to binary
      pre:  s represents non-negative binary number
      post: returns decimal equivalent as int
      eg  
      binToDec("0") -> 0
      binToDec("1") -> 1
      binToDec("10") -> 2
      binToDec("11") -> 3
      binToDec("1110") -> 14
      =====================================*/
    public static int binToDec( String s ) {
	int dec = 0; //holds the int that will be outputted  
	for (int i = 0; i < s.length() ; i++) { //forloop traversing string s
	    //first element of string is parsed to int 
	    dec += Integer.parseInt(s.substring(i,i+1)) * Math.pow(2,s.length()-i-1);} //multiply by base 2 to the length-i-1
	return dec; //return int
    }

    /*=====================================
      String binToDecR(String) -- converts base-10 input to binary, recursively
      pre:  s represents non-negative binary number
      post: returns decimal equivalent as int
      eg  
      binToDecR("0") -> 0
      binToDecR("1") -> 1
      binToDecR("10") -> 2
      binToDecR("11") -> 3
      binToDecR("1110") -> 14
      =====================================*/
    public static int binToDecR( String s ) {  
	if (s.length() == 0) { //base case 
	    return 0;
	}
	else {
	    //first element of string is parsed into int multiplied by 2^s.length-1 
	    return Integer.parseInt(s.substring(0,1)) * (int)Math.pow(2,s.length()-1) + 
		binToDecR(s.substring(1)); //calls own method & string is returned without first element 
	}
    }

    /*=============================================
      boolean equals(Object) -- tells whether 2 Objs are equivalent
      pre:  other is an instance of class Binary
      post: Returns true if this and other are aliases (pointers to same 
      Object), or if this and other represent equal binary values
      =============================================*/
    public boolean equals( Object other ) { 
        //First, check for aliasing.
	boolean retVal = this == other;
 
	//Next, if this and input Object are different objects,
        if ( !retVal )
 
	    //...check to see if input Object is a Binary
	    retVal = other instanceof Binary 
 
		//...and that its state variables match those of this Binary
		&& this._binNum.equals(((Binary)other)._binNum)
		&& this._decNum == (((Binary)other)._decNum);
 
	return retVal;
    }

    //alternative equalsTo method
    /**** 
	  public boolean equals(Object other) { 
	  Binary bin = (Binary)(other); 
	  return (this.compareTo(bin) == 0); 
	  }


	  /*=============================================
	  int compareTo(Object) -- tells which of two Binary objects is greater
	  pre:  other is instance of class Binary
	  post: Returns 0 if this Object is equal to the input Object,
	  negative integer if this<input, positive integer otherwise
	  =============================================*/
    public int compareTo( Object other ) { 
	if (this.equals((Binary)other)) {
	    return 0; }
	else if (this._decNum < ((Binary)other)._decNum) {
	    return -1; }
	else return 1;
    }

    //alternative clever compareTo method
    /**   public int compareTo(Object other) {
	  Binary bin = (Binary)(other);
	  return this.decNum - otherbin._decNum;
	  }
    **/
    
	
    //main method for testing
    public static void main( String[] args ) {

	System.out.println();
	System.out.println( "Testing ..." );

	Binary b1 = new Binary(5);
	Binary b2 = new Binary(5);
	Binary b3 = b1;
	Binary b4 = new Binary(7);

	System.out.println( b1 );
	System.out.println( b2 );
	System.out.println( b3 );       
	System.out.println( b4 );

	System.out.println(decToBin(0));  //should be 0
	System.out.println(decToBin(1));  //should be 1
	System.out.println(decToBin(2)); //should be 10
 	System.out.println(decToBin(3)); //should be 11
 	System.out.println(decToBin(14)); //should be 1110
	System.out.println(decToBinR(0));   
	System.out.println(decToBinR(1));  
	System.out.println(decToBinR(2)); 
	System.out.println(decToBinR(3)); 
 	System.out.println(decToBinR(14)); 

	System.out.println(binToDec("0")); // should be 0
	System.out.println(binToDec("1")); //should be 1
	System.out.println(binToDec("10")); // should be 2
        System.out.println(binToDec("11")); // should be 3
        System.out.println(binToDec("1110")); // should be 14
	System.out.println(binToDecR("0")); 
	System.out.println(binToDecR("1"));  
	System.out.println(binToDecR("10"));  
        System.out.println(binToDecR("11"));  
        System.out.println(binToDecR("1110"));  
	
	System.out.println( "\n==..." );
	System.out.println( b1 == b2 ); //should be false
	System.out.println( b1 == b3 ); //should be true

	System.out.println( "\n.equals()..." );
	System.out.println( b1.equals(b2) ); //should be true
	System.out.println( b1.equals(b3) ); //should be true
	System.out.println( b3.equals(b1) ); //should be true
	System.out.println( b4.equals(b2) ); //should be false
	System.out.println( b1.equals(b4) ); //should be false

	System.out.println( "\n.compareTo..." );
	System.out.println( b1.compareTo(b2) ); //should be 0
	System.out.println( b1.compareTo(b3) ); //should be 0
	System.out.println( b1.compareTo(b4) ); //should be neg
	System.out.println( b4.compareTo(b1) ); //should be pos
	  
    }//end main()

} //end class
