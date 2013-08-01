import scala.math

import scala.collection.mutable.ListBuffer

object problems {
    //main funkcija
  def main(args: Array[String]): Unit = 
  {  
    problem1()
    problem2()
    problem3()
    problem4()
    problem5()
    problem6()
  }
  
  def problem1(): Unit = {
    var sum = 0;
	for(i<- 1 to 1000)
	  if(isMultiple(i) == 1)
	    sum += i;
	println("Problem 1: "+sum);
	
	def isMultiple(number: Int): Int ={
	  var isMultiple = 0;
	  if ((number % 3 == 0) || (number % 5 == 0))
	    isMultiple = 1;
	  return isMultiple;
	}// end is Multiple
  }//end problem1
  
  def problem2(): Unit= {
    var sum = 0;
    var fibSeqNumber = 2;
    var fibSeqPreviousNumber = 1;
    while(fibSeqNumber<4000000){
      if (fibSeqNumber % 2 == 0)
        sum += fibSeqNumber;
      generateNextNumber();
    }  
    println("Problem 2: "+sum);
    
    def generateNextNumber(): Unit = {
      var temp = fibSeqNumber;
      fibSeqNumber += fibSeqPreviousNumber;
      fibSeqPreviousNumber = temp;      
    }//end generateNextNumber
  }//end problem 2
  
  def problem3(): Unit= {
    val number = 600851475143L;
    val sqrtOfNumber = Math.sqrt(number).toInt;//aukstesni skaiciai negali buti pirminiai daugikliai
    var skaiciai = List(1 to sqrtOfNumber:_*);
    var maxPrime = 0;
    var notPrime = 0;
    skaiciai = skaiciai.filter(number % _ == 0);//atmetam skaicius kurie nesidalina is number
    for(i <- 1 to skaiciai.length-1){ // nes nulinis elementas visada bus 1, kuris yra pirminis.
      notPrime = 0;
      for(j<- 2 to skaiciai(i))
        if((skaiciai(i) == j)&&(notPrime == 0)) maxPrime = j;
        else
          if(skaiciai(i)% j == 0) notPrime = 1; //skaicius ne pirminis
    }
    println("Problem 3: "+maxPrime);   
  }//end problem 3
  
  def problem4(): Unit= {
    var baseNumber = 0;
    var reversedNumber = 0;
    var charOfNumber = " ";
    var largestNumber = 0;
    for(i<- 100 to 999)
      for(j<- 100 to 999){
        baseNumber = i*j;
        charOfNumber = baseNumber.toString();
        charOfNumber = charOfNumber.reverse;
        reversedNumber = charOfNumber.toInt;
        if((baseNumber == reversedNumber)&&(baseNumber>largestNumber))
          largestNumber = baseNumber;
      }       
    println("Problem 4: "+largestNumber);   
  }//end problem 4
  
  def problem5(): Unit= {
    var number = 10;
    var stopButton = 0;
    while(stopButton == 0){
      numberChecker();
    }
    println("Problem 5: "+number);
    
    def numberChecker(): Unit = {
      var gate = 0;
      var i = 1;
      number += 1;
      while(i <= 21){
        if((i == 21))
          stopButton = 1; 
        if(number % i != 0)
          i = 25; //salyga netenkinama, breakinam while
        i += 1;
      }
    }//end numberChecker()
  }// end problem5 
  
  def problem6(): Unit= {
    var listSum = 0;
    var squaresSum = 0;
    var answer = 0;
    var skaiciai = List(1 to 100 :_*);
    listSum = skaiciai.sum;
    listSum = power2(listSum);
    skaiciai = skaiciai.map(power2(_));
    squaresSum = skaiciai.sum;
    answer = listSum - squaresSum;
    println("Problem 6: "+answer);
    
    def power2(i : Int): Int ={
      var j = 0;
      j = i * i;
      return j;
    }//end power 2
  }//end problem 6

}