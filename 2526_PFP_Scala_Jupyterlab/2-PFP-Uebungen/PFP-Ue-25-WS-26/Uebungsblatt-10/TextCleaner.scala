def contains: (List[Char], Char) => Boolean = {
    case (Nil, c) => false
    case (l::cs, c) if c == l => true
    case (l::cs, c) => contains(cs, c)
}


def clean: (List[Char], List[Char]) => List[Char] = {
    case (Nil, ps) => Nil
    case (' ':: ' ':: cs, ps) => clean(' '::cs, ps)
    case (' '::l::cs, ps) if contains(ps, l) => clean(l::cs, ps)
    case (c::cs, ps) => c :: clean(cs, ps)
}