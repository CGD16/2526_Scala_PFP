val numberIllegal = for (s <- studentSolution if s < 1 | 4 < s) yield s
assert(numberIllegal.isEmpty, "\nDie folgenden Eingaben sind UNGÜLTIG: " + numberIllegal.mkString("\"", "\", \"", "\"") + "\nVersuchen Sie es nochmal.")

val mc1 = if (studentSolution.contains(1)) 1 else -1
val mc2 = if (studentSolution.contains(2)) 1 else -1
val mc3 = if (studentSolution.contains(3)) -1 else 1
val mc4 = if (studentSolution.contains(4)) -1 else 1
val bonus = mc1 + mc2 + mc3 + mc4
val points = if (bonus < 0) 0 else bonus*2/4
println("Für Ihre Antwort würden Sie " + points + " von 2 Punkten erhalten.")

assert(studentSolution.contains(1), "\nIhnen ist eine RICHTIGE Aussage entgangen.\nVersuchen Sie es nochmal.")
assert(studentSolution.contains(2), "\nIhnen ist eine RICHTIGE Aussage entgangen.\nVersuchen Sie es nochmal.")
assert(!studentSolution.contains(3), "\nSie haben eine FALSCHE Aussage angegeben.\nVersuchen Sie es nochmal.")
assert(!studentSolution.contains(4), "\nSie haben eine FALSCHE Aussage angegeben.\nVersuchen Sie es nochmal.")

println("PRIMA!")