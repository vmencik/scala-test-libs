package cz.mencik.testing.junit

import java.util.EmptyStackException

import org.junit.Test
import org.scalatest.matchers.ShouldMatchers

import cz.mencik.testing.Stack

// this is a JUnit test (but written in Scala) that uses the ShouldMatchers DSL from ScalaTest instead of org.junit.Assert
class ScalaStackTest extends ShouldMatchers {

  @Test
  def testLiFo(): Unit = {
    val stack = new Stack[Int]
    stack.push(1)
    stack.push(2)
    stack.pop() should equal(2)
    stack.pop() should equal(1)
    stack should be('empty)
  }

  @Test
  def testEmptyStackPopThrowsException(): Unit = {
    val emptyStack = new Stack[String]
    evaluating { emptyStack.pop() } should produce[EmptyStackException]
  }

}