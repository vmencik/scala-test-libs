package cz.mencik.testing.scalatest

import org.scalatest.FunSpec
import cz.mencik.testing.Stack
import java.util.EmptyStackException
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

// this is a ScalaTest suite that uses the FunSpec that allows writing nested specifications in the style of RSpec from Ruby
// it uses plain asserts instead of the ShouldMatchers DSL, but that is just a stylistic choice
// the @RunWith is allows running the suite in JUnit tools (Ant/Gradle tasks, or Maven's surefire plugin)
@RunWith(classOf[JUnitRunner])
class StackFunSpec extends FunSpec {

  describe("A Stack") {
    it("should pop values in last-in-first-out order") {
      val stack = new Stack[Int]
      stack.push(1)
      stack.push(2)
      assert(stack.pop() === 2)
      assert(stack.pop() === 1)
      assert(stack.isEmpty(), "stack was not empty")
    }

    describe("when empty") {
      it("should throw EmptyStackException if an empty stack is popped") {
        intercept[EmptyStackException] {
          val emptyStack = new Stack[String]
          emptyStack.pop()
        }
      }
    }
  }

}