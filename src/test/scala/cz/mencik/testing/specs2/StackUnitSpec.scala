package cz.mencik.testing.specs2

import org.specs2.mutable._
import cz.mencik.testing.Stack
import java.util.EmptyStackException
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner

// this is a spec2 test wit the unit-style (mutable) specification
@RunWith(classOf[JUnitRunner])
class StackUnitSpec extends Specification {

  "A Stack" should {
    "pop values in last-in-first-out order" in {
      val stack = new Stack[Int]
      stack.push(1)
      stack.push(2)
      stack.pop() must beEqualTo(2)
      stack.pop() must beEqualTo(1)
      stack.isEmpty must beTrue
    }

    "throw EmptyStackException if an empty stack is popped" in {
      val emptyStack = new Stack[String]
      emptyStack.pop() must throwAn[EmptyStackException]
    }
  }

}