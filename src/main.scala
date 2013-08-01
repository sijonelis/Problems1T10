import scala.math

import scala.collection.mutable.ListBuffer

object problems {
    //main funkcija
  def main(args: Array[String]): Unit = 
  {  
    problem1();
    problem2();
    problem3();
    problem4();
    problem5();
    problem6();
    problem7();
    problem8();
    problem9();
    problem10();
    
  }
  
  // Bendri pastebėjimai:
  //
  // * Nereikia ;.
  
  /*
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
  */
  def problem1() {
  	val result = (1 to 1000).view.filter(i => i % 3 == 0 || i % 5 == 0).sum
  	println(s"Problem 1: $result")
  }
  
  /*
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
  */
  
  // Truputį pagooglinus.
  def problem2() {
  	lazy val fibs:Stream[Int] = 0 #:: 1 #:: (fibs zip fibs.tail).map{ t => t._1 + t._2 }
  	val result = fibs.takeWhile(_ < 4000000).filter(_ % 2 == 0).sum
  	println(s"Problem 2: $result")
  }
  
  /*
  def problem3(): Unit= {
    val number = 13195L;
    val sqrtOfNumber = Math.sqrt(number).toInt;
    var skaiciai = List(1 to sqrtOfNumber:_*);
    var maxPrime = 0;
    var notPrime = 0; // !!!!!!!!!!!!!! Apie Boolean tipą žinai? !!!!!!!!!!!!!!!!
    skaiciai = skaiciai.filter(number % _ == 0);//atmetam skaicius kurie nesidalina is number
    for(i <- 1 to skaiciai.length-1){ // nes nulinis elementas visada bus 1, kuris yra pirminis.
      notPrime = 0;
      for(j<- 2 to skaiciai(i)) // <----- !!!!! List access pagal indexa yra O(n) !!!!!
        if((skaiciai(i) == j)&&(notPrime == 0)) maxPrime = j;
        else
          if(skaiciai(i)% j == 0) notPrime = 1; //skaicius ne pirminis
    }
    println("Problem 3: "+maxPrime);   
  }//end problem 3
  */
  
  def problem3() {
  	// Paprasta pirminio skaičiaus nustatymo implementacija.
  	def isPrime(i: Long) = {
  		require(i > 0, s"Only positive numbers are accepted, got $i.")
  		if (i == 1) true
  		else ! Stream.range(2L, i - 1).exists(i % _ == 0)
  	}
	  	
  	def primeFactors(number: Long) = {	  	
	  	Stream.
	  		range(1, number / 3 /* Lowest prime factor */).
	  		filter(number % _ == 0).
	  		filter(isPrime)
  	}
  	
  	val result = primeFactors(600851475143L).last  
    	println(s"Problem 3: $result")  	
  }
  
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
  
  def problem7(): Unit= {
    var primeCount = 0
    var number = 2;
    while(primeCount != 10001){
      if(isPrime(number) == 1){
        primeCount += 1;
        number += 1;
      }
      else
       number +=1  ;  
    }
    number -= 1;
    println("Problem 7: " + number );
      
    def isPrime(i: Int): Int = {
     for(j <-2 to Math.sqrt(i).toInt)
       if(i % j == 0)
         return 0;
     return 1;
    }//end isprime
  }// end prob 7
  
   def problem8(): Unit= {
     val fileLines = io.Source.fromFile("8.txt").getLines.toList;
     val string = fileLines.mkString;
     var maxNumber = 0;
     var cycleNumber = 0;
     for(i<- 0 to string.length()-5){
       cycleNumber = string.slice(i, i+1).toInt * string.slice(i+1, i+2).toInt * string.slice(i+2, i+3).toInt * string.slice(i+3, i+4).toInt * string.slice(i+4, i+5).toInt;
       if(cycleNumber > maxNumber)
         maxNumber = cycleNumber;
     }
     println("Problem 8: " +maxNumber);
   }//end prob 8
   
   def problem9(): Unit = {
     var answer = (0, 0, 0);
     var isFound = 0;
     for(a <- 1 to 995)
       for(b <- 1 to 996)
         for(c <- 1 to 997)
           if(isFound == 0)
             if(a+b+c == 1000)
               if(a*a+b*b == c*c){
                 answer = (a, b, c);
                 isFound =1;
               }
     println("Problem 9: " + answer);
   }
   
   def problem10(): Unit = {
     var sum = 0L;
     for(i <- 2 to 2000000)
       if(isPrime(i) == 1)
         sum += i;
     println("Problem 10: " +sum);
     
     def isPrime(i: Int): Int = {
       for(j <- 2 to Math.sqrt(i).toInt)
         if(i % j == 0)
            return 0;
       return 1;
    }//end isprime
     
   }
   
}
