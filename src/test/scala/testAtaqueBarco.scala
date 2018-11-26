class testAtaqueBarco extends testBarcos {
  test("Hacer que el Perla Negra ataque al Shanghaied") {
    perlaNegra.atacarA(shanghaied)
    assert(perlaNegra.tripulacion.length == 10)
    assert(shanghaied.resistencia == 0)
    assert(shanghaied.poderDeFuego == 0)
    assert(shanghaied.municiones == 0)
    assert(shanghaied.tripulacion.isEmpty)
    assert(shanghaied.capitan == null)
  }

}
