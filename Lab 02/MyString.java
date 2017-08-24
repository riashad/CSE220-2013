public class MyString{
  private char [] myCharElementArray;
  
//______________________________EMPTY__CONSTRUCTOR_______________________________
  public MyString(){
    
  }
  
//______________________________CHARACTER_ARRAY_CONSTRUCTOR______________________
  public MyString(char[ ] charSeq){
    myCharElementArray= new char[charSeq.length];
    for(int counter=0;counter<myCharElementArray.length;counter++)
      myCharElementArray[counter]=charSeq[counter];
  }
  
//______________________________STRING_CONSTRUCTOR_______________________________
  public MyString(String str){
    myCharElementArray=str.toCharArray();
  }
  
//****************_______________METHOD_STARTS_______________********************
  
//_____________________METHOD__OF__RETURNING__THE__LENGTH_______________________
  public int length(){
    int i=0;
    if(checkingNull() && checkingZeroLength()){
      i=myCharElementArray.length;
    }
    return i;
  }
  
//__________METHOD__OF__RETURNING__THE__CHARACTER__OF__VALID__INDEX____________
  public char charAt(int n){
    char c=' ';
    if((checkingNull()&& checkingZeroLength()) &&( n<myCharElementArray.length)){
      c=myCharElementArray[n];
    }else{
      System.out.print("Invalid Index");  
    }
    return c;
  }
  
//_________________METHOD__OF__STARTS__WITH__PREFIX___________________________
  public boolean startsWith(MyString prefix){
    if(prefix.checkingNull()&& prefix.checkingZeroLength()){
      int n=prefix.length();
      if( n<=myCharElementArray.length){
        int start=0;
        if(myCharElementArray[start]==prefix.charAt(start)){
          return true;
        }
      }
    }
    return false;
  }
  
//_______________METHOD__OF__STARTS__WITH__PREFIX__OF__A__STRING_____________
  public boolean startsWith(String prefix){
    MyString fix=new MyString(prefix);
    if(fix.checkingNull()&& fix.checkingZeroLength()){
      int n=fix.length();
      if( n<=myCharElementArray.length){
        int start=0;
        if(myCharElementArray[start]==fix.charAt(start)){
          return true;
        }
      }
    }
    return false;
  } 
  
//_________________METHOD__OF__ENDS__WITH__SUFFIX______________________________
  public boolean endsWith(MyString suffix){
    if(suffix.checkingNull()&& suffix.checkingZeroLength()){
      int n=suffix.length();
      if( n==myCharElementArray.length){
        int end=n-1;;
        if(myCharElementArray[end]==suffix.charAt(end)){
          return true;
        }
      }
    }
    return false;
  }  
  
//_______________METHOD__OF__ENDS__WITH__SUFFIX__OF__A__STRING_________________
  public boolean endtsWith(String suffix){
    MyString pix=new MyString(suffix);
    if(pix.checkingNull()&& pix.checkingZeroLength()){
      int n=pix.length();
      if( n==myCharElementArray.length){
        int end=n-1;
        if(myCharElementArray[end]==pix.charAt(end)){
          return true;
        }
      }
    }
    return false;
  }
  
  //______________METHOD__OF__REPLACING__FIRSTCHAR__OF__MYSTRING________________ 
  public MyString replaceFirst(char oldChar, char newChar){
    int o= (int) oldChar;
    int n = (int) newChar;
    if((o>= 65 && o<=122) && (n>=65 && n<=122)){
      int location=0;
      char [] another = new char[myCharElementArray.length];
      for (int counter=0; counter<myCharElementArray.length;counter++){
        if (myCharElementArray[counter]!=oldChar){
          another[counter]=myCharElementArray[counter];
        }else{
          another[counter]=newChar;
          location = counter;
          break;
        }
      }
      for(int d=location;d<another.length;d++){
        another[d]=myCharElementArray[d];
      }
      return new MyString(another);
    }else{
      System.out.print("Invalid Character/Characters!");
      return new MyString();
    }
  }
  
//______________METHOD__OF__REPLACING__ALLCHAR__OF__MYSTRING_______________  
  public MyString replaceAll(char oldChar, char newChar){
    int o= (int) oldChar;
    int n = (int) newChar;
    if((o>= 65 && o<=122) && (n>=65 && n<=122)){
      char [] another = new char[myCharElementArray.length];
      for (int counter=0; counter<myCharElementArray.length;counter++){
        if (myCharElementArray[counter]==oldChar){
          another[counter]=newChar;
        }else{
          another[counter]=myCharElementArray[counter];
        }
      }
      return new MyString(another);
    }else{
      System.out.print("Invalid Character/Characters!");
      return new MyString();
    }
  }
  
//______________METHOD__OF__REPLACING__LASTCHAR__OF__MYSTRING_______________
  public MyString replaceLast(char oldChar, char newChar){
    int o= (int) oldChar;
    int n = (int) newChar;
    if((o>= 65 && o<=122) && (n>=65 && n<=122)){
      int location=myCharElementArray.length-1;
      char [] another = new char[myCharElementArray.length];
      for (int counter=myCharElementArray.length; counter>0;counter--){
        if (myCharElementArray[counter]!=oldChar){
          another[counter]=myCharElementArray[counter];
        }else{
          another[counter]=newChar;
          location = counter;
          break;
        }
      }
      for(int d=location;d>0;d--){
        another[d]=myCharElementArray[d];
      }
      return new MyString(another);
    }else{
      System.out.print("Invalid Character/Characters!");
      return new MyString();
    }
  }
  
//_________________________METHOD__OF__TO__LOWERCASE____________________________
  public MyString toLowerCase(){
    char [] array=new char[myCharElementArray.length];
    MyString newtype= new MyString(array);
    for(int counter=0;counter<myCharElementArray.length;counter++){
      if((int)newtype.charAt(counter)>=65 && (int)newtype.charAt(counter)<=90){
        myCharElementArray[counter]=(char)((int)newtype.charAt(counter)+32);
      }
    }
    return newtype;
  }  
  
//_________________________METHOD__OF__TO__UPPERCASE____________________________
  public MyString toUpperCase(){
    char [] array=new char[myCharElementArray.length];
    MyString newtype= new MyString(array);
    for(int counter=0;counter<myCharElementArray.length;counter++){
      if((int)newtype.charAt(counter)>=97 && (int)newtype.charAt(counter)<=122){
        myCharElementArray[counter]=(char)((int)newtype.charAt(counter)-32);
      }
    }
    return newtype;
  }  
  
//_________________________METHOD__OF__BOOLEAN__EQUALS__________________________
  public boolean equals(MyString rightStr){
    if(checkingNull()&& rightStr.checkingNull()){
      try{ 
        boolean b = false;
        for(int counter=0;counter<length();counter++){
          if(charAt(counter)==rightStr.charAt(counter)){
            b = true;
          }
          else{
            b = false;
            break;
          }
        }
        return b;
      }
      catch(Exception e){
        return false;
      }
    }else{
      System.out.print("Yes, It is null reference!");
      return false;
    }
  }
  
//______________________METHOD__OF__BOOLEAN__EQUALS__IGNORE__CASE_______________
  public boolean equalsIgnoreCase(MyString rightString){
    if(checkingNull() && rightString.checkingNull()){
      try{
        boolean b = false;
        for(int counter=0;counter<myCharElementArray.length;counter++){
          if(((int)charAt(counter)>=65 && (int)charAt(counter)<=122) &&((int)rightString.charAt(counter)>=65 && (int)rightString.charAt(counter)<=122)){
            b = true;
          }
          else{ 
            b = false;
            break;
          }
        }
        return b;
      }
      catch(Exception e){
        return false;
      }
    }
    else{
      System.out.print("Yes, It is null reference!");
      return false;
    }
  }
  
  
  
  
//_____________________METHOD__OF__COMPARE__TO__MYSTRING_________________________
  public int compareTo(MyString str){
    if(str.checkingNull()){
      if(length()==str.length()){
        int give=0;
        for (int counter=0;counter<length();counter++){
          int a = (int) myCharElementArray[counter];
          int b = (int) str.charAt(counter);
          if(b>a){
            give=a-b;
            break;
          }else if (b<a){
            give=a-b;
            break;
          }else{
            give =0;
          }
        }
        return give;
      }
      else if(length()>str.length()){
        int give=0;
        for (int counter=0;counter<str.length();counter++){
          int a = (int) myCharElementArray[counter];
          int b = (int) str.charAt(counter);
          if(b>a){
            give=a-b;
            break;
          }else if (b<a){
            give=a-b;
            break;
          }else{
            give =length()-str.length();
          }
        }
        return give;
      }
      else{
        int give=0;
        for (int counter=0;counter<length();counter++){
          int a = (int) myCharElementArray[counter];
          int b = (int) str.charAt(counter);
          if(b>a){
            give=a-b;
            break;
          }
          else if (b<a){
            give=a-b;
            break;
          }else{
            give =length()-str.length();
          }
        } 
        return give;
      }
      
    }
    else{
      System.out.println("You have sent a null MyString Object!Send again!!!");
      return 420420;
    }
  }  
  
//_____________________METHOD__OF__COMPARE__TO__STRING___________________________
  public int compareTo(String str){
    MyString st= new MyString (str);
    if(st.checkingNull()){
      if(length()==st.length()){
        int give=0;
        for (int counter=0;counter<length();counter++){
          int a = (int) myCharElementArray[counter];
          int b = (int) st.charAt(counter);
          if(b>a){
            give=a-b;
            break;
          }else if (b<a){
            give=a-b;
            break;
          }else{
            give =0;
          }
        }
        return give;
      }
      else if(length()>st.length()){
        int give=0;
        for (int counter=0;counter<st.length();counter++){
          int a = (int) myCharElementArray[counter];
          int b = (int) st.charAt(counter);
          if(b>a){
            give=a-b;
            break;
          }else if (b<a){
            give=a-b;
            break;
          }else{
            give =length()-st.length();
          }
        }
        return give;
      }
      else{
        int give=0;
        for (int counter=0;counter<length();counter++){
          int a = (int) myCharElementArray[counter];
          int b = (int) st.charAt(counter);
          if(b>a){
            give=a-b;
            break;
          }
          else if (b<a){
            give=a-b;
            break;
          }else{
            give =length()-st.length();
          }
        } 
        return give;
      }
      
    }
    else{
      System.out.println("You have sent a null MyString Object!Send again!!!");
      return 420420;
    }
  }  
  
//_______________METHOD__OF__COMPARE__TO__IGNORE__CASE__MYSTRING__________________
  public int compareToIgnoreCase(MyString str){
    if(str.checkingNull()){
      if(length()==str.length()){
        int give=0;
        for (int counter=0;counter<length();counter++){
          int a = (int) myCharElementArray[counter];
          int b = (int) str.charAt(counter);
          if(a>=97 && a<=122){
            a= a -32;
          }
          if(b>=97 && b<=122){
            b= b -32;
          }
          if(b>a){
            give=a-b;
            break;
          }else if (b<a){
            give=a-b;
            break;
          }else{
            give =0;
          }
        }
        return give;
      }
      else if(length()>str.length()){
        int give=0;
        for (int counter=0;counter<str.length();counter++){
          int a = (int) myCharElementArray[counter];
          int b = (int) str.charAt(counter);
          if(a>=97 && a<=122){
            a= a -32;
          }
          if(b>=97 && b<=122){
            b= b -32;
          }
          if(b>a){
            give=a-b;
            break;
          }else if (b<a){
            give=a-b;
            break;
          }else{
            give =length()-str.length();
          }
        }
        return give;
      }
      else{
        int give=0;
        for (int counter=0;counter<length();counter++){
          int a = (int) myCharElementArray[counter];
          int b = (int) str.charAt(counter);
          if(a>=97 && a<=122){
            a= a -32;
          }
          if(b>=97 && b<=122){
            b= b -32;
          }
          if(b>a){
            give=a-b;
            break;
          }
          else if (b<a){
            give=a-b;
            break;
          }else{
            give =length()-str.length();
          }
        } 
        return give;
      }
    }
    else{
      System.out.println("You have sent a null MyString Object!Send again!!!");
      return 420420;
    }
  }
  
  //_______________METHOD__OF__COMPARE__TO__IGNORE__CASE__STRING____________________
  public int compareToIgnoreCase(String str){
    MyString st= new MyString (str);
    if(st.checkingNull()){
      if(length()==st.length()){
        int give=0;
        for (int counter=0;counter<length();counter++){
          int a = (int) myCharElementArray[counter];
          int b = (int) st.charAt(counter);
          if(a>=97 && a<=122){
            a= a -32;
          }
          if(b>=97 && b<=122){
            b= b -32;
          }
          if(b>a){
            give=a-b;
            break;
          }else if (b<a){
            give=a-b;
            break;
          }else{
            give =0;
          }
        }
        return give;
      }
      else if(length()>st.length()){
        int give=0;
        for (int counter=0;counter<st.length();counter++){
          int a = (int) myCharElementArray[counter];
          int b = (int) st.charAt(counter);
          if(a>=97 && a<=122){
            a= a -32;
          }
          if(b>=97 && b<=122){
            b= b -32;
          }
          if(b>a){
            give=a-b;
            break;
          }else if (b<a){
            give=a-b;
            break;
          }else{
            give =length()-st.length();
          }
        }
        return give;
      }
      else{
        int give=0;
        for (int counter=0;counter<length();counter++){
          int a = (int) myCharElementArray[counter];
          int b = (int) st.charAt(counter);
          if(a>=97 && a<=122){
            a= a -32;
          }
          if(b>=97 && b<=122){
            b= b -32;
          }
          if(b>a){
            give=a-b;
            break;
          }
          else if (b<a){
            give=a-b;
            break;
          }else{
            give =length()-st.length();
          }
        } 
        return give;
      }
    }
    else{
      System.out.println("You have sent a null MyString Object!Send again!!!");
      return 420420;
    }
  }
  
//_______________________METHOD__OF__SUBSTRING__WITH__STRAT______________________
  public MyString substring(int start){
    if(start>=0 && start<length()){
      int k= start;
      char [] newshape = new char[length()];
      for(int c=0;c<length();c++){
        newshape[c]=myCharElementArray[k];
        k=(k+1)%length();
      }
      return new MyString(newshape);
    }else{
      System.out.println("Either you sent a negetive integer or it exceeds the capacity!");
      return new MyString();
    }
  }
  
//_______________________METHOD__OF__SUBSTRING__WITH__STRAT______________________
  public MyString substring(int start,int end){
    if((start>=0 && start<length() && start<end) && (end>=0 && end<length())){
      int k= start;
      char [] newshape = new char[end-start+1];
      for(int c=0;c<newshape.length;c++){
        newshape[c]=myCharElementArray[k];
        k=(k+1)%length();
      }
      return new MyString(newshape);
    }else{
      System.out.println("Either you sent negetive start/end or any one exceeds the capacity or . . . ending is greater than the starting point!");
      return new MyString();
    }
  }
  
//_________________________METHOD__OF__FIRST__INDEX__OF________________________
  public int indexOf(char ch){
    if((int)ch>0){
      int location=-1;
      for(int counter=0;counter<myCharElementArray.length;counter++){
        if(ch==myCharElementArray[counter]){
          location=counter;
          break;
        }else{
          location=-1;
        }
      }
      return location;
    } else {
      System.out.println("You sent a null ch!");
      return 0;
    }
  }
  
  
//_________________________METHOD__OF__LAST__INDEX__OF________________________
  public int lastIndexOf(char ch){
    if((int)ch>0){
      int location=-1;
      for(int counter=myCharElementArray.length;counter>0;counter--){
        if(ch==myCharElementArray[counter]){
          location=counter;
          break;
        }else{
          location=-1;
        }
      }
      return location;
    }else {
      System.out.println("You sent a null ch!");
      return 0;
    }
  }
  
  
//_______________METHOD__OF__FIRST__INDEX__OF__WITH__STARTING__POINT_________
  public int indexOf(char ch, int start){
    int location=-1;
    for(int counter=start;counter<myCharElementArray.length;counter++){
      if(ch==myCharElementArray[counter]){
        location=counter;
        break;
      }else{
        location=-1;
      }
    }
    return location;
  }
  
//_______________METHOD__OF__LAST__INDEX__OF__WITH__STARTING__POINT_________
  public int lastIndexOf(char ch,int start){
    int location=-1;
    for(int counter=start;counter>0;counter--){
      if(ch==myCharElementArray[counter]){
        location=counter;
        break;
      }else{
        location=-1;
      }
    }
    return location;
  }
  
//_________________________METHOD__OF__FIRST__STRING__OF________________________
  public int indexOf(String str){
    MyString st= new MyString(str);
    if(st.checkingNull()){
      if(st.length()==1){
        int location=-1;
        for(int counter=0;counter<length();counter++){
          if(str.charAt(0)==myCharElementArray[counter]){
            location=counter;
            break;
          }else{
            location=-1;
          }
        }
        return location;
      }else if(st.length()>1 && st.length()<length()){
        int got;
        int location =-1;
        int out;
        for(int c=0;c<length();c++){
          if (st.charAt(0)==charAt(c)){
            got = c;
            out = got;
            for(int k=0;k<st.length();k++){
              if (charAt(got)==st.charAt(k)){
                got = got +1;
                location=out;
              }else{
                location=-1;
                break;
              }
            }
            break;
          }else{
            break;
          }
        }
        return location;
      }else{
        return -1;
      }
    }else{
      System.out.println("Null!");
      return -1;
    }
  }
  
  
//_________________________METHOD__OF__LAST__STRING__OF________________________
  public int lastIndexOf(String str){
    MyString st= new MyString(str);
    if(st.checkingNull()){
      if(st.length()==1){
        int location=-1;
        for(int counter=length()-1;counter>=0;counter--){
          if(st.charAt(0)==myCharElementArray[counter]){
            location=counter;
            break;
          }else{
            location=-1;
          }
        }
        return location;
      }else{
        return -1;
      }
    }else{
      System.out.println("Null!");
      return -1;
    }
  }
  
//_________________________METHOD__OF__FIRST__MYSTRING__OF______________________
  public int indexOf(MyString str){
    if(str.checkingNull()){
      if(str.length()==1){
        int location=-1;
        for(int counter=0;counter<length();counter++){
          if(str.charAt(0)==myCharElementArray[counter]){
            location=counter;
            break;
          }else{
            location=-1;
          }
        }
        return location;
      }else if(str.length()>1 && str.length()<length()){
        int got;
        int location =-1;
        int out;
        for(int c=0;c<length();c++){
          if (str.charAt(0)==charAt(c)){
            got = c;
            out=got;
            for(int k=0;k<str.length();k++){
              if (charAt(got)==str.charAt(k)){
                got = got +1;
                location=out;
              }else{
                location=-1;
                break;
              }
            }
            break;
          }else{
            break;
          }
        }
        return location;
      }else{
        return -1;
      }
    }else{
      System.out.println("Null!");
      return -1;
    }
  }
  
  
//_________________________METHOD__OF__LAST__MYSTRING__OF______________________
  public int lastIndexOf(MyString str){
    if(str.checkingNull()){
      if(str.length()==1){
        int location=-1;
        for(int counter=length()-1;counter>=0;counter--){
          if(str.charAt(0)==myCharElementArray[counter]){
            location=counter;
            break;
          }else{
            location=-1;
          }
        }
        return location;
      }else{
        return -1;
      }
    }else{
      System.out.println("Null!");
      return -69;
    }
  }
  
//_______________________CONCAT__METHOD__OF__MYSTRING_____________________________
  public MyString concat (MyString str){
    if (str.checkingNull()){
      char [] array = new char [length()+str.length()];
      for(int c=0;c<length();c++){
        array[c]=myCharElementArray[c];
      }
      for(int d=length();d<str.length();d++){
        array[d]=str.charAt(d-length());
      }
      return new MyString(array);
    }else{
      return new MyString();
    }
  }
  
//_______________________CONCAT__METHOD__OF__CHAR_____________________________
  public MyString concat (char[]charSeq){
    if (charSeq!=null){
      char [] array = new char [length()+charSeq.length];
      for(int c=0;c<length();c++){
        array[c]=myCharElementArray[c];
      }
      for(int d=length();d<charSeq.length;d++){
        array[d]=charSeq[d-length()];
      }
      return new MyString(array);
    }else{
      return new MyString();
    }
  }
  
//_______________________CONCAT__METHOD__OF__STRING_____________________________
  public MyString concat (String str){
    if(str!=null){
      char [] convert = new char[str.length()];
      for(int c=0;c<convert.length;c++){
        convert[c]=str.charAt(c);
      }
      char [] array = new char[convert.length+length()];
      for(int c=0;c<convert.length;c++){
        array[c]=convert[c];
      }
      for(int c=convert.length;c<array.length;c++){
        array[c]=myCharElementArray[c-convert.length];
      }
      return new MyString(array);
    }else{
      return new MyString();
    }
  }
  
  
//________________EXTRA__ASSISTING__METHODS____________________________________
  
//_________________________METHOD__OF__TO__STRING_____________________________
  public String toString(){
    if(checkingNull()){
      if(myCharElementArray.length<1){
        return "No character is here!";
      }
      else{
        for(int counter=0;counter<myCharElementArray.length;counter++){
          System.out.print(myCharElementArray[counter]);
        }
      }
    }
    return "";
  }
  
//________________CHECKING__NULL__REFERENCE__OR__NOT___________________________
  public boolean checkingNull(){
    boolean b=true;
    try{
      int i=myCharElementArray.length;
    }catch(Exception e){
      System.out.println("You have sent a null reference");
      b=false;
    }
    return b;
  } 
  
//_______________CHECKING__THE__GIVEN__IS__ZERO__OR__NOT_______________________
  public boolean checkingZeroLength(){
    boolean b=true;
    if(myCharElementArray.length<1){
      System.out.println("Empty (Zero Length)");
      b=false;}
    return b;
  }
}  