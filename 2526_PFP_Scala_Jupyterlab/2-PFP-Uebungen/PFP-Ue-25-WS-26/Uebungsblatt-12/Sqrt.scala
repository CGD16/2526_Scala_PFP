def split1: BigInt => LazyList[BigInt] = {
    case number if number == 0 => LazyList.empty
    case number if number < 10 => LazyList(number % 10)
    case number => split1(number / 100) #::: LazyList(number % 100)
}


def split2: BigDecimal => LazyList[BigInt] = d => {
    LazyList.iterate(d)(x => (x * 100) % 1).map(x => (x * 100).toBigInt)
}


def split: BigDecimal => LazyList[BigInt] = d => {
  split1(d.toBigInt) #::: (BigInt(-1) #:: split2(d - BigDecimal(d.toBigInt)))
}


def findC: (BigInt, BigInt) => BigInt = (a, b) => {
    List.range(0,10).map(BigInt(_)).filter(c => (a * 20 + c) * c <= b).max
}


def sqrtHelper: LazyList[BigInt] => (BigInt, BigInt, BigInt, BigInt) => LazyList[BigInt] = {
    zs => (a0, b0, c0, d0) => {
      zs.head match {
        case z if z == BigInt(-1) => BigInt(-1) #:: sqrtHelper(zs.tail)(a0, b0, c0, d0)
        case z =>
          val a1 = a0 * 10 + c0
          val b1 = (b0 - d0) * 100 + z
          val c1 = findC(a1, b1)
          val d1 = (a1 * 20 + c1) * c1 
          c1 #:: sqrtHelper(zs.tail)(a1, b1, c1, d1)
      }
    }
}


def sqrt: BigDecimal => LazyList[Char] = d => {
    sqrtHelper(split(d))(0, 0, 0, 0)
      .map {
        case z if z == BigInt(-1) => ','
        case z                   => (z.toInt + '0').toChar
      }
}