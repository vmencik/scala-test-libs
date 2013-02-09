package cz.mencik.testing.specs2

import org.specs2._
import cz.mencik.testing.Stack
import java.util.EmptyStackException
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner

// this is a spec2 test wit the acceptance-style (immutable) specification
// by convention it uses non-standard code formatting
@RunWith(classOf[JUnitRunner])
class StackAcceptSpec extends Specification { def is =

  "A Stack should" 											^
    "pop values in last-in-first-out order" 				! e1 ^
    "throw EmptyStackException if an empty stack is popped" ! e2

  // the methods used in the examples must provide a single matcher
  // partial assertions must be combined to a single matcher using the 'and' method
  def e1 = {
    val stack = new Stack[Int]
    stack.push(1)
    stack.push(2)
    (stack.pop() must beEqualTo(2)) and
    (stack.pop() must beEqualTo(1)) and
    (stack.isEmpty must beTrue)
  }

  def e2 = {
    val emptyStack = new Stack[String]
    emptyStack.pop() must throwAn[EmptyStackException]
  }

}