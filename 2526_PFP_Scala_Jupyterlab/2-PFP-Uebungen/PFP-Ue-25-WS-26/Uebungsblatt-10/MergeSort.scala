def divide: List[Int] => (List[Int], List[Int]) = {
    ls => (ls.take(ls.length/2), ls.drop(ls.length/2))
}

def merge: ((List[Int], List[Int])) => List[Int] = {
    case (Nil, Nil) => Nil
    case (Nil, ls) => ls
    case (ls, Nil) => ls
    case (ll :: l1, rl :: l2) => if (ll <= rl) ll :: merge((l1, rl :: l2)) else rl :: merge((ll :: l1, l2))
}

def conquer: ((List[Int], List[Int])) => (List[Int], List[Int]) = {
    case (l1, l2) => (mergeSort(l1), mergeSort(l2))  // warum brauche ich ein "case"
}

def mergeSort: List[Int] => List[Int] = {
    case ls if ls.length < 2 => ls
    case ls => merge(conquer(divide(ls)))
}