package cz.mencik.testing.scalatest

import java.util.EmptyStackException
import org.junit.runner.RunWith
import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import cz.mencik.testing.Stack
import org.scalatest.junit.JUnitRunner

// this is a ScalaTest suite that uses the functional-style FlatSpec with ShouldMatchers DSL for assertions
// the @RunWith is allows running the suite in JUnit tools (Ant/Gradle tasks, or Maven's surefire plugin)
@RunWith(classOf[JUnitRunner])
class StackFlatSpec extends FlatSpec with ShouldMatchers {

  "A Stack" should "pop values in last-in-first-out order" in {
    val stack = new Stack[Int]
    stack.push(1)
    stack.push(2)
    stack.pop() should equal(2)
    stack.pop() should equal(1)
    stack should be('empty)
  }

  it should "throw EmptyStackException if an empty stack is popped" in {
    val emptyStack = new Stack[String]
    evaluating { emptyStack.pop() } should produce[EmptyStackException]
  }

}