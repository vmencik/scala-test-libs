package cz.mencik.testing.scalatest

import java.util.EmptyStackException
import org.scalatest.FeatureSpec
import org.scalatest.GivenWhenThen
import cz.mencik.testing.Stack
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

// this is a ScalaTest suite/spec that uses acceptance testing style provided by FeatureSpec and GivenWhenThen
@RunWith(classOf[JUnitRunner])
class StackFeatureSpec extends FeatureSpec with GivenWhenThen {

  info("As a Stack user")
  info("I want to be able to store items in the stack")
  info("So I can later retrieve them in the reverse order")

  feature("Storage of item in a Stack") {
    scenario("User adds items to stack and later retrieves them") {

      Given("an empty Stack")
      val stack = new Stack[Int]
      assert(stack.isEmpty)

      When("items are stored int the stack")
      stack.push(1)
      stack.push(2)

      Then("they can be retrived in reversed order")
      assert(stack.pop() === 2)
      assert(stack.pop() === 1)

      And("the Stack is empty again")
      assert(stack.isEmpty)
    }

    scenario("User tries to retrieve items from an empty Stack") {

      Given("an empty Stack")
      val stack = new Stack[Int]
      assert(stack.isEmpty)

      When("user tries to retrieve items")
      Then("EmptyStackException is thrown")
      intercept[EmptyStackException] {
        stack.pop()
      }

    }
  }

}