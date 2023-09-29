fun abcfn(name: String) {
  println("In abcfn() function")
  println("Say hello to $name")
}

fun printArray(arr: Array<Int>) {
  arr.forEach { print("${it} ") }
  println()
}
fun arrayOperation(arr: Array<Int>, operation: (arr: Array<Int>) -> Unit) {
  operation(arr)
}
fun double(x: Int): Int = x * 2
fun doubler(): (Int) -> Int {
  return ::double
}
fun calcOperations(opr: String = "add"): (a1: Int, a2: Int) -> Int {
  if (opr == "add") return { a1, a2 -> a1 + a2 }
  if (opr == "mul") return { a1, a2 -> a1 * a2 }
  if (opr == "sub") return { a1, a2 -> a1 - a2 }
  if (opr == "div") return { a1, a2 -> a1 / a2 }
  return { a1, a2 -> 0 }
}

//passing function as parameter
fun FunctionAsParameter(functionName: (name: String) -> Unit, name: String) {
  println("In higher order function")
  println("Calling Normalfn() function...")
}

// function as return type
fun ReturnIsFunction(): (name: String) -> Unit {
  println("In higherOrderReturnFunction")
  // return the Normalfn function
  return ::abcfn
}

// lamda as argument
fun LamdaAsArgumentFunction(functionName: (name: String) -> Unit, name: String) {

  println("In higherOrderLamdaAsArgumentFunction")
  println("Calling received function...")
  functionName(name)
}

// lamda as return value
fun LamdaAsReturnFunction(): (name: String) -> Unit {
  println("In higher order function")
  return { name ->
    println("Inside the lambda function")
    println("Say hello to $name")
  }
}

fun main() {
  println("types of functions example")

  val add = { a1: Int, a2: Int -> a1 + a2 }
  println("Sum of 1 and 2 is: ${add(1, 2)}")

  println("Double of 2 is ${double(2)}")

  val dou = { x: Int -> x * x }

  val items = listOf(1, 2, 3, 4, 5)

// Lambdas are code blocks enclosed in curly braces.
  items.fold(0, {
    // When a lambda has parameters, they go first, followed by '->'
      acc: Int, i: Int ->
    print("acc = $acc, i = $i, ")
    val result = acc + i
    println("result = $result")
    // The last expression in a lambda is considered the return value:
    result
  })

  val arr = arrayOf(1, 2, 3, 4, 5)

  arr.forEach { num -> print("${num * num} ") }
  println()
  arr.forEach { print("${it * it} ") }

//as function
  FunctionAsParameter(::abcfn, "Sai")

  //function as return type
  val functionasreturn = ReturnIsFunction()

  functionasreturn("Sai")

  // Lambda as argument
  LamdaAsArgumentFunction({ name: String ->
    println("Inside the lambda function")
    println("Say hello to $name")
  }, "Sai")

  //lamda as return type
  val lammdaasreturn = LamdaAsReturnFunction()
  lammdaasreturn("Lambda as return type")

  println("========================")

  printArray(arr)
  arrayOperation(arr, ::printArray)
  val doublerImplementation = doubler()
  println(doublerImplementation(2))
  // default operation is add
  println(calcOperations("add")(1, 2))
  println(calcOperations("mul")(6, 2))
  println(calcOperations("sub")(2, 2))
  println(calcOperations("div")(10, 2))
  println(calcOperations()(10, 2))
}