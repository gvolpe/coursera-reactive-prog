package com.gvolpe.reactive.week2

object Circuits {

  class Wire {

    private var state: Boolean = true

    def value: Boolean = state

    def setValue(newValue: Boolean): Unit = {
      state = newValue
    }

  }

  class Gate {

    def inverter(input: Wire, output: Wire): Unit = {
      output.setValue(!input.value)
    }

    def and(a1: Wire, a2: Wire, output: Wire): Unit = {
      output.setValue(a1.value && a2.value)
    }

    def or(a1: Wire, a2: Wire, output: Wire): Unit = {
      output.setValue(a1.value || a2.value)
    }

    def halfAdder(a: Wire, b: Wire, s: Wire, c: Wire): Unit = {
      val d, e = new Wire
      or(a, b, d)
      or(a, b, c)
      inverter(c, e)
      and(d, e, s)
    }

    def fullAdder(a: Wire, b: Wire, cin: Wire, sum: Wire, cout: Wire): Unit = {
      val s, c1, c2 = new Wire
      halfAdder(b, cin, s, c1)
      halfAdder(a, s, sum, c2)
      or(c1, c2, cout)
    }

    def notEquals(a: Wire, b: Wire, c: Wire): Unit = {
      val d, e, f, g = new Wire
      inverter(a, d)
      inverter(b, e)
      and(a, e, f)
      and(b, d, g)
      or(g, f, c)
    }

    def equals(a: Wire, b: Wire, c: Wire): Unit = {
      val d, e, f, g = new Wire
      inverter(a, d)
      inverter(b, e)
      and(a, e, f)
      and(b, d, g)
    }

  }

}
