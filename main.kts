// Explore a simple class
     println("UW Homework : Simple Kotlin")

// write a "whenFn" that takes an arg of type "Any" and returns a String
fun whenFn(x: Any) : String {
    when(x) {
        is Int -> return inRange(x)
        is String -> return isHello(x)
        else -> return("I don't understand")
    }
}

fun inRange(x: Int) : String {
    if(x == 0)
        return("zero")
    else if(x == 1)
        return("one")
    else if(x in 2..10)
        return("low number")
    else 
        return("a number")
}

fun isHello(x: String) : String {
    if (x == "Hello")
        return("world")
    else 
        return("Say what?")
}

// write an "add" function that takes two Ints, returns an Int, and adds the values
fun add(x: Int, y: Int) : Int {
    return x + y
}
// write a "sub" function that takes two Ints, returns an Int, and subtracts the values
fun sub(x: Int, y: Int) : Int {
    return x -y
}
// write a "mathOp" function that takes two Ints and a function (that takes two Ints and returns an Int), returns an Int, and applies the passed-in-function to the arguments
fun mathOp(x: Int, y: Int, math: (Int, Int) -> Int): Int {
    return math(x,y)
}
// write a class "Person" with first name, last name and age
class Person(val firstName: String, val lastName: String, var age: Int) {
    val debugString: String
        get() = "[Person firstName:${firstName} lastName:${lastName} age:${age}]"
    
    override fun hashCode(): Int {
        return age;
    }

    fun equals(compare: Person) : Boolean {
        return (compare.hashCode() == this.hashCode())
    }
}
// write a class "Money"
class Money(amount: Int, currency: String) {
    /*SET STARTING EXCPTIONS  */
     init {
        if (currency != "USD" && currency != "EUR" &&
                currency != "CAN" && currency != "GBP") {
            throw Exception("Currency not supported!")
        } else if (amount < 0) {
            throw Exception("Amount can't be less than zero!")
        }
    }

    fun convert (convertMe: String) : Money {
         when(convertMe) {
             "tenUSD" -> return Money(5, "GBP")
             "fiveGBP" -> return Money(10, "USD")
             "tenUSD" -> return Money(15, "EUR")
             else -> return Money(0, "GBP")8

         }
        /* 10 USD converts to 15 EUR; 12 USD converts to 15 CAN*/
    } 
}
/*
   "Amount" is a standard Int.
   Define the properties such that "amount" can never be less than zero, and that "currency"
    can only be one of those four symbols. Define a public method, convert, that takes a String 
    argument for the currency type to convert to, and return a new Money instance with the amount 
    converted. Conversion rates should be as follows: 10 USD converts to 5 GBP; 10 USD converts to 
    15 EUR; 12 USD converts to 15 CAN. (Make sure you can convert in both directions!) Define the 
    "+" operator on Money to return a new instance of Money that adds the amount, converting the 
    currency to the first (left-hand) Money's currency. So adding (10 USD) + (5 GBP) should return a
     result in USD. Similarly, adding (5 GBP) + (10 USD) should return the result in GBP. */
// ============ DO NOT EDIT BELOW THIS LINE =============
print("When tests: ")
val when_tests = listOf(
    "Hello" to "world",
    "Howdy" to "Say what?",
    "Bonjour" to "Say what?",
    0 to "zero",
    1 to "one",
    5 to "low number",
    9 to "low number",
    17.0 to "I don't understand"
)
 
 for ((k,v) in when_tests) {
    print(if (whenFn(k) == v) "." else "!")
}
println("")

print("Add tests: ")
val add_tests = listOf(
    Pair(0, 0) to 0,
    Pair(1, 2) to 3,
    Pair(-2, 2) to 0,
    Pair(123, 456) to 579
)
for ( (k,v) in add_tests) {
    print(if (add(k.first, k.second) == v) "." else "!")
}
println("")

print("Sub tests: ")
val sub_tests = listOf(
    Pair(0, 0) to 0,
    Pair(2, 1) to 1,
    Pair(-2, 2) to -4,
    Pair(456, 123) to 333
)
for ( (k,v) in sub_tests) {
    print(if (sub(k.first, k.second) == v) "." else "!")
}
println("")

print("Op tests: ")
print(if (mathOp(2, 2, { l,r -> l+r} ) == 4) "." else "!")
print(if (mathOp(2, 2, ::add ) == 4) "." else "!")
print(if (mathOp(2, 2, ::sub ) == 0) "." else "!")
print(if (mathOp(2, 2, { l,r -> l*r} ) == 4) "." else "!")
println("")

print("Person tests: ")
val p1 = Person("Ted", "Neward", 47)
print(if (p1.firstName == "Ted") "." else "!")
p1.age = 48
print(if (p1.debugString == "[Person firstName:Ted lastName:Neward age:48]") "." else "!")
println("")

print("Money tests: ")
val tenUSD = Money(10, "USD")
val twelveUSD = Money(12, "USD")
val fiveGBP = Money(5, "GBP")
val fifteenEUR = Money(15, "EUR")
val fifteenCAN = Money(15, "CAN")
val convert_tests = listOf(
    Pair(tenUSD, tenUSD),
    Pair(tenUSD, fiveGBP),
    Pair(tenUSD, fifteenEUR),
    Pair(twelveUSD, fifteenCAN),
    Pair(fiveGBP, tenUSD),
    Pair(fiveGBP, fifteenEUR)
)
for ( (from,to) in convert_tests) {
    print(if (from.convert(to.currency).amount == to.amount) "." else "!")
}
val moneyadd_tests = listOf(
    Pair(tenUSD, tenUSD) to Money(20, "USD"),
    Pair(tenUSD, fiveGBP) to Money(20, "USD"),
    Pair(fiveGBP, tenUSD) to Money(10, "GBP")
)
for ( (pair, result) in moneyadd_tests) {
    print(if ((pair.first + pair.second).amount == result.amount &&
              (pair.first + pair.second).currency == result.currency) "." else "!")
}
println("")
