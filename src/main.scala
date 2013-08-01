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
   // problem5()
    problem6()
    problem7()
    problem8()
    //problem9()
    //problem10()
    
  }
  
  // Bendri pastebėjimai:
  //
  // * Nereikia ;.
  
  /*
  def problem1(): Unit = {
  	val result = (1 to 1000).view.filter(i => i % 3 == 0 || i % 5 == 0).sum
  	println(s"Problem 1: $result")
  }//end problem1
  */
  def problem1() {
  	val result = (1 to 1000).view.filter(i => i % 3 == 0 || i % 5 == 0).sum
  	println(s"Problem 1: $result")
  }
  
<<<<<<< HEAD
  /*
  def problem2(): Unit= {
    var sum = 0;
    var fibSeqNumber = 2;
    var fibSeqPreviousNumber = 1;
=======
  def problem2(): Unit= 
  {
  	lazy val fibs:Stream[Int] = 0 #:: 1 #:: (fibs zip fibs.tail).map{ t => t._1 + t._2 }  //lazy ???
  	val result = fibs.takeWhile(_ < 4000000).filter(_ % 2 == 0).sum
  	println(s"Problem 2: $result")
 /*
  {
    var sum = 0
    var fibSeqNumber = 2
    var fibSeqPreviousNumber = 1
>>>>>>> some code modified
    while(fibSeqNumber<4000000){
      if (fibSeqNumber % 2 == 0)
        sum += fibSeqNumber
      generateNextNumber()
    }  
    println("Problem 2: "+sum)
    
    def generateNextNumber(): Unit = {
      var temp = fibSeqNumber
      fibSeqNumber += fibSeqPreviousNumber
      fibSeqPreviousNumber = temp      
    }//end generateNextNumber
<<<<<<< HEAD
  }//end problem 2
  */
  
  // Truputį pagooglinus.
  def problem2() {
  	lazy val fibs:Stream[Int] = 0 #:: 1 #:: (fibs zip fibs.tail).map{ t => t._1 + t._2 }
  	val result = fibs.takeWhile(_ < 4000000).filter(_ % 2 == 0).sum
  	println(s"Problem 2: $result")
  }
=======
*/  }//end problem 2
>>>>>>> some code modified
  
  /*
  def problem3(): Unit= {
<<<<<<< HEAD
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
=======
    val number = 600851475143L
    val sqrtOfNumber = Math.sqrt(number).toInt//aukstesni skaiciai negali buti pirminiai daugikliai
    var skaiciai = List(1 to sqrtOfNumber:_*)
    var maxPrime = 0
    var notPrime = false
    skaiciai = skaiciai.filter(number % _ == 0)//atmetam skaicius kurie nesidalina is number
    for(i <- 1 to skaiciai.length-1){ // nes nulinis elementas visada bus 1, kuris yra pirminis.
      notPrime = false
      for(j<- 2 to skaiciai(i))
        if((skaiciai(i) == j)&&(notPrime == false)) maxPrime = j
>>>>>>> some code modified
        else
          if(skaiciai(i)% j == 0) notPrime = true //skaicius ne pirminis
    }
    println("Problem 3: "+maxPrime)   
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
  
  /*
   *   def problem3() {
  	// Paprasta pirminio skaiciaus nustatymo implementacija.
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
   * 
   */
  
  def problem4(): Unit= {
    var baseNumber = 0
    var largestNumber = 0
    for(i<- 100 to 999; j<- i to 999){
      baseNumber = i*j
      if((baseNumber.toString() == baseNumber.toString().reverse)&&(baseNumber>largestNumber))
        largestNumber = baseNumber
    }       
    println("Problem 4: "+largestNumber)   
  }//end problem 4
  
  def problem5(): Unit= {
    
    // var number = Iterator.from(20)
    //var answer = number.find(numberChecker).get
    var number = 20
    var stopButton = false
    while(!stopButton){
      numberChecker()
    }
    println("Problem 5: "+number)
    
    def numberChecker(): Unit = {
      
      if((20 to 11 by -1).forall(number % _ == 0))
        stopButton = true 
        else 
          number += 1;

    }//end numberChecker()
  }// end problem5 
  
  def problem6(): Unit= {
    val skaiciai = List(1 to 100 :_*)
    val listSumSquare = skaiciai.sum*skaiciai.sum
    val squaresSum = skaiciai.map(i => i*i).sum
    val answer = listSumSquare - squaresSum
    println("Problem 6: "+answer)
  }//end problem 6
  
  def problem7(): Unit= {
   // var numbers = Iterator.from(20)
    var primeCount = 0
    var number = 2
    while(primeCount != 10001){
      if(isPrime(number)){
        primeCount += 1
        number += 1
      }
      else
       number +=1    
    }
    number -= 1
    println("Problem 7: " + number )
      
    def isPrime(i: Long) = {
  		require(i > 0, s"Only positive numbers are accepted, got $i.")
  		if (i == 1) true
  		else ! Stream.range(2L, math.sqrt(i).toInt).exists(i % _ == 0)
    }//end isprime
  }// end prob 7
  
   def problem8(): Unit= {
     val string = (io.Source.fromFile("8.txt").getLines.toList).mkString
     val maxNumber = string.map(_.asDigit).sliding(5).map(_.product).max
     println("problem 8: "+maxNumber)

   }//end prob 8
   
   def problem9(): Unit = {
     var answer = (0, 0, 0)
     var isFound = false
     for(a <- 1 to 995)
       for(b <- 1 to 996)
         for(c <- 1 to 997)
           if(isFound == false)
             if(a+b+c == 1000)
               if(a*a+b*b == c*c){
                 answer = (a, b, c)
                 isFound = true
               }
     println("Problem 9: " + answer)
   }
   
   def problem10(): Unit = {
     var sum = 0L
     for(i <- 2 to 2000000)
       if(isPrime(i))
         sum += i
     println("Problem 10: " +sum)
     
     def isPrime(i: Int): Boolean = {
       for(j <- 2 to Math.sqrt(i).toInt)
         if(i % j == 0)
            return false
       return true
    }//end isprime
     
   }
   
}
