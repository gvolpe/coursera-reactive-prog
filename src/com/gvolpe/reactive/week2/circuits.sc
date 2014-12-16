import com.gvolpe.reactive.week2.Circuits.{Wire, Gate}

val gate = new Gate
val a,b,s,c = new Wire
gate.halfAdder(a,b,s,c)
s.value
c.value
val a1, a2, eqOut, notOut = new Wire
gate.notEquals(a1,a2,notOut)

gate.equals(a1, a2, eqOut)
"EQ >> " + eqOut.value
"NOT EQ >> " + notOut.value