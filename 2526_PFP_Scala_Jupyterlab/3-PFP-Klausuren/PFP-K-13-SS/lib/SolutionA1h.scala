val numberIllegal = for (s <- studentSolutionH if s < 1 | 2 < s) yield s
assert(numberIllegal.isEmpty, "\nDie folgenden Eingaben sind UNGÜLTIG: " + numberIllegal.mkString("\"", "\", \"", "\"") + "\nVersuchen Sie es nochmal.")

val mc1 = studentSolutionH.contains(1)
val mc2 = studentSolutionH.contains(2)
val points = if (!mc1 & mc2) 1 else 0
println("Für Ihre Antwort würden Sie " + points + " von 1 Punkten erhalten.")

assert(!mc1, "\nSie haben eine FALSCHE Aussage angegeben.\nVersuchen Sie es nochmal.")
assert(mc2, "\nIhnen ist eine RICHTIGE Aussage entgangen.\nVersuchen Sie es nochmal.")

println("PRIMA!")