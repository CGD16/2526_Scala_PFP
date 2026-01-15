val numberIllegal = for (s <- studentSolutionF if s < 1 | 4 < s) yield s
assert(numberIllegal.isEmpty, "\nDie folgenden Eingaben sind UNGÜLTIG: " + numberIllegal.mkString("\"", "\", \"", "\"") + "\nVersuchen Sie es nochmal.")

val mc1 = studentSolutionF.contains(1)
val mc2 = studentSolutionF.contains(2)
val mc3 = studentSolutionF.contains(3)
val mc4 = studentSolutionF.contains(4)
val points = if (!mc1 & !mc2 & !mc3 & mc4) 1 else 0
println("Für Ihre Antwort würden Sie " + points + " von 1 Punkten erhalten.")

assert(!mc1, "\nSie haben eine FALSCHE Aussage angegeben.\nVersuchen Sie es nochmal.")
assert(!mc2, "\nSie haben eine FALSCHE Aussage angegeben.\nVersuchen Sie es nochmal.")
assert(!mc3, "\nSie haben eine FALSCHE Aussage angegeben.\nVersuchen Sie es nochmal.")
assert(mc4, "\nIhnen ist eine RICHTIGE Aussage entgangen.\nVersuchen Sie es nochmal.")

println("PRIMA!")