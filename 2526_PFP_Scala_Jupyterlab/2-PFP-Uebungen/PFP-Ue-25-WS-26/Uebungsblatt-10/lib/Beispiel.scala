object Beispiel {

  def g: Int => Int = x => if (x < 0) x * x + 3 else x * x * x
  
  def h: Int => Int = x =>
    if (x <= 1)
      x
    else
      h(x - 1) + h(x - 2)
}
