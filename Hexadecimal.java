/*
  Lisa Shi, Mei Huang
  Team -- Null
  APCS1 PD5
  HW44 This or That or fourteen other Things
  2015-12-08
*/
 
class Hexadecimal implements Comparable {
    //instance variables
    private int _decNum;
    private final static String HEXDIGITS = "0123456789ABCDEF";
    private String _hexNum;
    
    /*=====================================
      default constructor
      pre:  n/a
      post: initializes _decNum to 0
      =====================================*/
    
    public Hexadecimal() { 
	_decNum = 0;
	_hexNum = "0";
    }
     
    /*=====================================
      overloaded constructor
      pre:  s is String representing non-negative hexadecimal number
      post: sets  _decNum to decimal equiv
      =====================================*/
    
    public Hexadecimal( String s ) {
        _hexNum = s;
	_decNum = HexToDec(s);
    }
      
    public Hexadecimal( int n ) {
	_decNum = n; 
	_hexNum = decToHex(n); 
    }

    /*=====================================
      String toString() -- returns String representation of this Object
      pre:  n/a
      post: returns String representing value of this Object
      =====================================*/
    public String toString() { 
	return _hexNum;
    }
    
    /*=========================
      String decToHex( int n ) -- converts base 10 to base 16, iteratively
      pre: n >= 0;
      post: returns String of bits;
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      1. Divide the decimal number by 16. Treat the division as an integer division.
      2. Write down the remainder (in hexadecimal).
      3. Divide the result again by 16. Treat the division as an integer division.
      4. Repeat step 2 and 3 until result is 0.
      5. The hex value is the digit sequence of the remainders from the last to first.
      =========================*/

      
    public static String decToHex( int n ) {
	String te = ""; 
	while(n > 0){ //creates loop 
	    int tem = n % 16; 
	    if (tem >= 10) {  // deals with the letters in HEXDIGITS which starts at 10(A) 
		te = HEXDIGITS.charAt(tem) + te; } //value of the remainder is the index of HEXDIGITS with existing string after it
	    else { te = tem + te; } //deals with the numbers under 10 in HEXDIGITS 
	    n = n/16;
	}
	return te;
    }

    /*=====================================
      String decToHexR(int) -- converts base-10 input to Hexadecimal, recursively
      pre:  n >= 0
      post: returns String of bits
      eg  decToHexR(0) -> "0"
      decToHexR(1) -> "1"
      decToHexR(10) -> "A"
      decToHexR(16) -> "10"
      =====================================*/
    
    public static String decToHexR(int n) { 
        String hex = ""; 
        int r = n%16; //remainder when input is divided by 16
        int q = n/16; //quotient when input is divided by 16
	if (q == 0) {  //base case : if not divisible by 16 then 
            hex = HEXDIGITS.charAt(r) + hex; } //value of the remainder is the same value of the index of HEXDIGITS  & + existing string 
        else 
	    hex = decToHexR(q) + HEXDIGITS.charAt(r); //calls own method with new parameter as quotient + remainder after it to add to existing string
	return hex; //return string
    }
   
    /*=====================================
      String HexToDec(String) -- converts base-10 input to Hexadecimal
      pre:  s represents non-negative Hexadecimal number
      post: returns decimal equivalent as int
      eg  
      HexToDec("0") -> 0
      HexToDec("1") -> 1
      HexToDec("A") -> 10
      HexToDec("10") -> 16
      =====================================*/
    
    public static int HexToDec( String s ) {
	int m = 0;  
	int dec = 0; 
	for (int i = 0; i < s.length(); i++) { //creates forloop until i reaches one less than the length
	    m = HEXDIGITS.indexOf(s.substring(i,i+1)); //m holds index of hexdigits that contains the first element of the string 
	    dec +=  m * (int)Math.pow(16, s.length()-i-1);} //dec holds the first element * 16 base to one less than length 
	return dec; //return dec 
    }
    
    /*=====================================
      String HexToDecR(String) -- converts base-10 input to Hexadecimal, recursively
      pre:  s represents non-negative Hexadecimal number
      post: returns decimal equivalent as int
      eg  
      HexToDecR("0") -> 0
      HexToDecR("1") -> 1
      HexToDecR("A") -> 10
      HexToDecR("10") -> 16
      =====================================*/
    
	  public static int HexToDecR( String s ) {

	      if (s.length() == 0) //base case : if string is empty (due to the hacking off of string) 
		  return 0; // returns 0;
	      //returns index of hexdigits that contains the first element of the string s * 16^string length-1 
	      else return HEXDIGITS.indexOf(s.substring(0,1)) * (int)Math.pow(16, s.length()-1) + HexToDecR(s.substring(1)); //calls itself,leaving off first element 
	  }

    /*=============================================
      boolean equals(Object) -- tells whether 2 Objs are equivalent
      pre:  other is an instance of class Hexadecimal
      post: Returns true if this and other are aliases (pointers to same 
      Object), or if this and other represent equal Hexary values
      =============================================*/

    public boolean equals( Object other ) { 
	boolean aliasCheck = this == other;
	if ( !aliasCheck ){
	    aliasCheck = other instanceof Hexadecimal
		&& this._hexNum.equals(((Hexadecimal)other)._hexNum);
	}
	return aliasCheck;
    }

    /*=============================================
      int compareTo(Object) -- tells which of two Hexadecimal objects is greater
      pre:  other is instance of class Hexadecimal
      post: Returns 0 if this Object is equal to the input Object,
      negative integer if this<input, positive integer otherwise
      =============================================*/

    public int compareTo( Object other ) {
       
	if(this._decNum == ((Hexadecimal)other)._decNum){
	    return 0;
	}
	else if(this._decNum > ((Hexadecimal)other)._decNum){
	    return 1;
	}
	else{
	    return -1;
	}
    }
     
    public static void main( String[] args ) {

	System.out.println();
	System.out.println( "Testing ..." );

	Hexadecimal b1 = new Hexadecimal(5);
	Hexadecimal b2 = new Hexadecimal(5);
	Hexadecimal b3 = b1;
	Hexadecimal b4 = new Hexadecimal(7);

	System.out.println( b1 );
	System.out.println( b2 );
	System.out.println( b3 );       
	System.out.println( b4 );
	
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
	
	System.out.println( "Testing ...HexToDec" );
	System.out.println(HexToDec("C"));   //should be 12
	System.out.println(HexToDec("100")); //should be 256
	System.out.println(HexToDec("ABC")); //should be 2748
	System.out.println(HexToDec("700")); //should be 1792
	System.out.println(HexToDec("BEE")); //should be 3054
	System.out.println(HexToDec("ABCDEF")); //should be 11259375

	System.out.println( "Testing ...HexToDecR" );
	System.out.println(HexToDecR("C"));   //should be 12
	System.out.println(HexToDecR("100")); //should be 256
	System.out.println(HexToDecR("ABC")); //should be 2748
	System.out.println(HexToDecR("700")); //should be 1792
	System.out.println(HexToDecR("BEE")); //should be 3054
	System.out.println(HexToDecR("ABCDEF")); //should be 11259375
	
	System.out.println( "Testing...decToHexR" );
	System.out.println(decToHexR(12));   //should be C
	System.out.println(decToHexR(256));  //should be 100
	System.out.println(decToHexR(2748)); //should be ABC 
	System.out.println(decToHexR(1792)); //should be 700
	System.out.println(decToHexR(3054)); //should be BEE
	System.out.println(decToHexR(11259375)); //should be ABCDEF
  
	System.out.println( "Testing ...DecToHex" );
	System.out.println(decToHex(12));   //should be C
	System.out.println(decToHex(256));  //should be 100
	System.out.println(decToHex(2748)); //should be ABC 
	System.out.println(decToHex(1792)); //should be 700
	System.out.println(decToHex(3054)); //should be BEE
	System.out.println(decToHex(11259375)); //should be ABCDE
    }
}
     
 
     

     
