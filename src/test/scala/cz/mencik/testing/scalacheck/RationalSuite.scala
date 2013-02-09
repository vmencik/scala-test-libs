package cz.mencik.testing.scalacheck

import org.scalatest.prop.PropertyChecks
import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import cz.mencik.testing.Rational
import org.scalacheck.Gen
import org.scalacheck.Arbitrary
import java.math.BigDecimal
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

// this is a ScalaTest suite that uses property testing with ScalaCheck generators and table-driven checks 
// the @RunWith is allows running the suite in JUnit tools (Ant/Gradle tasks, or Maven's surefire plugin)
@RunWith(classOf[JUnitRunner])
class RationalSuite extends FunSuite with ShouldMatchers with PropertyChecks {

  test("Rationals are normalized so that the denominator is positive") {
    forAll("numerator", "denominator") { (n: Int, d: Int) =>

      whenever(d != 0 && d != Integer.MIN_VALUE && n != Integer.MIN_VALUE) {
        val f = new Rational(n, d)

        if (n < 0 && d < 0 || n > 0 && d > 0)
          f.numer should be > 0
        else if (n != 0)
          f.numer should be < 0
        else
          f.numer should be === 0

        f.denom should be > 0
      }
    }
  }

  test("Addition of Rationals - with ScalaCheck generator") {
    forAll("a", "b") { (a: Rational, b: Rational) =>

      val sum = a + b
      a.numer / a.denom + b.numer / b.denom <= sum.numer + sum.denom

    }
  }

  test("Normalization - tables") {
    val rationals = Table(
      ("numerator", "denominator"),
      (1, 2),
      (-1, 2),
      (1, -2),
      (0, 2),
      (-1, -2))

    forAll(rationals) { (n: Int, d: Int) =>
      val f = new Rational(n, d)
      if (n < 0 && d < 0 || n > 0 && d > 0)
        f.numer should be > 0
      else if (n != 0)
        f.numer should be < 0
      else
        f.numer should be === 0

      f.denom should be > 0
    }
  }

  implicit val arbRational: Arbitrary[Rational] = Arbitrary {
    for {
      n <- Gen.choose(-1000, 1000)
      d <- Gen.choose(-1000, 1000)
    } yield new Rational(n, d)
  }

}

