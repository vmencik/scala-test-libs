package cz.mencik.testing

class Rational(num: Int, den: Int = 1) {

  private val g = gcd(num, den)

  val numer: Int = num / g
  val denom: Int = den / g

  def +(that: Rational): Rational =
    new Rational(this.numer * that.denom + this.denom * that.numer,
      this.denom * that.denom)

  def -(that: Rational): Rational =
    this + new Rational(-that.numer, that.denom)

  private def gcd(x: Int, y: Int): Int =
    if (x == 0) y
    else if (x < 0) gcd(-x, y)
    else if (y < 0) -gcd(x, -y)
    else gcd(y % x, x)

  override def equals(other: Any) = {
    other match {
      case that: Rational => this.numer == that.numer && this.denom == that.denom
      case _ => false
    }
  }

  override def hashCode() = {
    val prime = 41
    prime * (prime + numer.hashCode) + denom.hashCode
  }

  override val toString = "" + numer + "/" + denom

}

