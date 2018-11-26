object unionPirata extends Bando {

  override def bonus(unBarco: Barco): Unit = {
    unBarco.aumentarPoderDeFuego(60)
  }
}